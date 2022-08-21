package edu.training.traineesrestapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    /**
     * Method of interface type where it's responsible for manipulate the password
     * Contains methods to match and encode a given password
     * @return
     */


    @Bean
    public PasswordEncoder passwordEncoder(){

        // BCryptPasswordEncoder is the most popular encoder for passwords
        return new BCryptPasswordEncoder(10);
    }
}
