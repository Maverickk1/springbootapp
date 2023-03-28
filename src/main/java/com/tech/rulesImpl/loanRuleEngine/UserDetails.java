package com.tech.rulesImpl.loanRuleEngine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
   
	String firstName;
	String lastName;
    Integer age;
    Long accountNumber;
    Double monthlySalary;
    String bank;
    Integer cibilScore;
    Double requestedLoanAmount;
    
    @Override
   	public String toString() {
   		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", accountNumber="
   				+ accountNumber + ", monthlySalary=" + monthlySalary + ", bank=" + bank + ", cibilScore=" + cibilScore
   				+ ", requestedLoanAmount=" + requestedLoanAmount + "]";
   	}
       
       
   	public UserDetails(String firstName, String lastName, Integer age, Long accountNumber, Double monthlySalary,
   			String bank, Integer cibilScore, Double requestedLoanAmount) {
   		super();
   		this.firstName = firstName;
   		this.lastName = lastName;
   		this.age = age;
   		this.accountNumber = accountNumber;
   		this.monthlySalary = monthlySalary;
   		this.bank = bank;
   		this.cibilScore = cibilScore;
   		this.requestedLoanAmount = requestedLoanAmount;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Integer getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(Integer cibilScore) {
		this.cibilScore = cibilScore;
	}
	public Double getRequestedLoanAmount() {
		return requestedLoanAmount;
	}
	public void setRequestedLoanAmount(Double requestedLoanAmount) {
		this.requestedLoanAmount = requestedLoanAmount;
	}
}
