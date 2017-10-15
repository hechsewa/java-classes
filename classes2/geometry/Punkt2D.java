package geometry;

import java.lang.*;
import java.text.DecimalFormat;

public class Punkt2D {
	double x;
	double y;
	
	public Punkt2D(double x_, double y_) {
		x = x_;
		y = y_;
	}
	
	public void SetX(double x_) {
		x = x_;
	}
	
	public void SetY(double y_) {
		y = y_;
	}
	
	public double GetX() {
		return x;
	}
	
	public double GetY() {
		return y;
	}
	
	private double distance(Punkt2D pkt) {
		double pX = pkt.GetX();
		double pY = pkt.GetY();
		
		double dist = Math.sqrt(((x - pX)*(x-pX)) + ((y-pY)*(y-pY)));
		return dist;
	}
	
	public static void main(String [] args){
		Punkt2D pkt = new Punkt2D(4,4);
		Punkt2D pkt2 = new Punkt2D(5,3);
		pkt2.SetX(2);
		pkt2.SetY(4);
		DecimalFormat df = new DecimalFormat("###.#");
		System.out.println("Pkt1 = (" + df.format(pkt.GetX()) + ","
				+ df.format(pkt.GetY()) + ")");
		System.out.println("Pkt2 = (" + df.format(pkt2.GetX()) + ","
							+ df.format(pkt2.GetY()) + ")");
		System.out.println();
		
		System.out.println("Distance between pkt1 and pkt2: " + pkt.distance(pkt2));
		
	}
}
