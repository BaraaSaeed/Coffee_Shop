/**
 * Copyright (c) 2019.
 * This program and the accompanying materials are made available
 * under my granted permission provided that this note is kept intact, unmodified and unchanged.
 * @ Author: Baraa Ali -  API and implementation.
 * All rights reserved.
*/

package co.grandcircus.coffee_shop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffee_shop.entity.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	public List<User> findAll() {
		return em.createQuery("FROM FOOD", User.class).getResultList();
	}

	public User findByID(Long id) {
		return em.find(User.class, id);
	}

	public User FindByEmailAndPassowrd(String email, String password) {
		try {
			return em.createQuery("FROM User WHERE email = :email AND password= :password", User.class)
					.setParameter("email", email).setParameter("password", password).getSingleResult();
		} catch (NoResultException ex) { // <-- see here
			return null;
		}
	}

	public void update(User user) {
		em.merge(user);
	}

	public void create(User user) {
		em.persist(user);
	}

	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}
}
