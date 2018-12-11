package geometry;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

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
		// c.draw(g);
		
		Rectangle r = new Rectangle(new Point(287, 198), 30, 60, true);
		// r.draw(g);
		
		Donut d = new Donut(new Point(500, 285), 50, 30, true);
		// d.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(p);
		shapes.add(l);
		shapes.add(c);
		shapes.add(d);
		shapes.add(r);
		
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext())
			System.out.println(it.next().isSelected());
		
		// iscrtati treci element liste
		shapes.get(2).draw(g);
		
		// iscrtati poslednji element liste
		shapes.get(shapes.size()-1).draw(g);
		
		// iscrtati element sa indeksom 3
		shapes.get(3).draw(g);
		
		// dodati liniju u listu tako da ona bude cetvrti element liste
		shapes.add(3, new Line(new Point(10, 10), new Point(20, 20)));
		
		// ukloniti drugi element liste
		shapes.remove(1);
		
		System.out.println(shapes.get(1).toString());
		
	}
	
}
