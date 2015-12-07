package basicTools;

import java.util.ArrayList;

public class Palindrome {
	public Palindrome(){}; 
	
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
	
	// Pandigital number check
	public static boolean isPandigital(String number){
		
		// Convert the number to a character array
		char[] numberString = number.toCharArray();
		
		boolean isPandigital = false;
		int digits = numberString.length;
		ArrayList<String> comparison = new ArrayList<String>();
		for(Integer i = 1; i < 10; i++){
			comparison.add(i.toString());
		}
		
		for(int i = 1; i < digits + 1; i ++){
			isPandigital = numberString[i] == (Character)comparison.get(i);
		}
		
	}
	
	// Testing area
	public static void main(String args[]){
		int numberOne = 10101;
		int numberTwo = 231456;
		System.out.println(isPalindrome(numberOne));
		System.out.println(isPalindrome(numberTwo));
	}
}
