package pesel;

public class PESEL {
	
	public static boolean check(String _pesel) {
		if(_pesel.length()!= 11) return false;
		else {
		int control = 9*Character.getNumericValue(_pesel.charAt(0)) + 
				7*Character.getNumericValue(_pesel.charAt(1)) + 
				3*Character.getNumericValue(_pesel.charAt(2)) +
				1*Character.getNumericValue(_pesel.charAt(3)) + 
				9*Character.getNumericValue(_pesel.charAt(4)) + 
				7*Character.getNumericValue(_pesel.charAt(5)) + 
				3*Character.getNumericValue(_pesel.charAt(6)) + 
				1*Character.getNumericValue(_pesel.charAt(7)) + 
				9*Character.getNumericValue(_pesel.charAt(8)) + 
				7*Character.getNumericValue(_pesel.charAt(9));
		
		control = control%10;
		
		int controlNum = Character.getNumericValue(_pesel.charAt(10));
		if(control == controlNum) {
			return true;
		}
		else return false;
	}
	}
}
