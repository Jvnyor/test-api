package com.example.testapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StringE {

	S("'S'"), M("'M'"), I("'I'");

	private final String param;

	public static boolean stringIsEnum(String s) {
		return Enum.valueOf(StringE.class, s) != null;
	}

}
