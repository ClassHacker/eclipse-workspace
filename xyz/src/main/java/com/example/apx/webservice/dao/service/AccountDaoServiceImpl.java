package com.example.apx.webservice.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apx.webservice.Exception.AccountException;
import com.example.apx.webservice.dao.repo.AccountRepository;
import com.example.apx.webservice.domain.api.Account;

@Service
public class AccountDaoServiceImpl implements AccountDaoService{
	
	@Autowired
 AccountRepository accountRepository;
	
	public AccountDaoServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public AccountDaoServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	

	@Override
	public Account updateAccount(Account account, long id) {
		
		Account existingaccount = accountRepository.findById(id).orElseThrow(
			() ->new AccountException(id))	;
		
		existingaccount.setAccountName(account.getAccountName());
		existingaccount.setProfileId(account.getProfileId());
		existingaccount.setTotalBalance(account.getTotalBalance());
		existingaccount.setHolding(account.getHolding());	
		accountRepository.save(existingaccount);
		
		return existingaccount;
	}



	@Override
	public void deleteAccount(long id) {
		
		Account existingaccount = accountRepository.findById(id).orElseThrow(
				() ->new AccountException(id));
		
		accountRepository.deleteById(id);
		
	}

}
