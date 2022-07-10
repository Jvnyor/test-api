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
import com.example.testapi.model.Teste;
import com.example.testapi.util.StringToEnumConverter;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ApiRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Teste> arrayOfEnumsToStringTest(String active, StringE[] eArr) {
		final StringToEnumConverter stringToEnumConverter = new StringToEnumConverter();
		
		String sql = null;
		
		String eArrToString = (eArr != null && eArr.length > 0)
				? Arrays.stream(eArr)
						.filter(e -> stringToEnumConverter.convert(e.toString()) != null)
						.map(e -> String.format("'%s'", e))
						.collect(Collectors.joining(", "))
				: null;
		
		List<Map<String, Object>> queryForList = null;
		
		log.info(eArrToString);
		
		if (active != null && active.isBlank()) active = null;
		
		if (eArrToString == null && active != null) {
			sql = "SELECT id, name, string, active FROM teste.testes t WHERE t.active = ? AND t.string IN ('TESTE1', 'TESTE2', 'TESTE3')";
			queryForList = this.jdbcTemplate.queryForList(sql, active);
		} else if (active == null && eArrToString != null) {
			sql = "SELECT id, name, string, active FROM teste.testes t WHERE t.active IN (1,0) AND t.string IN (%s)".formatted(eArrToString);
			queryForList = this.jdbcTemplate.queryForList(sql);
		} else if (active == null && eArrToString == null) {
			sql = "SELECT id, name, string, active FROM teste.testes t WHERE t.active IN (1,0) AND t.string IN ('TESTE1', 'TESTE2', 'TESTE3')";
			queryForList = this.jdbcTemplate.queryForList(sql);
		} else {
			sql = "SELECT id, name, string, active FROM teste.testes t WHERE t.active = ? AND t.string IN (%s)".formatted(eArrToString);
			queryForList = this.jdbcTemplate.queryForList(sql, active);
		}
		
		log.info(sql);
		
		List<Teste> testes = new ArrayList<>();
		
		queryForList.stream().forEach(map -> {
			testes.add(Teste.builder()
						.id(Long.valueOf(map.get("id").toString()))
						.name(map.get("name").toString())
						.string(map.get("string").toString())
						.active((Integer.valueOf(map.get("active").toString()) == 1) ? true : false)
						.build());
		});
		
		return testes;
	}
}
