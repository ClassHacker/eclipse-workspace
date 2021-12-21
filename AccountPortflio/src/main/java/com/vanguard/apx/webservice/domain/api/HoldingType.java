package com.vanguard.apx.webservice.domain.api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class HoldingType {
	@DynamoDBAttribute
	String stock;
	@DynamoDBAttribute
	String bond;
	@DynamoDBAttribute
	String cash;
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getBond() {
		return bond;
	}
	public void setBond(String bond) {
		this.bond = bond;
	}
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public HoldingType(String stock, String bond, String cash) {
		super();
		this.stock = stock;
		this.bond = bond;
		this.cash = cash;
	}
	

}
