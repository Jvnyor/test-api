package com.example.testapi.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.testapi.model.StringE;
import com.example.testapi.util.StringToEnumConverter;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ApiRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> arrayOfEnumsToStringTest(StringE[] eArr) {
		final StringToEnumConverter stringToEnumConverter = new StringToEnumConverter();
		
		String sql = "SELECT id, string from teste.testes t where t.string IN (%s)";
		
		String eArrToString = (eArr != null && eArr.length > 0)
				? Arrays.stream(eArr)
						.filter(e -> stringToEnumConverter.convert(e.toString()) != null)
						.map(e -> String.format("'%s'", e))
						.collect(Collectors.joining(", "))
				: null;
		
		log.info(eArrToString);
		
		if (eArrToString == null || eArrToString.isBlank()) {
			sql = "SELECT id, string from teste.testes t where t.string IN ('TESTE', 'TESTE2', 'TESTE3')";
		}
		
		sql = sql.formatted(eArrToString);
		
		List<Map<String, Object>> queryForList = this.jdbcTemplate.queryForList(sql);
		
		log.info(sql);
		
		List<String> strings = new ArrayList<>();
		
		queryForList.stream().forEach(s -> {
			strings.add(s.get("string").toString());
		});
		
		return strings;
	}
}
