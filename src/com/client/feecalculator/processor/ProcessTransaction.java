package com.client.feecalculator.processor;

import java.util.ArrayList;
import java.util.List;

import com.client.feecalculator.transaction.ProcessedTransactionData;
import com.client.feecalculator.transaction.Transaction;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This is the main processing class which will get transaction list and it will check the type of transaction and 
 * based on it will add processing fee to the processed transaction.
 */
public class ProcessTransaction {
	
	private List<ProcessedTransactionData> processedTransactions = new ArrayList<ProcessedTransactionData>();
	private BuyOrDepositTransaction buyOrDepositTransaction = new BuyOrDepositTransaction();
	private SellOrWithdrawTransaction sellOrWithdrawTransaction = new SellOrWithdrawTransaction();
	private IntradayTransaction intradayTransaction = new IntradayTransaction();
	private HighPriorityTransaction highPriorityTransaction = new HighPriorityTransaction();

	// This function will get called with transaction list, which we got from the file.
	public List<ProcessedTransactionData> processTransactions(List<Transaction> transactions){
		for(Transaction transaction : transactions){
			ProcessedTransactionData processTransactionData = new ProcessedTransactionData();
			
			processTransactionData.setClientId(transaction.getClientId());
			processTransactionData.setTransactionType(transaction.getTransactionType());
			processTransactionData.setTransactionDate(transaction.getTransactionDate());
			processTransactionData.setPriorityFlag(getPriority(transaction));
			
			//getting the processing fee based on type of transaction and priority. getProcessingFee() method with return the processing fee.
			processTransactionData.setProcessingFee(getProcessingFee(transaction, transactions));	
			
			//adding the processed transaction to the processedTransactions list
			processedTransactions.add(processTransactionData);
		}		
		return processedTransactions;
	}
	
	// This method will check the priority of the transaction and based on priority it will return Y or N.
	public String getPriority(Transaction transaction){
		if(transaction.getPriorityFlag()){
			return "Y";
		} else{
			return "N";
		}
		
	}	
	
	// This method is responsible of generating the processing fee based on type and priority of transaction.
	public String getProcessingFee(Transaction transaction,  List<Transaction> transactions){
		
		if(isIntradayTransaction(transaction, transactions)){
			return "$10";
		} else if(isHighPriorityTransaction(transaction, transactions)){
			return "$500";			
		} else if(isSellOrWithdrawTransaction(transaction, transactions)){
			return "$100";
		} else if(isBuyOrDepositTransaction(transaction, transactions)){
			return "$50";
		} 
		// If later client want to add any other type of transaction fee; it can be added up here.
		// we can also add a default fee, if transaction doesn't match any criteria.
		return "$0";		
	}
	
	// it will check that the transaction is Intraday
	public boolean isIntradayTransaction(Transaction transaction,  List<Transaction> transactions){
		return intradayTransaction.istrue(transaction, transactions);
	}	
	
	// it will check that the transaction is of High Priority
	public boolean isHighPriorityTransaction(Transaction transaction,  List<Transaction> transactions){
		return highPriorityTransaction.istrue(transaction, transactions);
	}
	
	// it will check that the transaction is of type Sell or Withdraw
	public boolean isSellOrWithdrawTransaction(Transaction transaction,  List<Transaction> transactions){
		return sellOrWithdrawTransaction.istrue(transaction, transactions);
	}
	
	// it will check that the transaction is of type Buy or Deposit
	public boolean isBuyOrDepositTransaction(Transaction transaction,  List<Transaction> transactions){
		return buyOrDepositTransaction.istrue(transaction, transactions);
	}		
}
