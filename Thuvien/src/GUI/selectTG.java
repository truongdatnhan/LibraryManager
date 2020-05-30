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

import BUS.linhvucBUS;
import BUS.tacgiaBUS;

public class selectTG extends selectID {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable tbTG;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectTG frame = new selectTG();
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
	public selectTG() throws Exception {
		super();
		
		tacgiaBUS bus = new tacgiaBUS();
		model = bus.docDSTG();
		tbTG = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(tbTG);
		scrollPane.setBounds(12, 98, 404, 126);
		getContentPane().add(scrollPane);
	}

}
