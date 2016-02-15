package solutions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Euler80 {
	
	// Initial funciton
	public static BigDecimal f(BigDecimal value, BigDecimal estimate){
		estimate = estimate.multiply(estimate);
		return(estimate.subtract(value));
	}
	
	// F Prime function
	public static BigDecimal fPrime(BigDecimal estimate) {
		return(estimate.multiply(new BigDecimal(2)));
	}
	
	public static int getTotal(String input) {
		String[] digits = input.replace(".", "").substring(0, 100).split("");
		int total = 0;
		for(String i : digits) {
			total += Integer.parseInt(i);
		}
		
		return(total);
	}


	public static BigDecimal newtonRaphson(BigDecimal estimate) {

		// Basic Parameters
		BigDecimal x0 = new BigDecimal(1); // Starting point
		BigDecimal tolerance = x0.divide(new BigDecimal(10).pow(105)); //
		BigDecimal epsilon = x0.divide(new BigDecimal(10).pow(105));
		BigDecimal y, yPrime, x1;
		int maxIterations = 1000;
		boolean solutionFound = false;

		for(int i = 1; i < maxIterations; i++){

			y = f(estimate,x0);
			yPrime = fPrime(x0);

			if(yPrime.abs().compareTo(epsilon) < 0){
				break;
			}

			x1 = x0.subtract(y.divide(yPrime,105,RoundingMode.CEILING));

			if (x1.subtract(x0).abs().compareTo(tolerance.multiply(x1.abs())) < 1){
				solutionFound = true;
				break;
			}

			x0 = x1;

		}

//		if(solutionFound) {
//			System.out.println("SUCCESS");
//		} else {
//			System.out.println("Bad bloody times.");
//		}

		return(x0);

	}
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		ArrayList<String> results = new ArrayList<String>();
		BigDecimal estimate;

		for(int i = 1; i <= 100; i++){
			estimate = newtonRaphson(new BigDecimal(i));
			if(estimate.divideAndRemainder(new BigDecimal(1))[1]
					.compareTo(new BigDecimal(0)) != 0){
				results.add(estimate.toPlainString());
			}
		}
		
		int total = 0;
		
		
		for(String i : results) {
//			System.out.println(i);
			total += getTotal(i);
//			System.out.println(total);
		}
		
		System.out.println(total);
		System.out.println(System.currentTimeMillis()- start); 
	}
}
