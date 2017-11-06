package shape;

import java.util.Random;
import java.util.LinkedList;
import javaIn.JIn;
import java.util.Scanner;
import java.util.Iterator;

public abstract class Shape{
	  public static LinkedList<Shape> shapes = new LinkedList<Shape>();
	  public abstract void draw(); //rysuje w konsoli dany ksztalt

	 public static void menu(){
	        System.out.println("Menu: ");
		System.out.println("1. Add a shape");
		System.out.println("2. Show all shapes of the list");
		System.out.println("3. Quit");
		
		int choice = 0;
		Scanner menu = new Scanner(System.in);
		choice = menu.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("square, triangle or circle?");
			String inShape = JIn.getString();
			if(inShape.equals("square")){
				Kwadrat s = new Kwadrat();
				shapes.add(s);
				System.out.println("Added!");
			}
			else if (inShape.equals("triangle")){
				Trojkat t = new Trojkat();
				shapes.add(t);
				System.out.println("Added!");
			}
			else if (inShape.equals("circle")){
				Kolo c = new Kolo();
				shapes.add(c);
				System.out.println("Added!");
			}
			else System.out.println("Wrong input!");

			System.out.println("What next?");
			menu();
			break;
		case 2:
			showList();
			System.out.println("What next?");
			menu();
			break;
		case 3: 
			return;
		default: 
			System.out.println("Wrong input!");
			System.out.println("What next?");
			menu();
			break;
	} }


	public static void showList() {
		if(shapes.isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		else {
		for(Shape s:shapes){  
		    s.draw();  
		    }  
		}
	 }
	  
	  public static void main(String []argv) {
 		menu(); 
	  }
}
