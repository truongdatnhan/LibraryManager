package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import BUS.nguoidungBUS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class QLTKPanel extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private JButton btnThem, btnXoa, btnSua, btnTailai;
	private tableNguoidung table;
	private JTextField txManv;
	private JPasswordField passwordField;
	public QLTKPanel() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnThem.setIcon(new ImageIcon("./icon/icons8_add_32.png"));
		btnThem.setBounds(30, 206, 150, 25);
		btnThem.addActionListener(this);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnXoa.setIcon(new ImageIcon("./icon/icons8_delete_sign_32.png"));
		btnXoa.setBounds(210, 205, 150, 25);
		btnXoa.addActionListener(this);
		add(btnXoa);

		btnTailai = new JButton("Tải lại");
		btnTailai.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTailai.setIcon(new ImageIcon("./icon/icons8_synchronize_32.png"));
		btnTailai.setBounds(210, 257, 150, 25);
		btnTailai.addActionListener(this);
		add(btnTailai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSua.setIcon(new ImageIcon("./icon/icons8_change_32.png"));
		btnSua.setBounds(30, 257, 150, 25);
		btnSua.addActionListener(this);
		add(btnSua);
		
		table = new tableNguoidung();
		nguoidungBUS bus = new nguoidungBUS();
		table.setData(bus.getNDList());
		table.loadData();
		table.setBounds(392, 16,596 , 573);
		add(table);
		
		txManv = new JTextField();
		txManv.setBounds(192, 59, 146, 26);
		add(txManv);
		txManv.setColumns(10);
		
		JLabel lbManv = new JLabel("Mã  nhân viên :");
		lbManv.setBounds(51, 62, 110, 20);
		add(lbManv);
		
		JLabel kbMatkhau = new JLabel("Mật khẩu :");
		kbMatkhau.setBounds(51, 98, 110, 20);
		add(kbMatkhau);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 95, 146, 26);
		add(passwordField);
		
		JLabel lbMaquye = new JLabel("Mã quyền :");
		lbMaquye.setBounds(51, 134, 110, 20);
		add(lbMaquye);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "MQ001", "MQ002"}));
		comboBox.setBounds(192, 137, 146, 26);
		add(comboBox);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnThem) {
			
		}
	}
}
