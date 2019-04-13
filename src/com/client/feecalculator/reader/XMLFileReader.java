package com.client.feecalculator.reader;


import java.util.List;

import com.client.feecalculator.transaction.Transaction;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class is used to read the transaction records from XML file.
 * We want only one instance of this reader, so creating it as singleton.
 */
public class XMLFileReader implements IFileReader {
	
	private static IFileReader xmlFileReader=null;
	
	private XMLFileReader(){
		if(xmlFileReader!=null){
			throw new IllegalStateException("INSTANCE ALREADY CREATED");
		}		
	}
	
	public static synchronized IFileReader getFileReader(){		
		if(xmlFileReader==null){			
			synchronized(CSVFileReader.class){				
				if(xmlFileReader==null){
					xmlFileReader=new XMLFileReader();
				}
			}			
		}
		return xmlFileReader;
		
	}
	
	@Override
	public List<Transaction> readFile() {		
		// We can implement the logic to read the transactions from XML file here.
			return null;
	}
}
