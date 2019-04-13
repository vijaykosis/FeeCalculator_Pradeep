package com.client.feecalculator.transaction;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class is used to keep the raw transaction records which we read from file.
 */
public class Transaction {

	private String transactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private String transactionDate;
	private double marketValue;
	private boolean priorityFlag;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public Double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	
	public Boolean getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(boolean priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	
}
