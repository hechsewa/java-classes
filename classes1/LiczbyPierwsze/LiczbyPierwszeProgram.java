package LiczbyPierwsze;

import javaIn.*;

public class LiczbyPierwszeProgram {
	public static void main(String args[]) {
		
		System.out.print("Enter your number: ");
		int num = JIn.getInteger();
		
		System.out.println("Prime Numbers: ");
		for(int i=num; i>0; i--) {
			if(LiczbyPierwsze.isPrime(i))
				System.out.printf("%d ", i);

	}
}
}
