package student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtBrojStudenata;
	DefaultListModel dlm = new DefaultListModel();
	JList lstStudent = new JList();
	int brojac;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStudent frame = new FrmStudent();
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
	public FrmStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		pnlCentar.setLayout(null);
		
		JScrollPane scrlStudent = new JScrollPane();
		scrlStudent.setBounds(10, 11, 214, 170);
		pnlCentar.add(scrlStudent);
		
		lstStudent.setModel(dlm);
		scrlStudent.setViewportView(lstStudent);
		
		JPanel pnlZapad = new JPanel();
		contentPane.add(pnlZapad, BorderLayout.WEST);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStudent dlgStudent = new DlgStudent();
				dlgStudent.setVisible(true);
				if (dlgStudent.isOk = true) {
					dlm.addElement("Broj indeksa: " + dlgStudent.getCbxSmer().getSelectedItem() +
							" " + dlgStudent.getTxtBrojIndeksa().getText() + " / " + 
							dlgStudent.getCbxGodina().getSelectedItem() + ", Prezime: " +
							dlgStudent.getTxtPrezime().getText() + " Ime: " + dlgStudent.getTxtIme().getText());
				brojac++;
				txtBrojStudenata.setText(Integer.toString(brojac));
				}
			}
		});
		
		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lstStudent.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Nijedan red nije selektovan!", 
							"Greška", 
							JOptionPane.ERROR_MESSAGE);
				} else {
					DlgStudent dlgModifikacija = new DlgStudent();
					String[] split = dlm.getElementAt(lstStudent.getSelectedIndex()).toString().split(" ");
					dlgModifikacija.getTxtIme().setText(split[9]);
					dlgModifikacija.getTxtPrezime().setText(split[7]);
					dlgModifikacija.getTxtBrojIndeksa().setText(split[3]);
					dlgModifikacija.getCbxSmer().setSelectedItem(split[2]);
					dlgModifikacija.getCbxGodina().setSelectedItem(split[5]);
					dlgModifikacija.setVisible(true);
					
					if (dlgModifikacija.isOk) {
						dlm.removeElementAt(lstStudent.getSelectedIndex());
						String s = "Broj indeksa: " + dlgModifikacija.getCbxSmer().getSelectedItem() +
								" " + dlgModifikacija.getTxtBrojIndeksa().getText() + " / " + 
								dlgModifikacija.getCbxGodina().getSelectedItem() + ", Prezime: " +
								dlgModifikacija.getTxtPrezime().getText() + " Ime: " + dlgModifikacija.getTxtIme().getText();
						dlm.add(lstStudent.getSelectedIndex(), s);
					}
					
				}
			}
		});
		GroupLayout gl_pnlZapad = new GroupLayout(pnlZapad);
		gl_pnlZapad.setHorizontalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDodaj)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pnlZapad.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnModifikuj)
					.addContainerGap())
		);
		gl_pnlZapad.setVerticalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addGap(22)
					.addComponent(btnDodaj)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnModifikuj)
					.addContainerGap(163, Short.MAX_VALUE))
		);
		pnlZapad.setLayout(gl_pnlZapad);
		
		JPanel pnlIstok = new JPanel();
		contentPane.add(pnlIstok, BorderLayout.EAST);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!dlm.isEmpty()) {
					dlm.remove(dlm.size()-1);
					brojac--;
					txtBrojStudenata.setText(Integer.toString(brojac));
				} else {
					JOptionPane.showMessageDialog(null,
							"Lista je prazna!", 
							"Greška", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GroupLayout gl_pnlIstok = new GroupLayout(pnlIstok);
		gl_pnlIstok.setHorizontalGroup(
			gl_pnlIstok.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlIstok.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(btnUkloni))
		);
		gl_pnlIstok.setVerticalGroup(
			gl_pnlIstok.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlIstok.createSequentialGroup()
					.addGap(20)
					.addComponent(btnUkloni)
					.addContainerGap(161, Short.MAX_VALUE))
		);
		pnlIstok.setLayout(gl_pnlIstok);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JLabel lblBrojStudenataU = new JLabel("Broj studenata u listi:");
		
		txtBrojStudenata = new JTextField();
		txtBrojStudenata.setEditable(false);
		txtBrojStudenata.setColumns(10);
		GroupLayout gl_pnlJug = new GroupLayout(pnlJug);
		gl_pnlJug.setHorizontalGroup(
			gl_pnlJug.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlJug.createSequentialGroup()
					.addGap(158)
					.addComponent(lblBrojStudenataU)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtBrojStudenata, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_pnlJug.setVerticalGroup(
			gl_pnlJug.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlJug.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlJug.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBrojStudenata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrojStudenataU)))
		);
		pnlJug.setLayout(gl_pnlJug);
		
		JLabel lblEvidencijaStudenata = new JLabel("Evidencija studenata");
		lblEvidencijaStudenata.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEvidencijaStudenata.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEvidencijaStudenata, BorderLayout.NORTH);
	}
}
