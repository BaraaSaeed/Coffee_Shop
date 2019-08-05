/**
 * Copyright (c) 2019.
 * This program and the accompanying materials are made available
 * under my granted permission provided that this note is kept intact, unmodified and unchanged.
 * @ Author: Baraa Ali -  API and implementation.
 * All rights reserved.
*/

package co.grandcircus.coffee_shop;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.coffee_shop.dao.ProductDao;
import co.grandcircus.coffee_shop.dao.UserDao;
import co.grandcircus.coffee_shop.entity.Product;
import co.grandcircus.coffee_shop.entity.User;

@Controller
public class CoffeeShopController {

	@Autowired
	private UserDao dao;
	@Autowired
	private ProductDao pdao;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/signup")
	public ModelAndView showSignup() {
		return new ModelAndView("signup-form");
	}

	@RequestMapping("/signup-confirmation")
	public ModelAndView signupConfirm(User user, HttpSession session) {
		dao.create(user);
		session.setAttribute("user", user);
		ModelAndView mav = new ModelAndView("thanks");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login-form");
	}

	@PostMapping("/login")
	public ModelAndView submitLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		User user = dao.FindByEmailAndPassowrd(email, password);
		if (user == null) {
			return new ModelAndView("login-form", "message", "Incorrect username or password.");
		}
		session.setAttribute("user", user);
		return new ModelAndView("thanks");
	}

	@RequestMapping("/products-list")
	public ModelAndView list() {
		List<Product> leListOfProducts = pdao.findAll();
		return new ModelAndView("products-list", "listOfProducts", leListOfProducts);
	}

	@RequestMapping("/edit-food")
	public ModelAndView showEditForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("edit-food");
		mav.addObject("product", pdao.findById(id));
		mav.addObject("title", "Edit Product");
		return mav;
	}

	@PostMapping("/edit-food")
	public ModelAndView submitEditForm(Product product) {
		pdao.update(product);
		return new ModelAndView("redirect:/products-list");
	}

	@RequestMapping("/delete-food")
	public ModelAndView deleteProduct(@RequestParam("id") Long id) {
		pdao.delete(id);
		return new ModelAndView("redirect:/products-list");
	}

	@RequestMapping("/add-product")
	public ModelAndView showCreateForm() {
		// If there is only one model value to add, use this one-line shortcut.
		// Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		return new ModelAndView("add-food");
	}

	@PostMapping("/add-product")
	public ModelAndView submitCreateForm(Product product) {
		pdao.create(product);
		return new ModelAndView("redirect:/products-list");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}
