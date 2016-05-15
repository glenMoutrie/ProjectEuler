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
			left[i] = A[p + i];
		}
		
		// Populate right
		for(j = 0; j < nTwo; j++) {
			right[j] = A[q + j];
		}
		
		// Add sentinal cards
		// (usually infinity, but I've just set it to the int storage limit)

		left[nOne] = Integer.MAX_VALUE;
		right[nTwo] = Integer.MAX_VALUE;
		
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
			}
		}
		
		return(A);
	}
	
	public static Integer[] mergeSort(Integer[] A, int p, int r) {
		ArrayList<Integer> handler = new ArrayList<Integer>(A.length);
		
		if (p < r) {
			int q = (int) Math.floor((p+r)*0.5);
			handler.addAll(new ArrayList<Integer>(Arrays.asList(mergeSort((Arrays.copyOfRange(A, p, q)), p, q))));
			handler.addAll(new ArrayList<Integer>(Arrays.asList(mergeSort((Arrays.copyOfRange(A, q + 1, r)), q + 1, r))));
			
			
//			output.addAll(new ArrayList<Integer>(Arrays.asList(merge(A, p, q, r))));
			return(merge(handler.toArray(new Integer[r]), p, q, r));
			
		} else {
			return(A);
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
		
		Integer[] b = {2, 4, 5, 7, 1, 2, 3, 6};
		
//		System.out.println(merge(b,0,3,7));
		Integer[] result = merge(b,0,4
				,7);
		for(Integer i : result) System.out.println(i);
		
		mergeSort(b, 0, 8);

	}
}
