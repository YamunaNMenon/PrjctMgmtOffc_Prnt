package com.fse.pmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PrjctMgmtOffcDiscovServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjctMgmtOffcDiscovServiceApplication.class, args);
	}

}
