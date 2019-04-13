package com.client.feecalculator.reader;


/**
 * 
 * @author Pradeep Marwaha
 * 
 * This class is used to read the transaction records from the file where the saperator is Pipe(|).
 * We want only one instance of this reader, so creating it as singleton.
 */
public class PipeSaperatedFileReader extends DelimiterFileReader {
	
	private static IFileReader excelFileReader=null;
	private final static String DELIMITER = "|";
	
	private PipeSaperatedFileReader(){
	}

	
	public static synchronized IFileReader getFileReader(){
		
		if(excelFileReader==null){			
			synchronized(CSVFileReader.class){				
				if(excelFileReader==null){
					excelFileReader=new PipeSaperatedFileReader();
				}
			}			
		}
		return excelFileReader;		
	}
	
	public String getDelimiter(){
		return DELIMITER;
	}
}
