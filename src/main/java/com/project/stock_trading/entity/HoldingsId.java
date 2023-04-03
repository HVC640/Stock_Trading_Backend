package com.project.stock_trading.entity;

import java.io.Serializable;

public class HoldingsId implements Serializable {
	private int userId;

	private int companyId;
	
	public HoldingsId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoldingsId(int userId, int companyId) {
		super();
		this.userId = userId;
		this.companyId = companyId;
	}

    
    // equals() and hashCode()
}