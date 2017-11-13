package graphicShape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Circle extends Shape{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void draw(Graphics arg0, double x, double y) {
		Graphics2D g2 = (Graphics2D) arg0;
        Ellipse2D e = new Ellipse2D.Double(x,y,200,200);
        g2.fill(e);
	}
			
}

