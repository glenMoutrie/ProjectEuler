package solutions;

import java.util.ArrayList;

import basicTools.NumberCharacteristics;

public class Euler38 {
	
	public static void main(String args[]) {
		
		ArrayList<Integer> digits;
		int multiple;
		int answer = 0;
		
		for (int i = 1; i < 5e7; i++) {
			digits = new ArrayList<Integer>(0);
			multiple = 0;
			
			while(digits.size() < 9) {
				digits.addAll(NumberCharacteristics.getDigits(i*++multiple));
			}
			
			if (digits.size() == 9) {
				if (NumberCharacteristics.isPandigital(digits)) {
					answer = i > answer ? i : answer;
				}
			}
			
			
		}
		
		// Not the answer you need to put into project euler, but finding it from here is trivial.
		System.out.println(answer);
	}

}
