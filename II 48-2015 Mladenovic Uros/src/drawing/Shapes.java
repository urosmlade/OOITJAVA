package drawing;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shapes implements Comparable, Moveable  {
	
	private boolean selected;
	private Color boja = Color.BLACK;
	
	DrawingFrm frm = new DrawingFrm();
	
	public Shapes() {
		
	}
	
	
	public Shapes (boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	
	public boolean isSelected () {
		return selected;
	}
	
	public void setSelected (boolean selected) {
		this.selected = selected;
	}
	
	public abstract void dijalog();

	public void setBoja(Color boja) {
		this.boja = boja;
	}

	public Color getBoja() {
		return boja;
	}



	
	
	
	
}
