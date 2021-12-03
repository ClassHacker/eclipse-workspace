package com.example.apx.webservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apx.webservice.dao.repo.AccountRepository;
import com.example.apx.webservice.dao.service.AccountDaoService;
import com.example.apx.webservice.domain.api.Account;
import com.example.apx.webservice.utility.APXUtillity;



@RestController
@RequestMapping("/account")
public class AccountResource {


	@Autowired
	AccountRepository accountRepository;
	@Autowired
	private AccountDaoService accountDaoService;
	@Autowired
	private APXUtillity aPXUtillity;

	public AccountResource(AccountDaoService accountDaoService, APXUtillity aPXUtillity,AccountRepository accountRepository) {
		super();
		this.accountDaoService = accountDaoService;
		this.aPXUtillity = aPXUtillity;
		this.accountRepository = accountRepository;
	}
	
	@PostMapping
	public ResponseEntity<Account> saveAccount(@RequestBody Account account){
		return new ResponseEntity<Account>(accountDaoService.saveAccount(account), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Account> getAllAccount(@RequestParam(required = false) boolean holdingName,@RequestParam(required = false) boolean holdingId){
		List<Account> accounts = accountDaoService.getAllAccounts();
		if(holdingId == true) {
			accounts = aPXUtillity.sortAccounts(accounts, holdingId);
		}
		
		return accounts;
		
	}
	
	

	@PutMapping("{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") long id,@RequestBody Account account){
		return new ResponseEntity<Account>(accountDaoService.updateAccount(account, id), HttpStatus.OK);
	}

	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") long id){
		
		accountDaoService.deleteAccount(id);
		
		return new ResponseEntity<String>("Account deleted Sucessfully!",HttpStatus.OK);
		
	}
}
