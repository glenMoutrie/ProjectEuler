package solutions;

import java.util.ArrayList;
import java.util.HashSet;

import basicTools.NumberCharacteristics;

public class Euler92 {

	
	
	public static void main(String[] args) {
		
		ArrayList<Long> digits;
		Long seqValue;
		int total = 0;
		
		HashSet<Long> knownSuccess = new HashSet<Long>();
		knownSuccess.add((long) 1);
		HashSet<Long> knownFail = new HashSet<Long>();
		knownFail.add((long) 89);
		
		HashSet<Long> thisSeq;
		
		
		
		for (Long i = new Long("1"); i <= 1e7; i++) {
			
			thisSeq = new HashSet<>();
			seqValue = i;
			
			while (!knownSuccess.contains(seqValue)) {
				
				thisSeq.add(seqValue);
				digits = NumberCharacteristics.getDigits(seqValue);
				seqValue = (long) digits.stream()
						.map(x -> Math.pow(x, 2))
						.mapToDouble(x -> x)
						.sum();

				if (knownFail.contains(seqValue)) {
					knownFail.addAll(thisSeq);
					total++;
					break;
				} else if (knownSuccess.contains(seqValue)) {
					knownSuccess.addAll(thisSeq);
				}
			}
			
		}
		
		System.out.println(total);
		
	}
	
}
