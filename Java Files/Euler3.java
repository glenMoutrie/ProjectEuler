public class Euler3{

	public static void main(String args[]){

		long target = 600851475143L;
		long largestFactor = Math.round(target*0.5);
		long x;
		long primeFactor = 1L;

		for(long i = 1L; i<=largestFactor; i++){
			if(target % i==0) {
				x = 2;

				while(i % x != 0 && x < i) {
					x++;
				}
				if (x==(i) && primeFactor <= i){
					primeFactor=i;				
				}
			}
		}
		System.out.println(primeFactor);
		}
		
}
