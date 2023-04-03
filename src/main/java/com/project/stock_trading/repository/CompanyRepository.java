package com.project.stock_trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stock_trading.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
