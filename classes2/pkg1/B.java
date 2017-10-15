package pkg1;


public class B extends A {

	public B(int number_, int number2_, String name_){
	super(number_, number2_, name_);
	}
	
	protected void decrement(){
		number -=2;
	}
	void changeName(){
		name = "classB";
	}
	private void increment(){
		number += 2;
	}

	public static void main(String [] args){
		A obj = new A(5,4,"hi");
		obj.callDecrement();
		B objB = new B(2,1,"objb");
		objB.changeName();
		System.out.println(objB.number);
		System.out.println(objB.name);
		
	}

}