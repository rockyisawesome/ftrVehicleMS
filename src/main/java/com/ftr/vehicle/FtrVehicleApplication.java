package com.ftr.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FtrVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtrVehicleApplication.class, args);
	}

}
