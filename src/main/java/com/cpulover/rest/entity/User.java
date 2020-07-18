package com.cpulover.rest.entity;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="Details for the user")
public class User {
	private Integer id;
	
	@Size(min=2, message="Name should have at least 2 characters") //for validation
	@ApiModelProperty(notes="Name should have at least 2 characters") //for documentation
	private String name;
	
	@Past //only allow time in the past //for validation
	@ApiModelProperty(notes="Only allow time in the past") //for documentation
	private Date birthDate;
}
