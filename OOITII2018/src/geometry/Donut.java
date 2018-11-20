package geometry;

import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
	}
	
	public boolean contains(int x, int y) {
		double dFromDistance = this.getCenter().distance(x, y);
		return super.contains(x, y) &&
				dFromDistance > innerRadius;
	}
	
	public boolean contains(Point p) {
		double dFromDistance = this.getCenter().distance(p.getX(), p.getY());
		return super.contains(p.getX(), p.getY()) &&
				dFromDistance > innerRadius;
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) &&
					this.getRadius() == d.getRadius() &&
					innerRadius == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + ", inner radius = " + innerRadius;
	}
	

	
	public int getInnerRadius() {
		return this.innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
}
