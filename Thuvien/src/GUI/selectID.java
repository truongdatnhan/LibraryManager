package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;

public class selectID extends JFrame {

	private JPanel mainPanel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectID frame = new selectID();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 */
	public selectID() throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new com.jtattoo.plaf.luna.LunaLookAndFeel());
		setBounds(100, 100, 450, 350);
		setLocationRelativeTo(null);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(15, 50, 201, 26);
		mainPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnChon = new JButton("Ch\u1ECDn");
		btnChon.setBounds(114, 249, 77, 29);
		mainPanel.add(btnChon);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setBounds(219, 249, 84, 29);
		mainPanel.add(btnThoat);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 450, 40);
		header.setBackground(new Color(45, 118, 232));
		mainPanel.add(header);
	}
}
