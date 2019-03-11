package drawing;
import java.awt.Graphics;

public class Rectangle extends Shapes {
	private Point ulp;
	private int width;
	private int height;
	PnlDrawing pnl = new PnlDrawing();
	
	public Rectangle(Point ulp, int width, int height) {
		this.ulp = ulp;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle (Point ulp, int width, int height, boolean selected) {
		this(ulp,width,height);
		setSelected(selected);
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}
	
	@Override
	public boolean contains(int x, int y) {
		if (this.getUlp().getX() <= x
				&& x <= (this.getUlp().getX() + width)
				&& this.getUlp().getY() < y
				&& y <= (this.getUlp().getY() + height)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(this.getUlp().getX(), this.getUlp().getY(), this.getWidth(), this.getHeight());
		if(isSelected() == true) {
			g.drawRect(this.getUlp().getX() - 3, this.getUlp().getY() - 3, 6, 6);
			g.drawRect(this.getUlp().getX() - 3 + width, this.getUlp().getY() - 3, 6, 6);
			g.drawRect(this.getUlp().getX() - 3, this.getUlp().getY() - 3 + height, 6, 6);
			g.drawRect(this.getUlp().getX() - 3 + width, this.getUlp().getY() - 3 + height, 6, 6);
		}
	}
	
	@Override
	public void boji(Graphics g) {
		g.setColor(getBojafill());
		g.fillRect(this.getUlp().getX()+1, this.getUlp().getY()+1, this.getWidth()-1, this.getHeight()-1);		
	}
	
	@Override
	public void dijalog() {
		DrwRecDlg drwrecdlg = new DrwRecDlg();
		for(Shapes shapes : PnlDrawing.shapesarr) {
			if(shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				drwrecdlg.getTxtXCoord().setText(split[2]);
				drwrecdlg.getTxtYCoord().setText(split[6]);
				drwrecdlg.getTxtSirina().setText(split[9]);
				drwrecdlg.getTxtVisina().setText(split[12]);
			}
		}
		drwrecdlg.setVisible(true);
	}

	@Override
	public void move(int byX, int byY) {
		ulp.move(byX, byY);		
	}

	public int area() {
		return width * height;
	}
	
	public Point getUlp() {
		return ulp;
	}
	public void setUlp(Point ulp) {
		this.ulp = ulp;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String toString() {
		return "X koordinata: " + getUlp().getX() + " , Y koordinata: " + getUlp().getY() + " , sirina: " + getWidth() + " , visina: " + getHeight() + " " + isSelected(); 
	}

	
}