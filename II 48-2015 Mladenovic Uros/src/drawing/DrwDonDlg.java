package drawing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DrwDonDlg extends JDialog {

	private final JPanel pnlCentar = new JPanel();
	private JTextField txtUP;
	private JTextField txtSP;
	boolean isOk;
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private int cx;
	private int cy;
	private int up;
	private int sp;
	private Color boja = Color.BLACK;
	private Color bojaTacke = Color.BLACK;
	private JButton btnPromenaBoje;
	private Color bojaPovrsine = Color.WHITE;
	private JButton btnPromenaBojeKruga;
	private boolean bojab;
	private boolean bojafillb;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DrwDonDlg dialog = new DrwDonDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DrwDonDlg() {
		setModal(true);
		setResizable(false);
		setTitle("Unos/Modifikacija Kruga sa rupom");
		setBounds(100, 100, 288, 400);
		getContentPane().setLayout(new BorderLayout());
		pnlCentar.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCentar, BorderLayout.CENTER);
		JLabel lblUP = new JLabel("Unutrasnji poluprecnik:");
		JLabel lblSP = new JLabel("Spoljasnji poluprecnik:");
		txtUP = new JTextField();
		txtUP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(getTxtUP().getText().trim().isEmpty()) {
					if (!((c >= '1') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
				}}else {
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			}
		});
		txtUP.setColumns(10);
		txtSP = new JTextField();
		txtSP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(getTxtSP().getText().trim().isEmpty()) {
					if (!((c >= '1') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
				}}else {
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			}
		});
		txtSP.setColumns(10);
		
		JLabel lblXKoordinataCentra = new JLabel("X koordinata centra:");
		
		JLabel lblYKoordinataCentra = new JLabel("Y koordinata centra:");
		
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXCoord.setColumns(10);
		
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYCoord.setColumns(10);
		
		btnPromenaBoje = new JButton("Promena boje ivice");
		btnPromenaBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boja = JColorChooser.showDialog(null, "Panel boja", bojaTacke);
				setBojab(true);
			}
		});
		
		btnPromenaBojeKruga = new JButton("Promena boje kruga sa rupom");
		btnPromenaBojeKruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bojaPovrsine = JColorChooser.showDialog(null, "Paleta boja", bojaTacke);
				setBojafillb(true);
			}
		});
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSP)
								.addComponent(lblXKoordinataCentra)
								.addComponent(lblYKoordinataCentra)
								.addComponent(lblUP))
							.addGap(42)
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtYCoord)
								.addComponent(txtXCoord)
								.addComponent(txtSP)
								.addComponent(txtUP))
							.addGap(24))
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addComponent(btnPromenaBoje)
							.addContainerGap(139, Short.MAX_VALUE))
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addComponent(btnPromenaBojeKruga)
							.addContainerGap(87, Short.MAX_VALUE))))
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXKoordinataCentra)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYKoordinataCentra)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSP)
						.addComponent(txtSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUP))
					.addGap(41)
					.addComponent(btnPromenaBoje)
					.addGap(18)
					.addComponent(btnPromenaBojeKruga)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		pnlCentar.setLayout(gl_pnlCentar);
		{
			JPanel pnlDole = new JPanel();
			getContentPane().add(pnlDole, BorderLayout.SOUTH);
			JButton btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty() || txtSP.getText().trim().isEmpty() || txtUP.getText().trim().isEmpty()) {
						isOk = false;
						getToolkit().beep();
						JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
					}else {
						if (Integer.parseInt(txtSP.getText()) > Integer.parseInt(txtUP.getText()) ) {
								cx = Integer.parseInt(txtXCoord.getText());
								cy = Integer.parseInt(txtYCoord.getText());
								up = Integer.parseInt(txtUP.getText());
								sp = Integer.parseInt(txtSP.getText());
								for (Shapes shapes : PnlDrawing.shapesarr) {
									if(shapes.isSelected()) {
										shapes.move(cx, cy);
										if(isBojab()==true) {
											shapes.setBoja(boja);
											setBojab(false);
										}
										if(isBojafillb()== true) {
											shapes.setBojafill(bojaPovrsine);
											setBojafillb(false);
										}
										if(shapes instanceof Donut) {
											((Donut) shapes).setInnerRadius(up);
											((Donut) shapes).setRadius(sp);
										}
									}
								}
								isOk = true;
								dispose();	
						}else {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Spoljasnji poluprecnik mora biti veci od unutrasnjeg poluprecnika", "Greska", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
			});
			JButton btnPonisti = new JButton("Ponisti");
			btnPonisti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			GroupLayout gl_pnlDole = new GroupLayout(pnlDole);
			gl_pnlDole.setHorizontalGroup(
				gl_pnlDole.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlDole.createSequentialGroup()
						.addGap(26)
						.addComponent(btnPotvrdi)
						.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
						.addComponent(btnPonisti)
						.addGap(52))
			);
			gl_pnlDole.setVerticalGroup(
				gl_pnlDole.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlDole.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnlDole.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPotvrdi)
							.addComponent(btnPonisti))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			pnlDole.setLayout(gl_pnlDole);
		}
	}

	public JTextField getTxtUP() {
		return txtUP;
	}

	public void setTxtUP(JTextField txtUP) {
		this.txtUP = txtUP;
	}

	public JTextField getTxtSP() {
		return txtSP;
	}

	public void setTxtSP(JTextField txtSP) {
		this.txtSP = txtSP;
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

	public JButton getBtnPromenaBoje() {
		return btnPromenaBoje;
	}

	public void setBtnPromenaBoje(JButton btnPromenaBoje) {
		this.btnPromenaBoje = btnPromenaBoje;
	}

	public JButton getBtnPromenaBojeKruga() {
		return btnPromenaBojeKruga;
	}

	public void setBtnPromenaBojeKruga(JButton btnPromenaBojeKruga) {
		this.btnPromenaBojeKruga = btnPromenaBojeKruga;
	}

	public boolean isBojab() {
		return bojab;
	}

	public void setBojab(boolean bojab) {
		this.bojab = bojab;
	}

	public boolean isBojafillb() {
		return bojafillb;
	}

	public void setBojafillb(boolean bojafillb) {
		this.bojafillb = bojafillb;
	}

}
