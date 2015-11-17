import java.math.*;

public class Euler20 {
	public static BigInteger FactorialSum(int factorial) {
		BigInteger factorialResult, factorialInt;
		factorialResult = new BigInteger(String.valueOf(factorial));
		//int factorialInt = Integer.parseInt(factorial);
		//int factorial = int.factorialInt;

		// Need to multiply by factorial - 1 first
		factorialInt = new BigInteger(String.valueOf(factorial - 1));

		while(factorialInt.compareTo(BigInteger.ONE) != 0){
			factorialResult = factorialResult.multiply(factorialInt);
			factorialInt = factorialInt.subtract(BigInteger.ONE);
		}
		System.out.println(factorialResult);
		return factorialResult;
	}

	public static Integer sumOfDigits(BigInteger target) {
		String characterTarget = target.toString();
		int length = characterTarget.length();
		Integer sum = 0;

		for (int i = length - 1; i >= 0; i--) {
			sum = sum + Integer.parseInt(characterTarget.substring(i,i+1));
		}
		System.out.println(sum);
		return sum;		
	}

	public static void main(String args[]){
		BigInteger firstStep = FactorialSum(100);
		Integer result = sumOfDigits(firstStep);
	}
}