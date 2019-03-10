package drawing;

import java.awt.Graphics;

public class Donut extends Circle{
	private int innerRadius;
	private boolean selected;
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius= innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		this.selected = selected;
	}
	
	@Override
	public boolean contains(int x, int y) {
		double dFromDistance = this.getCenter().distance(x, y);
		return super.contains(x, y) &&
				dFromDistance > innerRadius;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getBoja());
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return super.toString() + ", inner radius = " + innerRadius + " " + isSelected();
	}

	@Override
	public void dijalog() {
		DrwDonDlg drwdondlg = new DrwDonDlg();
		for (Shapes shapes: pnl.shapesarr) {
			if(shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				drwdondlg.getTxtXCoord().setText(split[2]);
				drwdondlg.getTxtYCoord().setText(split[4]);
				drwdondlg.getTxtSP().setText(split[7]);
				drwdondlg.getTxtUP().setText(split[12]);
			}
		}
		drwdondlg.setVisible(true);
	}
	
	
	
	
	
}
