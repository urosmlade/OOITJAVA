package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SortDlg extends JDialog {

	private final JPanel PnlCentar = new JPanel();
	private JButton btnPotvrdi;
	private JButton btnPonisti;
	private JTextField txtXKoord;
	private JTextField txtYKoord;
	private JTextField txtSirina;
	private JTextField txtVisina;
	boolean isOk;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SortDlg dialog = new SortDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SortDlg() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 272, 292);
		getContentPane().setLayout(new BorderLayout());
		PnlCentar.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(PnlCentar, BorderLayout.CENTER);
		PnlCentar.setLayout(null);
		
		JLabel lblXKoord = new JLabel("X koordinata:");
		lblXKoord.setBounds(34, 29, 79, 14);
		PnlCentar.add(lblXKoord);
		
		JLabel lblYKoord = new JLabel("Y koordinata:");
		lblYKoord.setBounds(34, 60, 79, 14);
		PnlCentar.add(lblYKoord);
		
		JLabel lblSirina = new JLabel("Sirina:");
		lblSirina.setBounds(34, 91, 79, 14);
		PnlCentar.add(lblSirina);
		
		JLabel lblVisina = new JLabel("Visina:");
		lblVisina.setBounds(34, 122, 79, 14);
		PnlCentar.add(lblVisina);
		
		txtXKoord = new JTextField();
		txtXKoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!((c>= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
				
			}
		});
		txtXKoord.setBounds(123, 26, 86, 20);
		PnlCentar.add(txtXKoord);
		txtXKoord.setColumns(10);
		
		txtYKoord = new JTextField();
		txtYKoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!((c>= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYKoord.setBounds(123, 57, 86, 20);
		PnlCentar.add(txtYKoord);
		txtYKoord.setColumns(10);
		
		txtSirina = new JTextField();
		txtSirina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!((c>= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtSirina.setBounds(123, 88, 86, 20);
		PnlCentar.add(txtSirina);
		txtSirina.setColumns(10);
		
		txtVisina = new JTextField();
		txtVisina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!((c>= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtVisina.setBounds(123, 119, 86, 20);
		PnlCentar.add(txtVisina);
		txtVisina.setColumns(10);
		{
			JPanel PnlDole = new JPanel();
			getContentPane().add(PnlDole, BorderLayout.SOUTH);
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtXKoord.getText().trim().isEmpty() || txtYKoord.getText().trim().isEmpty() || txtSirina.getText().trim().isEmpty() || txtVisina.getText().trim().isEmpty()) {
							isOk = false;
							setVisible(true);
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
						}else {
							isOk = true;
							dispose();
						}
						
					}
				});
				btnPotvrdi.setActionCommand("OK");
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				btnPonisti = new JButton("Ponisti");
				btnPonisti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnPonisti.setActionCommand("Cancel");
			}
			GroupLayout gl_PnlDole = new GroupLayout(PnlDole);
			gl_PnlDole.setHorizontalGroup(
				gl_PnlDole.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlDole.createSequentialGroup()
						.addGap(29)
						.addComponent(btnPotvrdi)
						.addGap(56)
						.addComponent(btnPonisti)
						.addGap(64))
			);
			gl_PnlDole.setVerticalGroup(
				gl_PnlDole.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_PnlDole.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_PnlDole.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPotvrdi)
							.addComponent(btnPonisti))
						.addContainerGap())
			);
			PnlDole.setLayout(gl_PnlDole);
		}
	}

	public JTextField getTxtXKoord() {
		return txtXKoord;
	}

	public void setTxtXKoord(JTextField txtXKoord) {
		this.txtXKoord = txtXKoord;
	}

	public JTextField getTxtYKoord() {
		return txtYKoord;
	}

	public void setTxtYKoord(JTextField txtYKoord) {
		this.txtYKoord = txtYKoord;
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	public void setTxtSirina(JTextField txtSirina) {
		this.txtSirina = txtSirina;
	}

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public void setTxtVisina(JTextField txtVisina) {
		this.txtVisina = txtVisina;
	}
}
