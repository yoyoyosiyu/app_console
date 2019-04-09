package com.beijiake.webproxystub.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;

public class MyCorsConfigurationSource implements CorsConfigurationSource {
    @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest httpServletRequest) {
        return new CorsConfiguration().applyPermitDefaultValues();
    }
}
