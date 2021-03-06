package basicTools.Fraction;

import java.math.BigDecimal;
import java.math.RoundingMode;

import basicTools.GeneralCalculation;

public class IntegerFraction implements Comparable<IntegerFraction>{

	private int numerator;
	private int denominator;
	private double value;
	private BigDecimal accValue;
	
	private boolean accurate;
	

	// Constructor
	public IntegerFraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		calculateValue();
		
	}
	
	public IntegerFraction(int numerator, int denominator, boolean accurate) {
		this.numerator = numerator;
		this.denominator = denominator;
		
		this.accurate = accurate;
		if (accurate) this.accValue = BigDecimal.ONE;
		calculateValue();
		
	}


	public void calculateValue() {
		if (this.accurate) {
			this.accValue = new BigDecimal(Integer.toString(this.numerator))
					.divide(new BigDecimal(Integer.toString(this.denominator)),10000,RoundingMode.CEILING);
		} else {
			this.value = ((double) this.numerator)/((double) this.denominator);
		}
		
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
	
	public double getValue() {
		return this.value;
	}
	
	public BigDecimal getAccValue() {
		return this.accValue;
	}
	
	public void print() {
		System.out.println(this.numerator);
		System.out.println("-------");
		System.out.println(this.denominator);
	}
	
	public void reduce() {
		
		int commonMultiple = GeneralCalculation.gcm(this.numerator, this.denominator);
		
		this.numerator = this.numerator/commonMultiple;
		this.denominator = this.denominator/commonMultiple;
		
	}

	@Override
	public int compareTo(IntegerFraction o) {
		
		boolean numeratorCheck = this.numerator == o.getNumerator();
		boolean denominatorCheck = this.denominator == o.getDenominator();
		
		if (numeratorCheck && denominatorCheck) {
			return 0;
		} else if (this.value > o.getValue()) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		
		if(!IntegerFraction.class.isAssignableFrom(obj.getClass())) {
			return false;
		} else {
			IntegerFraction compare = (IntegerFraction) obj;
			
//			boolean numeratorCheck = this.numerator == compare.getNumerator();
//			boolean denominatorCheck = this.denominator == compare.getDenominator();
			boolean valueCheck = this.value == compare.getValue();
			
			if(valueCheck) {
				return(true);
			} else {
				return(false);
			}
		}
		
	}

}
