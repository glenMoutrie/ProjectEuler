public class Euler33 {

	public static double gcm(double a, double b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	// We will create all possible versions of these. We will know which ones are are simple versions of the 
	// other because they will have the same value but with lower valued denominators.
	public fraction {

		double value;
		int numerator;
		int denominator;
		int firstUpper;
		int firstLower;
		int lastUpper;
		int lastLower;

		// Constructor
		public fraction(double numerator, double denominator) {
			value = numerator/denominator;

			int firstUpper = ((int)j)%10;
			int lastUpper = ((int)j)/10;
			int firstLower = ((int)i)%10;
			int lastLower = ((int)i)/10;
		}

		// Getters (no setters needed for this class, and I'm fucked if I'm going to build em)
		public void firstUpper() {
			return this.firstUpper;
		}
		public void firstUpper() {
			return this.lastUpper;
		}
		public void firstUpper() {
			return this.firstLower;
		}
		public void firstUpper() {
			return this.lastLower;
		}
		public void value() {
			return this.value;
		}
		public void numerator() {
			return this.numerator;
		}
		public void denominator() {
			return this.denominator;
		}
	}

	public static ArrayList<fraction> fractions(double max) {

		ArrayList<fraction> allFractions = new ArrayList<fraction>;

		// Iterate over all fractions below one
		for(double i = 1; i <= max; i++) {
			for(double j = 1; j <= i; j++) {

				// Calculate greatest common denominator
				allFractions.add() ;

				}
			}
		}
	}

	public static void main(String args[]){
		fractions(99);
	}

	// 	public static void fractions(double max) {

	// 	// Iterate over all fractions below one
	// 	for(double i = 1; i <= max; i++) {
	// 		for(double j = 1; j <= i; j++) {

	// 			// Calculate greatest common denominator
	// 			double gcm = gcm(i,j);

	// 			if(gcm == 1 || i ==j) {
	// 				continue;
	// 			}

	// 			// Calculate the simplified fraction
	// 			double simpleNumerator = j/gcm;
	// 			double simpleDenomenator = i/gcm;
	// 			double simple = simpleNumerator/simpleDenomenator;

	// 			if (simpleNumerator > 9 || simpleDenomenator > 9) {
	// 				continue;
	// 			}

	// 			// Calculate the fraction itself
	// 			double complex = j/i;

	// 			// Find the digits of each of the numbers
	// 			int firstUpper = ((int)j)%10;
	// 			int lastUpper = ((int)j)/10;
	// 			int firstLower = ((int)i)%10;
	// 			int lastLower = ((int)i)/10;

	// 			// Checks that the length is correct
				

	// 			// Checks that they have the number
	// 			boolean checkOne = firstUpper!=simpleNumerator && firstLower!= simpleDenomenator && firstUpper == firstLower && firstUpper > 0 && firstLower > 0;
	// 			boolean checkTwo = lastUpper!=simpleNumerator && firstLower!= simpleDenomenator && lastUpper == firstLower && lastUpper > 0 && firstLower > 0;
	// 			boolean checkThree = firstUpper!=simpleNumerator && lastLower!= simpleDenomenator && firstUpper == lastLower && firstUpper > 0 && lastLower > 0;
	// 			boolean checkFour = lastUpper!=simpleNumerator && lastLower!= simpleDenomenator && lastUpper == lastLower && lastUpper > 0 && lastLower > 0;

	// 			if(j == 49 && i == 98) {
	// 				System.out.println("Numerator: " + j + " Denominator: " + i);
	// 				System.out.println("Numerator Simple: " + simpleNumerator + " Denominator Simple: " + simpleDenomenator);
	// 				System.out.println("First: " + firstUpper + " Second: " + lastUpper);
	// 				System.out.println("First: " + firstLower + " Second: " + lastLower);
	// 				System.out.println("C1: " + checkOne + " C2: " + checkTwo + " C3: " + checkThree + " C4: " +  checkFour);
	// 				System.out.println("SC1: " + (simpleNumerator == firstUpper || simpleNumerator == lastUpper) + " SC2: " + (simpleDenomenator == firstLower || simpleDenomenator == lastLower));
	// 			}
	// 			if (checkOne || checkTwo || checkThree || checkFour) {
	// 				if ((simpleNumerator == firstUpper || simpleNumerator == lastUpper) && (simpleDenomenator == firstLower || simpleDenomenator == lastLower)) {
	// 				System.out.println("Numerator: " + j + " Denominator: " + i);
	// 				System.out.println("Numerator Simple: " + simpleNumerator + " Denominator Simple: " + simpleDenomenator);
	// 				System.out.println("First: " + firstUpper + " Second: " + lastUpper);
	// 				System.out.println("First: " + firstLower + " Second: " + lastLower);
	// 				}

	// 			}
				

	// 		}
	// 	}
	// }
}