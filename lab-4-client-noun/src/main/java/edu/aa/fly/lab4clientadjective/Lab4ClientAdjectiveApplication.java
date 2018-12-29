package edu.aa.fly.lab4clientadjective;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication (scanBasePackages = "edu.aa.fly")
@EnableDiscoveryClient
public class Lab4ClientAdjectiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4ClientAdjectiveApplication.class, args);
    }

}

