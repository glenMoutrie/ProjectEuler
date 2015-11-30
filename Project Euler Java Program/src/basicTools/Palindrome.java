package basicTools;

public class Palindrome {
	public Palindrome(){}; 
	public static boolean isPalindrome(Long number) {
		
		// Convert the number to a character array
		char[] numberString = number.toString().toCharArray();
		
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
	
	public static void main(String args[]){
		long numberOne = 10101;
		long numberTwo = 231456;
		System.out.println(isPalindrome(numberOne));
		System.out.println(isPalindrome(numberTwo));
	}
}
