package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
	
	HashMap<String, Integer> histogram = new HashMap<String, Integer>();
	
	public Table (ArrayList<String> knownValues) {
		knownValues.stream().forEach(x -> this.update(x));
	}
	
	Table () {
	}
	
	
	// Update with a single value
	public void update(String value) {
		if (histogram.containsKey(value)) {
			histogram.compute(value, (k,v) -> v = v + 1);
		} else {
			histogram.put(value, 1);
		}
	}
	
	// Update with multiple values
	public void update(ArrayList<String> values) {
		values.parallelStream().forEach(v -> this.update(v));
	}
	
	public boolean areEqual(Table comparison) {
		
		boolean result = true;
		
		for (String key : histogram.keySet()) {
			
			// Check the each frequency is equal
			if (comparison.observed(key)) {
				if (comparison.freq(key) == histogram.get(key)) {
					continue;
				} else {
					result = false;
					break;
				}
				
			} else {
				result = false;
				break;
			}
			
						
		}
		
		return(result);
	}
	
	public void printTable() {
		for (String key : histogram.keySet()) {
			System.out.println(key + ": " + histogram.get(key));
		}
	}
	
	public boolean observed(String observation) {
		return(histogram.containsKey(observation));
	}
	
	public int freq(String observation) {
		return(histogram.get(observation));
	}
	
	public static void main(String[] args) {
		
		// Populate three array lists
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> compareTrue = new ArrayList<String>();
		ArrayList<String> compareFalse = new ArrayList<String>();
		
		String[] testString = {"String","the", "Yadda", "Yadda", "asdfasd", "Yadda", "String"};
		
		for (String i : testString) data.add(i);
		for (String i : testString) compareTrue.add(i);
		for (String i : testString) compareFalse.add(i);
		compareFalse.remove(0);
		
		// Create three tables
		Table test = new Table(data);
		Table testTrue = new Table(compareTrue);
		Table testFalse = new Table(compareFalse);
		
		// Print results
		test.printTable();
		
		System.out.println("");
		System.out.println(test.areEqual(testTrue));
		System.out.println(test.areEqual(testFalse));
		
		
	}
	
}
