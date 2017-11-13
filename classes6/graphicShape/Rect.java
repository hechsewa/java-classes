package graphicShape;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rect extends Shape{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void draw(Graphics arg0, double x, double y) {
		Graphics2D g = (Graphics2D) arg0;
		g.fillRect((int)x, (int)y, 200, 200);
	}
}
