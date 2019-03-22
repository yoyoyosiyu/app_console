package com.huayutech.web.repository;

import com.huayutech.web.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Optional<Account> findByUserName(String username);


}
