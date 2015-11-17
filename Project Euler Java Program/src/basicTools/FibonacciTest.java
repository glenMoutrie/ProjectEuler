package basicTools;

import basicTools.Factors;
import java.util.ArrayList;


public class FibonacciTest {
	public static void main(String args[]){
//		System.out.println(NumberSequence.fibonacciNumber(11));
//		System.out.println(NumberSequence.fibonacciSequence(11));
//		
//		// Testing prime factors
		
		ArrayList<Integer> primes;
		primes = Factors.primeSieve(100);
//		int primeSize = primes.size();
		ArrayList<Integer> composites;
		composites = Factors.compositeSieve(100, true);
//		
		System.out.println(composites);
		System.out.println(primes);
//		System.out.println(Factors.oddValues(composites));
		
		System.out.println(2/3);
		
	}
}
