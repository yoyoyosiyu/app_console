package com.huayutech.web.web;

import com.huayutech.web.domain.Account;
import com.huayutech.web.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


// 用于注册账户
@Controller
public class RegisterAccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @RequestMapping("/register")
    public ModelAndView doRegister(
            HttpServletRequest request,
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name = "password", required = false) String password,
            @RequestParam(name="password_confirm", required = false) String passwordConfirm) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        if (request.getMethod().equalsIgnoreCase("GET")) {
            return modelAndView;
        }

        if (password == null) {
            modelAndView.addObject("error", "密码不能为空");

            return modelAndView;
        }

        if (!password.equals(passwordConfirm)){
            modelAndView.addObject("error", "两次输入的密码不一致");
            return modelAndView;
        }

        if (accountRepository.findByUserName(name).isPresent())
        {
            modelAndView.addObject("error", "账号已经被注册");
            return modelAndView;
        }

        Account newAccount = new Account();

        newAccount.setUserName(name);
        newAccount.setPassword(passwordEncoder.encode(password));

        accountRepository.save(newAccount);


        return modelAndView;

    }


}
