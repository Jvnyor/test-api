package com.example.testapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Teste {

	private Long id;
	private String name;
	private String string;
	private boolean active;
	
}
