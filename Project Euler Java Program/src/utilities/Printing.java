package utilities;

import java.util.ArrayList;

public class Printing {
	public static <E> void printTokenisedArrayList(ArrayList<E> list){
		StringBuffer tokenised = new StringBuffer();
		int index = 0;
		
		for(Object item:list){
			index++;
			tokenised.append(item);
			if(index != list.size()){
				tokenised.append(",");
			}
		}
		System.out.println(tokenised);
	}
	
	public static void main(String args[]){
		ArrayList<String> testOne = new ArrayList<String>();
		ArrayList<Integer> testTwo = new ArrayList<Integer>();
		
		testOne.add("One");
		testOne.add("Two");
		testOne.add("Three");
		
		testTwo.add(1);
		testTwo.add(2);
		testTwo.add(3);
		
		printTokenisedArrayList(testOne);
		printTokenisedArrayList(testTwo);
		printTokenisedArrayList(basicTools.Factors.primeSieve(123));
	}

}
