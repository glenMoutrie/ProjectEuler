package matrix;

import throwables.TheoreticalError;

public class Matrix {
	
	// Class fields
	Double[][] matrix;
	int m;
	int n;
	int rowID = 1;
	int columnID = 2;
	
	// Constructors
	public Matrix(int m, int n) {
		matrix = new Double[m][n];
		this.m = m;
		this.n = n;
	}
	
	public Matrix(Double[][] data) {
		new DenseMatrix = DenseMatrix(data);
		this.m = data.length;
		this.n = data[1].length;
	}
	
	// Methods
	public Matrix add(Matrix o) {
		
		if (this.m != o.getNumCols()) throw new TheoreticalError("The columns do not match");
		if (this.n != o.getNumRows()) throw new TheoreticalError("The rows do not match");
		
		for(int i = 0; i < this.n; i++) {
			for (int j = 0; i < this.m; j++) {
				this.matrix[i][j] = this.matrix[i][j] + o.getMatrixData()[i][j];
			}
		}
		
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
	
	private Double[][] getMatrixData() {
		return this.matrix;
	}
	
	public int getNumCols() {
		return this.m;
	}
	
	public int getNumRows() {
		return this.n;
	}

}
