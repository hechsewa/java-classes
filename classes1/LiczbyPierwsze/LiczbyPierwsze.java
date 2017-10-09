package LiczbyPierwsze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LiczbyPierwsze {
	private static Integer num;
	
	public LiczbyPierwsze(int _num) {
		num=_num;
	}

	public static boolean isPrime(int n) {
	    for(int j=2;j<n;j++) {
	        if(n%j==0)
	            return false;
	    }
	    return true;
	}
	
	/*public static void primeNums() {
		for(int i=num; i<0; i--) {
			if(isPrime(i))
				System.out.printf("%d ", i);
		}
		  
} */
}
