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

public class DrwCirDlg extends JDialog {

	private final JPanel pnlCentar = new JPanel();
	private JButton btnPotvrdi;
	private JTextField txtRadius;
	boolean isOk;
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private	int cx;
	private	int cy;
	private int rad;
	DrawingFrm frm = new DrawingFrm();
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
			DrwCirDlg dialog = new DrwCirDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DrwCirDlg() {
		setModal(true);
		setResizable(false);
		setTitle("Unos/Modifikacija Kruga");
		setBounds(100, 100, 262, 333);
		getContentPane().setLayout(new BorderLayout());
		pnlCentar.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCentar, BorderLayout.CENTER);
		
		JLabel lblPoluprecnik = new JLabel("Poluprecnik:");
		
		txtRadius = new JTextField();
		txtRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(getTxtRadius().getText().trim().isEmpty()) {
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
		txtRadius.setColumns(10);
		
		JLabel lblXKoordinataCentra = new JLabel("X koordinata centra:");
		
		JLabel lblYKoordinataCentra = new JLabel("Y koordinata centra:");
		
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(getTxtXCoord().getText().trim().isEmpty()) {
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
		txtXCoord.setColumns(10);
		
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(getTxtXCoord().getText().trim().isEmpty()) {
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
		txtYCoord.setColumns(10);
		
		btnPromenaBoje = new JButton("Promena boje ivice");
		btnPromenaBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boja = JColorChooser.showDialog(null, "Panela boja", bojaTacke);
				setBojab(true);
			}
		});
		
		btnPromenaBojeKruga = new JButton("Promena boje povrsine");
		btnPromenaBojeKruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_pnlCentar.createSequentialGroup()
								.addComponent(lblXKoordinataCentra)
								.addGap(18)
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_pnlCentar.createSequentialGroup()
								.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblPoluprecnik, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblYKoordinataCentra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
									.addComponent(txtRadius, 66, 66, 66)
									.addComponent(txtYCoord, 66, 66, 66))))
						.addGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnPromenaBoje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPromenaBojeKruga, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblXKoordinataCentra)
							.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlCentar.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYKoordinataCentra)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_pnlCentar.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoluprecnik)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnPromenaBoje)
					.addGap(18)
					.addComponent(btnPromenaBojeKruga)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		pnlCentar.setLayout(gl_pnlCentar);
		{
			JPanel pnlDole = new JPanel();
			getContentPane().add(pnlDole, BorderLayout.SOUTH);
			
			JButton btnPonisti = new JButton("Ponisti");
			btnPonisti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				dispose();
				}
			});
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty() || txtRadius.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						}else {
							cx = Integer.parseInt(txtXCoord.getText());
							cy = Integer.parseInt(txtYCoord.getText());
							rad = Integer.parseInt(txtRadius.getText());
							for (Shapes shapes : PnlDrawing.shapesarr) {
								if(shapes.isSelected()) {
									shapes.move(cx, cy);
									if(isBojab() == true) {
										shapes.setBoja(boja);
										setBojab(false);
									}
									if(isBojafillb() == true) {
										shapes.setBojafill(bojaPovrsine);
										setBojafillb(false);	
									}
									
									if(shapes instanceof Circle) {
										((Circle) shapes).setRadius(rad);
									}
								}
							}
							isOk = true;
							dispose();
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			GroupLayout gl_pnlDole = new GroupLayout(pnlDole);
			gl_pnlDole.setHorizontalGroup(
				gl_pnlDole.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlDole.createSequentialGroup()
						.addGap(20)
						.addComponent(btnPotvrdi)
						.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
						.addComponent(btnPonisti)
						.addGap(39))
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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
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
