package com.example.testapi.service;

import org.springframework.stereotype.Service;

import com.example.testapi.StringArrE;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiService {

	public String arrayToStringFormatted(String[] stringArr) {
		String string = null;

		if (stringArr.length > 1) {
			for (int i = 0; i < stringArr.length; i++) {
				if (StringArrE.stringIsValid(stringArr[i])) {
					stringArr[i] = String.format("'%s'", stringArr[i].trim());
				} else {
					throw new IllegalArgumentException();
				}
			}
			string = String.join(",", stringArr);
		}
		if (stringArr.length == 1) {
			if (StringArrE.stringIsValid(stringArr[0])) {
				string = String.format("'%s'", stringArr[0].trim());
			} else {
				throw new IllegalArgumentException();
			}
		}

		log.info(string);
		return string;
	}
}
