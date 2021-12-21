package com.vanguard.apx.webservice.resource;



	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.vanguard.apx.webservice.dao.service.AccountDaoService;
import com.vanguard.apx.webservice.domain.api.Account;



	@RestController
	@RequestMapping("/account")
	public class AccountResource {
		private DynamoDBMapper dynamoDBMapper;

	    @Autowired
	    private AmazonDynamoDB amazonDynamoDB;

	    @Autowired
	    AccountDaoService accountDaoService;

	    private static final String EXPECTED_COST = "20";
	    private static final String EXPECTED_PRICE = "50";


		
		
		
		
		  @PostMapping 
		  public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
			  return new
		  ResponseEntity<Account>(accountDaoService.saveAccount(account), HttpStatus.CREATED);
		  
		  }
		 
		
		@GetMapping
		public List<Account> getAllAccount() throws Exception{
			dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
	        
	        CreateTableRequest tableRequest = dynamoDBMapper
	          .generateCreateTableRequest(Account.class);
	        tableRequest.setProvisionedThroughput(
	          new ProvisionedThroughput(1L, 1L));
	        //amazonDynamoDB.createTable(tableRequest);
	        
	        //...
	        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
	        List<Account> scanResult = dynamoDBMapper.scan(Account.class, scanExpression);
	        return scanResult;
//	        dynamoDBMapper.batchDelete(
//	          (List<Account>)accountDaoService.findAll());
	    
			
			
			
		}
		
		
		/*
		 * @PutMapping("{id}") public ResponseEntity<ProductInfo>
		 * updateAccount(@PathVariable("id") long id,@RequestBody Account account)
		 * throws StreamReadException, DatabindException, FileNotFoundException,
		 * IOException{ return new
		 * ResponseEntity<Account>(accountDaoService.updateAccount(account, id),
		 * HttpStatus.OK); }
		 * 
		 * 
		 * 
		 * @DeleteMapping("{id}") public ResponseEntity<String>
		 * deleteAccount(@PathVariable("id") long id) throws StreamReadException,
		 * DatabindException, FileNotFoundException, IOException{
		 * 
		 * accountDaoService.deleteAccount(id);
		 * 
		 * return new
		 * ResponseEntity<String>("Account deleted Sucessfully!",HttpStatus.OK);
		 * 
		 * }
		 */
	}


