public class Euler18 {

	public static int greedySearch(int[][] target,int maxRow) {
		
		int i = 0;
		int j = 0;
		int sum = target[i][j];

		while (maxRow>=i) {
			System.out.println("i = " + i + ", j = " + j);
			i = i + 1;

			if (target[i][j]>=target[i][j+1]){
				j = j;
			} else {
				j = j + 1;
			}

			sum = sum + target[i][j];
		}

		return(sum);

	}

	public static int recursiveSearch(int[][] target, int maxRow) {
		int nodeRow, rowBelow, i;
		nodeRow = maxRow;

		// Recusively adds up the maximum of each node, going up the array
		do {
			nodeRow = nodeRow - 1;
			rowBelow = nodeRow + 1;
			System.out.println("Node Row = " +  nodeRow);
			for (i = 0;i <= nodeRow;i++) {
				target[nodeRow][i] = target[nodeRow][i] + Math.max(target[rowBelow][i],target[rowBelow][i+1]);
				System.out.println(i);
			}
			// Diagnostics
			for (i = 0;i == nodeRow + 1;i++) {
				System.out.println(target[nodeRow][i]);
			}

		} while(nodeRow > 0);

		// Top of the array will be the value of the sum of the largest possible path
		int bestSum = target[0][0];

		return bestSum;

	}

public static void main(String args[]) {

	// Import the data
	int triangle[][] = {{75},
	{95,64},
	{17,47,82},
	{18,35,87,10},
	{20,4,82,47,65},
	{19,1,23,75,3,34},
	{88,2,77,73,7,63,67},
	{99,65,4,28,6,16,70,92},
	{41,41,26,56,83,40,80,70,33},
	{41,48,72,33,47,32,37,16,94,29},
	{53,71,44,65,25,43,91,52,97,51,14},
	{70,11,33,28,77,73,17,78,39,68,17,57},
	{91,71,52,38,17,14,91,43,58,50,27,29,48},
	{63,66,4,68,89,53,67,30,73,16,69,87,40,31},
	{4,62,98,27,23,9,70,98,73,93,38,53,60,4,23}};

	// System.out.println(triangle[14][2]);

	// Find the solution to a greedy search (not a solution to this problem)
	int greedySolution = greedySearch(triangle,13);
	System.out.println(greedySolution);

	// Now perform a search which compares itself to the next best;
	int result = recursiveSearch(triangle,14);
	System.out.println("Result of recursive search = " + result);

}

}