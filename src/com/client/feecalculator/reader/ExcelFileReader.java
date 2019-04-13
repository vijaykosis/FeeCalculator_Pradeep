package com.client.feecalculator.reader;


import java.util.List;

import com.client.feecalculator.transaction.Transaction;


/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class is used to read the transaction records from the Excel file.
 * We want only one instance of this reader, so creating it as singleton.
 */

public class ExcelFileReader implements IFileReader {

	private static IFileReader excelFileReader=null;

	
	private ExcelFileReader(){
	}

	
	public static synchronized IFileReader getFileReader(){
		
		if(excelFileReader==null){			
			synchronized(CSVFileReader.class){				
				if(excelFileReader==null){
					excelFileReader=new ExcelFileReader();
				}
			}			
		}
		return excelFileReader;		
	}
	
	@Override
	public List<Transaction> readFile() {		
		// We can implement the logic to read the transactions from EXCEL file here.
			return null;
	}
}
