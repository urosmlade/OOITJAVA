package drawing;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrwTest extends JPanel {
	
public static void main(String[] args) {
		
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		DrwTest drawing = new DrwTest();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);

	}


	public void paint(Graphics g) {
	
		
		Line l = new Line(new Point (50,50), new Point (200,200), true);
		l.draw(g);
	}
	

	

}
