package solutions;

import java.util.ArrayList;

public class Euler41 {
	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		ArrayList<Integer> primes = basicTools.Factors.primeSieve(987654321);
		System.out.println(System.currentTimeMillis()-start);
		
		
	}
}
