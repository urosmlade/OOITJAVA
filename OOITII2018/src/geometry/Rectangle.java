package geometry;

public class Rectangle {

	private Point upperLeftPoint;
	private int height;
	private int width;
	private boolean selected;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		this.selected = selected;
	}
	
	public boolean contains(int x, int y) {
		if (this.getUpperLeftPoint().getX() <= x
				&& x <= (this.getUpperLeftPoint().getX() + width)
				&& this.getUpperLeftPoint().getY() <= y
				&& y <= (this.getUpperLeftPoint().getY() + height)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Point p) {
		if (this.getUpperLeftPoint().getX() <= p.getX()
				&& p.getX() <= (this.getUpperLeftPoint().getX() + width)
				&& this.getUpperLeftPoint().getY() < p.getY()
				&& p.getY() <= (this.getUpperLeftPoint().getY() + height)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean equals (Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle) obj;
			if (this.upperLeftPoint.equals(r.getUpperLeftPoint()) &&
					this.height == r.getHeight() &&
					this.width == r.getWidth()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public int area() {
		return width * height;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return "Upper left point=" + upperLeftPoint + ", height=" + height + ", width=" + width;
	}
	
	
}
