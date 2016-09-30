package basicTools;

public class FractionDeprecated {
	// We will create all possible versions of these. We will know which ones are are simple versions of the 
	// other because they will have the same value but with lower valued denominators.

	// Declaration of fields
	public double value;
	public double numerator;
	public double denominator;

	public int firstUpper;
	public int firstLower;
	public int lastUpper;
	public int lastLower;



	// Constructor
	public FractionDeprecated(double j, double i) {
		numerator = j;
		denominator = i;
		value = j/i;

		firstUpper = ((int)j)%10;
		lastUpper = ((int)j)/10;
		firstLower = ((int)i)%10;
		lastLower = ((int)i)/10;
	}


	// Setter
	public void editFraction (double j, double i) {
		numerator = j;
		denominator = i;
		value = j/i;

		firstUpper = ((int)j)%10;
		lastUpper = ((int)j)/10;
		firstLower = ((int)i)%10;
		lastLower = ((int)i)/10;
	}

	// Getters
	public int firstUpper() {
		return this.firstUpper;
	}

	public int lastUpper() {
		return this.lastUpper;
	}

	public int firstLower() {
		return this.firstLower;
	}

	public int lastLower() {
		return this.lastLower;
	}

	public double value() {
		return this.value;
	}

	public double numerator() {
		return this.numerator;
	}

	public double denominator() {
		return this.denominator;
	}
}
