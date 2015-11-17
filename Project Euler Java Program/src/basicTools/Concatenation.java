package basicTools;

public class Concatenation {
	
	public int lengthCheck(int number) {
		// Initiate metrics
		int multipleOfTen = 10;
		int length = 0;
		int iteration = 0;
		
		while(length < 1){
			length = multipleOfTen/number;
			multipleOfTen = multipleOfTen*10;
			iteration++;
		}
		
		return iteration;
	}
	
	public int concatenate(int front, int back) {
		int n = lengthCheck(back);
		int result = front*(int)Math.pow(10, n);
		result = result + back;
		return result;
		
	}
	
	// Testing Area
//	public static void main(String[] args){
//		System.out.println(lengthCheck(123495));
//		System.out.println(concatenate(123,456));
//	}

}
