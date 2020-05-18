package FORM;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;

public class QLSPanel extends JPanel {
	private JTextField txMasach;
	private JTextField txTensach;
	private JTextField txGia;
	private JTextField txTheloai;
	private JTextField txTacgia;
	private JTextField txMaNXB;
	private JTextField txSoluong;
	private DefaultTableModel model;
	private JTable tbQLS;

	/**
	 * Create the panel.
	 */
	public QLSPanel() {
		setLayout(null);
		
		JLabel lbMasach = new JLabel("M\u00E3 s\u00E1ch :");
		lbMasach.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbMasach.setBounds(50, 30, 120, 25);
		add(lbMasach);
		
		txMasach = new JTextField();
		txMasach.setBounds(175, 28, 203, 25);
		add(txMasach);
		txMasach.setColumns(10);
		
		JLabel lbTensach = new JLabel("T\u00EAn s\u00E1ch :");
		lbTensach.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbTensach.setBounds(50, 70, 120, 25);
		add(lbTensach);
		
		txTensach = new JTextField();
		txTensach.setColumns(10);
		txTensach.setBounds(175, 70, 203, 25);
		add(txTensach);
		
		JLabel lbGia = new JLabel("Gi\u00E1 s\u00E1ch :");
		lbGia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbGia.setBounds(50, 110, 94, 25);
		add(lbGia);
		
		txGia = new JTextField();
		txGia.setColumns(10);
		txGia.setBounds(175, 110, 203, 25);
		add(txGia);
		
		JLabel lbTheloai = new JLabel("M\u00E3 th\u1EC3 lo\u1EA1i : ");
		lbTheloai.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbTheloai.setBounds(420, 30, 120, 25);
		add(lbTheloai);
		
		txTheloai = new JTextField();
		txTheloai.setBounds(537, 28, 120, 25);
		add(txTheloai);
		txTheloai.setColumns(10);
		
		JLabel lbTacgia = new JLabel("M\u00E3 t\u00E1c gi\u1EA3 :");
		lbTacgia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbTacgia.setBounds(420, 110, 94, 25);
		add(lbTacgia);
		
		txTacgia = new JTextField();
		txTacgia.setBounds(537, 108, 120, 26);
		add(txTacgia);
		txTacgia.setColumns(10);
		
		JLabel txNXB = new JLabel("M\u00E3 NXB : ");
		txNXB.setFont(new Font("Calibri", Font.PLAIN, 18));
		txNXB.setBounds(420, 70, 94, 25);
		add(txNXB);
		
		txMaNXB = new JTextField();
		txMaNXB.setBounds(537, 68, 120, 25);
		add(txMaNXB);
		txMaNXB.setColumns(10);
		
		JLabel lbSoluong = new JLabel("S\u1ED1 l\u01B0\u1EE3ng :");
		lbSoluong.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbSoluong.setBounds(50, 151, 82, 25);
		add(lbSoluong);
		
		txSoluong = new JTextField();
		txSoluong.setBounds(175, 149, 203, 26);
		add(txSoluong);
		txSoluong.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnThem.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_add_32.png"));
		btnThem.setBounds(110, 205, 150, 30);
		add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnXoa.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_delete_sign_32.png"));
		btnXoa.setBounds(270, 205, 150, 30);
		add(btnXoa);

		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTailai.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_synchronize_32.png"));
		btnTailai.setBounds(430, 205, 150, 30);
		add(btnTailai);

		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSua.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_change_32.png"));
		btnSua.setBounds(590, 205, 150, 30);
		add(btnSua);

		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTim.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_search_32.png"));
		btnTim.setBounds(750, 205, 150, 30);
		add(btnTim);
		
		Vector<String> header = new Vector<String>();
		header.add("Mã sách");
		header.add("Tên sách");
		header.add("Giá sách");
		header.add("Mã thể loại");
		header.add("Mã tác giả");
		header.add("Mã nhà xuất bản");
		header.add("Số lượng");
		model = new DefaultTableModel();

		if (model.getRowCount() == 0) {
			model = new DefaultTableModel(header, 0);
		}
		tbQLS = new JTable();
		tbQLS.setModel(model);
		tbQLS.setFont(new Font("Calibri", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(tbQLS);
		scrollPane.setBounds(30, 250, 1050, 250);
		add(scrollPane);

	}
}
