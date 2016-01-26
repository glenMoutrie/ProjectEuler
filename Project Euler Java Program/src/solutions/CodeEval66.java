package solutions;

import java.util.ArrayList;

public class CodeEval66 {
	public static Integer[] nextFibLine(Integer[] lastLine){
		int newLength = (lastLine.length + 1);
		Integer[] output = new Integer[newLength];
		output[0] = 1;
		output[newLength - 1] = 1;
		
		for(int i = 1; i < (newLength - 1); i++){
			try {
				output[i] = lastLine[i-1] + lastLine[i];
			} catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Try harder...");
			}
		}
		
		return output;
	}
	
	public static String toString(Integer[] fibLine){
		StringBuffer printOutput = new StringBuffer("");
		for(Integer i : fibLine) {
			printOutput.append(i);
			printOutput.append(" ");
		}
		return printOutput.toString();
	}
	

	public static void main(String args[]) {
		
		// Parameters needed from the start
		StringBuffer output;
		ArrayList<Integer[]> triangle = new ArrayList<Integer[]>();
		ArrayList<String> triangleString = new ArrayList<String>();
		
		// Initialize values
		int largest = 1;
		triangle.add(new Integer[] {1});
		triangleString.add(toString(triangle.get(0)));
		
		// Iterate over this
		String[] inputs = {"2","3"};
		
		for(String line : inputs) {
			int printTo = Integer.parseInt(line);
			
			// Add if needed
			if(largest < printTo){
				for(int i = largest - 1; i < printTo; i++){
					triangle.add(nextFibLine(triangle.get(triangle.size()-1)));
					triangleString.add(toString(triangle.get(triangle.size()-1)));
				}
				largest = printTo;
			}
			
			output = new StringBuffer("");
			
			for(int i = 0; i < printTo; i++){
				output.append(triangleString.get(i));
			}
			System.out.println(output);
		}
		
	}
}
