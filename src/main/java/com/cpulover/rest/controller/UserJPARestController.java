package com.cpulover.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cpulover.rest.dao.UserDaoImpl;
import com.cpulover.rest.entity.User;
import com.cpulover.rest.repository.UserRepository;

@RestController
@RequestMapping("/jpa")
public class UserJPARestController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);

		// HATEOAS
		// resource contains data and links associated to this user
//		EntityModel<Optional<User>> resource = EntityModel.of(user);
//		// create a link to retrieveAllUsers()
//		WebMvcLinkBuilder link1 = WebMvcLinkBuilder
//				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
//		// rename the link and add to the resource
//		resource.add(link1.withRel("all-users"));

		return user;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);

	}

	//

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);

		// get the uri of new created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		// assign the uri to location attribute of the Header of Response
		return ResponseEntity.created(location).build();

	}

}
