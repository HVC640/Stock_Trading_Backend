package com.project.stock_trading.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;



@Entity
@Table(name="userHoldings")
@IdClass(HoldingsId.class)
public class UserHoldings {

	@Id
	private int userId;
	
	@Id
	private int companyId;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="buyPrice")
	private int buyPrice;
	
	@Column(name="currentPrice")
	private int currentPrice;
	
	public UserHoldings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserHoldings(int userId, int companyId, int quantity, int buyPrice, int currentPrice) {
		super();
		this.userId = userId;
		this.companyId = companyId;
		this.quantity = quantity;
		this.buyPrice = buyPrice;
		this.currentPrice = currentPrice;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

}
