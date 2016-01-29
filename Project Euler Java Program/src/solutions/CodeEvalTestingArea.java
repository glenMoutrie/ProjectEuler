package solutions;

import java.util.ArrayList;


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
		//		String line = "Ignore punctuation, please :)";
		//		line = line.toLowerCase();
		//		String[] sentence = line.split("");
		//		
		//		int total, letterValue;
		//		total = 0;
		//		for(String letter: sentence){
		//			switch(letter) {
		//			case "a": letterValue = 1;
		//			break;
		//			case "b": letterValue = 2;
		//			break;
		//			case "c": letterValue = 3;
		//			break;
		//			case "d": letterValue = 4;
		//			break;
		//			case "e": letterValue = 5;
		//			break;
		//			case "f": letterValue = 6;
		//			break;
		//			case "g": letterValue = 7;
		//			break;
		//			case "h": letterValue = 8;
		//			break;
		//			case "i": letterValue = 9;
		//			break;
		//			case "j": letterValue = 10;
		//			break;
		//			case "k": letterValue = 11;
		//			break;
		//			case "l": letterValue = 12;
		//			break;
		//			case "m": letterValue = 13;
		//			break;
		//			case "n": letterValue = 14;
		//			break;
		//			case "o": letterValue = 15;
		//			break;
		//			case "p": letterValue = 16;
		//			break;
		//			case "q": letterValue = 17;
		//			break;
		//			case "r": letterValue = 18;
		//			break;
		//			case "s": letterValue = 19;
		//			break;
		//			case "t": letterValue = 20;
		//			break;
		//			case "u": letterValue = 21;
		//			break;
		//			case "v": letterValue = 22;
		//			break;
		//			case "w": letterValue = 23;
		//			break;
		//			case "x": letterValue = 24;
		//			break;
		//			case "y": letterValue = 25;
		//			break;
		//			case "z": letterValue = 26;
		//			break;
		//			default: letterValue = 0;
		//			break;
		//			}
		//			if(letterValue>0){
		//				System.out.println(letter + ", ");
		//				letterValue = 26;
		//			}
		//			total += letterValue;
		//			
		//		}
		//		System.out.println(total);

		/*
		 * Bit Positions
		 */

		//		int pOne, pTwo, bits;
		//		
		//		String line = "125,1,2";
		//		String[] split = line.split(",");
		//		
		//		pOne = Integer.parseInt(split[1]);
		//		pTwo = Integer.parseInt(split[2]);
		//		
		//		char[] number = Integer.toBinaryString(Integer.parseInt(split[0])).toCharArray();
		//		bits = number.length;
		//		System.out.println(number[bits - pOne] == number[bits - pTwo]);

		/* 
		 * String Search
		 */

		//		String[] split;
		//		
		////		String line = "Hello,ell";
		////		String line = "This is good, is";
		//		String line = "CodeEval,C\\*";
		////		String line = "Old,Young";
		//		
		//		split = line.split(",");
		//		System.out.println(split[1].contains("\\"));
		//		if(split[1].contains("\\")){
		//			split[1].replace("\\", "");
		//			System.out.println(split[0].contains(split[1]));
		//		} else if(split[1].contains("*")){
		//			String[] starSplit = split[1].split("\\*");
		//			if(starSplit.length == 1) {
		//				System.out.println(split[0].contains(starSplit[0]));
		//			} else {
		//				boolean first = split[0].contains(starSplit[0]);
		//				boolean second = split[0].contains(starSplit[1]);
		//				System.out.println(first && second);
		//			}
		//			
		//		} else {
		//			System.out.println(split[0].contains(split[1]));
		//		}

		/* 
		 * matrix rotation 90 degrees
		 */

		//		String line = "a b c d";
		//
		//		// Create the necessary data
		//		String[] split = line.split(" ");
		//		int length = split.length;
		//		Integer row = ((Double)Math.sqrt(length)).intValue();
		//
		//		// String buffer to add the output to
		//		StringBuffer output = new StringBuffer();
		//
		//		// Now loop over the matrix, first by column then by row
		//		for(int column = 0; column < row; column++){O
		//			for(int i = column + row*(row-1); i >= 0; i = i - row){
		//
		//				// Add the data to the output
		//				output.append(split[i]);
		//
		//				// Don't add a space at the end
		//				if(output.length() != line.length()) {
		//					output.append(" ");
		//				}
		//			}
		//		}
		//		
		//		// Finally add the output
		//		System.out.println(output);
		//
		/* 
		 * File size
		 */
		//		Path fileLoc = Paths.get("/Users/glenmoutrie/Documents/Data/Airpassengers.csv");
		//
		//		try{
		//			BasicFileAttributes attr = Files.readAttributes(fileLoc, BasicFileAttributes.class);
		//			System.out.println(attr.size());
		//		} catch (IOException e){
		//			System.err.println("File could not be found. Check the path: " + fileLoc.toString());
		//		}


		/*
		 * Mth element
		 */

		//		String[] split;
		//		int m;
		//		String line = "a b c d 4";
		//		try{
		//			split = line.split(" ");
		//			m = Integer.parseInt(split[split.length - 1]);
		//			System.out.println(split[split.length - (m+1)]);
		//		} catch (ArrayIndexOutOfBoundsException e) {
		//			System.out.println("The following input caused an error: " + line);
		//		}

		/*
		 * Rightmost Char
		 */
		//		String[] split, sentence;
		//		boolean found;
		//		int index;
		//		
		//		String line = "Hello CodeEval,C";
		//		split = line.split(",");
		//		split[0] = split[0].replace(" ", "");
		//		sentence = split[0].split("");
		//		found = false;
		//		index = sentence.length - 1;
		//		
		//		while(!found){
		//			if (index >= 0) {
		//				found = sentence[index].equals(split[1]);
		//			} else {
		//				found = true;
		//			}
		//			
		//			if (found) {
		//				System.out.println(index);
		//			} else {
		//				index--;
		//			}
		//			
		//		}

		/*
		 * Point in circle
		 */
		//		String line = "Ignore punctuation, please :)";
		//		line = line.toLowerCase();
		//		String[] sentence = line.split("");
		//		
		//		int total, letterValue;
		//		total = 0;
		//		for(String letter: sentence){
		//			switch(letter) {
		//			case "a": letterValue = 1;
		//			break;
		//			case "b": letterValue = 2;
		//			break;
		//			case "c": letterValue = 3;
		//			break;
		//			case "d": letterValue = 4;
		//			break;
		//			case "e": letterValue = 5;
		//			break;
		//			case "f": letterValue = 6;
		//			break;
		//			case "g": letterValue = 7;
		//			break;
		//			case "h": letterValue = 8;
		//			break;
		//			case "i": letterValue = 9;
		//			break;
		//			case "j": letterValue = 10;
		//			break;
		//			case "k": letterValue = 11;
		//			break;
		//			case "l": letterValue = 12;
		//			break;
		//			case "m": letterValue = 13;
		//			break;
		//			case "n": letterValue = 14;
		//			break;
		//			case "o": letterValue = 15;
		//			break;
		//			case "p": letterValue = 16;
		//			break;
		//			case "q": letterValue = 17;
		//			break;
		//			case "r": letterValue = 18;
		//			break;
		//			case "s": letterValue = 19;
		//			break;
		//			case "t": letterValue = 20;
		//			break;
		//			case "u": letterValue = 21;
		//			break;
		//			case "v": letterValue = 22;
		//			break;
		//			case "w": letterValue = 23;
		//			break;
		//			case "x": letterValue = 24;
		//			break;
		//			case "y": letterValue = 25;
		//			break;
		//			case "z": letterValue = 26;
		//			break;
		//			default: letterValue = 0;
		//			break;
		//			}
		//			if(letterValue>0){
		//				letterValue = 26;
		//			}
		//			total += letterValue;
		//			
		//		}
		//		System.out.println(total);

		//		/* 
		//		 * Counting capital letters
		//		 */
		//		
		//		String line = "thisTHIS";
		//		String lowerCase = line.toLowerCase();
		//		
		//		char[] both = line.toCharArray();
		//		char[] lower = lowerCase.toCharArray();
		//		
		//		int capitalLetters = 0;
		//		
		//		for(int i = 0; i < both.length; i++){
		//			if(both[i] != lower[i]){
		//				capitalLetters++;
		//			}
		//		}
		//		
		//		Double pctLower = (double)(both.length - capitalLetters);
		//		Double pctUpper = (double)(capitalLetters);
		//		
		//		pctLower = (pctLower/both.length)*100;
		//		pctUpper = (pctUpper/both.length)*100;
		//		
		//		System.out.println("lowercase: " + new DecimalFormat("###.##").format(pctLower) + 
		//				" uppercase: " + new DecimalFormat("###.##").format(pctUpper));


		/*
		 * Inside Circle
		 */

		//		String line = "Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)";
		//		String[] split = line.split(";");
		//		for(String i : split) System.out.println(i);

		/*
		 * Longest word
		 */
		//		String line = "another line";
		//		String[] split = line.split(" ");
		//		String longest = split[0];
		//		for (int i = 1; i < split.length; i++) {
		//			if(split[i].length() > longest.length()){
		//				longest = split[i];
		//			}
		//		}
		//		System.out.println(longest);

		//		/*
		//		 * Lowest Unique Number
		//		 */
		//		String line = "3 3 9 1 6 5 8 1 5 3";
		//		String[] split = line.split(" ");
		//		

		//		/*
		//		 * De capitalize
		//		 */
		//		String line = "Hello world!";
		//		// Process line of input Here
		//        String[] split = line.split("");
		//        StringBuffer output = new StringBuffer("");
		//        
		//        for(String i : split) {
		//        	if(i.matches("[A-Z]")){
		//        		output.append(i.toLowerCase());
		//        	} else if (i.matches("[a-z]")) {
		//        		output.append(i.toUpperCase());
		//        	} else {
		//        		output.append(i);
		//        	}
		//        }
		//        
		//        System.out.println(output);

		/*
		 * Match email address
		 */

		//		String line = "admin#codeeval.com";
		//		System.out.println(line.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));


		/*
		 * Simple addition
		 */
		//		String[] line = {"17","9","8"};
		//		int total = 0;
		//		for(String i :
		//			line){
		//			total += Integer.parseInt(i);
		//		}
		//		
		//		System.out.println(total);

		/*
		 * Unique elements
		 */

		//		TreeSet<Integer> unique = new TreeSet();
		//		StringBuffer output = new StringBuffer("");
		//		String line = "10,11,12,13,14,14,14,15,16,17,18";
		//		String[] split = line.split(",");
		//		for(String i : split){
		//			unique.add(Integer.parseInt(i));
		//		}
		//		
		//		output.append("Result: ");
		//		for(Integer result : unique){
		//			output.append(result);
		//			output.append(",");
		//		}
		//		output.deleteCharAt(output.length()-1);
		//		System.out.println(output);

		/*
		 * Remove characters
		 */

//		String line;
//		String split[];
//
//		line = "how are you, how";
//		split = line.split(", ");
//		
//		StringBuffer output = new StringBuffer(split[0]);
//
//		Pattern pattern = Pattern.compile(new String(new StringBuffer("")
//		.append("[").append(split[1]).append("]")));
//		
//		try{
//			Matcher matcher = pattern.matcher(split[0]);
//			int length = output.length();
//			int diff;
//			while(matcher.find()){
//				diff = length - output.length();
//				output.replace(matcher.start() - diff, matcher.end() - diff, "");
//			}
//			
//		} catch (IllegalStateException e) {
//			System.out.println(pattern);
//			System.out.println("No match");
//		}
//		
//		System.out.println(output);
		
		/* 
		 * Modulus
		 */
		
//		String line = "20,6";
//		String[] split = line.split(",");
//		
////		Double one = Double.parseDouble(split[0]);
//		Double two = Double.parseDouble("0.9");
//		System.out.println(Double.parseDouble(split[0])%Double.parseDouble(split[1]));
//		Double division = Double.parseDouble(split[0])/Double.parseDouble(split[1]);
//		System.out.println((int)((division - division.intValue())*Double.parseDouble(split[1]) + 0.5));
		
		/*
		 * Swap numbers
		 */
		
//		String line = "4Always0 5look8 4on9 7the2 4bright8 9side7 3of8 5life5";
//		char[] output = line.toCharArray();
//		Pattern pattern = Pattern.compile("[0-9]*[A-Za-z]*[0-9]");
//		char first, last;
//		
//		try {
//			Matcher matcher = pattern.matcher(line);
//			while(matcher.find()){
//				first = output[matcher.start()];
//				last = output[matcher.end()-1];
//				output[matcher.start()] = last;
//				output[matcher.end()-1] = first;
//			}
//		} catch (IllegalStateException e) {
//			System.out.println("Matcher failed");
//		}
//		
//		System.out.println(new String(output));
		
		/*
		 * Penultimate line
		 */
		
//		String line = "this is some text";
//		String[] split = line.split(" ");
//		System.out.println(split[split.length - 2]);
		
		/* 
		 * Find a writer
		 */
		
		String line = "osSE5Gu0Vi8WRq93UvkYZCjaOKeNJfTyH6tzDQbxFm4M1ndXIPh27wBA rLclpg| 3 35 27 62 51 27 46 57 26 10 46 63 57 45 15 43 53";
		
		// Declare
		String[] split, numbers;
		ArrayList<Integer> key;
		StringBuffer output;
		
		// Split the string
		split = line.split("|");
		numbers = split[1].split(" ");
		key = new ArrayList<Integer>();
		
		for (String i : numbers) {
			key.add(Integer.parseInt(i));
		}
		
		output = new StringBuffer("");
		for (Integer j : key) {
			output.append(split[0].substring(j, j));
		}
		
		System.out.println(output);

	}
}
