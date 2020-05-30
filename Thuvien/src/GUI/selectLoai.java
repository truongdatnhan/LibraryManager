package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.loaiBUS;

public class selectLoai extends selectID {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable tbL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectLoai frame = new selectLoai();
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
	public selectLoai() throws Exception {
		super();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		loaiBUS bus = new loaiBUS();
		model = bus.docDSL();
		tbL = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(tbL);
		scrollPane.setBounds(12, 98, 404, 126);
		getContentPane().add(scrollPane);
	}

}
