package com.client.feecalculator.reader;

import java.util.List;

import com.client.feecalculator.transaction.Transaction;

public interface IFileReader {
	public List<Transaction> readFile();

}
