public class Euler9 {

	public static void tripletSearch(int endNumber){
		// Declare the Pythagorian integers you are looking for
		int a,b,c,sum, check;
		a = 1;
		b = 4;
		c = 1;
		sum = b;

		while (b < endNumber && sum != 1000) {
			// These will be used when searching for the factor pairs
			int factor, factorPair, remainder;
			factor = (b/2)-1;
			remainder = (b/2) % factor;

			System.out.println(factor + " " + b);

			// Searching for the factor pairs
			while(Math.abs(factor) > 0 || a + b + c == 1000) {
				remainder = (b/2) % factor;
				// Find m and n, check for the values of the Pythagorean triplet
				if(remainder==0) {
					factorPair = (b/2)/factor;
					
					// Set m as the largest factor
					int m, n;
					if (factor > factorPair) {
						m = factor;
						n = factorPair;
					} else {
						m = factorPair;
						n = factor;
					}

					// Find triplet
					a = ((m*m) - (n*n));
					c = ((m*m) + (n*n));

					sum = a + b + c;
					check = (a*a) + (b*b) - (c*c);

					// Print results
					if (sum == 1000) {
						System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", pleaseB0 = " + check + ", pleaseB1000 = " + sum);
						break;

					}
					
				}
				factor = factor - 1;


			}
			b = b + 2;			
		}

		int[] results = {a,b,c};


		


	}

	// public static void tripletSearchtwo(int endSearch) {
	// 	int m, n, a, b, c, sum;
	// 	sum = 1;
	// 	m = 1;
	// 	n = 1;
	// 	a = 1;
	// 	b = 1;
	// 	c = 1;

	// 	while (n < endSearch && sum != 1000) {
	// 		while(m < endSearch && sum != 1000) {
	// 			a = (m^2) - (n^2);
	// 			b = 2*m*n;
	// 			c = (m^2) + (n^2);
	// 			sum = a + b + c;
	// 			System.out.println("a = " + a + ", b = " + b + ", c = " + c);
	// 			m = m + 1;
	// 		}
	// 		n = n+1;
	// 		m = 1;
	// 	}
	// 	int check;
	// 	check = (a^2) + (b^2) - (c^2);
	// 	System.out.println("Quick check: " + sum + ", " + check);

	// }

	public static void main(String[] args) {
		int maxCsumThousand;
		maxCsumThousand = 1000;
		tripletSearch(maxCsumThousand);
	}
}