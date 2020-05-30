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
import BUS.nxbBUS;

public class selectLV extends selectID {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable tbLV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectLV frame = new selectLV();
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
	public selectLV() throws Exception {
		super();
		
		linhvucBUS bus = new linhvucBUS();
		model = bus.docDSLV();
		tbLV = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(tbLV);
		scrollPane.setBounds(12, 98, 404, 126);
		getContentPane().add(scrollPane);
	}

}
