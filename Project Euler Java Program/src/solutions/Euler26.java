package solutions;

import java.util.ArrayList;
import java.util.Collections;

import basicTools.CycleDetection;
import basicTools.NumberCharacteristics;
import basicTools.Fraction.IntegerFraction;

public class Euler26 {
	
	public static void main(String[] args) {
		
		IntegerFraction frac;
		ArrayList<Integer> values;
		CycleDetection cycle;
		
		int max = 0;
		
		for (int i = 1; i <= 20; i++) {
			frac = new IntegerFraction(1, i, true);
			
			frac.print();
			System.out.println("\n"+ frac.getAccValue());
			
			values = NumberCharacteristics.getDecimalValues(frac.getAccValue());
			Collections.reverse(values);
			
			for(int j = values.size() - 1; j >= 1; j--) {
				if (values.get(j) == 0) {
					values.remove(j);
				} else {
					break;
				}
			}
			
			if (values.size() > 2) {
				cycle = new CycleDetection(values);
				System.out.println("Cycle length "+ cycle.getLambda());
				
				if (cycle.getLambda() > max) max = cycle.getLambda();
				
			} else {
				System.out.println("Cycle length "+ values.size());
			}
			
			
			
		}
		System.out.println("MAX = "+max);
	}
	
	
	// INITIAL ATTEMPT
//	public static int brent(String[] series) {
//		int tortoise = 0;
//		int hare = 0;
//		int diff;
//		int mu;
//		int lambda;
//		
//		boolean equal = false;
//		
//		while(!equal && hare < series.length - 2) {
//			hare += 2;
//			tortoise++;
//			
//			equal = series[tortoise].equals(series[hare]);
//			
//		}
//		
//		if(!equal) {
//			System.out.println("Not found");
//			return(0);
//		} else {
//			diff = hare - tortoise;
//		}
//		
//		int limit = series.length - 1;
//		mu = 0;
//		tortoise = 0;
//		
//		while(hare < limit) {
//			tortoise++;
//			hare++;
//			mu++;
//			
//			if(series[tortoise].equals(series[hare])) {
//				break;
//			}
//		}
//		
//		lambda = 1;
//		hare = tortoise + 1;
//		
//		boolean found = false;
//		
//		while(!found & hare < limit) {
//			hare++;
//			lambda++;
//			
//			
//			if (series[tortoise].equals(series[hare]) & diff%lambda == 0) {
//				found = true;
//			}
//			
//		}
//		
//		if (lambda == 9998) {
//			lambda = 0;
//		}
//		
//		return(lambda);
//
//	}
//	
//	public static void main(String args[]){
//		ArrayList<BigDecimal> fractions = new ArrayList<BigDecimal>(998);
//		BigDecimal result;
//		
//		for(Integer i = 2; i < 1000; i++){
//			result = new BigDecimal("1");
//			result = result.divide(new BigDecimal(i.toString()),10000,RoundingMode.CEILING);
//			fractions.add(result);
//		}
//		
////		System.out.println(fractions.get(0));
////		for(BigDecimal j : fractions) {
////			System.out.println(j);
////		}
//		
//		String formatted;
//		String[] split;
//		int length, max;
//		max = 0;
//		int denominator = 0;
//		
//		for(int i = 0; i < fractions.size(); i++) {
//			formatted = fractions.get(i).toString();
//			formatted = formatted.substring(2, formatted.length());
//			
//			split = formatted.split("");
//			length = brent(split);
//			if(length > max) {
//				max = length;
//				denominator = i + 2;
//				System.out.println(fractions.get(i));
//			}
//			System.out.println(length);
//		}
//		System.out.println("Max = " + max + "; Denominator = " + denominator);
//	}

}
