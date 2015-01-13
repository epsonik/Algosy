package LZW;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LZWControler {
	private FileReader inputFile = null;
	private static BufferedReader inputLine = null;
	private PrintWriter saveFile = null;
	
	public LZWControler(FileReader inputFile, PrintWriter saveFile){
		this.inputFile = inputFile;
		this.saveFile = saveFile;
	}
	
	public void compress() throws IOException{
		inputLine = new BufferedReader(inputFile);
		String s = "";
		//ka¿da linia jest wczytywana, kompresowana i zapisywana do pliku wyjœciowego
		while( (s=inputLine.readLine()) != null ) {
			List<Integer >compressed = LZW.compress(s);
			Iterator<Integer> compressIterator = compressed.iterator();
			while (compressIterator.hasNext()){
				String a = compressIterator.next() + " ";
				saveFile.print(a);
			}
			saveFile.println("");
		}
		saveFile.close();
		
		System.out.println("Done");
	}
	
	public void decompress() throws IOException{
		inputLine = new BufferedReader(inputFile);
		List<Integer> compressed = new ArrayList<Integer>();
		String s = "";
		//ka¿da linia jest wczytywana, kompresowana i zapisywana do pliku wyjœciowego
		while( (s=inputLine.readLine()) != null ) {
			String[] a = s.split(" ");
			for(String i : a){
				compressed.add(Integer.parseInt(i));
			}
			
			String text = LZW.decompress(compressed);
			
			System.out.println(text);
			
			saveFile.print(text);
			
			saveFile.println();
			
			compressed.clear();
		}
		saveFile.close();
		
		System.out.println("Done");
	}
}
