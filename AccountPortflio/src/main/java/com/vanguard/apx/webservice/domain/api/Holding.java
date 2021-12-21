package com.vanguard.apx.webservice.domain.api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Holding {
	@DynamoDBAttribute
	 private long holdingId;
	@DynamoDBAttribute
	   private String holdingName;
	@DynamoDBAttribute
	   private long balance;
	@DynamoDBAttribute
	   private HoldingType holdingType ;
	@DynamoDBAttribute
	   private long quantity;
	public long getHoldingId() {
		return holdingId;
	}
	public void setHoldingId(long holdingId) {
		this.holdingId = holdingId;
	}
	public String getHoldingName() {
		return holdingName;
	}
	public void setHoldingName(String holdingName) {
		this.holdingName = holdingName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public HoldingType getHoldingType() {
		return holdingType;
	}
	public void setHoldingType(HoldingType holdingType) {
		this.holdingType = holdingType;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Holding(long holdingId, String holdingName, long balance, HoldingType holdingType, long quantity) {
		super();
		this.holdingId = holdingId;
		this.holdingName = holdingName;
		this.balance = balance;
		this.holdingType = holdingType;
		this.quantity = quantity;
	}
	   
}
