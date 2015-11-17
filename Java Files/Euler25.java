import java.math.*;

public class Euler25 {
	public static long calcFibN(int target) {
		BigInteger fN,fNPlusOne,next,limit;
		boolean check;
		int iterationNum;
		check = false;
		fN = new BigInteger("1");
		fNPlusOne = new BigInteger("2");
		iterationNum = 3;

		// Account for the fact that the power needs to be one less than the number of digits
		target = target -1;

		limit = new BigInteger("10");
		limit = limit.pow(target);

		do {

			// Calculate next in sequence, allocate accordingly
			next = fN.add(fNPlusOne);
			fN = fNPlusOne;
			fNPlusOne = next;

			// Update n
			iterationNum = iterationNum + 1;

			int comparison = fNPlusOne.compareTo(limit);

			if(comparison >=0){
				check = true;
			}

		} while (!check);

		System.out.println(limit + " " + target);
		System.out.println(fN + " " + fNPlusOne);
		System.out.println(iterationNum);
		return(iterationNum);

	}

	public static void main(String args[]) {
		long result = calcFibN(1000);
	}
}