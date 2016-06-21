package solutions;

import java.util.ArrayList;

public class Euler70 {
	public static void main(String args[]) {
		
		// Totient
		ArrayList<Integer> totient = basicTools.NumberSequence.eulerTotient(10000000);
		
		double n = 1;
		double max = 0;
		double current;
		
		for (int i : totient) {

			// Calculate current value
			current = (n)/i;
			
			// If larger than max add it
			if (current >= max) {
				max = current;
				System.out.println(max + " " + n + " " + i);
			}
			
			// Add one more
			n++;
		}
		
	}
}
