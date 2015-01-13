package ReadData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class ReadData {
	private String inputFileName;
	private String outputFileName;
	private FileReader inputFile = null;
	private PrintWriter saveFile = null;
	
	public ReadData(String inputFileName, String outputFileName){
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}
	
	public void read() throws ErrorHandling, FileNotFoundException{
		
		//wczytywanie pliku
		try {
			inputFile = new FileReader(inputFileName);
		} catch (FileNotFoundException e) {
			throw new ErrorHandling( e.getMessage() );
		}
				
		//plik wyjœciowy
		saveFile = new PrintWriter(outputFileName);
	
	}
	
	public FileReader getInputFile(){
		return inputFile;
	}
	
	public PrintWriter getSaveFile(){
		return saveFile;
	}
	
	public String getInputFileName(){
		return inputFileName;
	}
	
	public String getOutputFileName(){
		return outputFileName;
	}
}
