package pkg2;
import pkg1.*;

public class C extends B {

	public C(int number_, int number2_, String name_){
	super(number_, number2_, name_);
	}
	
	void changeName(){
		name = "classC";
	}

	public static void main(String [] args){
		A obj = new A(5,4,"hi");
		obj.callDecrement();
		B objB = new B(2,1,"objb");
		
	}

}