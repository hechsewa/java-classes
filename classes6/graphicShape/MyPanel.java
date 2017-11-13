package graphicShape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseMotionListener, MouseListener{
	public static LinkedList<Shape> shapes = new LinkedList<Shape>();
	public double x=0, y=0;
	public static JPanel mousepanel = new JPanel();
	boolean mouseDragged = true;
	
	public static void menu() {
		System.out.println("square (1), triangle (2), circle (3), quit (4)");
		Scanner in = new Scanner(System.in);
		int inShape = in.nextInt();
		if(inShape == 1){
			Rect s = new Rect();
			shapes.add(s);
			System.out.println("Added!");
			menu();
		}
		else if (inShape == 2){
			Triangle t = new Triangle();
			shapes.add(t);
			System.out.println("Added!");
			menu();
		}
		else if (inShape == 3){
			Circle c = new Circle();
			shapes.add(c);
			System.out.println("Added!");
			menu();
		}
		else if(inShape == 4) {
			return;
		}
		else System.out.println("Wrong input!");
	}
	
	/**mouse movement**/
	@Override
	public void mouseDragged(MouseEvent arg0) {
		x = arg0.getX()-50;
		y = arg0.getY()-50;
		mouseDragged = false;
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouseDragged = false;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		x = arg0.getX()-50;
		y = arg0.getY()-50;
		mouseDragged = false;
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
	
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(!mouseDragged) {
			x = arg0.getX()-50;
			y = arg0.getY()-50;
			mouseDragged = true;
		}
		
	}
	/** end of mouse movement **/
	
	@Override
    public void paint(Graphics arg0) {
		Graphics2D g = (Graphics2D) arg0;
        if(mouseDragged) {
        	for(Shape i : shapes) {
        		i.draw(g, x, y);
        	}
        	mouseDragged = false;
        }
        	
        repaint();
    }
	
	
	public static void main(String [] argv){
		menu();
		JFrame f = new JFrame();
	    f.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    MyPanel panel = new MyPanel();
	    f.setContentPane(panel);
	    f.addMouseListener(panel);
		f.addMouseMotionListener(panel);
	    f.setSize(1000,375);
	    f.setVisible(true);
	  }

}

