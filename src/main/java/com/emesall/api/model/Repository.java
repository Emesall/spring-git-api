package com.emesall.api.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository implements Serializable {

	
	private static final long serialVersionUID = -5069906439545351297L;
	
	private String name;
	private Owner owner;
	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonAlias("branches_url")
	private String branchesUrl;
	private List<Branch> branches;
	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonAlias("fork")
	private boolean isFork;
	
}