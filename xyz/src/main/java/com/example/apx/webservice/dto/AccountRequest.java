package com.example.apx.webservice.dto;

import com.example.apx.webservice.domain.api.Account;

class AccountRequest {
	
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountRequest(Account account) {
		super();
		this.account = account;
	}

}
