package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

public class Mode {

	public static String majoritySymbol(ArrayList<String> data, Double minPop) {
		Hashtable<String, Integer> count = new Hashtable<String, Integer>();
		String key;
		int endPoint = (int) (1/minPop);
		int max = 0;
		int increment;
		
		for(int i = 0; i < data.size(); i++) {
			
			// Begin calculating the frequency of object
			key = data.get(i);
			if(count.containsKey(key)) {
				increment = count.get(key) + 1;
				if (increment > max) {
					max = increment;
				}
				count.put(key, increment);
				
			} else {
				count.put(key, 1);
			}
			
			// Once this is true then you can start removing objects less than two
			if(count.size() + 1 > endPoint) {
				
				System.out.println(count);
				
				Enumeration<String> countKeys = count.keys();
				String check;
				
				// Removing each of the objects
				while(countKeys.hasMoreElements()){
					check = countKeys.nextElement();
					if (count.get(check) == 1) {
						count.remove(check);
					}
				}
				
				break;
			}
		}
		
		if(count.keySet().size() == 1) {
			return(count.keys().nextElement());
		} else {
			return("Hasn't found the mode");
		}
		
	}
	
	public static void main(String args[]) {
		String[] testData = {"a", "b", "c", "d", "e", "f", "f", "f", "i", "f", "f", "l", "m", "n", "f", "p", "q", "r", "f", "t", "u", "v", "f", "x", "y", "f"};
//		String[] testData = {"a","a","a", "a","f","f","f"};
		ArrayList<String> data = new ArrayList<String>(Arrays.asList(testData));
		
		String result = majoritySymbol(data, 0.9);
		System.out.println(result);
	}
}
