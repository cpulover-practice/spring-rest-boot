package com.cpulover.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpulover.rest.dao.UserDaoImpl;
import com.cpulover.rest.entity.User;
import com.cpulover.rest.view.UserView;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class UserFilteringRestController {
	@Autowired
	private UserDaoImpl userDaoImpl;

	@GetMapping(value = { "/users/filter/name/birthdate", // map multiple endpoints to one method
			"/users/filter/birthdate/name" })
	@JsonView(UserView.NameBirthdate.class) //for dynamic filtering
	public List<User> retrieveAllUsersViewNameBirthdate() {
		return userDaoImpl.findAll();
	}

	@GetMapping("/users/filter/password")
	@JsonView(UserView.Password.class)
	public List<User> retrieveAllUsersViewPassword() {
		return userDaoImpl.findAll();
	}
	
	@GetMapping("/users/filter/name/birthdate/password")
	@JsonView(UserView.NameBirthdatePassword.class)
	public List<User> retrieveAllUsersViewNameBirthdatePassword() {
		return userDaoImpl.findAll();
	}
}
