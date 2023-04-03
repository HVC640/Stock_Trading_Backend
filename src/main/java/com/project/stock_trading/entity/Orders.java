package com.project.stock_trading.entity;


import java.time.*;
import java.util.*;

import jakarta.persistence.*;


@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="companyId")
	private int companyId;
	
	@Column(name="orderTime")
	private LocalDate orderTime;
	
	@Column(name="orderType")
	private int orderType; // 0 - sell, 1 - buy

	@Column(name="stockPrice")
	private int stockPrice;
	
	@Column(name="stockQuantity")
	private int stockQuantity;
	
	@Column(name="totalAmount")
	private int totalAmount;
	

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Orders(int id, int userId, int companyId, LocalDate orderTime, int orderType, int stockPrice,
			int stockQuantity, int totalAmount) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyId = companyId;
		this.orderTime = orderTime;
		this.orderType = orderType;
		this.stockPrice = stockPrice;
		this.stockQuantity = stockQuantity;
		this.totalAmount = totalAmount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public LocalDate getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(LocalDate orderTime) {
		this.orderTime = orderTime;
	}


	public int getOrderType() {
		return orderType;
	}


	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}


	public int getStockPrice() {
		return stockPrice;
	}


	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}


	public int getStockQuantity() {
		return stockQuantity;
	}


	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}


	public int getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}


	
	
	

}
