package com.beijiake.webproxystub.web;

import com.beijiake.webproxystub.config.AuthorizationServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class TokenController {

    @Autowired
    AuthorizationServerProperties authorizationServerProperties;

    Logger logger = LoggerFactory.getLogger(TokenController.class);

    @PostMapping("/oauth/token")
    public ResponseEntity doObtainAccessToken(@RequestPart("username") String username, @RequestPart("password") String password) {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("username", username);
        body.add("password", password);

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        restTemplate.getInterceptors()
                .add(new BasicAuthenticationInterceptor(
                        authorizationServerProperties.getClientId(),
                        authorizationServerProperties.getClientSecret()
                ));

        try {
            ResponseEntity<Map> responseEntity = restTemplate.postForEntity(authorizationServerProperties.getTokenUrl(), requestEntity, Map.class);

            return responseEntity;
        }
        catch(RestClientException restClientException) {
            return new ResponseEntity<>(restClientException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
