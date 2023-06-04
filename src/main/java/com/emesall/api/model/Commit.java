package com.emesall.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit implements Serializable {
	
	private static final long serialVersionUID = -666658332914506075L;
	
	private String sha;

}
