package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class StackFrm extends JFrame {

	private JPanel contentPane;
	DefaultListModel dlm = new DefaultListModel();
	Stack stack = new Stack();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrm frame = new StackFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel PnlCentar = new JPanel();
		contentPane.add(PnlCentar, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_PnlCentar = new GroupLayout(PnlCentar);
		gl_PnlCentar.setHorizontalGroup(
			gl_PnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_PnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_PnlCentar.setVerticalGroup(
			gl_PnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList lstRect = new JList();
		scrollPane.setViewportView(lstRect);
		PnlCentar.setLayout(gl_PnlCentar);
		
		JPanel PnlDole = new JPanel();
		contentPane.add(PnlDole, BorderLayout.SOUTH);
		
		lstRect.setModel(dlm);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDlg stackdlg = new StackDlg();
				stackdlg.setVisible(true);
				Rectangle rec = new Rectangle(new Point (Integer.parseInt(stackdlg.getTxtXKoord().getText()), (Integer.parseInt(stackdlg.getTxtYKoord().getText()))), 
						Integer.parseInt(stackdlg.getTxtSirina().getText()), 
						Integer.parseInt(stackdlg.getTxtVisina().getText()));
				
				if(stackdlg.isOk == true) {
					dlm.add(0,"X koordinata: " + rec.getUlp().getX() + " , Y koordinata: " + rec.getUlp().getY() + " , sirina: " + rec.getWidth() + " , visina: " + rec.getHeight());
				}
				
				stack.push(rec);
				System.out.println(stack);
			}
		});
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDlg stackdlgobrisi = new StackDlg();
				String[] split = dlm.firstElement().toString().split(" ");
				stackdlgobrisi.getTxtXKoord().setText(split[2]);
				stackdlgobrisi.getTxtYKoord().setText(split[6]);
				stackdlgobrisi.getTxtSirina().setText(split[9]);
				stackdlgobrisi.getTxtVisina().setText(split[12]);
				stackdlgobrisi.setVisible(true);
				stack.pop();
				System.out.println(stack);
				dlm.removeElementAt(0);
				
			}
		});
		GroupLayout gl_PnlDole = new GroupLayout(PnlDole);
		gl_PnlDole.setHorizontalGroup(
			gl_PnlDole.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlDole.createSequentialGroup()
					.addGap(38)
					.addComponent(btnDodaj)
					.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
					.addComponent(btnObrisi)
					.addGap(39))
		);
		gl_PnlDole.setVerticalGroup(
			gl_PnlDole.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PnlDole.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_PnlDole.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDodaj)
						.addComponent(btnObrisi))
					.addContainerGap())
		);
		PnlDole.setLayout(gl_PnlDole);
	}
}
