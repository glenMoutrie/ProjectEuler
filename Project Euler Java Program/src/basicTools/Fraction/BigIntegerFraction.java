package basicTools.Fraction;

import java.math.BigInteger;

public class BigIntegerFraction {

	BigInteger numerator;
	BigInteger denominator;
	double value;
	
	public BigIntegerFraction(int numerator, int denominator) {
		this.numerator = new BigInteger(Integer.toString(numerator));
		this.denominator = new BigInteger(Integer.toString(denominator));
		calculateValue();
		
	}
	
	public BigIntegerFraction(BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		calculateValue();
		
	}
	
	public void calculateValue() {
		this.value = this.numerator.divide(this.denominator).doubleValue();
	}


	/*
	 * Basic Numerical Methods
	 */
	
	public BigIntegerFraction multiply(BigIntegerFraction x) {
		BigIntegerFraction update = new BigIntegerFraction(this.numerator.multiply(x.getNumerator()),
				this.denominator.multiply(x.getDenominator()));
		
		update.calculateValue();
		
		return(update);
		
	}

	public BigIntegerFraction add(BigIntegerFraction x) {
		
		BigInteger denominator = this.denominator.multiply(x.getDenominator());
		BigInteger numerator = this.denominator.multiply(x.getNumerator());
		numerator = numerator.add(x.getDenominator().multiply(this.numerator));
		
		return new BigIntegerFraction(numerator, denominator);
		
	}

	public BigIntegerFraction add(int x) {
		
		return this.add(new BigIntegerFraction(x, 1));
		
	}
	
	public void invert() {
		
		BigInteger newDenominator = this.numerator;
		this.numerator = this.denominator;
		this.denominator = newDenominator;
		
		calculateValue();
		
	}

	public void print() {
		System.out.println(this.numerator);
		System.out.println("----------");
		System.out.println(this.denominator);
		
	}
	
	public BigInteger getNumerator() {
		return numerator;
	}
	
	public BigInteger getDenominator() {
		return denominator;
	}
	
	public double getValue() {
		return value;
	}

}
