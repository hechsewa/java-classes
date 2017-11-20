package javaClasses7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
 
public class DB{
  private Connection conn = null;
  private Statement stmt = null;
  private ResultSet rs = null;
 
  public void connect(){
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/hechsman",
                                    "hechsman","GRNiEeQLaUTZMWEg");
 	} catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }catch(Exception e){e.printStackTrace();}	
  }
 
  public void listAll(){
    try {
      connect();
      stmt = conn.createStatement();
 
      // Wyciagamy wszystkie pola z tabeli
      rs = stmt.executeQuery("SELECT * FROM books");
 
      while(rs.next()){
        String isbn = rs.getString(1);
 	String title = rs.getString(2);
	String author = rs.getString(3);
 	String year = rs.getString(4);
        System.out.println("ISBN: "+isbn+ "TITLE: "+title+ "AUTHOR: "+author+ "YEAR: "+year);
      }
    }catch (SQLException ex){
      // handle any errors
    	System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
 
    }finally {
      // zwalniamy zasoby, które nie bêd¹ potrzebne
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException sqlEx) { } // ignore
        rs = null;
      }
 
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException sqlEx) { } // ignore
 
        stmt = null;
      }
    }
  }
  
  /*search by author*/
  public void searchByAuthor(){
	    try {
	      connect();
	      stmt = conn.createStatement();
	      
	      /*getting the string from user */
	      String text = null;
		  try{
			System.out.println("Input an author: ");
			InputStreamReader rd = new InputStreamReader(System.in);
			BufferedReader bfr = new BufferedReader(rd);
	 
			text = bfr.readLine();
		  }catch(IOException e){e.printStackTrace();}
	 
		  
	      /* finding the query */
		  PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM books WHERE author=?");
		  pstmt.setString(1, text);
	      rs = pstmt.executeQuery();
	      
	 
	      while(rs.next()){
	        String isbn = rs.getString(1);
	        String title = rs.getString(2);
	        String author = rs.getString(3);
	        String year = rs.getString(4);
	        System.out.println("ISBN: "+isbn+ "TITLE: "+title+ "AUTHOR: "+author+ "YEAR: "+year);
	      }
	    }catch (SQLException ex){
	      // handle any errors
	    	System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	 
	    }finally {
	      // zwalniamy zasoby, które nie bêd¹ potrzebne
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (SQLException sqlEx) { } // ignore
	        rs = null;
	      }
	 
	      if (stmt != null) {
	        try {
	          stmt.close();
	        } catch (SQLException sqlEx) { } // ignore
	 
	        stmt = null;
	      }
	    }
	  }
  
  /*delete by isbn number*/
  public void deleteByISBN(){
	    try {
	      connect();
	      stmt = conn.createStatement();
	      
	      /*getting the string from user */
	      String isbnNr = null;
		  try{
			System.out.println("Input a ISBN to delete: ");
			InputStreamReader rd = new InputStreamReader(System.in);
			BufferedReader bfr = new BufferedReader(rd);
	 
			isbnNr = bfr.readLine();
		  }catch(IOException e){e.printStackTrace();}
	 
		  
	      /* finding the query */
		  PreparedStatement pstmt = conn.prepareStatement("DELETE FROM books WHERE isbn=?");
		  pstmt.setString(1, isbnNr);
	      int rs = pstmt.executeUpdate();
	      System.out.println("deleted");
	      listAll();
	      
	    }catch (SQLException ex){
	      // handle any errors
	    	System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	 
	    }finally {
	      // zwalniamy zasoby, które nie bêd¹ potrzebne
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (SQLException sqlEx) { } // ignore
	        rs = null;
	      }
	 
	      if (stmt != null) {
	        try {
	          stmt.close();
	        } catch (SQLException sqlEx) { } // ignore
	 
	        stmt = null;
	      }
	    }
	  }

	public static void main(String[] args){
	DB db = new DB();
	db.deleteByISBN();
	}

}
