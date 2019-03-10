package drawing;

import java.awt.Graphics;

public class Line extends Shapes {
	
	private Point start;
	private Point end;
	PnlDrawing pnl = new PnlDrawing();
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Line (Point start, Point end, boolean selected) {
		this(start, end);
		setSelected(selected);
	}
	

	
	
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}
	
	
	public Point middleOfLine() {
		int middleByX = (this.getStart().getX() + this.getEnd().getX()) / 2;
		int middleByY = (this.getStart().getY() + this.getEnd().getY()) / 2;
		Point p = new Point(middleByX, middleByY);
		return p;
	}
	
	

	
	public double length() {
		return start.distance(end.getX(), end.getY());
	}
	
	
	@Override
	public boolean contains(int x, int y) {
		if ((start.distance(x, y) + end.distance(x, y)) - length() <= 0.05 ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
		if(isSelected() == true) {
			g.drawRect(this.getStart().getX()-3, this.getStart().getY()-3, 6, 6);
			g.drawRect(this.getEnd().getX()-3, this.getEnd().getY()-3, 6, 6);
			g.drawRect(this.middleOfLine().getX()-3, this.middleOfLine().getY()-3, 6, 6);
		}
	}
	
	public String toString() {
		return "(" + this.getStart() + ", " + this.getEnd() + " )"  + " " + isSelected();
	}

	@Override
	public void dijalog() {
		DrwLinDlg drwlindlg = new DrwLinDlg();
		for (Shapes shapes : PnlDrawing.shapesarr ) {
			if(shapes.isSelected()) {
				String[] split = shapes.toString().split(" ");
				drwlindlg.getTxtXStart().setText(split[1]);
				drwlindlg.getTxtYStart().setText(split[3]);
				drwlindlg.getTxtXEnd().setText(split[6]);
				drwlindlg.getTxtYEnd().setText(split[8]);
			}
		}
		drwlindlg.setVisible(true);

	}

	@Override
	public void move(int sx, int sy) {
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
