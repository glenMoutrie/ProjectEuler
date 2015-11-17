public class Euler4 {

	public static String reverseString(String input) {
		
		int inputLength, i;
		inputLength = input.length();
		String output = "";

		for (i = inputLength-1; i >= 0; i--) {
			output  = output + input.charAt(i);
		}

		return output;
	}

	public static int largestPalidrome() {
		int x,y,z,palidrome,remainder,factor, otherFactor;
		String first, palidromeString;
		x = 997;

		// Create the palidrome and check for factors for 6 figure palidromes
		do {
			// Creation of the palidrome itself
			first = String.valueOf(x);
			palidromeString = first + reverseString(first);
			palidrome = Integer.parseInt(palidromeString);

			// Starting point for the factor
			factor = 1000;
			otherFactor = 1;

			// Checking for the largest three figure factor
			do {
				remainder = palidrome%factor;
				
				// Find the other factor, otherwise take the next step
				if(remainder == 0){
					otherFactor = palidrome/factor;
					System.out.println("The two factors are: " + factor + ", " + otherFactor + ", palidrome: " + palidrome);
				} else {
					factor = factor - 1;
				}

				

			} while(factor >= 100 && otherFactor >= 100 && (remainder != 0 && otherFactor <= 100));

			x = x - 1;
			

		} while (palidrome>= 100000);
		System.out.println("Palidrome = " + palidrome);

		x = 999;
		first = "100";
		return x;
	}

	public static void main(String args[]){
		String x,y,combined;
		x = "10";
		y = "11";
		combined = x+y;

		int test = 777;

		int result = Integer.parseInt(combined);
		combined = String.valueOf(test);
		System.out.println(combined + ", and in int form " + result);
		System.out.println(largestPalidrome());
		System.out.println(reverseString("Hello"));


	}
}