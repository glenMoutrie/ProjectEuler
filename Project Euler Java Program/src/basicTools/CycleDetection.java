package basicTools;

import java.util.ArrayList;

public class CycleDetection<T> {
	
	ArrayList<T> series;
	int lambda;
	int mu;
	
	CycleDetection(ArrayList<T> series) {
		this.series = series;
		floydCycleDetection();
	}
	
	private boolean checkEqual(int tortoise, int hare) {
		return this.series.get(hare).equals(this.series.get(tortoise));
//		return tortoise == hare;
	}
	
	private void floydCycleDetection() {
		
		int tortoise = 0;
		int hare = 1;
		
		while(!checkEqual(tortoise, hare)) {
			tortoise++;
			hare = hare + 2;
		}
		
		int mu = 0;
		
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
	
	public static void main(String[] args) {
		
		Integer[] i = {1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3};
		
		ArrayList<Integer> test = new ArrayList<Integer>(i.length);
		for(Integer j : i) test.add(j);
		
		CycleDetection<Integer> cycle = new CycleDetection<Integer>(test);
		
		System.out.println(cycle.getLambda());
		
	}
	
	

}
