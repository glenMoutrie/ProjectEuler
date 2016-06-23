package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Sort {

	/* 
	 * Implements Insertion sort a per page 18 of Introduction to Algorithms
	 */
	public static ArrayList<Integer> insertionSort(ArrayList<Integer> unsorted, boolean increasing){

		if (increasing) {
			// Sorting the list in an increasing order
			for (int j = 1; j < unsorted.size(); j++) {
				
				// The value of the next item to be sorted
				int key = unsorted.get(j);

				// Shifting previously sorted values to the right
				int i = j - 1;
				while(i >= 0 && unsorted.get(i) > key){
					unsorted.set(i + 1, unsorted.get(i));
					i--;
				}
				unsorted.set(i + 1, key);
			}
		} else {
			// Sorting the list in a decreasing order
			for (int j = unsorted.size() - 2; j >= 0; j--) {
			 	int key = unsorted.get(j);

				// Shifting previously sorted values to the left
				int i = j + 1;
				while(i < unsorted.size() && unsorted.get(i) > key){
					unsorted.set(i - 1, unsorted.get(i));
					i++;
				}
				unsorted.set(i - 1, key);
			}
		}

		return(unsorted);
	}
	
<<<<<<< Updated upstream
	private static Integer[] merge(Integer[] A, int p, int q, int r) {
		
		// Indexing for the two splits
		int nOne = q - p + 1;
		int nTwo = r - q + 1;
		
		// Initiate the two splits
		int[] right = new int[nOne + 2];
		int[] left = new int[nTwo + 2];
		int i, j;
		
		// Populate left
		for(i = 0; i < nOne; i++) {
=======
	private static int[] merge(int[] A, int p, int q, int r) {
		
		// Indexing for the two splits
		int nOne = r - q + 1;
		int nTwo = q - p;
		
		// Initiate the two splits
		int[] right = new int[nOne + 1];
		int[] left = new int[nTwo + 1];
		
		// Populate left
		for(int i = 0; i < nOne; i++) {
>>>>>>> Stashed changes
			left[i] = A[p + i];
		}
			
		// Populate right
		for(int j = 0; j < nTwo; j++) {
			right[j] = A[q + j];
		}
		
		// Add sentinal cards
		// (usually infinity, but I've just set it to the int storage limit)

		left[nOne] = Integer.MAX_VALUE;
		right[nTwo] = Integer.MAX_VALUE;
		
<<<<<<< Updated upstream
		i = 0;
		j = 0;
		
		// Now perform the merge sort
		for (int k = p; k <= r; k++) {
			if (left[i] <= right[j]) {
				A[k] = left[i];
				i++;
			} else {
				A[k] = right[j];
				j++;
=======
		int i = 0;
		int j = 0;
		
		int[] result = new int[nOne + nTwo];
		
		// Merge left and right into a single array
		for(int k = p; k <= r; k++) {
			
			System.out.println("Left: " + left[i] +", Right: " + right[j]);
			if (left[i] <= right[j]) {
				result[k] = left[i];
				i++;
			} else {
				result[k] = right[j];
				j++;
			}
		}
		
		return(result);
	}
	
	public static int[] mergeSort(int[]A, int p, int r) {
		
		//{5,2,4,7,1,3,2,6};
		
		if (p < r) {
			
			// Set up the mid point
			int q = (int) Math.floor((p + r)/2);
			System.out.println(q);
			
			// Copy the array to the new one (ugly as fuck, but right now I just want an implementation...)
			System.arraycopy(mergeSort(A, p, q), 0, A, 0, q);
			for(int i : A ){
				System.out.println("First Merge Sort complete");
				System.out.println(i);
>>>>>>> Stashed changes
			}
			
			System.arraycopy(mergeSort(A, q + 1, r), 0, A, q + 1, r);
			
			// Merge the two sorted results
			A = merge(A, p, q, r);
		} else {
			System.out.println(A[p] + ", r = " + r);
		}
		
		// Return a copy of the array
		return(Arrays.copyOfRange(A,p,r + 1));
	}
	
	public static Integer[] mergeSort(Integer[] A, int p, int r) {
		
		if (A.length > 0) {
			String message = "";
			for (Integer i : A) {
				message += i.toString() + " ";
			}
			System.out.println(message);
		} else {
			System.out.println(A);
		}
		
		
		ArrayList<Integer> handler = new ArrayList<Integer>(A.length);
		
		if (p < r & A.length > 1) {
			int q = (int) Math.floor((p+r)*0.5);
			handler.addAll(new ArrayList<Integer>(Arrays.asList(mergeSort((Arrays.copyOfRange(A, p, q)), p, q))));
			handler.addAll(new ArrayList<Integer>(Arrays.asList(mergeSort((Arrays.copyOfRange(A, q + 1, r)), q + 1, r))));
			
//			output.addAll(new ArrayList<Integer>(Arrays.asList(merge(A, p, q, r))));
			return(merge(handler.toArray(new Integer[r]), p, q, r));
			
		} else if (A.length == 1) {
			return(A);
		} else {
			return(null);
		}
		
//		return((Integer[]) output.toArray());
	}

	public static ArrayList<Integer> insertionSort(ArrayList<Integer> unsorted) {
		return(insertionSort(unsorted, true));
	}

	public static void main(String args[]){

		Integer[] a = {5, 5, 2, 4, 6, 1, 3};
		
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(a));

  
		ArrayList<Integer> sorted = insertionSort(A,true);

		System.out.println(sorted);
		System.out.println(insertionSort(A, false));
		
<<<<<<< Updated upstream
		Integer[] b = {2, 4, 5, 7, 1, 2, 3, 6};
		
//		System.out.println(merge(b,0,3,7));
		Integer[] result = merge(b,0,4
				,7);
		for(Integer i : result) System.out.println(i);
		
		mergeSort(b, 0, 8);
=======
		int[] b = {2, 4, 5, 7, 1, 2, 3, 6};
		
		int[] result = merge(b,0,4,7);
		
		for(int i : result) System.out.println(i);
		
		int[] c = {5,2,4,7,1,3,2,6};
		
		System.out.println("Merge Sort check");
		
		int[] check = Arrays.copyOfRange(c, 0, 1);
		for(int i : check) {System.out.println(i);}
		
		int[] sortResult = mergeSort(c, 0 , 7);
		
		for(int i : sortResult) {System.out.println(i);}
>>>>>>> Stashed changes

	}
}
