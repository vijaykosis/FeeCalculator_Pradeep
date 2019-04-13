package com.client.feecalculator.main;

import java.util.List;

import com.client.feecalculator.processor.ProcessTransaction;
import com.client.feecalculator.reader.FileReaderFactory;
import com.client.feecalculator.reader.IFileReader;
import com.client.feecalculator.transaction.ProcessedTransactionData;
import com.client.feecalculator.transaction.Transaction;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This is the main class of this Processing fee calculator.
 */
public class ProcessingFeeCalculator {
	
	public static void main(String[] args) {
		
		// Get the factory by passing type of file as parameter.
		// Currently completely supported factory is for CSV format.
		// We have have other's also live EXCEL, XML, PIPE.  
		FileReaderFactory fileReaderFactory=new FileReaderFactory("CSV");

		IFileReader fileReader=fileReaderFactory.getFactory();
		if(fileReader == null){
			System.out.println(" Please share proper file type. Currently code is supported only for : CSV ");
			return;
		}
		List<Transaction> transactionList=fileReader.readFile();
		
		ProcessTransaction processor=new ProcessTransaction();
		
		//Calling the method which will process the transactions.
		List<ProcessedTransactionData> processedData=processor.processTransactions(transactionList);
		
		
		// Printing the processed record on the console, we can write them to file if required.
		System.out.println(" Client-Id	| Transaction-Date	| Priority	| Processing-Fee  | Transaction-Type");
		System.out.println("----------------------------------------------------------------------------------------------");
		
		for (ProcessedTransactionData processedTransactionData : processedData) {
			System.out.println(" "+ processedTransactionData.getClientId()  
				+ "		| "	+ processedTransactionData.getTransactionDate() 
					+ "		| " + processedTransactionData.getPriorityFlag() 
						+ "		| "	+ processedTransactionData.getProcessingFee()
							+ " 		  | " + processedTransactionData.getTransactionType());
		}		
	}
}
