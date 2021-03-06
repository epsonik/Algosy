package BZIP2;

import bzip2.BZip2InputStream;
import bzip2.BZip2OutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BZIP2Controler {
	private String inputFileName;
	private String outputFileName;
	
	public BZIP2Controler(String inputFileName, String outputFileName){
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}
	
	public void compress() throws IOException{
		File inputFile2 = new File (inputFileName);
		File outputFile = new File (inputFileName + ".bzip2");
		
		InputStream fileInputStream = new BufferedInputStream (new FileInputStream (inputFile2));
		OutputStream fileOutputStream = new BufferedOutputStream (new FileOutputStream (outputFile), 524288);
		BZip2OutputStream outputStream = new BZip2OutputStream (fileOutputStream);

		byte[] buffer = new byte [524288];
		int bytesRead;
		while ((bytesRead = fileInputStream.read (buffer)) != -1) {
			outputStream.write (buffer, 0, bytesRead);
		}
		outputStream.close();
		
		System.out.println("Done");
	}
	
	public void decompress() throws IOException{
	

        File inputFile = new File(inputFileName);
        InputStream fileInputStream = new BufferedInputStream(new FileInputStream(inputFile));
        BZip2InputStream inputStream = new BZip2InputStream(fileInputStream, false);
        OutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(outputFileName), 524288);

        byte[] decoded = new byte[524288];
        int bytesRead;
        while ((bytesRead = inputStream.read(decoded)) != -1) {
            fileOutputStream.write(decoded, 0, bytesRead);
        }
        fileOutputStream.close();
	
	System.out.println("Done");
	}
}
