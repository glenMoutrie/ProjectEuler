package solutions;

import java.math.BigInteger;
import java.util.ArrayList;

import basicTools.NumberCharacteristics;

public class Euler56 {

	private static class Powers {

		String a;
		ArrayList<BigInteger> values;

		Powers(int a, int n) {

			this.a = Integer.toString(a);
			values = new ArrayList<BigInteger>(n);

			BigInteger addition;

			for (int i = 1; i <= n; i++) {
				addition = new BigInteger(this.a);
				addition = addition.pow(i);
				values.add(addition);
			}

		}

		ArrayList<BigInteger> getValues() {
			return values;
		}
		
		int getMaxDigitSum() {
			
			int max = 0;
			int current;
			
			for(BigInteger i : this.values) {
				current = NumberCharacteristics.getSumOfDigits(i);
				if (current > max) max = current;
			}
			
			return max;
		}
		
	}

	public static void main(String[] args) {
		
		int n = 100;
		
		ArrayList<Powers> powers = new ArrayList<Powers>(n);
		
		Powers update;
		
		int max = 0;
		int current;
		
		for(int i = 1; i <= 100; i++) {

			update = new Powers(i,n);
			powers.add(update);
			current = update.getMaxDigitSum();
			if (current > max) max = current;
			
		}
		
		System.out.println(max);
	}

}
