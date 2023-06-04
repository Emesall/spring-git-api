package com.emesall.api.service;

import java.util.List;

import com.emesall.api.model.Branch;
import com.emesall.api.model.Repository;

public interface GithubApiService {

	public List<Repository> getRepos(String username,String mediaType);
	public List<Branch> getBranches(String branches_url, String mediaType);
}
