package com.decio.desafio;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.decio.desafio.services.DBService;


@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService db;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		db.instantiateDataBase();
		return true;
	}
	
}