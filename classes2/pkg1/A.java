package pkg1;

/* ćwiczenie 1: 
Pola o dostępie pakietowym są widziane tylko w klasach pochodnych należących do tego samego pakietu, ale nie w innych pakietach.
*/

public class A{
	int number;
	protected int number2;
	protected String name;
	
	public A(int number_, int number2_, String name_){ 
		number = number_;
		number2 = number2_;
		name = name_;
	}
	
	public void callDecrement(){
		decrement();
		System.out.printf("%d", number);
		System.out.println();
	}
	public void callChangeName(){
		changeName();
	}
	public void callIncrement(){
		increment();
	}
	private void increment(){
		number += 1;
	}
	protected void decrement(){
		number -= 1;
	}
	void changeName(){
		name = "classA";
	}

}
