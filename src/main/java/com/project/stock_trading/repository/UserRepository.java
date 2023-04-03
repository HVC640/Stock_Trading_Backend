package com.project.stock_trading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.stock_trading.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select sum(u.accountBalance) from User u where u.id =:ID")
	public int findUserFundQuery(@Param("ID")  int id);
}
 