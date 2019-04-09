package com.beijiake.webproxystub.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


@Setter // need setter method to works
@Getter
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "authorization-server")
public class AuthorizationServerProperties {

    String tokenUrl;
    String clientId;
    String clientSecret;

}
