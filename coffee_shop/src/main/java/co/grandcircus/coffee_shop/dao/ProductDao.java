/**
 * Copyright (c) 2019.
 * This program and the accompanying materials are made available
 * under my granted permission provided that this note is kept intact, unmodified and unchanged.
 * @ Author: Baraa Ali -  API and implementation.
 * All rights reserved.
*/
package co.grandcircus.coffee_shop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffee_shop.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Product> findAll() {
		String sql = "SELECT * FROM Products";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}
}
