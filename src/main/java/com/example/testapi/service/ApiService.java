package com.example.testapi.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.testapi.model.StringE;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiService {

	public String arrayOfEnumsToStringFormatted(StringE[] arrE) {
		final String regex = "[\\[\\]]";
		if (arrE != null && arrE.length > 0) {
			String[] arrS = new String[arrE.length];
			for (int i = 0; i < arrE.length; i++) {
				if (StringE.stringIsEnum(arrE[i].toString().trim())) {
					arrS[i] = arrE[i].getParam();
				}
			}
			log.info("Array of string(s): {}", Arrays.toString(arrS).replaceAll(regex, ""));
			return Arrays.toString(arrS).replaceAll(regex, "");
		}

		return null;
	}
}
