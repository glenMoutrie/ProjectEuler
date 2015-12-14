package basicTools;

import java.util.ArrayList;

public class NumberSequence {
	
	// Constructor
	public NumberSequence(){
	}
	
	// Creates an ArrayList of the fibonacci sequence
	public static ArrayList<Integer> fibonacciSequence(int length) {
		// Set up each of the variables
		int thisNumber;
		int lastNumber;
		int nextNumber;
		ArrayList<Integer> results = new ArrayList<Integer>(length);
		
		// Set the starting numbers and loop
		thisNumber = 2;
		lastNumber = 1;
		nextNumber = 0;
		
		// Add the inital numbers
		results.add(nextNumber);
		results.add(lastNumber);
		results.add(thisNumber);
		
		for(int i = 3; i < length; i++){
			nextNumber = thisNumber + lastNumber;
			lastNumber = thisNumber;
			thisNumber = nextNumber;
			results.add(thisNumber);
		}
		
		return results;
		
	}
	
	// Provides the last integer
	public static int fibonacciNumber(int length) {
		// Set up each of the variables
		int thisNumber;
		int lastNumber;
		int nextNumber;
		
		// Set the starting numbers and loop
		thisNumber = 2;
		lastNumber = 1;
		nextNumber = 0;
		
		for(int index = 3; index < length; index++){
			nextNumber = thisNumber + lastNumber;
			lastNumber = thisNumber;
			thisNumber = nextNumber;
		}
		
		return thisNumber;
	}
	public static void main(String[] args) {
		String line = "12";
		System.out.println(fibonacciNumber(Integer.parseInt(line)));
	}
	
}
