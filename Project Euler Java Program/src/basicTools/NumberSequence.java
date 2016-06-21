package basicTools;

import java.util.ArrayList;

import throwables.NumberOverflow;

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

	public static int fibbonaciNumberRecurse(int n) throws NumberOverflow {
		if (n == 1) {
			return(1);
		} else if (n <= 0) {
			return(0);
		} else if (n > 46) {
			throw new NumberOverflow("Larger than possible");
		}
		return(fibbonaciNumberRecurse(n - 2) + fibbonaciNumberRecurse(n - 1));

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

	public static ArrayList<Integer> eulerTotient(int n) {
		// Create phi vector and populate it with the range of numbers
		int[] phi = new int[n +  2];
		for (int i = 0; i < phi.length; i++) {
			phi[i] = i;
		}

		ArrayList<Integer> result = new ArrayList<Integer>(n);
		result.add(1);

		for (int i = 2; i <= n; i ++) {
			if (phi[i] == i) {
				for (int j = i; j <= n; j += i) {
					phi[j] = phi[j]/i*(i-1);
				}
			}

			result.add(phi[i]);
		}

		return(result);
	}

	public static void main(String[] args) {
		String line = "12";
		System.out.println(fibonacciNumber(Integer.parseInt(line)));
		//		for(int i = 0; i <= 100; i++) {
		//			try {
		//				System.out.println(fibbonaciNumberRecurse(i) + " Input: " +  i);
		//			} catch (NumberOverflow e) {
		//				System.out.println("Creates a int value that is too large");
		//			}
		//		}

		ArrayList<Integer> totient = eulerTotient(10);
		for (int i : totient) System.out.println(i);
		
	}

}
