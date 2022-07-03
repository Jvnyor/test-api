package com.example.testapi.util;

import org.springframework.core.convert.converter.Converter;

import com.example.testapi.model.StringE;

public class StringToEnumConverter implements Converter<String, StringE> {

	@Override
	public StringE convert(String s) {
		return Enum.valueOf(StringE.class, s);
	}

}
