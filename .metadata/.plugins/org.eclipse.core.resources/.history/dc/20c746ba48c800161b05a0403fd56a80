package solutions;

import java.util.HashSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

import basicTools.NumberCharacteristics;

public class Euler74 {

	

	public static int factorialChainLength(int start) {
		HashSet<Integer> observed = new HashSet<>();
		int next, total, seqLen;
		
		seqLen = 0;
		next = start;
		
		while(!observed.contains(next)) {
			
			observed.add(next);
			
			total = 0;
			
			for (int i : NumberCharacteristics.getDigits(start)) {
				total += i;
			}
			
			System.out.println(next);
			next = total;
			seqLen++;
		}
		
		System.out.println(next);
		return(seqLen);
		
	}
	

	public static void main(String args[]) {

		//for(int i = 1; i < 1e6; i++) {
//		for(int i = 1; i < 200; i++) {
//
//		}
		
		System.out.println(factorialChainLength(69));

	}


}
