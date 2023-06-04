package com.emesall.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch implements Serializable {

	
	private static final long serialVersionUID = 4478845159221292058L;
	
	private String name;
	@JsonAlias("commit")
	private Commit lastCommit;
}
