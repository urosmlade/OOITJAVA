package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.awt.Color;

public class DrawingFrm extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnl;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrm frame = new DrawingFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DrawingFrm() {
		setTitle("II48/2015 Uros Mladenovic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnl = new PnlDrawing();
		pnl.setBackground(Color.WHITE);
		pnl.setBorder(null);
		contentPane.add(pnl, BorderLayout.CENTER);
		GroupLayout gl_pnldrawing = new GroupLayout(pnl);
		gl_pnldrawing.setHorizontalGroup(
			gl_pnldrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 577, Short.MAX_VALUE)
		);
		gl_pnldrawing.setVerticalGroup(
			gl_pnldrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 357, Short.MAX_VALUE)
		);
		pnl.setLayout(gl_pnldrawing);
		
		JPanel pnlLevo = new JPanel();
		pnlLevo.setBackground(Color.LIGHT_GRAY);
		contentPane.add(pnlLevo, BorderLayout.WEST);
		
		
		JButton btnPoint = new JButton("Tacka");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 1;
				for (Shapes shapes : PnlDrawing.shapesarr) {
					shapes.setSelected(false);
				}
			
			}
		});
		
		JButton btnLine = new JButton("Linija");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 2;
				for (Shapes shapes : PnlDrawing.shapesarr) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Pravougaonik");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 3;
				for (Shapes shapes : PnlDrawing.shapesarr) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Krug");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 4;
				for (Shapes shapes : PnlDrawing.shapesarr) {
					shapes.setSelected(false);
				}
			}
		});
		
		JButton btnDonut = new JButton("Krug sa rupom");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PnlDrawing.obj = 5;
				for (Shapes shapes : PnlDrawing.shapesarr) {
					shapes.setSelected(false);
				}
			}
		});	
		
		
		JButton btnSelect = new JButton("Selektovanje");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesarr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za selektovanje!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {
					PnlDrawing.obj = 6;
				}
			}
		});
		
		
		JButton btnModify = new JButton("Modifikacija");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(PnlDrawing.shapesarr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za modifikacuju!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				for (Shapes shapes : PnlDrawing.shapesarr) {
					if(shapes.isSelected()) {
							shapes.dijalog();						
						return;
					}

				}
				JOptionPane.showMessageDialog(null, "Pre modifikovanja morate selektovati objekat!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		JButton btnDelete = new JButton("Brisanje");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesarr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema objekata za brisanje!", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				for (Shapes shapes : PnlDrawing.shapesarr) {
					if(shapes.isSelected()) {
						int odgovor = JOptionPane.showConfirmDialog(null, "Da li zelite da izbrisete selektovani objekat?","Upozorenje", JOptionPane.YES_NO_OPTION);
						if(odgovor == 0) {
							PnlDrawing.shapesarr.remove(shapes);	
						}
						return;
					}

				}
				JOptionPane.showMessageDialog(null, "Pre brisanja morate selektovati objekat!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
	
		GroupLayout gl_pnlLevo = new GroupLayout(pnlLevo);
		gl_pnlLevo.setHorizontalGroup(
			gl_pnlLevo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLevo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlLevo.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRectangle, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnPoint, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnLine, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnCircle, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnDonut, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlLevo.setVerticalGroup(
			gl_pnlLevo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLevo.createSequentialGroup()
					.addGap(34)
					.addComponent(btnPoint)
					.addGap(18)
					.addComponent(btnLine)
					.addGap(18)
					.addComponent(btnRectangle)
					.addGap(18)
					.addComponent(btnCircle)
					.addGap(18)
					.addComponent(btnDonut)
					.addGap(18)
					.addComponent(btnSelect)
					.addGap(18)
					.addComponent(btnModify)
					.addGap(18)
					.addComponent(btnDelete)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		pnlLevo.setLayout(gl_pnlLevo);
	}
}