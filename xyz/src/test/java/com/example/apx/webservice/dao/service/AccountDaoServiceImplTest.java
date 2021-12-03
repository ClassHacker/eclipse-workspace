package com.example.apx.webservice.dao.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.apx.webservice.Exception.AccountException;
import com.example.apx.webservice.dao.repo.AccountRepository;
import com.example.apx.webservice.domain.api.Account;
import com.example.apx.webservice.domain.api.Holding;

public class AccountDaoServiceImplTest {
	
	@InjectMocks
	AccountDaoServiceImpl accountDaoServiceImpl ;
	
	@Mock
	private AccountRepository accountRepository;
	
	Account account = new Account();
	Holding holding = new Holding();
	
	@BeforeEach
	public void setup() {
		Account account = new Account();
		Holding holding = new Holding();
		holding.setBalance(55);
		holding.setHid(006);
		holding.setHoldingName("holding name");
		holding.setHoldingType("bond");
		holding.setQuantity(55);
		List<Holding> holdings = new ArrayList();
		holdings.add(holding);
		account.setAccountName("acc name");
		account.setHolding(holdings);
		account.setProfileId("profile");
		account.setTotalBalance(10000);
		account.setId(005);
		
		
	}
	
	@Test
	public void testGetAllAccounts() {
		List<Account> accounts = new ArrayList();
		accounts.add(account);
		when(accountRepository.findAll()).thenReturn(accounts);
		assertTrue(accountDaoServiceImpl.getAllAccounts().size()>0);
	}
	
	@Test
	public void testSaveAccount() {
		when(accountRepository.save(account)).thenReturn(account);
		assertEquals(account,accountDaoServiceImpl.saveAccount(account));

	}
	
	@Test
	public void testUpdateAccount() {
		Account oldAcc = new Account();
		oldAcc = account;
		long id  = 005;
		when(accountRepository.findById(id).orElseThrow(
				() ->new AccountException(id))).thenReturn(account);
		assertEquals(account,accountDaoServiceImpl.updateAccount(oldAcc,id));
		
	}
	
	@Test
	public void testDeleteAccount() {
		Account oldAcc = new Account();
		oldAcc = account;
		long id  = 005;
		Account deletedAccount = null;
		accountDaoServiceImpl.deleteAccount(id);
		assertEquals(deletedAccount,oldAcc);
		
	}



	

}
