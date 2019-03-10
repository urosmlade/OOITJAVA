package drawing;

import java.awt.Graphics;

public abstract class Shapes implements Comparable, Moveable  {
	
	private boolean selected;
	
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
	
	
}
