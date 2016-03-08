package solutions;

public class Euler72 {
	public static double gcm(double a, double b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	
	/*
	 * Below is a brute force method which doesn't work well as you get much higher than 10^4
	 */
	public static int properFractions(int d) {
		double multiple;
		int total = 0;

		for(int i = 1; i <= d; i++) {
			for(int j = i + 1; j <= Math.sqrt(d); j++) {
				multiple = gcm(i,j);
				if (multiple == 1) {
					total++;
				}
			}
		}
		return(total);
	}

	public static void main(String args[]){
		int previous = properFractions(1);
		int current = properFractions(1000);
//
//		for(int i = 1; i <= 100; i++) {
//			current = properFractions(i);
//			System.out.println("Total: " + current + "; d: "+ i +
//					"; Difference: " + (current - previous));
//			previous = current;
//		}
		System.out.println((previous - current));
	}
}
