package drawing;
import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shapes {
	private Point center;
	private int radius;
	PnlDrawing pnl = new PnlDrawing();
	
		
	public Circle (Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle (Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= radius;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBoja());
		g.drawOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
			if (isSelected()) {
				g.setColor(Color.BLACK);
				g.drawRect(this.getCenter().getX() + getRadius() - 3, this.getCenter().getY()-3, 6, 6);
				g.drawRect(this.getCenter().getX() - getRadius() - 3, this.getCenter().getY()-3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + getRadius() -3, 6, 6);
				g.drawRect(this.getCenter().getX()  - 3, this.getCenter().getY() - getRadius() -3, 6, 6);
				g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
		}
	}
	
	@Override
	public void boji(Graphics g) {
		g.setColor(getBojafill());
		g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
			
	}
	
	@Override
	public void dijalog() {
		DrwCirDlg drwcirdlg = new DrwCirDlg();		
		for (Shapes shapes : PnlDrawing.shapesarr) {
			if(shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				drwcirdlg.getTxtXCoord().setText(split[2]);
				drwcirdlg.getTxtYCoord().setText(split[4]);
				drwcirdlg.getTxtRadius().setText(split[7]);
				
			}
		}
		drwcirdlg.setVisible(true);
	}

	@Override
	public void move(int byX, int byY) {
		center.move(byX, byY);
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
		return "Center= " + center + ", radius= " + radius + " " + isSelected(); 
	}

	
	

}
