package com.tech.rulesImpl.insuranceRuleEngine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public  class InsuranceDetails {
    Double maturityAmount;

	public Double getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(Double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public InsuranceDetails() {
		super();
	}

	public InsuranceDetails(Double maturityAmount) {
		super();
		this.maturityAmount = maturityAmount;
	}
}
