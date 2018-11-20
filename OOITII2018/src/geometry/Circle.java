package geometry;

import java.awt.Graphics;

public class Circle extends Shape {

	private Point center;
	private int radius;
	
	public Circle() {
		
	} 
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		
	}
	
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= radius;
	}
	
	public boolean contains(Point p) {
		if (p.distance(getCenter().getX(), getCenter().getY()) <= radius ) {
			return true;
		} else {	
			return false;
		}
	}
	
	public boolean equals (Object obj) {
		if (obj instanceof Circle) {
			Circle c = (Circle) obj;
			if (this.center.equals(c.getCenter()) &&
					this.radius == c.getRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "Center=" + center + ", radius=" + radius; 
	}

	
	
	
}
