package solutions;

import java.util.ArrayList;


public class Euler69 {
	
	public static void main(String args[]) {
		
		ArrayList<Integer> totient = basicTools.NumberSequence.eulerTotient(1000000);
		double n = 1;
		double max = 0;
		double current;
		System.out.println("Euler Totient Results");
		for (int i : totient) {

			current = (n)/i;
			if (current > max) {
				max = current;
				System.out.println(max + " " + n);
			}
			n++;
		}
		
	}

}
