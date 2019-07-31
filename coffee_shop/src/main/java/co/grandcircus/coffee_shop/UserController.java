/**
 * Copyright (c) 2019.
 * This program and the accompanying materials are made available
 * under my granted permission provided that this note is kept intact, unmodified and unchanged.
 * @ Author: Baraa Ali -  API and implementation.
 * All rights reserved.
*/

package co.grandcircus.coffee_shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffee_shop.dao.ProductDao;
import co.grandcircus.coffee_shop.dao.UserDao;
import co.grandcircus.coffee_shop.entity.Product;
import co.grandcircus.coffee_shop.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;
	@Autowired
	private ProductDao pdao;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/list_of_products");
	}

	@RequestMapping("/list_of_products")
	public ModelAndView list() {
		List<Product> leListOfRooms = pdao.findAll();
		return new ModelAndView("list_of_products", "listOfProducts", leListOfRooms);
	}

	@RequestMapping("/register")
	public ModelAndView add() {
		return new ModelAndView("register");
	}

	@PostMapping("/register")
	public ModelAndView registerSubmit(User user) {
		dao.create(user);
		return new ModelAndView("register");
	}
}
