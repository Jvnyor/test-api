package com.example.testapi.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiService {

	public String arrayToStringFormatted(String[] stringArr) {
		String string = null;
		if (stringArr.length > 1) {
			String[] stringArr2 = new String[stringArr.length];
			for (int i = 0; i < stringArr.length; i++) {
				stringArr2[i] = String.format("'%s'", stringArr[i].trim());
			}
			stringArr = stringArr2;
			string = String.join(",", stringArr);
		}
		if (stringArr.length == 1) {
			String s = String.format("'%s'", stringArr[0].trim());
			log.info(s);
			return s;
		}
		log.info(string);
		return string;
	}
}
