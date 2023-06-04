package com.emesall.api.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emesall.api.model.Repository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GithubApiServiceImplTest {

	@Autowired
	GithubApiService apiService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetRepos() {
		List<Repository> repos=apiService.getRepos("Emesall","application/json");
		System.out.println(repos);
	}

}
