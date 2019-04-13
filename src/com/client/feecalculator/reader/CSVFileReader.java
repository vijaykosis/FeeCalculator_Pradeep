package com.client.feecalculator.reader;

/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class is used to read the transaction records from the CSV file.
 * We want only one instance of this reader, so creating it as singleton.
 */

public class CSVFileReader extends DelimiterFileReader {


	private static IFileReader csvFileReader=null;
	private final static String DELIMITER = ",";
	
	private CSVFileReader(){
		
	}
	

	public static synchronized IFileReader getFileReader(){
		
		if(csvFileReader==null){
			
			synchronized(CSVFileReader.class){
				
				if(csvFileReader==null){
					csvFileReader=new CSVFileReader();
				}
			}			
		}
		return csvFileReader;
		
	}
	
	public String getDelimiter(){
		return DELIMITER;
	}
	

}
