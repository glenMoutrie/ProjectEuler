package solutions;

import java.util.ArrayList;
import java.util.Iterator;

public class Euler46 {

	public static void main(String args[]) {
		
		long start = System.currentTimeMillis();

		// Set the highest target
		int highestTarget = 1000000;

		ArrayList<Integer> composite = basicTools.Factors.compositeSieve(highestTarget,true);
		ArrayList<Integer> primeNumbers = basicTools.Factors.primeSieve(highestTarget);

		boolean conjectureDisproven = false;
		int currentComposite, currentPrime, currentSquare, result, possibleSolutions;
		
		for (Iterator<Integer> compositeIterator = composite.iterator(); compositeIterator.hasNext() && !conjectureDisproven;) {
			currentComposite = compositeIterator.next();
			possibleSolutions = 0;
			
			// Looping over all primes less than the composite number
			for(Iterator<Integer> primeIterator = primeNumbers.iterator(); primeIterator.hasNext() && possibleSolutions == 0;){
				currentPrime = primeIterator.next();
				currentSquare = 0;
				
				// The prime number cannot be greater than the composite for a solution
				if(currentPrime > currentComposite) {
					break;
				}
				
				// Loop over the square terms
				do{
					// Compute the result and print them
					result = currentPrime + (2*currentSquare*currentSquare);
//					System.out.println("Composite: " + currentComposite + "; Current Square: " + currentSquare + "; Current Prime: " + currentPrime + "; Result: " + result);
					
					// Break once you find a solution
					if(result == currentComposite) {
//						System.out.println("Composite " + currentComposite +  " has a solution, does not disprove.");
						++possibleSolutions;
					}
					
					// Update the square term
					
					++currentSquare;
				} while (currentComposite > result && possibleSolutions == 0);
				
				// If you have found any solutions you do not want to iterate further, go to the next composite
				if(possibleSolutions > 0){
					break;
				}
			}
			
			// If you have reached this point without any solutions, you have found the answer
			if(possibleSolutions == 0) {
				System.out.println("The solution is: " + currentComposite);
				break;
			}
		}

		System.out.println(System.currentTimeMillis()-start);
		// This was too slow
		//		composite = basicTools.Factors.oddValues(composite);

//		System.out.println(composite);

	}

}
