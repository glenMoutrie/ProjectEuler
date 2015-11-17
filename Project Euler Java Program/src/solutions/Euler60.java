package solutions;

import java.util.ArrayList;

public class Euler60 {
	/********************
	 ***** Euler 60 *****
	 ********************
	 * The primes 3, 7, 109, 673 are quite remarkeable. By taking any two primes and concatenating them
	 * in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097
	 * are prime. The sum of these four primes is 792 and represents the lowest sum for a set of four
	 * primes with this property.
	 * 
	 * Find the lowest sum for a set of primes for which any two primes concatenate to produce another
	 * prime.
	 * 
	 */
	
	public static void main(String[] args){
		ArrayList<Integer> availablePrimes = basicTools.Factors.primeSieve(1000000);
		System.out.println(availablePrimes);
	}

}
