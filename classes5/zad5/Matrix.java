package zad5;
import java.io.*;
import java.util.Scanner;

public class Matrix {
	private int[][] matrix;
	
	public Matrix() { 
	}
	
	public void setMatrix(int[][] matrix_) {
		matrix = matrix_;
	}
	
	/******************************************************************/
	public Matrix readMatrixFile(String filepath_) throws FileNotFoundException{
		File file = new File(filepath_);
		Scanner input = new Scanner(file);
		if(file != null){	
			//wczytaj wymiary macierzy
			int rows = 0; int cols = 0;
			if(input.hasNextLine()) {
				rows++;
				Scanner colReader = new Scanner(input.nextLine());
				while(colReader.hasNextInt()) {
					cols++;
				}
			}
			//nowa macierz o wczytanych wymiarach
			int[][] mat = new int[rows][cols];
			input.close();
			
			//wczytaj macierz
			Scanner matInput = new Scanner(file);
			for (int i=0; i<rows; i++) {
				for(int j=0; j<cols; j++) {
					if(matInput.hasNextInt()) {
						mat[i][j] = matInput.nextInt();
					}
				}
			}
			matInput.close();
			Matrix newMat = new Matrix();
			newMat.setMatrix(mat);
			return newMat;
			
		}else {
			throw new FileNotFoundException("not found");
		}
	}
	
	
	/*addiction*/
	public int[][] add(int[][] arr) throws MatrixDimensionsException{
		//proceed if sizes are the same
		if(matrix.length==arr.length && matrix[0].length==arr[0].length) {
		
		//create a new matrix to store the added val
		int[][] added = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				added[i][j] = matrix[i][j]+arr[i][j];
			}
		}
		return added;
	}
		else {
			throw new MatrixDimensionsException("Wrong sizes to add");
		}
	}

	
	/*substraction*/
	public int[][] sub(int[][] arr) throws MatrixDimensionsException{
		//proceed if sizes are the same
		if(matrix.length==arr.length && matrix[0].length==arr[0].length) {
		
		//create a new matrix to store the val
		int[][] sub = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				sub[i][j] = matrix[i][j]- arr[i][j];
			}
		}
		return sub;
	}
		else {
			throw new MatrixDimensionsException("Wrong sizes to substract");
		}
	}
	
	/*multiplication*/
	public int[][] mul(int[][] arr) throws MatrixDimensionsException{
		//check if columns of A is equal to rows of B
		if(matrix[0].length != arr.length || matrix.length != arr[0].length) {
			throw new MatrixDimensionsException("Wrong sizes to multiplicate");
			 }
		else {
		//create a new matrix to store the val
		int[][] mul = new int[matrix.length][arr[0].length];
		
		//multiplicate matrices
		for(int a=0; a<matrix.length; a++) { //rows of A
			for(int b=0; b<arr[0].length; b++) { //columns of B
				for(int k=0; k<matrix[0].length; k++) { //columns of A
				mul[a][b] = mul[a][b] + (matrix[a][k] * arr[k][b]);
			}
		}}
		return mul;
	}}

	
	
}
