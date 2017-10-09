package matrix;

import javaIn.*;

public class MatrixProgram {
	 public static void main(String[] argv) {
		 int[][] C = JIn.getMatrix();
		 int[][] B = {{5,6}, {7,8}};
		 Matrix A = new Matrix(C);
		 
		 /*addition*/
		 int[][] AddResult = A.add(B);
		 System.out.println("Added: ");
		 for (int i = 0; i < C.length; i++) {
	            for (int j = 0; j < C.length; j++)
	                System.out.print(AddResult[i][j] + " ");
	            System.out.println();
		 }
		 
		 /*substraction*/
		 int[][] SubResult = A.sub(B);
		 System.out.println("Substracted: ");
		 for (int i = 0; i < C.length; i++) {
	            for (int j = 0; j < C.length; j++)
	                System.out.print(SubResult[i][j] + " ");
	            System.out.println();
		 }
		 
		 /*multiplication*/
		 int[][] MulResult = A.mul(B);
		 System.out.println("Multiplicated: ");
		 for (int i = 0; i < C.length; i++) {
	            for (int j = 0; j < B[0].length; j++)
	                System.out.print(MulResult[i][j] + " ");
	            System.out.println();
		 }
		 
	 }
}
