package com.cpulover.rest.entity;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.cpulover.rest.view.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="Details for the user")
//@JsonIgnoreProperties(value = {"name", "birthDate"}) //for static filtering: exclude fields from JSON response
public class User {
	@JsonView(UserView.Id.class)
	private Integer id;
	
	@Size(min=2, message="Name should have at least 2 characters") //for validation
	@ApiModelProperty(notes="Name should have at least 2 characters") //for documentation
	@JsonView(UserView.Name.class)
	private String name;
	
	@Past //only allow time in the past //for validation
	@ApiModelProperty(notes="Only allow time in the past") //for documentation
	@JsonView(UserView.Birthdate.class)
	private Date birthDate;
	
	//@JsonIgnore // for static filtering: exclude this field from JSON response
	@JsonView(UserView.Password.class)
	private String password;
}

