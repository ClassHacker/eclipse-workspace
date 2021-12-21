package com.vanguard.apx.webservice.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.vanguard.apx.webservice.domain.api.Account;

@Service
public class AccountDaoServiceIImpl implements AccountDaoService{
	private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
	public Account saveAccount(Account account) {
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		dynamoDBMapper.save(account);
		return account;
		
	}
	
	public List<Account> getAllAccounts(){
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<Account> scanResult = dynamoDBMapper.scan(Account.class, scanExpression);
        return scanResult;
	}
}
