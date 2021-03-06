package edu.aa.fly.lab4clientsentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "edu.aa.fly")
public class Lab4ClientSentenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4ClientSentenceApplication.class, args);
    }

}
