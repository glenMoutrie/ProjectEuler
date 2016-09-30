package basicTools.Fraction;

public class IntegerFraction {

	private int numerator;
	private int denominator;
	private double value;

	// Constructor
	public IntegerFraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		calculateValue();
		
	}

	public void calculateValue() {
		this.value = this.numerator/this.denominator;
	}

	/*
	 * Basic Numerical Methods
	 */

	public IntegerFraction multiply(IntegerFraction x) {

		IntegerFraction update = new IntegerFraction(this.numerator*x.getNumerator(), 
				this.numerator*x.getDenominator());

		update.calculateValue();

		return(update);

	}

	public IntegerFraction add(IntegerFraction x) {

		int denominator = this.denominator*x.getDenominator();
		int numerator = (this.denominator*x.getNumerator()) + (x.getDenominator()*this.numerator);

		IntegerFraction update = new IntegerFraction(numerator, denominator);

		update.calculateValue();

		return(update);

	}

	public IntegerFraction add(int x) {

		IntegerFraction addition = new IntegerFraction(x, 1);

		return(this.add(addition));
	}

	public void invert() {

		// Switch the numerator and denominator
		int newDenominiator = this.numerator;
		this.numerator = this.denominator;
		this.denominator = newDenominiator;

		// Update the value
		calculateValue();
	}

	public int getDenominator() {
		return this.denominator;
	}

	public int getNumerator() {
		return this.numerator;
	}

	public void print() {
		System.out.println(this.numerator);
		System.out.println("-------");
		System.out.println(this.denominator);
	}


}