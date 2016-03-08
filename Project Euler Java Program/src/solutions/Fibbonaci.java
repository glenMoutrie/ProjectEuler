package solutions;

import java.math.BigInteger;

public class Fibbonaci {
	
	public static BigInteger fibb(String n){
		
		BigInteger output;
		n = Integer.toString(Integer.parseInt(n) - 1);
		
		if(Integer.parseInt(n) < 0){
			output = new BigInteger("0");
		} else if (n.equals("0")) {
			output = new BigInteger("1");
		} else if (n.equals("1")) {
			output = new BigInteger("1");
		} else {
			
			// Initiate variables
			BigInteger previous = new BigInteger("1");
			BigInteger current = new BigInteger("2");
			BigInteger nextDigit = current;
			
			int index = 2;
			int nInt = Integer.valueOf(n);
			
			while(index < nInt) {
				
				nextDigit = previous.add(current);
				previous = current;
				current = nextDigit;
				
				index++;
			}
			
			output = current;
			
		}
		
		return(output);
	}
	
	public static void main(String args[]){
		System.out.println(fibb("0"));
		System.out.println(fibb("1"));
		System.out.println(fibb("2"));
		System.out.println(fibb("3"));
		System.out.println(fibb("4"));
		System.out.println(fibb("5"));
		System.out.println(fibb("6"));
		System.out.println(fibb("999999").toString().length());
	}

}
