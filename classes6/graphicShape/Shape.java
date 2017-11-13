package graphicShape;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.*;

public abstract class Shape extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract void draw(Graphics arg0, double x, double y);
	
}
