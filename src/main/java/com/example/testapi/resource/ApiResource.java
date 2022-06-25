package com.example.testapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testapi.service.ApiService;

@RestController
@RequestMapping("/test")
public class ApiResource {

	@Autowired
	private ApiService apiService;
	
	@GetMapping
	public String arrayToStringFormatted(String[] stringArr) {
		return apiService.arrayToStringFormatted(stringArr);
	}
}
