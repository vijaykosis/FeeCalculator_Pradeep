package com.client.feecalculator.reader;


public class FileReaderFactory {
	
	IFileReader fileReader=null;
	String fileType;

	public FileReaderFactory(String fileType){
		this.fileType = fileType;
	}
	
	/*
	 * Factory method give the instance of the class type
	 */
	public IFileReader getFactory(){
	
		if(fileType.equals("")){
			this.fileReader=null;
		} else if(fileType.equals("CSV")){
			fileReader= CSVFileReader.getFileReader();
		} else if(fileType.equals("EXCEL")){
			fileReader=ExcelFileReader.getFileReader();
		} else if(fileType.equals("XML")){
			fileReader=XMLFileReader.getFileReader();
		} else if(fileType.equals("PIPE")){
			fileReader=PipeSaperatedFileReader.getFileReader();
		}

		return fileReader;
		
	}
	
}

