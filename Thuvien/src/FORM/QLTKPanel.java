package FORM;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLTKPanel extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private JButton btnThem, btnXoa, btnSua, btnTailai;
	public QLTKPanel() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnThem.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_add_32.png"));
		btnThem.setBounds(50, 206, 150, 30);
		btnThem.addActionListener(this);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnXoa.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_delete_sign_32.png"));
		btnXoa.setBounds(204, 205, 150, 30);
		btnXoa.addActionListener(this);
		add(btnXoa);

		btnTailai = new JButton("Tải lại");
		btnTailai.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTailai.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_synchronize_32.png"));
		btnTailai.setBounds(509, 205, 150, 30);
		btnTailai.addActionListener(this);
		add(btnTailai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSua.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_change_32.png"));
		btnSua.setBounds(357, 205, 150, 30);
		btnSua.addActionListener(this);
		add(btnSua);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
