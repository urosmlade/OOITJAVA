package drawing;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JPanel;


public class PnlDrawing extends JPanel implements MouseListener{
	int mx,my;
	static int obj; //integer kojim se gleda koje je dugme pritisnuto u DrawingFrm
	int x,y; // koordinare za crtanje tacke
	int width,height; // koordinate, sirina i visina za crtanje pravougaonika
	int sx,sy,ex,ey; // koordinate za crtanje linije
	int click = 1;
	boolean starttrue,endtrue; // boolean za proveru da li se kliknulo dva puta za crtanje linije
	boolean rectrue; //boolean da se proveri da li su popunjene sve vrednosti za crtanje pravougaonika, x i y prilikom klika i sirina i visina popunjavanjem dijaloga
	int radius; // koorinate i precnik za crtanje kruga
	boolean cirtrue; // boolean da se proveri da li je sve popunjeno za pravljenje kruga
	int dr,dir; // koordinate, poluprecnik i unutrasnji poluprecnik krofne 
	boolean dontrue; // boolean da se proveri da li je sve popunjeno za pravljenje krofne
	static boolean selecttb;
	static ArrayList <Shapes> shapesarr = new ArrayList <Shapes>();
	
	public PnlDrawing() {
		addMouseListener(this);
	}
	
	
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		if(selecttb == false) {
			switch (obj) {
			
			
			case 2:
				System.out.println(click);
				if(click % 2 == 0 ) {
					sx = e.getX();
					sy = e.getY();
					starttrue = true;
				}
				if (click % 2 != 0 ) {
					ex = e.getX();
					ey =e.getY();
					endtrue = true;
				}
				break;
				
			case 3:
				DrwRecDlg drwrecdlg = new DrwRecDlg();
				drwrecdlg.getTxtXCoord().setText(String.valueOf(mx));
				drwrecdlg.getTxtYCoord().setText(String.valueOf(my));
				drwrecdlg.getTxtXCoord().setEditable(false);
				drwrecdlg.getTxtYCoord().setEditable(false);
				drwrecdlg.getBtnPromenaBoje().setEnabled(false);
				drwrecdlg.getBtnPromenaBojePravougaonika().setEnabled(false);
				drwrecdlg.setVisible(true);
				if(drwrecdlg.isOk == true) {
					width = Integer.parseInt(drwrecdlg.getTxtSirina().getText());
					height = Integer.parseInt(drwrecdlg.getTxtVisina().getText());
					rectrue = true;
				}
				
				break;
				
			case 4:
				DrwCirDlg drwcirdlg = new DrwCirDlg();
				drwcirdlg.getTxtXCoord().setText(String.valueOf(mx));
				drwcirdlg.getTxtYCoord().setText(String.valueOf(my));
				drwcirdlg.getTxtXCoord().setEditable(false);
				drwcirdlg.getTxtYCoord().setEditable(false);
				drwcirdlg.setVisible(true);

				if (drwcirdlg.isOk == true) {
					radius = Integer.parseInt(drwcirdlg.getTxtRadius().getText());
					cirtrue = true;
				}
				break;
				
			case 5:
				DrwDonDlg drwdondlg = new DrwDonDlg();
				drwdondlg.getTxtXCoord().setText(String.valueOf(mx));
				drwdondlg.getTxtYCoord().setText(String.valueOf(my));
				drwdondlg.getTxtXCoord().setEditable(false);
				drwdondlg.getTxtYCoord().setEditable(false);
				drwdondlg.setVisible(true);
				if(drwdondlg.isOk == true) {
					dr = Integer.parseInt(drwdondlg.getTxtSP().getText());
					dir = Integer.parseInt(drwdondlg.getTxtUP().getText());
					dontrue = true;
				}
			
				break;
				
			case 6:
				boolean matchFound = false;
				Collections.reverse(shapesarr);
	            for (Shapes shapes : shapesarr) {
	                shapes.setSelected(false);
	                if (!matchFound) {
	                    if(shapes.contains(mx, my)) {         
	                        shapes.setSelected(true);
	                        matchFound = true;
	                    } 
	                }
	            }
				Collections.reverse(shapesarr);
				break;
			}
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if(selecttb == false) {
			switch (obj) {
			case 1:
				Point p = new Point(mx,my,false);
				shapesarr.add(p);
				System.out.println(shapesarr);
				break;

			case 2:
				if(starttrue == true && endtrue== true) {
					Line l = new Line(new Point(sx, sy), new Point(ex, ey), false);
					shapesarr.add(l);
					starttrue = false;
					endtrue = false;
					System.out.println(shapesarr);
				}
				break;
				
			case 3:
				if(rectrue == true) {
					Rectangle r = new Rectangle(new Point(mx,my),width,height,false);					
					shapesarr.add(r);
					System.out.println(shapesarr);
					rectrue = false;
				}
				break;
				
			case 4:
				if(cirtrue == true) {
					Circle c = new Circle(new Point(mx,my), radius, false);
					shapesarr.add(c);
					System.out.println(shapesarr);
					cirtrue = false;
				}
				break;
				
			case 5:
				if(dontrue == true) {
					Donut d = new Donut(new Point(mx,my), dr, dir, false);
					shapesarr.add(d);
					System.out.println(shapesarr);
					dontrue = false;
				}
				break;
			}

			}else {
				System.out.println(shapesarr);
			}

			for (Shapes shapes : shapesarr) {
				shapes.draw(g);

			}

	}
	

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		switch(obj) {
		case 2:
			click++;
		}
	}
}

