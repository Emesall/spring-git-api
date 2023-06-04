package com.emesall.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emesall.api.model.Repository;
import com.emesall.api.service.GithubApiService;

@Controller
public class IndexController {

	private final GithubApiService apiService;

	@Autowired
	public IndexController(GithubApiService apiService) {
		this.apiService = apiService;
	}

	@GetMapping({ "", "/", "/index" })
	public String getIndexPage() {

		
		
		return "index";
	}
	
	@GetMapping("/getUser/{username}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Repository> getUser(@PathVariable String username,@RequestParam("mediaType")String mediaType) {
		
		List<Repository> repos=apiService.getRepos(username,mediaType);
		return repos;
	}
	
	
	@PostMapping("/getUser")
	public String getUser(@ModelAttribute("username") String user,@ModelAttribute("mediaType") String mediaType,Model model) {
		
		return "redirect:/getUser/"+user+"?mediaType="+mediaType;
	}
}
