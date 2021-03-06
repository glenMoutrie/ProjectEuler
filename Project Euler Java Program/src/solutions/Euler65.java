package solutions;

import basicTools.NumberCharacteristics;
import basicTools.Fraction.BigIntegerFraction;
import basicTools.Fraction.IntegerFraction;

public class Euler65 {

	public static void main(String[] args) {
		int[] updateSeq = new int[100];

		updateSeq[0] = 2;
		updateSeq[1] = 1;
		
		int update = 2;
		int counter = 2;
		
		for (int i = 1; i < updateSeq.length; i++){
			
			if (counter == 3) {
				updateSeq[i] = update;
				update = update + 2;
				counter = 1;
			} else {
				updateSeq[i] = 1;
				counter++;
			}
			
			
		}
		
		for (int i : updateSeq) System.out.println(i);
		
//		IntegerFraction estimate = new IntegerFraction(1,updateSeq[updateSeq.length - 1]);
		BigIntegerFraction estimate = new BigIntegerFraction(1,updateSeq[updateSeq.length - 1]);
		
		for(int i = updateSeq.length - 2; i >= 0; i--) {
			estimate = estimate.add(updateSeq[i]);
			if(i != 0) {
				estimate.invert();
			}
			
			System.out.println("\nIteration : "+ updateSeq[i]);
			estimate.print();
		}
		
		estimate.print();
		System.out.println(estimate.getValue());
		
		System.out.println(NumberCharacteristics.getSumOfDigits(estimate.getNumerator()));
		
	}
	
	
}
