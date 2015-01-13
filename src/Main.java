
import java.io.IOException;
import java.util.Scanner;
import BZIP2.BZIP2Controler;
import LZW.LZWControler;
import ReadData.ErrorHandling;
import ReadData.ReadData;

public class Main {
	
	private static Scanner input;

	public static void main(String[] args) throws IOException, ErrorHandling {
		
		//brak pliku
		if (args.length == 0) {
			System.err.println ("You haven't entered a input file name");
			System.exit (1);
		}
		
		if (args.length == 1) {
			System.err.println ("You haven't entered a output file name");
			System.exit (1);
		}
		
		//wczytujemy pliki
		ReadData readData = new ReadData(args[0],args[1]);
		readData.read();
		
		
		input = new Scanner(System.in);
		System.out.println("Choose what type of compression/decompression do you want: "
				+ "lzw-compression, lzw-decompression,"
				+ " bzip2-compression or bzip2-decompression"
				+ "type exit to ");
		
		String text = input.nextLine();
		
		while(text != null){
			switch(text){
				case "lzw-compress":{
					LZWControler lzwControler = new LZWControler(readData.getInputFile(),readData.getSaveFile());
					lzwControler.compress();
					break;
				}
				case "lzw-decompress":{
					LZWControler lzwControler = new LZWControler(readData.getInputFile(),readData.getSaveFile());
					lzwControler.decompress();
					break;
				}
				
				case "bzip2-compress":{
					BZIP2Controler bzip2Controler = new BZIP2Controler(readData.getInputFileName(), readData.getOutputFileName());
					bzip2Controler.compress();
					break;
				}
				
				case "bzip2-decompress":{
					BZIP2Controler bzip2Controler = new BZIP2Controler(readData.getInputFileName(), readData.getOutputFileName());
					bzip2Controler.decompress();
					break;
				}
				
				case "exit":{
					System.exit (1);
				}
				default:{
					System.out.println("You've made some mistake. Type again");
				}
			}
			text = input.nextLine();
		}
	}
}
