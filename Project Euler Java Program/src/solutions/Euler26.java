package solutions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Euler26 {
	
	public static int brent(String[] series) {
		int tortoise = 0;
		int hare = 0;
		int result;
		boolean equal = false;
		
		while(!equal && hare < series.length - 2) {
			hare = hare + 2;
			tortoise++;
			
			equal = series[tortoise].equals(series[hare]);
			
			result = hare - tortoise;
			
		}
		
		if(!equal) {
			System.out.println("Not found");
			return(0);
		}
		
		while(tortoise < hare) {
			tortoise++;
			if(series[tortoise].equals(series[hare])) {
				result = tortoise - hare;
				break;
			}
		}
		
		return(hare - tortoise);

	}
	
	public static void main(String args[]){
		ArrayList<BigDecimal> fractions = new ArrayList<BigDecimal>(998);
		BigDecimal result;
		
		for(Integer i = 2; i < 1000; i++){
			result = new BigDecimal("1");
			result = result.divide(new BigDecimal(i.toString()),10000,RoundingMode.CEILING);
			fractions.add(result);
		}
		
//		System.out.println(fractions.get(0));
//		for(BigDecimal j : fractions) {
//			System.out.println(j);
//		}
		
		String formatted;
		String[] split;
		int length, max;
		max = 0;
		int denominator = 0;
		
		for(int i = 0; i < fractions.size(); i++) {
			formatted = fractions.get(i).toString();
			formatted = formatted.substring(2, formatted.length());
			
			split = formatted.split("");
			length = brent(split);
			if(length > max) {
				max = length;
				denominator = i + 2;
				System.out.println(fractions.get(i));
			}
			System.out.println(length);
		}
		System.out.println("Max = " + max + "; Denominator = " + denominator);
	}

}
