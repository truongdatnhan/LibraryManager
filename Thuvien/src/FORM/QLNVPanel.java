package FORM;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import BUS.nhanvienBUS;
import DTO.nhanvienDTO;
import TOOL.check;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.Color;

public class QLNVPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	private JTextField txManv;
	private JTextField txHo;
	private JTextField txTen;
	private JTextField txDiachi;
	private JTextField txEmail;
	private JTextField txSDT;
	private JTextField txLuong;
	private JTable tbQLNV;
	private DefaultTableModel model;
	private JButton btnThem, btnXoa, btnSua,btnTim;
	private JRadioButton rbNu, rbNam;
	private JDateChooser dateChooser;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public QLNVPanel() throws Exception {
		setBackground(new Color(244, 244, 244));
		setLayout(null);
		nhanvienBUS bus = new nhanvienBUS();
		bus.docDSND();

		JLabel lbManv = new JLabel("Mã nhân viên :");
		lbManv.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbManv.setHorizontalAlignment(SwingConstants.LEFT);
		lbManv.setBounds(50, 30, 120, 25);
		add(lbManv);

		txManv = new JTextField();
		txManv.setBounds(175, 30, 268, 25);
		add(txManv);
		txManv.setColumns(10);

		JLabel lbHo = new JLabel("Họ :");
		lbHo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbHo.setBounds(50, 70, 114, 25);
		add(lbHo);

		txHo = new JTextField();
		txHo.setBounds(175, 70, 92, 25);
		add(txHo);
		txHo.setColumns(10);

		JLabel lbTen = new JLabel("Tên :");
		lbTen.setHorizontalAlignment(SwingConstants.CENTER);
		lbTen.setBounds(270, 71, 50, 25);
		add(lbTen);

		txTen = new JTextField();
		txTen.setBounds(316, 69, 127, 26);
		add(txTen);
		txTen.setColumns(10);

		JLabel lblNgaysinh = new JLabel("Ngày sinh :");
		lblNgaysinh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNgaysinh.setBounds(50, 110, 100, 25);
		add(lblNgaysinh);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(175, 110, 268, 25);
		add(dateChooser);

		JLabel lbGioitinh = new JLabel("Giới tính :");
		lbGioitinh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbGioitinh.setBounds(50, 150, 100, 25);
		add(lbGioitinh);

		rbNam = new JRadioButton("Nam");
		rbNam.setFont(new Font("Calibri", Font.PLAIN, 18));
		rbNam.setHorizontalAlignment(SwingConstants.CENTER);
		rbNam.setBounds(197, 150, 92, 25);
		add(rbNam);

		rbNu = new JRadioButton("Nữ");
		rbNu.setFont(new Font("Calibri", Font.PLAIN, 18));
		rbNu.setHorizontalAlignment(SwingConstants.CENTER);
		rbNu.setBounds(304, 150, 114, 25);
		add(rbNu);

		ButtonGroup groupGioitinh = new ButtonGroup();
		groupGioitinh.add(rbNam);
		groupGioitinh.add(rbNu);

		JLabel lbDiachi = new JLabel("Địa chỉ :");
		lbDiachi.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbDiachi.setBounds(600, 30, 70, 25);
		add(lbDiachi);

		txDiachi = new JTextField();
		txDiachi.setBounds(750, 29, 213, 25);
		add(txDiachi);
		txDiachi.setColumns(10);

		JLabel lbEmail = new JLabel("Email :");
		lbEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbEmail.setBounds(600, 72, 70, 25);
		add(lbEmail);

		txEmail = new JTextField();
		txEmail.setBounds(750, 70, 213, 25);
		add(txEmail);
		txEmail.setColumns(10);

		JLabel lbSDT = new JLabel("Số điện thoại :");
		lbSDT.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbSDT.setBounds(600, 112, 120, 25);
		add(lbSDT);

		txSDT = new JTextField();
		txSDT.setBounds(750, 110, 213, 26);
		add(txSDT);
		txSDT.setColumns(10);

		JLabel lbLuong = new JLabel("Lương :");
		lbLuong.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbLuong.setBounds(600, 152, 70, 25);
		add(lbLuong);

		txLuong = new JTextField();
		txLuong.setBounds(750, 149, 213, 25);
		add(txLuong);
		txLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnThem.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_add_32.png"));
		btnThem.setBounds(110, 206, 150, 30);
		btnThem.addActionListener(this);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnXoa.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_delete_sign_32.png"));
		btnXoa.setBounds(270, 205, 150, 30);
		btnXoa.addActionListener(this);
		add(btnXoa);

		JButton btnTailai = new JButton("Tải lại");
		btnTailai.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTailai.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_synchronize_32.png"));
		btnTailai.setBounds(430, 205, 150, 30);
		add(btnTailai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSua.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_change_32.png"));
		btnSua.setBounds(590, 205, 150, 30);
		btnSua.addActionListener(this);
		add(btnSua);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTim.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_search_32.png"));
		btnTim.setBounds(750, 205, 150, 30);
		btnTim.addActionListener(this);
		add(btnTim);

//		tbQLNV = new JTable();

//		tbQLNV.setModel(new DefaultTableModel(
//				new Object[][] { { null, null, null, null, null, null, null, null, null },
//						{ null, null, null, null, null, null, null, null, null },
//						{ null, null, null, null, null, null, null, null, null },
//						{ null, null, null, null, null, null, null, null, null },
//						{ null, null, null, null, null, null, null, null, null },
//						{ null, null, null, null, null, null, null, null, null },
//						{ null, null, null, null, null, null, null, null, null },
//						{ null, null, null, null, null, null, null, null, null }, },
//				new String[] { "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Email",
//						"Số điện thoại", "Lương" }));
//		scrollPane.setViewportView(tbQLNV);

		Vector<String> header = new Vector<String>();
		header.add("Mã nhân viên");
		header.add("Họ");
		header.add("Tên");
		header.add("Ngày sinh");
		header.add("Giới tính");
		header.add("Địa chỉ");
		header.add("Email");
		header.add("Số điện thoại");
		header.add("Lương");
		model = new DefaultTableModel();

		if (model.getRowCount() == 0) {
			model = new DefaultTableModel(header, 0);
		}
		tbQLNV = new JTable();
		tbQLNV.setModel(model);
		// tbQLNV.setFont(new Font("Calibri", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(tbQLNV);
		scrollPane.setBounds(30, 250, 1050, 250);
		add(scrollPane);
		tbQLNV.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = tbQLNV.getSelectedRow();
				if (i >= 0) {
					nhanvienDTO nv = new nhanvienDTO();
					nv = nhanvienBUS.dsnv.get(i);
					txManv.setText(nv.getManv());
					txHo.setText(nv.getHo());
					txTen.setText(nv.getTen());
					try {
						Date ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse(nv.getNgaysinh());
						dateChooser.setDate(ngaysinh);
						;
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if ("Nam".equals(nv.getGioitinh())) {
						rbNam.setSelected(true);
					} else if ("Nữ".equals(nv.getGioitinh())) {
						rbNu.setSelected(true);
					}
					txDiachi.setText(nv.getDiachi());
					txEmail.setText(nv.getEmail());
					txSDT.setText(nv.getSdt());
					txLuong.setText(nv.getLuong());
				}
			}
		});

		for (nhanvienDTO nv : nhanvienBUS.dsnv) {
			Vector<String> row = new Vector<String>();
			row.add(nv.getManv());
			row.add(nv.getHo());
			row.add(nv.getTen());
			row.add(nv.getNgaysinh());
			row.add(nv.getGioitinh());
			row.add(nv.getDiachi());
			row.add(nv.getEmail());
			row.add(nv.getSdt());
			row.add(nv.getLuong());
			model.addRow(row);

		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getSource() == btnThem) {
			nhanvienBUS bus = new nhanvienBUS();
			nhanvienDTO nv = new nhanvienDTO();
			// kiểm tra xem đã nhập mã nhân viên chưa
			if (check.checkNull(txManv.getText())) {
				JOptionPane.showMessageDialog(null, "Hãy nhập vào mã nhân viên");
			} else {
				// kiểm tra mã nhân viên vừa nhập có đúng định dạng hay không
				if (check.checkID(txManv.getText(), "NV")) {
					int i = 0;
					for (nhanvienDTO temp : nhanvienBUS.dsnv) {
						if (temp.getManv().compareTo(txManv.getText().toUpperCase()) == 0) {
							i++;
							break;
						}
					}
					if (i == 1) {
						JOptionPane.showMessageDialog(null, "Mã nhân viên này đã tồn tại");
					} else {
						nv.setManv(txManv.getText());
						if (!check.checkNull(txHo.getText())) {
							nv.setHo(txHo.getText());
							if (!check.checkNull(txTen.getText())) {
								nv.setTen(txTen.getText());
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								String date = sdf.format(dateChooser.getDate());
								JOptionPane.showMessageDialog(null, date);
								nv.setNgaysinh(date);
								if (rbNam.isSelected()) {
									nv.setGioitinh("Nam");
								} else {
									nv.setGioitinh("Nữ");
								}
								nv.setDiachi(txDiachi.getText());
								if (check.checkEmail(txEmail.getText())) {
									nv.setEmail(txEmail.getText());
									if (check.checkPhone(txSDT.getText())) {
										nv.setSdt(txSDT.getText());
										if (check.isNumeric(txLuong.getText())) {
											nv.setLuong(txLuong.getText());
											Vector<String> row = new Vector<String>();
											row.add(nv.getManv());
											row.add(nv.getHo());
											row.add(nv.getTen());
											row.add(nv.getNgaysinh());
											row.add(nv.getGioitinh());
											row.add(nv.getEmail());
											row.add(nv.getDiachi());
											row.add(nv.getSdt());
											row.add(nv.getLuong());
											model.addRow(row);
											tbQLNV.setModel(model);
											nhanvienBUS.dsnv.add(nv);
											try {
												bus.Insert(nv);
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											txManv.setText(null);
											txHo.setText(null);
											txTen.setText(null);
											dateChooser.setDate(null);
											if (rbNam.isSelected() == true) {
												rbNam.getDisabledSelectedIcon();
											} else {
												rbNu.getDisabledSelectedIcon();
											}
											txDiachi.setText(null);
											txEmail.setText(null);
											txSDT.setText(null);
											txLuong.setText(null);
										} else {
											txLuong.setBorder(BorderFactory.createLineBorder(Color.red));
											JOptionPane.showMessageDialog(null, "Lương phải là số");
										}
									} else {
										txSDT.setBorder(BorderFactory.createLineBorder(Color.red));
										JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
									}
								} else {
									txEmail.setBorder(BorderFactory.createLineBorder(Color.red));
									JOptionPane.showMessageDialog(null, "Email không hợp lệ");
								}
							} else {
								txTen.setBorder(BorderFactory.createLineBorder(Color.red));
								JOptionPane.showMessageDialog(null, "Tên nhân viên không được để trống");
							}
						} else {
							txHo.setBorder(BorderFactory.createLineBorder(Color.red));
							JOptionPane.showMessageDialog(null, "Họ nhân viên không được để trống");
						}
					}
				} else {
					txManv.setBorder(BorderFactory.createLineBorder(Color.red));
					JOptionPane.showMessageDialog(null, "Mã nhân viên phải có dạng ");
				}
			}

		} else if (evt.getSource() == btnXoa) {
			int i = tbQLNV.getSelectedRow();
			nhanvienBUS bus = new nhanvienBUS();
			if (i >= 0) {
				nhanvienDTO nv = bus.dsnv.get(i);
				try {
					bus.Delete(nv);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bus.dsnv.remove(i);
				model.removeRow(i);
				tbQLNV.setModel(model);
			}
		} else if (evt.getSource() == btnSua) {
			int i = tbQLNV.getSelectedRow();
			nhanvienBUS bus = new nhanvienBUS();
			if (i >= 0) {
				nhanvienDTO nv = bus.dsnv.get(i);
				if (!check.checkNull(txHo.getText())) {
					nv.setHo(txHo.getText());
					if (!check.checkNull(txTen.getText())) {
						nv.setTen(txTen.getText());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String date = sdf.format(dateChooser.getDate());
						nv.setNgaysinh(date);
						if (rbNam.isSelected()) {
							nv.setGioitinh("Nam");
						} else {
							nv.setGioitinh("Nữ");
						}
						nv.setDiachi(txDiachi.getText());
						if (check.checkEmail(txEmail.getText())) {
							nv.setEmail(txEmail.getText());
							if (check.checkPhone(txSDT.getText())) {
								nv.setSdt(txSDT.getText());
								if (check.isNumeric(txLuong.getText())) {
									nv.setLuong(txLuong.getText());
									nhanvienBUS.dsnv.add(nv);
									try {
										bus.Update(nv);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} else {
									txLuong.setBorder(BorderFactory.createLineBorder(Color.red));
									JOptionPane.showMessageDialog(null, "Lương phải là số");
								}
							} else {
								txSDT.setBorder(BorderFactory.createLineBorder(Color.red));
								JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
							}
						} else {
							txEmail.setBorder(BorderFactory.createLineBorder(Color.red));
							JOptionPane.showMessageDialog(null, "Email không hợp lệ");
						}
					} else {
						txTen.setBorder(BorderFactory.createLineBorder(Color.red));
						JOptionPane.showMessageDialog(null, "Tên nhân viên không được để trống");
					}
				} else {
					txHo.setBorder(BorderFactory.createLineBorder(Color.red));
					JOptionPane.showMessageDialog(null, "Họ nhân viên không được để trống");
				}

				model.setValueAt(txManv.getText(), i, 0);
				model.setValueAt(txHo.getText(), i, 1);
				model.setValueAt(txTen.getText(), i, 2);
				// model.setValueAt(tx.getText(), i,1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooser.getDate());
				// JOptionPane.showMessageDialog(null, date);
				model.setValueAt(date, i, 3);
				if (rbNam.isSelected()) {
					model.setValueAt("Nam", i, 4);
				} else {
					model.setValueAt("Nữ", i, 4);
				}
				model.setValueAt(txDiachi.getText(), i, 5);
				model.setValueAt(txEmail.getText(), i, 6);
				model.setValueAt(txSDT.getText(), i, 7);
				model.setValueAt(txLuong.getText(), i, 8);

			}
		}else if(evt.getSource()==btnTim) {
			searchNVPanel searchNV = new searchNVPanel();
			searchNV.setVisible(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
