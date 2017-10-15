package geometry;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*  Napisz klasê Test, 
 * zawieraj¹c¹ metodê main, oraz pole LinkedList<Punkt3D> punkty. 
 * Po uruchomieniu programu powinno pojawiæ siê proste
 *  tekstowe menu umo¿liwiaj¹ce wykonywanie wymienionych w nim operacji:
1. Wczytaj punkt 3D
2. Wyœwietl wszystkie punkty
3. Oblicz odleg³oœæ
4. Zakoñcz
? 
*/

public class Test{
	LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();
	
	public Test() {
	}
	
	public void input3D(Punkt3D pkt) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of X: ");
		pkt.SetX(in.nextInt());
		System.out.println("Enter the value of Y: ");
		pkt.SetY(in.nextInt());
		System.out.println("Enter the value of Z: ");
		pkt.SetZ(in.nextInt());

	}
	
	public void showList() {
		if(punkty.isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		else {
		for(Punkt3D pkt:punkty){  
		    System.out.println("(" + pkt.GetX() +"," +
		    					pkt.GetY() + "," +
		    					pkt.GetZ() + ")");  
		    }  
		}
	}
	
	public void calculateDist() {
		Punkt3D pkt1 = new Punkt3D(0,0,0);
		Punkt3D pkt2 = new Punkt3D(0,0,0);
		
		System.out.println("First point: ");
		input3D(pkt1);
		System.out.println("Second point: ");
		input3D(pkt2);
		
		System.out.println("The distance between the points: "
							+pkt1.distance(pkt2));
		
	}
	
	public static void main(String [] args){
		Test tester = new Test();
		
		/*Punkt3D pkta = new Punkt3D(1,1,1);
		Punkt3D pktb = new Punkt3D(2,2,3);
		tester.punkty.add(pkta);
		tester.punkty.add(pktb);*/
		
		System.out.println("Menu: ");
		System.out.println("1. Input 3D point");
		System.out.println("2. Show all points of the list");
		System.out.println("3. Calculate distance between two points");
		System.out.println("4. Quit");
		
		int choice = 0;
		Scanner menu = new Scanner(System.in);
		choice = menu.nextInt();
		
		switch(choice) {
		case 1:
			Punkt3D pkt = new Punkt3D(0,0,0);
			tester.input3D(pkt);
			tester.punkty.add(pkt);
			System.out.println("Saved!");
			break;
		case 2:
			tester.showList();
			break;
		case 3: 
			tester.calculateDist();
			break;
		case 4: 
			return;
		default: 
			System.out.println("Wrong input!");
			break;
		}
	}
	
	
}
