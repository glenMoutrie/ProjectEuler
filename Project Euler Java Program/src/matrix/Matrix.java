package matrix;

import org.jblas.DoubleMatrix;

import throwables.TheoreticalError;

public class Matrix {
	
	// Class fields
	DoubleMatrix matrix;
	int m;
	int n;
	int rowID = 1;
	int columnID = 2;
	
	// Constructors
	public Matrix(int m, int n) {
		this.matrix = new DoubleMatrix(m, n);
		this.m = m;
		this.n = n;
	}
	
	public Matrix(Double[][] data) {
		this.m = data.length;
		this.n = data[1].length;
		
		// Create the double matrix
		this.matrix = new DoubleMatrix(m, n);
		
		// Populate the matrix
		for (int i = 0; i < data.length; i ++) {
			for (int j = 0; j < data[i].length; j++) {
				this.matrix.put(i, j, data[i][j]);
			}
			
		}
	}
	
	// Methods
	public Matrix addWith(Matrix o) {
		
		this.matrix = add(o).getMatrixData();
		
		return this;
		
	}
	
	public Matrix add(Matrix o) {
		if (this.m != o.getNumCols()) throw new TheoreticalError("The columns do not match");
		if (this.n != o.getNumRows()) throw new TheoreticalError("The rows do not match");
		
		this.matrix.add(o.getMatrixData());
		
		return this;
	}
	
	public void transpose() {
		
		int placeHolder = this.m;
		this.m = this.n;
		this.n = placeHolder;
		
		placeHolder = this.rowID;
		this.rowID = this.columnID;
		this.columnID = this.rowID;
		
	}
	
	public Matrix multiply(Matrix o) {
		
		if (this.n != o.getNumCols()) throw new TheoreticalError("The columns do not match");
		if (this.m != o.getNumRows()) throw new TheoreticalError("The rows do not match");
		
		return this;
		
	}
	
	private DoubleMatrix getMatrixData() {
		return this.matrix;
	}
	
	public int getNumCols() {
		return this.m;
	}
	
	public int getNumRows() {
		return this.n;
	}

}
