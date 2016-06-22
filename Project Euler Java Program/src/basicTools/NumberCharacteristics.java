package basicTools;

import java.math.BigInteger;
import java.util.ArrayList;

import algorithms.Table;

public class NumberCharacteristics {
	public static long reverseNumber(long initial) {
		long result = 0;
		while(initial != 0) {
			result = result*10;
			result = result + initial%10;
			initial = initial/10;
		}
		return(result);
	}
	
	public static boolean isPermutation(Number x, Number y) {
		
		ArrayList<String> xS = new ArrayList<String>();
		ArrayList<String> yS = new ArrayList<String>();
		
		for (String i : x.toString().split("")) xS.add(i);
		for (String i : y.toString().split("")) yS.add(i);
		
		Table xF = new Table(xS);
		Table yF = new Table(yS);
		
		return(xF.areEqual(yF));
	}
	
	public static boolean isPermutation(Double x, Double y){
		return(isPermutation(x.intValue(), y.intValue()));
	}
	
	public static BigInteger reverseNumber(BigInteger initial) {
		BigInteger result = new BigInteger("0");
		BigInteger zero = new BigInteger("0");
		BigInteger ten = new BigInteger("10");
		
		while(!initial.equals(zero)) {
			result = result.multiply(ten);
			result = result.add(initial.mod(ten));
			initial = initial.divide(ten);
		}
		return(result);
	}
	
	public static boolean lychrelCheck(Long start) {
		boolean isLychrel = false;
		boolean isPalindrome = false;
		BigInteger value = new BigInteger(start.toString());
		int iterations = 0;
		
		while(!isPalindrome && iterations <= 50) {
			value = reverseNumber(value).add(value);
			isPalindrome = basicTools.Palindrome.isPalindrome(value);
			iterations++;
		}
		
		isLychrel = iterations > 50;
		
		return(isLychrel);
	}
	
	public static void main(String args[]) {
		long test = 12345;
		System.out.println(reverseNumber(test));
		int total = 0;
		for(long i = 0; i <= 10001; i++){
			if(lychrelCheck(i)) {
				total++;
			}
		}
		System.out.println(total);
		
		System.out.println(isPermutation(12345678, 87654231));
		
		double x = 127.;
		double y = 127.;
		System.out.println(isPermutation(x, y));

		
	}
	
}

