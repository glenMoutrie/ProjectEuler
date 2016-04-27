package matrix;

import throwables.TheoreticalError;

public class Matrix {
	
	// Class fields
	Double[][] matrix;
	int m;
	int n;
	
	// Constructors
	public Matrix(int m, int n) {
		matrix = new Double[m][n];
		this.m = m;
		this.n = n;
	}
	
	public Matrix(Double[][] data) {
		matrix = data;
		this.m = data.length;
		this.n = data[1].length;
	}
	
	// Methods
	public Matrix add(Matrix A, Matrix B) {
		
		
		
	}
	
	

}
