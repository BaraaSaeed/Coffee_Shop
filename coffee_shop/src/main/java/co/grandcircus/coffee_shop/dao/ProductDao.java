/**
 * Copyright (c) 2019.
 * This program and the accompanying materials are made available
 * under my granted permission provided that this note is kept intact, unmodified and unchanged.
 * @ Author: Baraa Ali -  API and implementation.
 * All rights reserved.
*/
package co.grandcircus.coffee_shop.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffee_shop.entity.Product;

@Repository
@Transactional
public class ProductDao {

	@PersistenceContext
	private EntityManager em;

	public List<Product> findAll() {
		return em.createQuery("FROM Product", Product.class).getResultList();
	}

	public Product findById(Long id) {
		return em.find(Product.class, id);
	}

	public List<Product> findByCategory(String category) {
		return em.createQuery("FROM Product WHERE category = :category", Product.class)
				.setParameter("category", category).getResultList();
	}

	public List<Product> findByKeyword(String keyword) {
		return em.createQuery("FROM Food WHERE LOWER(name) LIKE :regex", Product.class)
				.setParameter("regex", "%" + keyword.toLowerCase() + "%").getResultList();
	}

	public Product findByName(String name) {
		try {
			return em.createQuery("FROM Food WHERE name = :name", Product.class).setParameter("name", name)
					.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}

	public void create(Product product) {
		em.persist(product);
	}

	public void update(Product product) {
		em.merge(product);
	}

	public void delete(Long id) {
		Product product = em.getReference(Product.class, id);
		em.remove(product);
	}

	public Set<String> findAllCategories() {
		List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM Product", String.class)
				.getResultList();
		return new TreeSet<>(categoryList);
	}
}
