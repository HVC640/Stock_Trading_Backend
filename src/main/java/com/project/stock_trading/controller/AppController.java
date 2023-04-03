package com.project.stock_trading.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.stock_trading.entity.Company;
import com.project.stock_trading.entity.User;
import com.project.stock_trading.entity.Orders;
import com.project.stock_trading.entity.UserHoldings;
import com.project.stock_trading.entity.HoldingsId;
import com.project.stock_trading.repository.CompanyRepository;
import com.project.stock_trading.repository.UserRepository;
import com.project.stock_trading.repository.OrdersRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;

import com.project.stock_trading.repository.UserHoldingsRepository;

@RestController
public class AppController {
	
	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserHoldingsRepository userHoldingsRepo;
	
	@Autowired
	OrdersRepository ordersRepo;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getAllCompanies")
	public List<Company> getAllCompanies() {
		List<Company> companyListing = companyRepo.findAll();
		return companyListing;
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertCompany")
	public String insertCompany(@RequestBody Company company) {
		System.out.println("Received data : " + company);
		companyRepo.save(company);
		return "Record inserted successfully...";
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping(path="/getUser/{id}")
	public Optional<User> getUser(@PathVariable int id){
		return userRepo.findById(id);
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getUserHoldings/{id}")
	public List<UserHoldings> getUserHoldings(@PathVariable int id) {
		List<UserHoldings> list = userHoldingsRepo.findAllByUserId(id);
		return list;
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertUser")
	public String insertUser (@RequestBody User userObj) {
		System.out.println("Received data : " + userObj);
		userRepo.save(userObj);
		return "Record inserted successfully...";
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getOrders/{id}")
	public List<Orders> getOrders(@PathVariable int id) {
		List<Orders> list = ordersRepo.findAllByUserId(id);
		return list;
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertOrder")
	public String insertOrder (@RequestBody Orders ordersObj) {
		System.out.println("Received data : " + ordersObj);
		ordersRepo.save(ordersObj);
		return "Record inserted successfully...";
	}

	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/insertHoldings")
	public String insertHoldings (@RequestBody UserHoldings holdingsObj) {
		System.out.println("Received data : " + holdingsObj);
		
		HoldingsId hid = new HoldingsId(holdingsObj.getUserId(), holdingsObj.getCompanyId());
		Optional<UserHoldings> obj = userHoldingsRepo.findById(hid);
		
		if(obj.isPresent()) {
			UserHoldings updatedHolding = obj.get();
			
			updatedHolding.setQuantity(updatedHolding.getQuantity() + holdingsObj.getQuantity());
			updatedHolding.setBuyPrice(holdingsObj.getBuyPrice());
			updatedHolding.setCurrentPrice(holdingsObj.getCurrentPrice());
			
			userHoldingsRepo.save(updatedHolding);
			return "Record Updated successfully...";
		}
		userHoldingsRepo.save(holdingsObj);
		return "Record inserted successfully...";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping (path="/updateHoldings")
	public String updateHoldings (@RequestBody UserHoldings holdingsObj) {
		System.out.println("Received data : " + holdingsObj);
		
		HoldingsId hid = new HoldingsId(holdingsObj.getUserId(), holdingsObj.getCompanyId());
		Optional<UserHoldings> obj = userHoldingsRepo.findById(hid);
		
		if(obj.isPresent()) {
			UserHoldings updatedHolding = obj.get();
			
			updatedHolding.setQuantity(updatedHolding.getQuantity() - holdingsObj.getQuantity());
			updatedHolding.setBuyPrice(holdingsObj.getBuyPrice());
			updatedHolding.setCurrentPrice(holdingsObj.getCurrentPrice());
			
			userHoldingsRepo.save(updatedHolding);
			return "Record Updated successfully...";
		}
		userHoldingsRepo.save(holdingsObj);
		return "Record inserted successfully...";
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/findCurrentValue/{id}") 
	public int findCurrentValue(@PathVariable int id) {
		return userHoldingsRepo.findTotalCurrentValueQuery(id);
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/findTotalInvestment/{id}") 
	public int findTotalInvestment(@PathVariable int id) {
		return userHoldingsRepo.findTotalInvestmentQuery(id);
	}

	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/findProfitLoss/{id}") 
	public int findProfitLoss(@PathVariable int id) {
		return userHoldingsRepo.findProfitLossQuery(id);
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping (path="/updateFund")
	public String updateFund (@RequestBody User user) {
		System.out.println("Received data : " + user);
		
		Optional<User> obj = userRepo.findById(user.getId());
		
		if(obj.isPresent()) {
			User updatedUser = obj.get();
			
			updatedUser.setAccountBalance(updatedUser.getAccountBalance() + user.getAccountBalance());
			
			userRepo.save(updatedUser);
			return "Record Updated successfully...";
		}
		return "User not found!!!";
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping (path="/updateFundWithdraw")
	public String updateFundWithdraw (@RequestBody User user) {
		System.out.println("Received data : " + user);
		
		Optional<User> obj = userRepo.findById(user.getId());
		
		if(obj.isPresent()) {
			User updatedUser = obj.get();
			
			updatedUser.setAccountBalance(updatedUser.getAccountBalance() - user.getAccountBalance());
			
			userRepo.save(updatedUser);
			return "Record Updated successfully...";
		}
		return "User not found!!!";
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping (path="/getFund/{id}") 
	public int getFund(@PathVariable int id) {
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		System.out.println(userRepo.findUserFundQuery(id));
		System.out.println("-------------------------------------");
		System.out.println("-------------------------------------");
		return userRepo.findUserFundQuery(id);
	}
}
