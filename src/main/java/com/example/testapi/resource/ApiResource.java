package com.example.testapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testapi.model.StringE;
import com.example.testapi.service.ApiService;

@RestController
@RequestMapping("/test")
public class ApiResource {

	@Autowired
	private ApiService apiService;

	@GetMapping
	public ResponseEntity<String> arrayToStringFormatted(
			@RequestParam(name = "arrE", required = false) StringE[] arrE) {
		return ResponseEntity.ok(apiService.arrayOfEnumsToStringFormatted(arrE));
	}
}
