package com.huayutech.web;

import com.huayutech.web.config.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }




    @Bean
    CommandLineRunner init(StorageProperties storageProperties) {
        return (args)->{

            String rootLocation = storageProperties.getLocation();
            if (!Files.isWritable(Paths.get(rootLocation)))
            {
                System.out.println(String.format("the storage location %s is not writable.", rootLocation));
            }
        };
    }

}
