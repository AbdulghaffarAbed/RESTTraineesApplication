package edu.training.traineesrestapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The goal of this application is to deal with REST API and HTTP CRUD methods
 * Use postman for CRUD methods and for send JSON file in the body
 * Deal with postgreSQL database
 * Add authentication and authorization to the code
 * ADMIN userName: AbdulghaffarAbed password:1234 can do everything
 * TRAINER userName: wisamAssi password:wisam1234 can execute GET and PUT only cannot POST nor DELETE
 */


@SpringBootApplication
public class TraineesRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraineesRestApplication.class, args);
    }

}
