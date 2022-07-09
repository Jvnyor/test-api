package com.example.testapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testapi.model.StringE;
import com.example.testapi.repository.ApiRepository;

@Service
public class ApiService {

	@Autowired
	private ApiRepository apiRepository;
	
	public List<String> arrayOfEnumsToStringTest(StringE[] eArr) {
		return apiRepository.arrayOfEnumsToStringTest(eArr);
	}
}
