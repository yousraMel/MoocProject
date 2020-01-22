package com.inti.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.util.concurrent.Service;
import com.inti.formation.entities.Committee;
import com.inti.formation.iservices.ICommitteeService;
import com.inti.formation.services.CommitteeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MoocProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoocProjectApplication.class, args);
	}
	
	
}
