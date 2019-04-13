package com.client.feecalculator.processor;

import java.util.List;

import com.client.feecalculator.transaction.Transaction;


/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class checks that the given transaction is an Intraday transaction or not.
 */
public class IntradayTransaction implements TransactionType {

	@Override
	public boolean istrue(Transaction transaction, 	List<Transaction> transactions) {


		String transactionType = transaction.getTransactionType();
		if(!(transactionType.equals("BUY") || transactionType.equals("SELL")) ){
			return false;
		}
		
		if(transactionType.equals("BUY")){
			for(Transaction trans : transactions){
				if(trans.getTransactionType().equals("SELL") &&  
						transaction.getClientId().equals(trans.getClientId()) && 
							transaction.getSecurityId().equals(trans.getSecurityId()) &&
								transaction.getTransactionDate().equals(trans.getTransactionDate())){
					return true;
				}
			}
		}else {
			for(Transaction trans : transactions){
				if(trans.getTransactionType().equals("BUY") &&  
						transaction.getClientId().equals(trans.getClientId()) && 
							transaction.getSecurityId().equals(trans.getSecurityId()) &&
								transaction.getTransactionDate().equals(trans.getTransactionDate())){
					return true;
				}
			}
		}	
		
		return false;		
	}
}
