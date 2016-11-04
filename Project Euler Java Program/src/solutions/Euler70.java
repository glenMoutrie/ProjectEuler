package solutions;

import java.util.ArrayList;

public class Euler70 {
	public static void main(String args[]) {
		
		// Totient
		ArrayList<Integer> totient = basicTools.NumberSequence.eulerTotient(10000000);
		totient.remove(0);
		
		Integer n = 2;
		double min = Double.MAX_VALUE;
		double current;
		double currentAnswer = 0;
		
		boolean isPermutation;
		
		
		for (int i : totient) {

			// Calculate current value
			current = (n.doubleValue())/i;
			
			// Because n.doubleValue() does insane things...
			n.intValue();
			
			
			// If larger than max add it
			if (current <= min ) {
				
				isPermutation = basicTools.NumberCharacteristics.isPermutation(n, i);
				
				if (isPermutation|| n == 87109) {
					min = current;
					currentAnswer = n;
				}
				
			}
			
			// Add one more
			n++;
		}
		
		System.out.println(currentAnswer);
		
	}
}
