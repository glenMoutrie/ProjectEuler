package basicTools;

import java.math.BigDecimal;
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
	
	public static ArrayList<Integer> getDigits(BigInteger x) {
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		while(!x.equals(BigInteger.ZERO)) {
			values.add(x.mod(BigInteger.TEN).intValue());
			x = x.divide(BigInteger.TEN);
		}
		
		return values;
	}
	
	public static int getSumOfDigits(BigInteger x) {
		ArrayList<Integer> digits = getDigits(x);
		return digits.stream().mapToInt(i -> i).sum();
	}
	
	public static ArrayList<Integer> getDecimalValues(BigDecimal x) {
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		String[] digits = x.toString().split("\\.");
		digits = digits[1].split("");
		
		for (String i : digits) values.add(new Integer(i));
		
		return values;
		
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
	
	private static enum Character {
		UP,DOWN,BOUNCY,UNKNOWN
	}
	
	public static boolean isBouncy(int number) {
		
		Character status = Character.UNKNOWN;
		
		int[] digits = Concatenation.getDigitArray(number);
		int numDigits = digits.length;
		int diff;
		
		if (numDigits < 3) {
			return false;
		}
		
		for (int i = 0; i < numDigits - 1; i++) {
			diff = digits[i] - digits[i + 1];
			
			// If unkown
			if (status == Character.UNKNOWN) {
				if (diff < 0) {
					status = Character.DOWN;
				} else if (diff > 0) {
					status = Character.UP;
				}
				
			// If not unknown
			} else if (status == Character.UP) {
				if (diff < 0) {
					status = Character.BOUNCY;
				}
			} else if (status == Character.DOWN) {
				if (diff > 0) {
					status = Character.BOUNCY;
				}
			}
			
			if (status == Character.BOUNCY) break;
			
		}
		
		return status == Character.BOUNCY;
		
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
		
		System.out.println(isBouncy(123444678));
		System.out.println(isBouncy(864221));
		System.out.println(isBouncy(1248964126));

		System.out.println(getSumOfDigits(new BigInteger("55555")));
		
	}
	
	
}

