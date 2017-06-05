package com.souvc.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
public class SpringbootSampleSchedulingApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringbootSampleSchedulingApplication.class);

	public static void main(String[] args) {
		logger.info("My Spring Boot Application Started");
		SpringApplication.run(SpringbootSampleSchedulingApplication.class, args);
	}
}
