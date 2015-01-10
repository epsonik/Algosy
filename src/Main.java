import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import LZW.LZW;

public class Main {

	private static BufferedReader inputLine;
	private static Scanner input;

	public static void main(String[] args) throws ErrorHandling, IOException {
		
		//brak pliku
		if (args.length == 0) {
			System.err.println ("You haven't entered a input file name");
			System.exit (1);
		}
		
		if (args.length == 1) {
			System.err.println ("You haven't entered a output file name");
			System.exit (1);
		}
		
		//wczytywanie pliku
		FileReader inputFile;
		try {
			inputFile = new FileReader(args[0]);
		} catch (FileNotFoundException e) {
			throw new ErrorHandling( e.getMessage() );
		}
		
		//plik wyjœciowy
		PrintWriter saveFile = new PrintWriter("compressed.txt");
		
		input = new Scanner(System.in);
		System.out.println("Choose what type of compression do you want: lzw or bzip2");
		String text = input.nextLine();
		
		switch(text){
			case "lzw":{
				inputLine = new BufferedReader(inputFile);
				String s = "";
				//ka¿da linia jest wczytywana, kompresowana i zapisywana do pliku wyjœciowego
				while( (s=inputLine.readLine()) != null ) {
					List<Integer >compressed = LZW.compress(s);
					Iterator<Integer> compressIterator = compressed.iterator();
					while (compressIterator.hasNext()){
						saveFile.print(compressIterator.next() + " ");
					}
					saveFile.println();
				}
				saveFile.close();
				
				System.out.println("Done");
				break;
			}
			case "bzip2":{
				
				
				
				break;
			}
			default:{
				System.out.println("You've made some mistake. Restart the program");
			}
		}	
	}
}
