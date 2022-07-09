package com.example.testapi.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

class StringToEnumConverterTest {

	final StringToEnumConverter stringToEnumConverter = new StringToEnumConverter();
	
	@Test
	void testStringToEnumConverterReturnsNullIfEnumNotExist() {
		assertThrows(IllegalArgumentException.class, () -> stringToEnumConverter.convert(ArgumentMatchers.anyString()));
	}

}
