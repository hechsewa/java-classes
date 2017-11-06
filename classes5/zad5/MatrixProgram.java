package zad5;

//import javaIn.*;
import java.io.*;

public class MatrixProgram {
	 public static void main(String[] argv) {
		 int[][] B = {{5,6}, {7,8}};

		 try {
		Matrix A = new Matrix();
		A = A.readMatrixFile("arr.txt");
		 //Matrix A = new Matrix("./arr.txt");
		 
		 /*addition*/
		 int[][] AddResult = A.add(B);
		 System.out.println("Added: ");
		 for (int i = 0; i < B.length; i++) {
	            for (int j = 0; j < B.length; j++)
	                System.out.print(AddResult[i][j] + " ");
	            System.out.println(); 
		 }
		 
		 /*substraction*/
		 int[][] SubResult = A.sub(B);
		 System.out.println("Substracted: ");
		 for (int i = 0; i < B.length; i++) {
	            for (int j = 0; j < B.length; j++)
	                System.out.print(SubResult[i][j] + " ");
	            System.out.println();
		 }
		 
		 /*multiplication*/
		 int[][] MulResult = A.mul(B);
		 System.out.println("Multiplicated: ");
		 for (int i = 0; i < B.length; i++) {
	            for (int j = 0; j < B[0].length; j++)
	                System.out.print(MulResult[i][j] + " ");
	            System.out.println();
		 }
	}catch(MatrixDimensionsException e){
		System.out.println(e);	
	} catch(FileNotFoundException e) {
		System.out.println(e);
	} 
	
}
}
