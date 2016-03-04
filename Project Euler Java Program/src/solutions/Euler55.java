package solutions;

public class Euler55 {
	
	public static void main(String args[]){
		int total = 0;
		for(long i = 0; i <= 10001; i++){
			if(basicTools.NumberCharacteristics.lychrelCheck(i)) {
				total++;
			}
		}
		System.out.println(total);
	}

}
