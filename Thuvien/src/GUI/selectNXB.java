package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.nxbBUS;
import java.awt.Color;
import javax.swing.JLabel;

public class selectNXB extends selectID {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable tbNXB;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectNXB frame = new selectNXB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public selectNXB() throws Exception {
		super();
		getContentPane().setBackground(Color.WHITE);
		
		//table.setBounds(12, 76, 404, 148);
		//getContentPane().add(table);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		nxbBUS bus = new nxbBUS();
		model = bus.docNXB();
		tbNXB = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(tbNXB);
		scrollPane.setBounds(12, 98, 404, 126);
		getContentPane().add(scrollPane);
	}
}
