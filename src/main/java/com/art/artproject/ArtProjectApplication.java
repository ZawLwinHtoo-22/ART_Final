package com.art.artproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArtProjectApplication{

    public static void main(String[] args) {
        SpringApplication.run(ArtProjectApplication.class, args);
    }

    @Bean
    ModelMapper modelMapper() { // To perform injection, the method must be bean
        return new ModelMapper();
    }


}
