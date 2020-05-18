package FORM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class searchNVPanel extends JFrame {

	private JPanel mainPanel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchNVPanel frame = new searchNVPanel();
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
	public searchNVPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setUndecorated(true);
		setLocationRelativeTo(null);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(15, 52, 225, 26);
		mainPanel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn"}));
		comboBox.setBounds(255, 52, 164, 26);
		mainPanel.add(comboBox);
		
		JButton btnTimkiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimkiem.setBounds(436, 51, 115, 29);
		mainPanel.add(btnTimkiem);
		
		JLabel lbManv = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn :");
		lbManv.setBounds(15, 111, 173, 20);
		mainPanel.add(lbManv);
		
		JLabel lbHoten = new JLabel("H\u1ECD v\u00E0 t\u00EAn :");
		lbHoten.setBounds(15, 147, 301, 20);
		mainPanel.add(lbHoten);
		
		JLabel lbGioitinh = new JLabel("Gi\u1EDBi t\u00EDnh :");
		lbGioitinh.setBounds(331, 147, 220, 20);
		mainPanel.add(lbGioitinh);
		
		JLabel lbNgaysinh = new JLabel("Ng\u00E0y sinh :");
		lbNgaysinh.setBounds(15, 183, 301, 20);
		mainPanel.add(lbNgaysinh);
		
		JLabel lbSDT = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
		lbSDT.setBounds(15, 219, 258, 20);
		mainPanel.add(lbSDT);
		
		JLabel lbEmail = new JLabel("Email :");
		lbEmail.setBounds(331, 219, 220, 20);
		mainPanel.add(lbEmail);
		
		JLabel lbDiachi = new JLabel("\u0110\u1ECBa ch\u1EC9 :");
		lbDiachi.setBounds(15, 256, 570, 20);
		mainPanel.add(lbDiachi);
		
		JLabel lbLuong = new JLabel("L\u01B0\u01A1ng :");
		lbLuong.setBounds(15, 292, 264, 20);
		mainPanel.add(lbLuong);
	}
}
