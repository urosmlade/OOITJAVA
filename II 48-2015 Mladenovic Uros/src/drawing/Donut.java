package drawing;
import java.awt.Graphics;

public class Donut extends Circle{
	private int innerRadius;
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius= innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);	
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
	
	@Override
	public void boji(Graphics g) {
		// TODO Auto-generated method stub
		//super.boji(g);
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
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", inner radius = " + innerRadius + " " + isSelected();
	}

	
}