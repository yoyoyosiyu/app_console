package com.beijiake.webproxystub;

import com.beijiake.webproxystub.config.AuthorizationServerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AuthorizationServerProperties.class)
public class WebProxyStubApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProxyStubApplication.class, args);
    }

}
