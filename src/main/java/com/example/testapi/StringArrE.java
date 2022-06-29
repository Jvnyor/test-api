package com.example.testapi;

public enum StringArrE {

	N, S;

	public static boolean stringIsValid(String s) {
		return Enum.valueOf(StringArrE.class, s) != null;
	}

}
