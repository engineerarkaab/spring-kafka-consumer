package com.company.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@JsonProperty(value="ADDRESS")
	private String address;
	
	@Override
	public String toString() {
		return "Address [address=" + address + "]";
	}
}
