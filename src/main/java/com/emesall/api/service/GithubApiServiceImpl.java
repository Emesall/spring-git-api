package com.emesall.api.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emesall.api.model.Branch;
import com.emesall.api.model.Repository;

@Service
public class GithubApiServiceImpl implements GithubApiService {

	private RestTemplate restTemplate;

	private String api_url;

	@Autowired
	public GithubApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
		super();
		this.restTemplate = restTemplate;
		this.api_url = api_url;
	}

	@Override
	public List<Repository> getRepos(String username,String mediaType) {

		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Collections.singletonList(MediaType.parseMediaType(mediaType)));

		HttpEntity<String> request = new HttpEntity<String>(headers);
		api_url += username + "/repos";

		ResponseEntity<List<Repository>> repoResponse = restTemplate.exchange(api_url, HttpMethod.GET, request,
				new ParameterizedTypeReference<List<Repository>>() {
				});

		List<Repository> repos = repoResponse.getBody().stream().filter(repo -> !repo.isFork()).toList();
		for (Repository repo : repos) {
			List<Branch> branches = getBranches(repo.getBranchesUrl().split("\\{")[0],mediaType);
			repo.setBranches(branches);
		}
		return repos;

	}

	@Override
	public List<Branch> getBranches(String branches_url,String mediaType) {
		ResponseEntity<List<Branch>> branchResponse = restTemplate.exchange(branches_url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Branch>>() {
				});
		return branchResponse.getBody();
	}

}
