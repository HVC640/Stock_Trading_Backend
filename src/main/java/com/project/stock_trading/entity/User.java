package com.project.stock_trading.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name="user")
public class User {
	
	@Id
	private int id;
	
//	@OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId_fk", referencedColumnName = "id")
//	public List<Orders> ordersList;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="phoneNumber")
	private long phoneNumber;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="dob")
	private LocalDate dob; // LocalDate.parse(input); 
	
	@Column(name="gender")
	private int gender;
	
	@Column(name="accountBalance")
	private int accountBalance;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String lastName, long phoneNumber, String mail,
			LocalDate dob, int gender, int accountBalance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.dob = dob;
		this.gender = gender;
		this.accountBalance = accountBalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
