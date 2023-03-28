package com.tech.knowledgeBase.models;

import com.tech.restAPI.RuleNamespace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rule {
    RuleNamespace ruleNamespace;
    String ruleId;
    String condition;
    String action;
    Integer priority;
    String description;
	public Rule(RuleNamespace ruleNamespace, String ruleId, String condition, String action, Integer priority,
			String description) {
		super();
		this.ruleNamespace = ruleNamespace;
		this.ruleId = ruleId;
		this.condition = condition;
		this.action = action;
		this.priority = priority;
		this.description = description;
	}
	public RuleNamespace getRuleNamespace() {
		return ruleNamespace;
	}
	public void setRuleNamespace(RuleNamespace ruleNamespace) {
		this.ruleNamespace = ruleNamespace;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
