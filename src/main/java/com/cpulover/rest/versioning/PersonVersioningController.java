package com.cpulover.rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// URI versioning
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// request param versioning
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// header versioning
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// media type versioning
	// @GetMapping(value = "/person/produces", produces ="application/com.cpulover.spring-v1+json")
	@GetMapping(value = "/person/produces", produces = { "application/com.cpulover.spring-v1+json",
			"application/com.cpulover.spring-v1+xml" })
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}

	// @GetMapping(value = "/person/produces", produces ="application/com.cpulover.spring-v2+json")
	@GetMapping(value = "/person/produces", produces = { "application/com.cpulover.spring-v2+json",
			"application/com.cpulover.spring-v2+xml" })
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}