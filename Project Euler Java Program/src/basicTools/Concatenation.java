package basicTools;

import java.util.ArrayList;

public class Concatenation {
	
	public int lengthCheck(int number) {
		// Initiate metrics
		int multipleOfTen = 10;
		int length = 0;
		int iteration = 0;
		
		while(length < 1){
			length = multipleOfTen/number;
			multipleOfTen = multipleOfTen*10;
			iteration++;
		}
		
		return iteration;
	}
	
	public int concatenate(int front, int back) {
		int n = lengthCheck(back);
		int result = front*(int)Math.pow(10, n);
		result = result + back;
		return result;
		
	}
	
	public static int[] getDigitArray(int number) {
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		// Split the digits up
		do{
			output.add(number % 10);
			number /= 10;
		} while (number > 0);
		
		// Convert to an int array
		int[] baseArray = new int[output.size()];
		int j = 0;
		for (int i = baseArray.length - 1; i >= 0; i--) baseArray[j++] = output.get(i);
		
		return baseArray;
	}
	
	public static void main(String[] args){
//		System.out.println(lengthCheck(123495));
//		System.out.println(concatenate(123,456));
		
		int[] output = getDigitArray(123456);
		for(int i : output) System.out.println(i);
	}

}
