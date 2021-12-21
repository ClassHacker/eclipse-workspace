package com.vanguard.apx.webservice.dao.service;

import com.vanguard.apx.webservice.domain.api.Account;

public interface AccountDaoService{
	
   Account saveAccount(Account account) ;
	
	List<Account> getAllAccounts();
	
	//Account updateAccount(Account account, long id) ;
	
	//void deleteAccount(long id) ;


}
