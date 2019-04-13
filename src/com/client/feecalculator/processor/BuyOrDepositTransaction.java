package com.client.feecalculator.processor;

import java.util.List;

import com.client.feecalculator.transaction.Transaction;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class checks that the given transaction is of type BUY or Deposit.
 */

public class BuyOrDepositTransaction implements TransactionType{

	@Override
	public boolean istrue(Transaction transaction, List<Transaction> transactions) {
		if(transaction.getTransactionType().equals("BUY") || transaction.getTransactionType().equals("DEPOSIT") ){
			return true;
		} else{			
		return false;
		}
	}
}
