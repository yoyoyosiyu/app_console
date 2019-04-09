package com.huayutech.web;

import com.huayutech.web.config.StorageProperties;
import com.huayutech.web.service.StorageException;
import com.huayutech.web.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({StorageProperties.class})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }




    @Bean
    CommandLineRunner init(StorageProperties storageProperties, StorageService storageService) {
        return (args)->{


            storageService.init();

            String rootLocation = storageProperties.getLocation();



            if (!Files.isWritable(Paths.get(rootLocation)))
            {
                throw new StorageException(String.format("The storage location %s is not writable.", rootLocation));
            }

            Logger logger = LoggerFactory.getLogger(getClass());

            logger.info(String.format("The upload storage have already set to location: %s", rootLocation));
        };
    }

}
