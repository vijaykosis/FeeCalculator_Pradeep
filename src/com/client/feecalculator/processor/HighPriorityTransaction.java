package com.client.feecalculator.processor;

import java.util.List;

import com.client.feecalculator.transaction.Transaction;


/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class checks that the given transaction is of High Priority.
 */

public class HighPriorityTransaction implements TransactionType{

	@Override
	public boolean istrue(Transaction transaction, List<Transaction> transactions) {
		if(transaction.getPriorityFlag()){
			return true;
		} else{			
		return false;
		}
	}
}
