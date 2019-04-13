package com.client.feecalculator.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.client.feecalculator.transaction.Transaction;

public abstract class DelimiterFileReader implements IFileReader {

	
	// This method will read the given file and put it transaction type and adding this transaction to a list.
	@Override
	public List<Transaction> readFile() {
			
			List<Transaction> list=new ArrayList<Transaction>();

			BufferedReader br=null;
			String row;
			String delimiters= getDelimiter();	
			try {
				br=new BufferedReader(new FileReader("Transactions.csv"));
				while((row=br.readLine())!=null){
					
					Transaction record = new Transaction();
					// use comma as separator
					String[] columns = row.split(delimiters);
					
					record.setTransactionId(columns[0]);
					record.setClientId(columns[1]);
					record.setSecurityId(columns[2]);
					record.setTransactionType(columns[3]);
				
					record.setTransactionDate(columns[4]);
					record.setMarketValue(Double.parseDouble(columns[5]));
						
					record.setPriorityFlag(getBooleanValue(columns[6]));
				
						
					list.add(record);
			      		
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return list;
		}

		public boolean getBooleanValue(String priority){
			if(priority.equals("Y"))
				return true;
			else 
				return false;
		}
		
		
		// this method is abstrac because we can use the same logic of reading the file with any type of saperator.
		public abstract String getDelimiter();

}
