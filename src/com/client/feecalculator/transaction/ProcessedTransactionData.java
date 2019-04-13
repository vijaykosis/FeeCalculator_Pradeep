package com.client.feecalculator.transaction;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class is used to keep the processed records.
 * For Grouping the fee based on OrderId, TransactionType, TransactionDate or Priority we can use comparator. 
 * 
 */

public class ProcessedTransactionData {
	
	private String clientId;
	private String transactionType;
	private String transactionDate;
	private String priorityFlag;
	private String processingFee;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public String getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(String processingFee) {
		this.processingFee = processingFee;
	}
	
	
}
