package com.client.feecalculator.processor;

import java.util.List;

import com.client.feecalculator.transaction.Transaction;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This is an interface for all the Transaction Types
 */
public interface TransactionType {

	boolean istrue(Transaction transaction, List<Transaction> transactions);
}
