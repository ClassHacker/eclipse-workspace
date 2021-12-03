package com.example.apx.webservice.dao.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apx.webservice.domain.api.Account;

@Repository
@Transactional
public interface AccountRepository  extends JpaRepository<Account, Long>{

}
