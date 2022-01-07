package com.jsanhueza.matricula;

import com.jsanhueza.matricula.config.RibbonConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClients(defaultConfiguration = {RibbonConfigurator.class})
@EnableCircuitBreaker
public class MatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculaApplication.class, args);
	}

}
