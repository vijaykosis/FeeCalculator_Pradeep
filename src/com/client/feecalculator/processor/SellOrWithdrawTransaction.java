package com.client.feecalculator.processor;

import java.util.List;

import com.client.feecalculator.transaction.Transaction;


/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class checks that the given transaction is of type SELL or Withdraw.
 */
public class SellOrWithdrawTransaction implements TransactionType{

	@Override
	public boolean istrue(Transaction transaction, List<Transaction> transactions) {
		if(transaction.getTransactionType().equals("SELL") || transaction.getTransactionType().equals("WITHDRAW") ){
			return true;
		} else{			
		return false;
		}
	}
}
