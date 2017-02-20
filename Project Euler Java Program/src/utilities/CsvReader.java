package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CsvReader {
	
	boolean hasColNames;
	boolean hasRowNames;
	File csvFile;
	FileInputStream stream;
	
	// Constructors
	public CsvReader(String path, boolean hasColNames, boolean hasRowNames) throws FileNotFoundException, IOException {
		
		setUpConnection(path);
		
		readCSV();
		
	}
	
	public CsvReader(String fileName){
		hasColNames = false;
		hasRowNames = false;
	}
	
	private void setUpConnection(String path) throws FileNotFoundException {
		
		this.csvFile = new File(path);
		this.stream = new FileInputStream(this.csvFile);
		
	}
	
	private void readCSV() throws IOException {
		System.out.println(this.stream.read());
	}
	
	public static void main(String[] args) {
		
		System.out.println("Yay...");
		
//		try {
//			
//			CsvReader test = new CsvReader("~/Documents/Data/Boston.csv", true, false);
//			
//		} catch (FileNotFoundException PathError)  {
//			
//		} catch (IOException IOError)  {
//			
//		}
		
	}

}
