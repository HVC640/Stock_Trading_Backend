package com.project.stock_trading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stock_trading.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	public List<Orders> findAllByUserId(int id);
}
