package solutions;

import java.util.ArrayList;

public class Euler41 {
	public static void main(String args[]) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result = basicTools.Factors.primeSieve(999999999);
		result.stream().filter(p -> basicTools.Palindrome.isPandigital(p.toString())).forEach(q -> System.out.println(q));
		
		
	}
}
