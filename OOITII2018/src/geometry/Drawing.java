package geometry;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);

	}

	public void paint(Graphics g) {
		
		Point p = new Point(150, 150, true);
		p.draw(g);
		
		Line l = new Line(new Point(600, 222), new Point(540, 22), true);
		l.draw(g);
		
		Circle c = new Circle(new Point(300, 380), 60, true);
		c.draw(g);
		
		Rectangle r = new Rectangle(new Point(287, 198), 30, 60, true);
		r.draw(g);
		
		Donut d = new Donut(new Point(500, 285), 50, 30, true);
		d.draw(g);
	}
	
}
