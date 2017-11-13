package graphicShape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.math.*;

public class Triangle extends Shape{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Graphics2D g;
	
	public void draw(Graphics arg0, double x, double y) {
		g = (Graphics2D) arg0;
		
		int xPoints[] = {(int)x,(int)x+100,(int)x+200};
		int sq = (int)Math.sqrt(3);
		int yPoints[] = {(int)y,100*sq+(int)y,(int)y};
		int nPoints = 3;
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
}