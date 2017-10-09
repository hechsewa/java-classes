package pesel;

import javaIn.*;

public class PESELProgram {
	public static void main(String[] argv){
		
	System.out.print("Enter a pesel: ");
	String pesel_ = JIn.getString();
	
	if(PESEL.check(pesel_)) {
		System.out.println("OK");
	}
	else System.out.println("Incorrect");
}
}
