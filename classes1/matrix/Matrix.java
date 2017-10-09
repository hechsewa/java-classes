package matrix;
import java.io.*;

public class Matrix {
	private int[][] matrix;
	
	public Matrix(int[][] _matrix) { //konstruktor
		matrix = _matrix;
	}
	
	/*addiction*/
	public int[][] add(int[][] arr){
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
			System.out.println("wrong sizes");
			return matrix;
		}
	}
	
	/*substraction*/
	public int[][] sub(int[][] arr){
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
			System.out.println("wrong sizes");
			return matrix;
		}
	}
	
	/*multiplication*/
	public int[][] mul(int[][] arr){
		//check if columns of A is equal to rows of B
		if(matrix[0].length != arr.length || matrix.length != arr[0].length) {
			System.out.println("wrong sizes");
			return matrix; }
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
