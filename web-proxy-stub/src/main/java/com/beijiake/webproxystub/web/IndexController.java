package com.beijiake.webproxystub.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexController {


    @RequestMapping("/")
    public String doGet(HttpServletResponse response) {
        response.setHeader("X-XSRF-TOKEN", "2222345555");
        return "hello";
    }
}
