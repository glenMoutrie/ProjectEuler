package solutions;

import java.util.ArrayList;

public class Euler72 {
	public static double gcm(double a, double b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	
	/*
	 * Below is a brute force method which doesn't work well as you get much higher than 10^4
	 */
//	public static int properFractions(int d) {
//		double multiple;
//		int total = 0;
//
//		for(int i = 1; i <= d; i++) {
//			for(int j = i + 1; j <= Math.sqrt(d); j++) {
//				multiple = gcm(i,j);
//				if (multiple == 1) {
//					total++;
//				}
//			}
//		}
//		return(total);
//	}
	

//	public static void main(String args[]){
//		int previous = properFractions(1);
//		int current;
//
//		for(int i = 1; i <= 100; i++) {
//			current = properFractions(i);
//			System.out.println("Total: " + current + "; d: "+ i +
//					"; Difference: " + (current - previous));
//			previous = current;
//		}
//		System.out.println(properFractions(1000));
//	}
	
	/* 
	 * This is a better method using Euler's product formula for the totient function
	 */
	
	public static int properFactors(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes = basicTools.Factors.primeSieve(n);
		
		// Incrementally find the next totient, and add this value to the total
		int totient;
		int totientMultiplier;
		int total;
		int index = 0;
		
		totientMultiplier = 1 - (1/primes.get(index));
		
		for(int i = 1; i <= n; i++) {
			
			// Update the totient
			while(primes.get(index) < i) {
				
			}
			
		}
		
		
	}
}
