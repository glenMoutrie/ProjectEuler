package basicTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

public class Factors {
	
	public static ArrayList<Integer> primeSieve(Integer highest) {
		
		//Declare ArrayList
		ArrayList<Integer> results = new ArrayList<Integer>(highest);
		
		// Initially populate the list with odd numbers (but set one as two)
		for (int i = 1; i <= highest; i = i + 2){
			if (i == 1) {
				results.add(2);
			} else {
				results.add(i);
			} 
		}
		
		// For all numbers higher than nine a prime sieve needs to be used
		// I have done this by setting divisible components to 0
		if (highest >= 9){
			
			// Start with the second prime value, note that the highest factor is only
			// going to be the square root of the highest possible prime
			for (int k = 3; k <= Math.sqrt(highest); k = k + 2){
				if(results.get((k)/2) != 0){
					for (int j = ((k*k))/2; j < results.size(); j = j + k){
						try {
							results.set(j, 0);
						} catch (IndexOutOfBoundsException e) {
							continue;
						}
					}
				}
			}
		}
		
		// Remove all zeros using removeIf and FUNCTIONAL JAVA PROGRAMMING BIATCH
		final Predicate<Integer> myPredicate = x -> x == 0;
		results.removeIf(myPredicate);
		
		return results;
		
	}
	
	public static ArrayList<Integer> compositeSieve(int highest,boolean oddOnly) {
		
		//Declare ArrayList
		ArrayList<Integer> results = new ArrayList<Integer>(highest);
		ArrayList<Integer> composites = new ArrayList<Integer>(highest);
		
		// Initially populate the list with odd numbers (but set one as two)
		for (int i = 2; i <= highest; i++){
			results.add(i);
		}
		
		// For all numbers higher than nine a prime sieve needs to be used
		// I have done this by setting divisible components to 0
		if (highest >= 9){
			
			// Start with the second prime value, note that the highest factor is only
			// going to be the square root of the highest possible prime
			for (int k = 1; k <= Math.sqrt(highest); k = k +2){
				int index = k/2;
				if(results.get(index) != 0){
					int target = results.get(index);
					for (int j = (target*target)-2; j < results.size(); j = j + target){
						try {
							if(oddOnly && results.get(j)%2 == 0){
								continue;
							}
							composites.add(results.get(j));
							results.set(j, 0);
						} catch (IndexOutOfBoundsException e) {
							continue;
						}
					}
				}
			}
		}
		Collections.sort(composites);
//		// Remove all zeros using removeIf and FUNCTIONAL JAVA PROGRAMMING BIATCH
		final Predicate<Integer> myPredicate = x -> x == 0;
		composites.removeIf(myPredicate);
		return composites;
		
	}
	
	
	public static ArrayList<Integer> oddValues(ArrayList<Integer> initialList){
		// Iterate through the list removing values that aren't even
		for (Iterator<Integer> i = initialList.iterator(); i.hasNext();) {
			if(i.next()%2 == 0) {
				i.remove();
			}
		}
		return initialList;
	}
	
	public static ArrayList<Integer> compositeNumbers(int highest){
		// Create method fields
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>(highest);
		ArrayList<Integer> composites = new ArrayList<Integer>(highest);
		
		// Make primes a list of primes, and composite a list of numbers from 0 to one.
		primeNumbers = primeSieve(highest);
		for(int i = 2; i < highest; i++) {
			composites.add(i);
		}
		
		// Remove prime numbers from composites and return the composite numbers
		composites.removeAll(primeNumbers);
		return composites;
		
	}
	
	public static void main(String... args){
		ArrayList<Integer> primeValues = new ArrayList<Integer>(1000);
		primeValues = primeSieve(1000);
		Integer sum = 0;
		for(int i = 0; i < primeValues.size(); i ++){
			sum = sum + primeValues.get(i);
		}
		System.out.println(sum);
		
	}
	
	//TODO finish this after completing a PrimeNumber generator.
//	public ArrayList<Integer> findPrimeFactors(int Target) {
//		
//		// Declare the arrayList
//		ArrayList<Integer> results = new ArrayList<Integer>();
//		
//		if(Target < 4){
//			results.add(Target);
//			return results;
//		}
//		
//		if(Target <= Math.pow(2, 53) - 1) {
//			
//		}
//		return results
//	}
}
