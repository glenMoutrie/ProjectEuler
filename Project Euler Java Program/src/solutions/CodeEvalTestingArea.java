package solutions;

public class CodeEvalTestingArea {

	public static void main(String args[]){
		/*
		 * Swapping words around
		 * */
		//		String sentence = "This is a sentence with multiple words";
		//		String[] words = sentence.split(" ");
		//		StringBuffer output = new StringBuffer();
		//		for(int i = words.length - 1; i >= 0; i--){
		//			output.append(words[i].concat(" "));
		//		}
		//		System.out.println(output);

		/*
		 * Finding the first multiple of a number that is larger than another.
		 * Much too easy, it's a pity their submission system is SO SHIT
		 */
		//		String line = "2548,1024";
		//		String[] numbers = line.split(",");
		//		Integer x = Integer.valueOf(numbers[0]);
		//		Integer n = Integer.valueOf(numbers[1]);
		//		Integer result = n;
		//		int multiple = 1;
		//		while(result < x){
		//			result = ++multiple*n;
		//		}
		//		System.out.println(result);

		/*
		 * Check for all primes weather or not they are palindromes
//		 */
		//		line = "496";
		//		String[] digits = line.split("");
		//		int total = 0;
		//		for(String number:digits){
		//			if(!number.equals("")){
		//				total += Integer.valueOf(number);
		//			}
		//			
		//		}
		//		System.out.println(total);

		/*
		 * Convert numbers to digits (yawn, at least I get to use switch...)
		 */
//		String line = "zero;two;five;seven;eight;four";
//		String [] numbers = line.split(";");
//		StringBuffer result = new StringBuffer();
//		for(String values:numbers){
//			switch(values) {
//			case "zero": result.append("0");
//			break;
//			case "one": result.append("1");
//			break;
//			case "two": result.append("2");
//			break;
//			case "three": result.append("3");
//			break;
//			case "four": result.append("4");
//			break;
//			case "five": result.append("5");
//			break;
//			case "six": result.append("6");
//			break;
//			case "seven": result.append("7");
//			break;
//			case "eight": result.append("8");
//			break;
//			case "nine": result.append("9");
//			break;
//			default: break;
//			}
//		}
//		System.out.println(result);
		
		/*
		 * Find the intersection between sets of digits
		 */
		
//		String line = "7,8,9;8,9,10,11,12";
//		
//		// Split each component
//		String[] firstSplit = line.split(";");
//		String[] left = firstSplit[0].split(",");
//		String[] right = firstSplit[1].split(",");
//		
//		StringBuffer output = new StringBuffer("");
//		
//		// Iterate on the left hand side
//		for(String values:left) {
//			for(String otherValues:right) {
//				if(values.equals(otherValues)){
//					if(output.length()!=0){
//						output.append(",");
//					}
//					output.append(values);
//				}
//			}
//		}
//		
//		System.out.println(output);
		
		/*
		 * Beautiful Strings
		 * 
		 */
		String line = "Ignore punctuation, please :)";
		line = line.toLowerCase();
		String[] sentence = line.split("");
		
		int total, letterValue;
		total = 0;
		for(String letter: sentence){
			switch(letter) {
			case "a": letterValue = 1;
			break;
			case "b": letterValue = 2;
			break;
			case "c": letterValue = 3;
			break;
			case "d": letterValue = 4;
			break;
			case "e": letterValue = 5;
			break;
			case "f": letterValue = 6;
			break;
			case "g": letterValue = 7;
			break;
			case "h": letterValue = 8;
			break;
			case "i": letterValue = 9;
			break;
			case "j": letterValue = 10;
			break;
			case "k": letterValue = 11;
			break;
			case "l": letterValue = 12;
			break;
			case "m": letterValue = 13;
			break;
			case "n": letterValue = 14;
			break;
			case "o": letterValue = 15;
			break;
			case "p": letterValue = 16;
			break;
			case "q": letterValue = 17;
			break;
			case "r": letterValue = 18;
			break;
			case "s": letterValue = 19;
			break;
			case "t": letterValue = 20;
			break;
			case "u": letterValue = 21;
			break;
			case "v": letterValue = 22;
			break;
			case "w": letterValue = 23;
			break;
			case "x": letterValue = 24;
			break;
			case "y": letterValue = 25;
			break;
			case "z": letterValue = 26;
			break;
			default: letterValue = 0;
			break;
			}
			if(letterValue>0){
				letterValue = 26;
			}
			total += letterValue;
			
		}
		System.out.println(total);
		

	}
}
