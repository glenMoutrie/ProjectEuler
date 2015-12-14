package solutions;
import java.io.*;
import java.util.ArrayList;

public class CodeEvalPrimePalindrome {
	
    // Integer version
	public static boolean isPalindrome(Integer number) {
		return(isPalindrome(number.toString()));
	}
	
	// String Version
	public static boolean isPalindrome(String number) {
		
		// Convert the number to a character array
		char[] numberString = number.toCharArray();
		
		// Other bits of information that will be needed later
		int digits = numberString.length;
		boolean palindrome = true;
		
		// Iterate through the array in both directions
		for(int i = 0; i < digits; i++){
			
			// Only break if not a palindrome
			if(numberString[i] != numberString[digits - (i + 1)]){
				palindrome = false;
				break;
			}			
		}
		
		// Return the boolean
		return(palindrome);
	}
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
		// but had to change as codeval doesn't do 1.8...
//		final Predicate<Integer> myPredicate = x -> x == 0;
//		results.removeIf(myPredicate);
		for(int i = 0; i < results.size(); i++){
			if(results.get(i) == 0) {
				results.remove(i);
				i--;
			}
		}
		
		return results;
		
	}
    public static void main (String[] args) throws IOException {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes = primeSieve(1000);
        for(int i = primes.size() - 1;i > 0; i--){
            if(isPalindrome(primes.get(i))){
                System.out.println(primes.get(i));
                break;
            }
        }
    }
    
}