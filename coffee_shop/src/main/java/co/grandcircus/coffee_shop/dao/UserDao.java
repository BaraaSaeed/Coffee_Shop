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

import co.grandcircus.coffee_shop.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<User> findAll() {
		String sql = "SELECT * FROM Users";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
	}

	public User findBuyID(Long id) {
		String sql = "SELECT * FROM Users WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
	}

	public void update(User user) {
		String sql = "UPDATE Users SET first_name=?, last_name=?, phone_number=?, email=?, password=? WHERE id =?";
		jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(),
				user.getPassword());
	}

	public void create(User user) {
		String sql = "INSERT INTO Users (first_name, last_name, phone_number, email, password) VALUES (?, ?, ?, ?, ?)";
		System.out.println(user.getFirstName() + " ... " + user.getLastName() + " ... " + user.getPhoneNumber()
				+ user.getEmail() + " ... " + user.getPassword());
		jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(),
				user.getPassword());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM Users WHERE ID =? ";
		jdbc.update(sql, id);
	}
}
