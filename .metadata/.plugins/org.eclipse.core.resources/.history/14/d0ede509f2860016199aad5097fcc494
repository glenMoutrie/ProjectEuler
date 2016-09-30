package basicTools;

import java.math.BigInteger;
import java.util.ArrayList;

public class SquareRootFraction {

	int n;
	ArrayList<BigInteger> numerator;
	ArrayList<BigInteger> denominator;
	
	
	public SquareRootFraction (int n) {
		this.n = n;
	}
	
	private BigInteger update(BigInteger lagOne, BigInteger lagTwo) {
		
		// (lagOne*2)+lagTwo
		return(lagOne.multiply(new BigInteger("2")).add(lagTwo));
	}
	
	private void calculateDenominator() {
		this.denominator = new ArrayList<BigInteger>(this.n);
		
		this.denominator.add(0, new BigInteger("2"));
		this.denominator.add(1, new BigInteger("5"));
		
		BigInteger update;
		
		for (int i = 2; i < this.n; i++) {
			update = this.denominator.get(i - 1).multiply(new BigInteger("2"));
			update = update.add(this.denominator.get(i - 2));
			this.denominator.add(i, update);
		}
		
	}
	
	private void calculateNumerator() {
		this.numerator = new ArrayList<BigInteger>(this.n);
		
		this.numerator.add(0, new BigInteger("3"));
		
		for (int i = 1; i < this.n; i++) {
			this.numerator.add(i, this.denominator.get(i - 1).add(this.denominator.get(i)));
		}
		
	}
	
	private int calculateLargerNumerator() {
		
		int dLength;
		int nLength;
		int instance = 0;
		
		for(int i = 0; i < this.n; i++) {
			dLength = this.denominator.get(i).toString().length();
			nLength = this.numerator.get(i).toString().length();
			if (dLength < nLength) {
				instance++;
			}
		}
		
		return(instance);
	}
	
	public ArrayList<BigInteger> getDenominator() {
		return denominator;
	}
	
	public ArrayList<BigInteger> getNumerator() {
		return numerator;
	}
	
	public static void main(String[] args) {
		SquareRootFraction test = new SquareRootFraction(1000);
		test.calculateDenominator();
		test.calculateNumerator();
		
		System.out.println(test.calculateLargerNumerator());
		
	}
	
}
