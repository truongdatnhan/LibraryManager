package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class QLPMPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public QLPMPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lbMaHD = new JLabel("Mã phiếu mượn");
		lbMaHD.setBounds(478, 30, 99, 25);
		add(lbMaHD);
		
		textField = new JTextField();
		textField.setBounds(630, 29, 191, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lbManv = new JLabel("Mã nhân viên");
		lbManv.setBounds(478, 70, 99, 25);
		add(lbManv);
		
		textField_1 = new JTextField();
		textField_1.setBounds(630, 69, 163, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.setBounds(796, 70, 25, 25);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Mã thẻ");
		lblNewLabel.setBounds(478, 110, 69, 25);
		add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(630, 109, 163, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("...");
		btnNewButton_1.setBounds(796, 111, 25, 25);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày mượn");
		lblNewLabel_1.setBounds(478, 151, 99, 25);
		add(lblNewLabel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(630, 149, 191, 26);
		add(dateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày quy định trả");
		lblNewLabel_2.setBounds(478, 191, 143, 25);
		add(lblNewLabel_2);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(630, 191, 191, 26);
		add(dateChooser_1);
		
		JLabel lblNewLabel_3 = new JLabel("Mã sách ");
		lblNewLabel_3.setBounds(40, 305, 99, 25);
		add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 304, 190, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setBounds(40, 467, 148, 29);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Xóa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(221, 467, 149, 29);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tải lại");
		btnNewButton_4.setBounds(40, 512, 148, 29);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Lưu");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(221, 512, 149, 29);
		add(btnNewButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng");
		lblNewLabel_4.setBounds(40, 346, 69, 20);
		add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(180, 343, 190, 26);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tình trạng");
		lblNewLabel_5.setBounds(40, 382, 79, 20);
		add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Đã trả");
		rdbtnNewRadioButton.setBounds(180, 381, 84, 29);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Chưa trả");
		rdbtnNewRadioButton_1.setBounds(271, 378, 99, 29);
		add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày thực trả");
		lblNewLabel_6.setBounds(40, 418, 99, 20);
		add(lblNewLabel_6);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(180, 419, 190, 26);
		add(dateChooser_2);

	}
}
