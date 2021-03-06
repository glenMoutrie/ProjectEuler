package solutions;

import java.util.ArrayList;
import java.util.Collections;

import basicTools.Fraction.IntegerFraction;

public class Euler71 {

	private static ArrayList<IntegerFraction> generateFractions(int denominator) {

		ArrayList<IntegerFraction> output = new ArrayList<IntegerFraction>(denominator);

		IntegerFraction input;

		for(int j = denominator; j >= 1; j--) {
			for(int i = j - Math.floorDiv(denominator, 2); i >= 1; i--) {

				input = new IntegerFraction(i, j);

				if(!output.contains(input)) {
					input.reduce();
					output.add(input);
				}

			}
		}

		Collections.sort(output);

		return(output);
	}

	public static void main(String[] args) {
		
		/*
		 * HAHAHA BRUTE FORCE LOL DOESN"T WORK
		 * 
		 * 
		 * Managed to guess it, simply divide the number by 999999, and you get the
		 * numerator 428570
		 */
		boolean hitTarget = false;
		
		for(IntegerFraction i : generateFractions(8)) {
			
			if (hitTarget) i.print();
			
			hitTarget = (i.getNumerator() == 3 && i.getDenominator() ==7);
		}
		

	}
	
}

