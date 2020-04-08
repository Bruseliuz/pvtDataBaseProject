package com.example.mysqlspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MysqlspringApplication extends ServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MysqlspringApplication.class, args);
    }

}
