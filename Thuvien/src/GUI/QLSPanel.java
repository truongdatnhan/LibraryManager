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
import BUS.sachBUS;
import DTO.sachDTO;
import TOOL.check;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Button;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QLSPanel extends JPanel implements MouseListener, ActionListener {
	private JTextField txMasach;
	private JTextField txTensach;
	private JTextField txGia;
	private JTextField txTheloai;
	private JTextField txTacgia;
	private JTextField txMaNXB;
	private JTextField txSoluong;
	private DefaultTableModel model;
	private JButton btnThem, btnXoa, btnSua, btnTailai, btnNXB;
	private JTextField txLinhvuc;
	private JButton btnTL, btnTG;
	private JButton btnLV;
	private TableSach table;

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

		table = new TableSach();
		table.loadData();
		table.setFont(new Font("Calibri", Font.PLAIN, 18));
		table.setBounds(10, 295, 970, 270);
		add(table);

		JLabel lbMalinhvuc = new JLabel("Mã lĩnh vực :");
		lbMalinhvuc.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbMalinhvuc.setBounds(420, 152, 94, 20);
		add(lbMalinhvuc);

		txLinhvuc = new JTextField();
		txLinhvuc.setBounds(537, 149, 98, 25);
		add(txLinhvuc);
		txLinhvuc.setColumns(10);

		btnTL = new JButton("...");
		btnTL.addActionListener(this);
		btnTL.setBounds(636, 28, 25, 25);
		add(btnTL);

		btnTG = new JButton("...");
		btnTG.addActionListener(this);
		btnTG.setBounds(636, 68, 25, 25);
		add(btnTG);

		btnNXB = new JButton("...");
		btnNXB.addActionListener(this);
		btnNXB.setBounds(636, 110, 25, 25);
		add(btnNXB);

		btnLV = new JButton("...");
		btnLV.addActionListener(this);
		btnLV.setBounds(636, 149, 25, 25);
		add(btnLV);

		JLabel lbHinhanh = new JLabel("");
		lbHinhanh.setBounds(754, 30, 173, 158);
		add(lbHinhanh);

		table.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					sachDTO nv = new sachDTO();
					nv = sachBUS.dss.get(i);
					txMasach.setText(nv.getMasach());
					txTensach.setText(nv.getTensach());
					txGia.setText(String.valueOf(nv.getGiasach()));
					txTheloai.setText(nv.getMatheloai());
					txTacgia.setText(nv.getMatg());
					txMaNXB.setText(nv.getManxb());
					txLinhvuc.setText(nv.getMalinhvuc());
					txSoluong.setText(String.valueOf(nv.getSoluong()));
				}
			}
		});
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
		if (e.getSource() == btnTL) {
			try {
				selectLoai theloai = new selectLoai();
				theloai.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnNXB) {
			try {
				selectNXB nxb = new selectNXB();
				nxb.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnLV) {
			try {
				selectLV linhvuc = new selectLV();
				linhvuc.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnTG) {
			try {
				selectTG tacgia = new selectTG();
				tacgia.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnThem) {
			Insert(0, "Insert");
		} else if (e.getSource() == btnXoa) {
			Delete();
		} else if (e.getSource() == btnSua) {
			Update();
		}
	}

	public void Insert(int i, String k) {
		try {
			sachDTO sach = new sachDTO();
			sachBUS bus = new sachBUS();
			if (!check.checkNull(txMasach.getText()) == true) {
				sach.setMasach(txMasach.getText());
				if (!check.checkNull(txTensach.getText()) == true) {
					sach.setTensach(txTensach.getText());
					if (check.isNumeric(txGia.getText()) == true && !check.checkNull(txGia.getText()) == true) {
						sach.setGiasach(Integer.parseInt(txGia.getText()));
						if (check.isNumeric(txSoluong.getText()) == true
								&& !check.checkNull(txSoluong.getText()) == true) {
							sach.setSoluong(Integer.parseInt(txSoluong.getText()));
							if (!check.checkNull(txTheloai.getText()) == true) {
								sach.setMatheloai(txTheloai.getText());
								if (!check.checkNull(txTheloai.getText()) == true) {
									sach.setMatg(txTacgia.getText());
									if (!check.checkNull(txMaNXB.getText()) == true) {
										sach.setManxb(txMaNXB.getText());
										if (!check.checkNull(txLinhvuc.getText()) == true) {
											sach.setMalinhvuc(txLinhvuc.getText());
											sach.setHinhanh("");
											// code phần hình
											sach.setTrangthai(1);
											switch (k) {
											case "Insert": {
												try {
													bus.Insert(sach);
													table.addData(sach);
												} catch (Exception ex) {
													Logger.getLogger(QLSPanel.class.getName()).log(Level.SEVERE, null,
															ex);
												}
												break;
											}
											case "Update": {
												bus.Update(sach);
												table.Update(i, sach);
											}
												break;
											}

										} else
											JOptionPane.showMessageDialog(null, "Mã thể loại không được để trống");
									} else
										JOptionPane.showMessageDialog(null, "Mã Nhà Xuất bản không được để trống");
								} else
									JOptionPane.showMessageDialog(null, "Mã Tác giả không được để trống");
							} else
								JOptionPane.showMessageDialog(null, "Mã thể loại không được để trống");
						} else
							JOptionPane.showMessageDialog(null, "Số lượng phải là số và không được để trống");
					} else
						JOptionPane.showMessageDialog(null, "Gía sách phải là số và không để trống");
				} else
					JOptionPane.showMessageDialog(null, "Tên sách không được để trống");
			} else
				JOptionPane.showMessageDialog(null, "Mã sách không được để trống");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void Delete() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách cần xóa");
			return;
		}
		String masach = txMasach.getText();
		int i = table.getSelectedRow();
		sachDTO temp = table.getModel().getSach(i);
		if (!masach.equals(temp.getMasach())) {
			JOptionPane.showMessageDialog(null, "Bạn không thể thay đổi mã sách");
			return;
		}
		sachBUS bus = new sachBUS();
		bus.Delete(temp);
		table.removeData(i); // ?? xóa dss thì sachList cũng bị thay đổi theo
	}

	public void Update() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách cần xóa");
			return;
		}
		String masach = txMasach.getText();
		int i = table.getSelectedRow();
		sachDTO temp = table.getModel().getSach(i);
		if (!masach.equals(temp.getMasach())) {
			JOptionPane.showMessageDialog(null, "Bạn không thể thay đổi mã sách");
			return;
		}
		Insert(i, "Update");
	}
}
