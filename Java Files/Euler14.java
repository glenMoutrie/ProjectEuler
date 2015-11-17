
public class euler14 {
	private static Integer collatzLength(int startingNumber) {
		
		Integer currentNumber = startingNumber;
		Integer length = 1;
		
		do {
			if (currentNumber != 1) {
				if(currentNumber % 2 ==0) {
					currentNumber = currentNumber/2;
				} else {
					currentNumber = (3*currentNumber) + 1;
				}
				System.out.println(currentNumber);
				length++;
			}
			
		} while (currentNumber!=1);
			
		return length;
	}
	
	public static void main(String args[]) {
//		int result;
		Integer largest = 0;
//		for(int x = 1; x <= 1000000; x++) {
//			result = collatzLength(x);
//			if(result > largest) {
//				largest = result;
//			}
//			System.out.println(x + "gives length" + result);
//		}
		largest = collatzLength(113383);
		System.out.println(largest);
	}
}
