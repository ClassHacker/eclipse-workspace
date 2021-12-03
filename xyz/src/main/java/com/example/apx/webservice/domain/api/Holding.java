package com.example.apx.webservice.domain.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "holdings")
public class Holding {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private long holdingId;
	   
	   @Column(name = "holding_name")
	   private String holdingName;
	   
	   @Column(name = "holding_balance")
	   private long balance;
	   
	   @Column(name = "holding_type")
	   private String holdingType ;
	   
	   @Column(name = "holding_quantity")
	   private long quantity;

   public long getHid() {
		return holdingId;
	}

	public void setHid(long hid) {
		this.holdingId = hid;
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

	public String getHoldingType() {
		return holdingType;
	}

	public void setHoldingType(String holdingType) {
		this.holdingType = holdingType;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


   
	
}


