package geometry;

import java.lang.*;
/*  Napisz klas� Punkd3D, dziedzicz�c� po Punkt2D i przechowuj�c� dodatkowo pole wsp�rz�dnej z.
 *  Klasa powinna posiada� konstruktor parametrowy podobnie jak klasa Punkt2D
 *  Metody kalsy do zaimplementowania:
 *	setZ, getZ
 *	distance pobieraj�ca jako parametr Punkt3D i zwracaj�ca odleg�o�� do niego (warto�� double)
 * */

public class Punkt3D extends Punkt2D{
	private double z;
	
	public Punkt3D(double x_, double y_, double z_) {
		super(x_,y_);
		z = z_;
	}

	public void SetZ(double z_) {
		z = z_;
	}
	
	public double GetZ() {
		return z;
	}
	
	public double distance(Punkt3D pkt) {
		double pX = pkt.GetX();
		double pY = pkt.GetY();
		double pZ = pkt.GetZ();
		
		double dist = Math.sqrt(((x-pX)*(x-pX)) +
								((y-pY)*(y-pY)) + 
								((z-pZ)*(z-pZ)));
		return dist;
	}
	
	public static void main(String [] args){
		Punkt3D pkt1 = new Punkt3D(1,1,1);
		Punkt3D pkt2 = new Punkt3D(1,2,3);
		
		System.out.println("The distance between pkt1 and pkt2: " +
							pkt1.distance(pkt2));
	}
	
}
