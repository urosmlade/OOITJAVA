package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNaslov = new JLabel("Naslov");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNaslov, BorderLayout.NORTH);
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(new Color(255, 255, 153));
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		pnlCentar.setLayout(null);
		
		JLabel lblKolarov = new JLabel("Aleksandar Kolarov");
		lblKolarov.setBounds(104, 11, 119, 14);
		pnlCentar.add(lblKolarov);
		
		JLabel lblMatic = new JLabel("Nemanja Mati\u0107");
		lblMatic.setBounds(104, 36, 107, 14);
		pnlCentar.add(lblMatic);
		
		JLabel lblMitrovic = new JLabel("Aleksandar Mitrovi\u0107");
		lblMitrovic.setBounds(104, 61, 119, 14);
		pnlCentar.add(lblMitrovic);
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnKolarov.isSelected()) {
					lblKolarov.setForeground(Color.BLUE);
					lblMatic.setForeground(Color.BLACK);
					lblMitrovic.setForeground(Color.BLACK);
					dlm.addElement(lblKolarov.getText());
				}
			}
		});
		buttonGroup.add(tglbtnKolarov);
		
		tglbtnKolarov.setBounds(10, 7, 84, 23);
		pnlCentar.add(tglbtnKolarov);
		
		JToggleButton tglbtnMatic = new JToggleButton("Mati\u0107");
		tglbtnMatic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnMatic.isSelected()) {
					lblMatic.setForeground(Color.BLUE);
					lblKolarov.setForeground(Color.BLACK);
					lblMitrovic.setForeground(Color.BLACK);
					dlm.addElement(lblMatic.getText());
				}
			}
		});
		buttonGroup.add(tglbtnMatic);
		
		tglbtnMatic.setBounds(10, 32, 84, 23);
		pnlCentar.add(tglbtnMatic);
		
		JToggleButton tglbtnMitrovic = new JToggleButton("Mitrovi\u0107");
		tglbtnMitrovic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (tglbtnMitrovic.isSelected()) {
					lblMatic.setForeground(Color.BLACK);
					lblKolarov.setForeground(Color.BLACK);
					lblMitrovic.setForeground(Color.BLUE);
					dlm.addElement(lblMitrovic.getText());
				}
			}
		});
		buttonGroup.add(tglbtnMitrovic);
		
		tglbtnMitrovic.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tglbtnMitrovic.setBounds(10, 57, 84, 23);
		pnlCentar.add(tglbtnMitrovic);
		
		JScrollPane scrlPnIgraci = new JScrollPane();
		scrlPnIgraci.setBounds(218, 11, 178, 77);
		pnlCentar.add(scrlPnIgraci);
		
		JList lstIgraci = new JList();
		lstIgraci.setModel(dlm);
		scrlPnIgraci.setViewportView(lstIgraci);
		
		JButton btnIzbrisi = new JButton("Izbri\u0161i");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.removeElement(lstIgraci.getSelectedValue());
			}
		});
			
		btnIzbrisi.setBounds(327, 93, 69, 23);
		pnlCentar.add(btnIzbrisi);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JButton btnIspisi = new JButton("Ispi\u0161i");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)");
			}
		});
		pnlJug.add(btnIspisi);
	}
}