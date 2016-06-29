package solutions;

public class Euler112 {
	
	public static void main(String[] args) {
		
		int number = 0;
		boolean ninteyNinePC = false;
		double PC = 0.;
		int bouncyNum = 0;
		
		while(!ninteyNinePC) {
			++number;
			if (basicTools.NumberCharacteristics.isBouncy(number)) {
				PC = ((++bouncyNum)*1.)/(number*1.);
				ninteyNinePC = 0.99 <= PC;
			}
			
		}
		
		System.out.println(number);
	}

}
