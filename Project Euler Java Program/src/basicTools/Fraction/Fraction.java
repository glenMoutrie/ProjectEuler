package basicTools.Fraction;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Fraction<N> {


	N numerator;
	N denominator;
	double value;
	BigDecimal accurateValue;
	boolean accurate;
	
	public Fraction(N numerator, N denominator) {
		this.numerator = numerator;
		this.denominator = numerator;
		calculateValue();
		
	}


	/*
	 * Basic Numerical Methods
	 */
	
	public abstract void calculateValue();
	
	public abstract N multiply(N x);

	public abstract N add(N x);

	public abstract void invert();

	public void print() {
		System.out.println(this.numerator);
		System.out.println("----------");
		System.out.println(this.denominator);
		
	}
	
	public N getNumerator() {
		return numerator;
	}
	
	public N getDenominator() {
		return denominator;
	}
	
	public double getValue() {
		return value;
	}
	
	public BigDecimal getAccurateValue() {
		return accurateValue;
	}

	
}
