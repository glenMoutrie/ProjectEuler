package solutions;

import java.util.ArrayList;
import java.util.HashSet;

import basicTools.NumberCharacteristics;

public class Euler32 {

	// Function to get the identity
	private static ArrayList<Integer> getIdentity(Integer multiplicand, Integer multiplier, Integer result) {
		
		// Create the output
		ArrayList<Integer> identity = new ArrayList<Integer>();
		
		// Add the digits from each of the individual numbers
		identity.addAll(NumberCharacteristics.getDigits(multiplicand));
		identity.addAll(NumberCharacteristics.getDigits(multiplier));
		identity.addAll(NumberCharacteristics.getDigits(result));
		
		// Return the array list
		return identity;
	}
	
	public static void main(String args[]) {
		
		// Create this here to not have to initialize every tiem
		int product;
		
		// All products
		HashSet<Integer> pandigitalProducts = new HashSet<Integer>();
		
		// Set search limit on possible candidates (this is slightly wider than needed)
		for (int i = 0; i <= 1000; i++) {
			for (int j = 0; j <= 10000; j++) {
				
				// Calculate the product
				product = i*j;
				
				// Check if the identity is pandigital
				if(NumberCharacteristics.isPandigital(getIdentity(i, j, product))) {
					
					// If so add it to the successful outcomes
					pandigitalProducts.add(product);
				}
				
			}
		}
		
		// Calculate the total
		int total = 0;
		for (Integer panProd : pandigitalProducts) total += panProd;
		
		// Print the result
		System.out.println(total);
	}
	
}
