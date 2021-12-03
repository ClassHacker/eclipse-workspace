package com.example.apx.webservice.dao.service;

import java.util.List;

import com.example.apx.webservice.domain.api.Account;


public interface AccountDaoService {
	
	
	Account saveAccount(Account account);
	
	List<Account> getAllAccounts();
	
	Account updateAccount(Account account, long id);
	
	void deleteAccount(long id);


}
