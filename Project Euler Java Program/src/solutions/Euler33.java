package solutions;

import java.util.ArrayList;
import basicTools.FractionDeprecated;



public class Euler33 {
	
	/**************
	 ** Euler 33 **
	 **************
	 *The fraction 49/98 is a curious fraction, as an inexperienced mathematician
	 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct,
	 * is obtained by cancelling the 9s.
	 * 
	 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
	 * 
	 * There are exactly four non-trivial examples of this type of fraction, less
	 * than one in value, and containing two digits in the numerator and denominator.
	 * If the product of these four fractions is given in its lowest common terms, find
	 * the value of the denominator.
	 * 
	 */
	
	// Handy tool for 
	public static double gcm(double a, double b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	

	

	public static ArrayList<FractionDeprecated> createFractions(double max) {
		ArrayList<FractionDeprecated> allFractions = new ArrayList<FractionDeprecated>();
		
		// Iterate over all fractions below one
		for(double i = 1; i <= max; i++) {
			for(double j = 1; j <= i; j++) {
				// Calculate greatest common denominator
				allFractions.add(new basicTools.FractionDeprecated(j,i));

			}
		}
		
		return allFractions;
	}



	public static void main(String[] args){
		ArrayList<FractionDeprecated> result = createFractions(99);
		System.out.println(result);
	}

}