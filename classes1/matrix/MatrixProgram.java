package matrix;

import javaIn.*;

public class MatrixProgram {
	 public static void main(String[] argv) {
		 int[][] A = JIn.getMatrix();
		 int[][] B = {{5,6}, {7,8}};
		 new Matrix(A);
		 
		 /*addition*/
		 int[][] AddResult = Matrix.add(B);
		 System.out.println("Added: ");
		 for (int i = 0; i < A.length; i++) {
	            for (int j = 0; j < A.length; j++)
	                System.out.print(AddResult[i][j] + " ");
	            System.out.println();
		 }
		 
		 /*substraction*/
		 int[][] SubResult = Matrix.sub(B);
		 System.out.println("Substracted: ");
		 for (int i = 0; i < A.length; i++) {
	            for (int j = 0; j < A.length; j++)
	                System.out.print(SubResult[i][j] + " ");
	            System.out.println();
		 }
		 
		 /*multiplication*/
		 int[][] MulResult = Matrix.mul(B);
		 System.out.println("Multiplicated: ");
		 for (int i = 0; i < A.length; i++) {
	            for (int j = 0; j < B[0].length; j++)
	                System.out.print(MulResult[i][j] + " ");
	            System.out.println();
		 }
		 
	 }
}
