package FORM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.nhanvienBUS;
import DTO.nhanvienDTO;
import TOOL.check;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class searchNVPanel extends JFrame implements ActionListener {

	private JPanel mainPanel;
	private JTextField txText;
	private JTextField txManv;
	private JTextField txHoten;
	private JTextField txGioitinh;
	private JTextField txNgaysinh;
	private JTextField txSDT;
	private JTextField txEmail;
	private JTextField txDiachi;
	private JTextField txLuong;
	JButton btnTimkiem;
	JComboBox comboBox;
	private final JLabel lbTimkiem = new JLabel("Tìm kiếm");

	public searchNVPanel() {
		setBounds(100, 100, 600, 400);
		setUndecorated(true);
		setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("./icon/book.png");
		Image img = icon.getImage();
		this.setIconImage(img);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		txText = new JTextField();
		txText.setBounds(15, 52, 225, 26);
		mainPanel.add(txText);
		txText.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Mã nhân viên", "Tên nhân viên" }));
		comboBox.setBounds(255, 52, 164, 26);
		mainPanel.add(comboBox);

		btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.setBounds(436, 51, 115, 29);
		btnTimkiem.addActionListener(this);
		mainPanel.add(btnTimkiem);

		JLabel lbManv = new JLabel("Mã nhân viên :");
		lbManv.setBounds(15, 111, 115, 20);
		mainPanel.add(lbManv);

		JLabel lbHoten = new JLabel("Họ và tên :");
		lbHoten.setBounds(15, 147, 88, 20);
		mainPanel.add(lbHoten);

		JLabel lbGioitinh = new JLabel("Giới tính :");
		lbGioitinh.setBounds(363, 147, 71, 20);
		mainPanel.add(lbGioitinh);

		JLabel lbNgaysinh = new JLabel("Ngày sinh :");
		lbNgaysinh.setBounds(15, 183, 108, 20);
		mainPanel.add(lbNgaysinh);

		JLabel lbSDT = new JLabel("Số điện thoại :");
		lbSDT.setBounds(15, 219, 115, 20);
		mainPanel.add(lbSDT);

		JLabel lbEmail = new JLabel("Email :");
		lbEmail.setBounds(363, 219, 50, 20);
		mainPanel.add(lbEmail);

		JLabel lbDiachi = new JLabel("Địa chỉ :");
		lbDiachi.setBounds(15, 256, 69, 20);
		mainPanel.add(lbDiachi);

		JLabel lbLuong = new JLabel("Lương :");
		lbLuong.setBounds(15, 292, 69, 20);
		mainPanel.add(lbLuong);

		txManv = new JTextField();
		txManv.setBounds(121, 108, 132, 26);
		mainPanel.add(txManv);
		txManv.setColumns(10);

		txHoten = new JTextField();
		txHoten.setBounds(120, 147, 208, 26);
		mainPanel.add(txHoten);
		txHoten.setColumns(10);

		txGioitinh = new JTextField();
		txGioitinh.setBounds(439, 144, 146, 26);
		mainPanel.add(txGioitinh);
		txGioitinh.setColumns(10);

		txNgaysinh = new JTextField();
		txNgaysinh.setBounds(121, 180, 207, 26);
		mainPanel.add(txNgaysinh);
		txNgaysinh.setColumns(10);

		txSDT = new JTextField();
		txSDT.setBounds(121, 216, 207, 26);
		mainPanel.add(txSDT);
		txSDT.setColumns(10);

		txEmail = new JTextField();
		txEmail.setBounds(439, 216, 146, 26);
		mainPanel.add(txEmail);
		txEmail.setColumns(10);

		txDiachi = new JTextField();
		txDiachi.setBounds(121, 255, 464, 26);
		mainPanel.add(txDiachi);
		txDiachi.setColumns(10);

		txLuong = new JTextField();
		txLuong.setBounds(121, 289, 146, 26);
		mainPanel.add(txLuong);
		txLuong.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(31, 117, 254));
		panel.setBounds(0, 0, 600, 40);
		mainPanel.add(panel);
		panel.setLayout(null);
		lbTimkiem.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimkiem.setForeground(Color.WHITE);
		lbTimkiem.setFont(new Font("Calibri", Font.BOLD, 18));
		lbTimkiem.setBounds(231, 0, 145, 41);
		panel.add(lbTimkiem);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		nhanvienBUS bus;
		if (evt.getSource() == btnTimkiem) {
			bus = new nhanvienBUS();
			nhanvienDTO temp = new nhanvienDTO();
			JOptionPane.showMessageDialog(null, comboBox.getSelectedItem());
			if (!check.checkNull(txText.getText())) {
				if (comboBox.getSelectedIndex() == 0) {
					int k = 0;
					for (nhanvienDTO nv : bus.dsnv) {
						if (txText.getText().compareTo(nv.getManv()) == 0) {
							txManv.setText(nv.getManv());
							txHoten.setText(nv.getHo() + " " + nv.getTen());
							txNgaysinh.setText(nv.getNgaysinh());
							txDiachi.setText(nv.getDiachi());
							txGioitinh.setText(nv.getGioitinh());
							txEmail.setText(nv.getEmail());
							txSDT.setText(nv.getSdt());
							txLuong.setText(nv.getLuong());
							k++;
						}
					}
					if (k == 0) {
						JOptionPane.showMessageDialog(null, "Nhân viên này không tồn tại");
					}
				} else {
					int k = 0;
					for (nhanvienDTO nv : bus.dsnv) {
						JOptionPane.showMessageDialog(null, nv.getHo() + " " + nv.getTen());
						if (txText.getText().compareToIgnoreCase(nv.getHo() + " " + nv.getTen()) == 0) {
							txManv.setText(nv.getManv());
							txHoten.setText(nv.getHo() + " " + nv.getTen());
							txNgaysinh.setText(nv.getNgaysinh());
							txDiachi.setText(nv.getDiachi());
							txGioitinh.setText(nv.getGioitinh());
							txEmail.setText(nv.getEmail());
							txSDT.setText(nv.getSdt());
							txLuong.setText(nv.getLuong());
						}
					}
					if (k == 0) {
						JOptionPane.showMessageDialog(null, "Nhân viên này không tồn tại");
					}
				}
			} else {
				txText.setBorder(BorderFactory.createLineBorder(Color.red));
			}
		}
	}
}
