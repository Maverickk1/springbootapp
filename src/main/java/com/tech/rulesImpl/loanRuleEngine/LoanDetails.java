package com.tech.rulesImpl.loanRuleEngine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class LoanDetails {
    Long accountNumber;
    Boolean approvalStatus;
    Float interestRate;
    Float sanctionedPercentage;
    Double processingFees;
    
    
	public LoanDetails(Long accountNumber, Boolean approvalStatus, Float interestRate, Float sanctionedPercentage,
			Double processingFees) {
		super();
		this.accountNumber = accountNumber;
		this.approvalStatus = approvalStatus;
		this.interestRate = interestRate;
		this.sanctionedPercentage = sanctionedPercentage;
		this.processingFees = processingFees;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public LoanDetails() {
		super();
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Boolean getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(Boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public Float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}
	public Float getSanctionedPercentage() {
		return sanctionedPercentage;
	}
	public void setSanctionedPercentage(Float sanctionedPercentage) {
		this.sanctionedPercentage = sanctionedPercentage;
	}
	public Double getProcessingFees() {
		return processingFees;
	}
	public void setProcessingFees(Double processingFees) {
		this.processingFees = processingFees;
	}
	@Override
	public String toString() {
		return "LoanDetails [accountNumber=" + accountNumber + ", approvalStatus=" + approvalStatus + ", interestRate="
				+ interestRate + ", sanctionedPercentage=" + sanctionedPercentage + ", processingFees=" + processingFees
				+ "]";
	}
    
    
    
    
}
