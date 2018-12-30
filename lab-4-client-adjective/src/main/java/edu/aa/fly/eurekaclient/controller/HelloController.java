package edu.aa.fly.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Value("${words}")
    private String words;

    @GetMapping("/")
    public String giveAdjective() {
        String[] wordArray = words.split(",");
        int i = (int) Math.round(Math.random() * (wordArray.length - 1));
        LOGGER.info("Adjective Controller; word -> {}", wordArray[i]);

        return wordArray[i];
    }
}
