package javaIn;

import java.io.*;
import java.util.Scanner;

public class JIn {
    public static String getString() {
	  String text = null;
	  try{
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(rd);
 
		text = bfr.readLine();
	  }catch(IOException e){e.printStackTrace();}
      return text;	  
    }
    
    public static Integer getInteger() {
  	  Integer number = null;
  	  try{
  		InputStreamReader rd = new InputStreamReader(System.in);
  		BufferedReader bfr = new BufferedReader(rd);
   
  		number = Integer.parseInt(bfr.readLine());
  	  }catch(IOException e){e.printStackTrace();}
        return number;	  
      }
    
    public static int[][] getMatrix(){
    	int row =0;
    	int col =0;
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println("enter a number of rows of the matrix: ");
    	row = in.nextInt();
    	System.out.println("enter a number of columns of the matrix: ");
    	col = in.nextInt();
    			
            int[][] data = new int[row][col]; 
            for(int i = 0; i< data.length; i++){ 
                  for(int j = 0 ;j< data[0].length; j++){ 
                       System.out.println("enter the elements of the Matrix: "); 
                      data[i][j] = in.nextInt(); 
                   } System.out.println(); 
              } 
             return data; 
    }
}