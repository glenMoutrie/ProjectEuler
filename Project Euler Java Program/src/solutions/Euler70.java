package solutions;

import java.util.ArrayList;

public class Euler70 {
	public static void main(String args[]) {
		
		// Totient
		ArrayList<Integer> totient = basicTools.NumberSequence.eulerTotient(10000000);
		totient.remove(0);
		
		double n = 2;
		double max = 10;
		double current;
		double currentAnswer = 0;
		
		boolean isPermutation;
		
		
		for (int i : totient) {

			// Calculate current value
			current = (n)/i;
//			System.out.println("\r\n " + n + " " + i);
			
			
			// If larger than max add it
			if (current <= max || n == 87109) {
				max = current;
				isPermutation = basicTools.NumberCharacteristics.isPermutation(n, i);
				
				if (isPermutation) {
					currentAnswer = n;
				}
				
//				System.out.println(max + " " + n + " " + i + " " + isPermutation);
			}
			
			// Add one more
			n++;
		}
		
		System.out.println(currentAnswer);
		
	}
}
