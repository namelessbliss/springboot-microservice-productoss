package com.nb.springbootmicroserviceproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.nb.springbootmicroservicecommons.Models.Entity"})
public class SpringbootMicroserviceProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMicroserviceProductosApplication.class, args);
    }

}
