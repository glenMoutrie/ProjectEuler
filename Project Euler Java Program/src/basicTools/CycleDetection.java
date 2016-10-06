package basicTools;

import java.util.ArrayList;

public class CycleDetection<T> {
	
	ArrayList<T> series;
	int lambda;
	int mu;
	
	public CycleDetection(ArrayList<T> series) {
		this.series = series;
//		floydCycleDetection();
		brent();
	}
	
	private boolean checkEqual(int tortoise, int hare) {
		return this.series.get(hare).equals(this.series.get(tortoise));
//		return tortoise == hare;
	}
	
	private void floydCycleDetection() {
		
		int tortoise = 0;
		int hare = 1;
		
		while(!checkEqual(tortoise, hare)) {
			tortoise = tortoise + 2;
			hare = hare + 4;
			
		}
		
		int mu = 0;
		tortoise = 0;
		
		while(!checkEqual(tortoise, hare)) {
			tortoise++;
			hare++;
			mu++;
		}
		
		int lambda = 1;
		hare = tortoise + 1;
		
		while(!checkEqual(tortoise, hare)) {
			hare++;
			lambda++;
		}
		
		this.lambda = lambda;
		this.mu = mu;
		
	}
	
	public int getMu() {
		return mu;
	}
	
	public int getLambda() {
		return lambda;
	}
	
	private void brent() {
		int power = 1;
		int lambda = 1;
		
		int tortoise = 0;
		int hare = 1;
		
		int length = this.series.size();
		
		while(!checkEqual(tortoise, hare)){
			if (power == lambda) {
				tortoise = hare;
				power = power*2;
				lambda = 0;
			}
			hare++;
			lambda++;
			
		}
		
		int mu = 0;
		tortoise = 0;
		hare = lambda;
		
		while (!checkEqual(hare, tortoise)){
			tortoise++;
			hare++;
			mu++;
		}
		
		this.lambda = lambda;
		this.mu = mu;
	}

	public static void main(String[] args) {
		// The array below wont work, and lambda is 1 instead of 4
//		int[] i = {1,1,2,3,1,1,2,3,1,1,2,3};
		
		// The array below will work, and lambda is 3
//		int[] i = {1,2,3,1,2,3,1,2,3};
		
		int[] i = {2, 0, 6, 3, 1, 6, 3, 1, 6, 3, 1};
		
		ArrayList<Integer> test = new ArrayList<Integer>(i.length);
		for(Integer j : i) test.add(j);
		
		CycleDetection<Integer> cycle = new CycleDetection<Integer>(test);
		
		System.out.println(cycle.getLambda());
		System.out.println(cycle.getMu());
		
		String message = "";
		for (int j = cycle.getMu(); j < cycle.getLambda() + cycle.getMu(); j++) {
			message = message + i[j] + " ";
		}
		System.out.println(message);
		
	}
	
	

}
