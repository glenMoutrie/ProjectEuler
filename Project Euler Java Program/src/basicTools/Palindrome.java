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
<<<<<<< HEAD

//	public static boolean isPandigital(String number) {
//
//		// Variables needed
//		char[] numberString = number.toCharArray();
//		int digits = numberString.length;
//		boolean isPalindrome = false;
//		
//		/* ******************************************************************
//		 * Use this for a check on digits, if it is false then the digit is
//		 * not in the number. Assume the order 1,2,3,4,5,6,7,8,9.
//		 * ****************************************************************** */
//		boolean[] digitCheck = new boolean[9];
//		
//		if (digits + 1 > 9) {
//			return(isPalindrome);
//		}
//		
//		// Checks each possible digit
//		for(int i = 0; i < digits; i++){
//			for(int posDigits = 1; posDigits < digits; posDigits++){
//				// I've made a stupid error as I'm comparing a char to an integer
//				// need to think about my types before I get to this stage, reluctant
//				// to do loads of casts or parsing.
//				if(numberString[i] == posDigits && !digitCheck[posDigits - 1]) {
//					System.out.println("Hit");
//					digitCheck[posDigits - 1] = true;
//				} else if (digitCheck[posDigits - 1] && numberString[i] == 0) {
//					System.out.println("DUPLICATE");
//					isPalindrome = false;
//					return(isPalindrome);
//				}
//			}
//		}
//		
//		for(int i = 0; i < digits; i++){
//			if(digitCheck[i]) {
//				if(i == digits -1) {
//					isPalindrome = true;
//				}
//			} else {
//				break;
//			}
//		}
//		
//		return(isPalindrome);
//	}

=======
	
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
	
>>>>>>> origin/master
	// Testing area
	public static void main(String args[]){
		int numberOne = 10101;
		int numberTwo = 231456;
		System.out.println(isPalindrome(numberOne));
		System.out.println(isPalindrome(numberTwo));
		System.out.println(isPandigital("12344"));
	}
}
