package com.emesall.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner implements Serializable {

	
	private static final long serialVersionUID = 2193198963233488381L;
	@JsonAlias("login")
	private String name;
}
