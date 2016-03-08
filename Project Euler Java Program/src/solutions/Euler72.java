package solutions;

public class Euler72 {
	public static double gcm(double a, double b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	public static int properFractions(int d) {
		double multiple;
		int total = 0;

		for(int i = 1; i <= Math.sqrt(d); i++) {
//			if(i % 100 == 0) {
//				System.out.println(i);
//			}
			for(int j = i + 1; j <= d; j++) {
				multiple = gcm(i,j);
				if (multiple == 1) {
					total++;
					//					System.out.println("Numerator = " + i + "; Denominator = " + j);
				}
			}
		}
		return(total);
	}

	public static void main(String args[]){
		int previous = properFractions(1);
		int current;

		for(int i = 1; i <= 100; i++) {
			current = properFractions(i);
			System.out.println("Total: " + current + "; d: "+ i +
					"; Difference: " + (current - previous));
			previous = current;
		}
		System.out.println(properFractions(1000));
	}
}
