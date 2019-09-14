package com.company.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

	@JsonProperty(value = "NAME")
	private String name;
	@JsonProperty(value = "department")
	private String dept;
	@JsonProperty("salary")
	private Long salary;
	@JsonProperty("addKey")
	private Address address;
	@Override
	public String toString() {
		return "User [name=" + name + ", dept=" + dept + ", salary=" + salary + ", address=" + address.toString() + "]";
	}
	
	
}
