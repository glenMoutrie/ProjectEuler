package solutions;

public class Euler36 {
	public static void main(String args[]){
		int total = 0;
		int max = ((Double) Math.pow(10,6)).intValue();
		
		Integer currentValue = 0;
		
		for(;currentValue < max; currentValue++){
			if(basicTools.Palindrome.isPalindrome(currentValue)){
				if(basicTools.Palindrome.isPalindrome(Integer.toBinaryString(currentValue))){
//					System.out.println(currentValue);
					total += currentValue;
				}
			}
		}
		
		System.out.println(total);
		
	}
}
