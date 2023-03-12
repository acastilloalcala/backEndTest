package com.acastillo.dev.backEndTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class BackEndTestConfiguration {
	
	@Bean
	public TracerImpl getTracer () {
		return new TracerImpl();
	}

}
