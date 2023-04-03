package com.project.stock_trading.entity;

import jakarta.persistence.*;

@Entity
@Table(name="company")
public class Company {

	@Id
	private int id;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="companyDescription")
	private String companyDescription;
	
	@Column(name="stockPrice")
	private int stockPrice;
	
	@Column(name="changePercent")
	private int changePercent;
	
	@Column(name="stockValueChange")
	private int stockValueChange;
	
	@Column(name="companySector")
	private String companySector;
	
	@Column(name="volume")
	private int volume; //Total purchase of share
	
	@Column(name="marketCapital")
	private int marketCapital; //volume * stockPrice

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String companyName, String companyDescription, int stockPrice, int changePercent,
			int stockValueChange, String companySector, int volume, int marketCapital) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyDescription = companyDescription;
		this.stockPrice = stockPrice;
		this.changePercent = changePercent;
		this.stockValueChange = stockValueChange;
		this.companySector = companySector;
		this.volume = volume;
		this.marketCapital = marketCapital;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(int changePercent) {
		this.changePercent = changePercent;
	}

	public int getStockValueChange() {
		return stockValueChange;
	}

	public void setStockValueChange(int stockValueChange) {
		this.stockValueChange = stockValueChange;
	}

	public String getCompanySector() {
		return companySector;
	}

	public void setCompanySector(String companySector) {
		this.companySector = companySector;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getMarketCapital() {
		return marketCapital;
	}

	public void setMarketCapital(int marketCapital) {
		this.marketCapital = marketCapital;
	}
	
	
}
