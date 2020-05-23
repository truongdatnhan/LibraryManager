package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Button;
import java.awt.Choice;

public class QLSPanel extends JPanel implements MouseListener,ActionListener{
	private JTextField txMasach;
	private JTextField txTensach;
	private JTextField txGia;
	private JTextField txTheloai;
	private JTextField txTacgia;
	private JTextField txMaNXB;
	private JTextField txSoluong;
	private DefaultTableModel model;
	private JTable tbQLS;
	private JButton btnThem, btnXoa, btnSua, btnTailai;
	private JTextField txLinhvuc;

	/**
	 * Create the panel.
	 */
	public QLSPanel() {
		setBackground(Color.WHITE);
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
		txTheloai.setBounds(537, 28, 98, 25);
		add(txTheloai);
		txTheloai.setColumns(10);
		
		JLabel lbTacgia = new JLabel("M\u00E3 t\u00E1c gi\u1EA3 :");
		lbTacgia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbTacgia.setBounds(420, 70, 94, 25);
		add(lbTacgia);
		
		txTacgia = new JTextField();
		txTacgia.setBounds(537, 68, 98, 26);
		add(txTacgia);
		txTacgia.setColumns(10);
		
		JLabel txNXB = new JLabel("M\u00E3 NXB : ");
		txNXB.setFont(new Font("Calibri", Font.PLAIN, 18));
		txNXB.setBounds(420, 110, 94, 25);
		add(txNXB);
		
		txMaNXB = new JTextField();
		txMaNXB.setBounds(537, 110, 98, 25);
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
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnThem.setIcon(new ImageIcon("./icon/icons8_add_32.png"));
		btnThem.setBounds(60, 206, 150, 25);
		btnThem.addActionListener(this);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnXoa.setIcon(new ImageIcon("./icon/icons8_delete_sign_32.png"));
		btnXoa.setBounds(231, 205, 150, 25);
		btnXoa.addActionListener(this);
		add(btnXoa);

		btnTailai = new JButton("Tải lại");
		btnTailai.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTailai.setIcon(new ImageIcon("./icon/icons8_synchronize_32.png"));
		btnTailai.setBounds(561, 205, 150, 25);
		btnTailai.addActionListener(this);
		add(btnTailai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSua.setIcon(new ImageIcon("./icon/icons8_change_32.png"));
		btnSua.setBounds(396, 205, 150, 25);
		btnSua.addActionListener(this);
		add(btnSua);
		
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
		scrollPane.setBounds(10, 295, 970, 270);
		add(scrollPane);
		
		JLabel lbMalinhvuc = new JLabel("Mã lĩnh vực :");
		lbMalinhvuc.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbMalinhvuc.setBounds(420, 152, 94, 20);
		add(lbMalinhvuc);
		
		txLinhvuc = new JTextField();
		txLinhvuc.setBounds(537, 149, 98, 25);
		add(txLinhvuc);
		txLinhvuc.setColumns(10);
		
		JButton btnTL = new JButton("...");
		btnTL.setBounds(636, 28, 25, 25);
		add(btnTL);
		
		JButton btnTG = new JButton("...");
		btnTG.setBounds(636, 68, 25, 25);
		add(btnTG);
		
		JButton btnNXB = new JButton("...");
		btnNXB.setBounds(636, 110, 25, 25);
		add(btnNXB);
		
		JButton btnLV = new JButton("...");
		btnLV.setBounds(636, 149, 25, 25);
		add(btnLV);
		
		JLabel lbHinhanh = new JLabel("");
		lbHinhanh.setBounds(754, 30, 173, 158);
		add(lbHinhanh);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
