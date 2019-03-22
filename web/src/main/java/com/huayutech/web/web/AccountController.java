package com.huayutech.web.web;


import com.huayutech.web.domain.Account;
import com.huayutech.web.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")
    public ResponseEntity findAccounts() {

        Page<Account> accountPage = accountRepository.findAll(PageRequest.of(0, 10));

        int pages = accountPage.getTotalPages();
        List<Account> accounts = accountPage.getContent();

        return new ResponseEntity(HttpStatus.OK);

    }
}
