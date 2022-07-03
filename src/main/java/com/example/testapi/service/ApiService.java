package com.example.testapi.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.testapi.model.StringE;
import com.example.testapi.util.StringToEnumConverter;

@Service
public class ApiService {

	public String arrayOfEnumsToStringFormatted(StringE[] arrE) {
		final StringToEnumConverter stringToEnumConverter = new StringToEnumConverter();
		return (arrE != null && arrE.length > 0)
				? Arrays.stream(arrE)
						.filter(e -> stringToEnumConverter.convert(e.toString()) != null)
						.map(e -> String.format("'%s'", e)).collect(Collectors.joining(", "))
				: null;
	}
}
