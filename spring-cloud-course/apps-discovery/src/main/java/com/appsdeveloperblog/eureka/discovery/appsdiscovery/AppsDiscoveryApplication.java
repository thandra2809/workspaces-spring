package com.appsdeveloperblog.eureka.discovery.appsdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppsDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsDiscoveryApplication.class, args);
	}

}
