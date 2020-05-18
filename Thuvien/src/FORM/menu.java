package FORM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.MyConnectToMySQL;

import java.awt.Color;
import javax.swing.JTabbedPane;

public class menu extends JFrame {

	private JPanel mainPanel;
	public JTabbedPane tabbedPane;
	private JPanel QLNVPanel,QLSPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public menu() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(31, 117, 254));
		panel.setBounds(0, 0, 1100, 40);
		mainPanel.add(panel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 41, 1100, 600);
		mainPanel.add(tabbedPane);

		QLNVPanel = new QLNVPanel();
		tabbedPane.addTab("Quản lí nhân viên", null, QLNVPanel, null);

		QLSPanel = new QLSPanel();
		tabbedPane.addTab("Quản lí sách", null, QLSPanel, null);
	}
}
