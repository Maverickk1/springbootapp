package com.tech;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.tech", lazyInit = true)
public class Application {
Logger log = LoggerFactory.getLogger(SpringBootApplication.class);


    public static void main(String[] args) {
    	
        new SpringApplicationBuilder(Application.class)
                .run(args);
    }
}

