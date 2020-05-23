package FORM;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.toedter.calendar.JDateChooser;

import BUS.nhanvienBUS;
import DTO.nhanvienDTO;
import TOOL.check;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
import javax.swing.DefaultComboBoxModel;

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
	private JButton btnThem, btnXoa, btnSua, btnTailai;
	private JRadioButton rbNu, rbNam;
	private JDateChooser dateChooser;
	private JTextField txTimkiem;
	private JComboBox<String> comboBox;

	public QLNVPanel() throws Exception {
		setBackground(Color.WHITE);
		setLayout(null);
		nhanvienBUS bus = new nhanvienBUS();

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
		lbDiachi.setBounds(561, 30, 70, 25);
		add(lbDiachi);

		txDiachi = new JTextField();
		txDiachi.setBounds(716, 28, 213, 25);
		add(txDiachi);
		txDiachi.setColumns(10);

		JLabel lbEmail = new JLabel("Email :");
		lbEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbEmail.setBounds(561, 70, 70, 25);
		add(lbEmail);

		txEmail = new JTextField();
		txEmail.setBounds(716, 68, 213, 25);
		add(txEmail);
		txEmail.setColumns(10);

		JLabel lbSDT = new JLabel("Số điện thoại :");
		lbSDT.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbSDT.setBounds(561, 110, 120, 25);
		add(lbSDT);

		txSDT = new JTextField();
		txSDT.setBounds(716, 108, 213, 26);
		add(txSDT);
		txSDT.setColumns(10);

		JLabel lbLuong = new JLabel("Lương :");
		lbLuong.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbLuong.setBounds(561, 150, 70, 25);
		add(lbLuong);

		txLuong = new JTextField();
		txLuong.setBounds(716, 148, 213, 25);
		add(txLuong);
		txLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Calibri", Font.PLAIN, 17));
		btnThem.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_add_32.png"));
		btnThem.setBounds(50, 206, 150, 25);
		btnThem.addActionListener(this);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnXoa.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_delete_sign_32.png"));
		btnXoa.setBounds(204, 205, 150, 25);
		btnXoa.addActionListener(this);
		add(btnXoa);

		btnTailai = new JButton("Tải lại");
		btnTailai.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTailai.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_synchronize_32.png"));
		btnTailai.setBounds(509, 205, 150, 25);
		btnTailai.addActionListener(this);
		add(btnTailai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSua.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_change_32.png"));
		btnSua.setBounds(357, 205, 150, 25);
		btnSua.addActionListener(this);
		add(btnSua);

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
		model = bus.docDSND();

		if (model.getRowCount() == 0) {
			model = new DefaultTableModel(header, 0);
		}
		// tbQLNV.setEnabled(true);
		tbQLNV = new JTable();
		tbQLNV.setModel(model);
		// tbQLNV.setFont(new Font("Calibri", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(tbQLNV);
		scrollPane.setBounds(10, 295, 970, 300);
		add(scrollPane);

		txTimkiem = new JTextField();
		txTimkiem.setBounds(712, 252, 217, 30);
		txTimkiem.addKeyListener(this);
		add(txTimkiem);
		txTimkiem.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Mã nhân viên", "Tên nhân viên" }));
		comboBox.setBounds(547, 256, 150, 26);
		add(comboBox);

		JButton btnNewButton = new JButton("Xuất Excel");
		btnNewButton.setIcon(
				new ImageIcon("D:\\Program Files\\Eclipse\\Thuvien\\icon\\icons8_Microsoft_Excel_2019_32.png"));
		btnNewButton.setBounds(662, 205, 150, 25);
		add(btnNewButton);
		tbQLNV.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = tbQLNV.getSelectedRow();
				if (i >= 0) {
					nhanvienDTO nv = new nhanvienDTO();
					nv = nhanvienBUS.dsnv.get(i);
					txManv.setText(nv.getManv());
					txManv.setEditable(false);
					txHo.setText(nv.getHo());
					txTen.setText(nv.getTen());
					try {
						Date ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse(nv.getNgaysinh());
						dateChooser.setDate(ngaysinh);
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
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnThem) {
			nhanvienBUS bus = new nhanvienBUS();
			nhanvienDTO nv = new nhanvienDTO();
			// đây là mã nhân viên không có null
			// kiểm tra mã nhân viên có null hay không
			if (!check.checkNull(txManv.getText())) {
				// kiểm tra mã nhân viên có đúng định dạng hay không
				if (check.checkID(txManv.getText(), "NV")) {
					// kiểm tra mã nhân viên đã tồn tại chưa
					if (!bus.checkID(txManv.getText())) {
						// nếu mã nhân viên thỏa cách điều kiện trên thì set giá trị mã cho nhân viên
						nv.setManv(txManv.getText());
						// kiểm tra họ nhân viên, họ nhân viên không được bỏ trống
						if (!check.checkNull(txHo.getText())) {
							// nếu đúng thực hiện gán giá tri
							nv.setHo(txHo.getText());
							// kiểm tra tên nhân viên
							if (!check.checkNull(txTen.getText())) {
								// gán giá trị cho tên nhân viên
								nv.setTen(txTen.getText());
								// định dạng cấu trúc hiển thị co ngày
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								String date = sdf.format(dateChooser.getDate());
								JOptionPane.showMessageDialog(null, date);
								// gán giá trị ngày sinh cho nhân viên
								nv.setNgaysinh(date);
								// gán giá trị giới tính cho nhân viên
								if (rbNam.isSelected()) {
									nv.setGioitinh("Nam");
								} else {
									nv.setGioitinh("Nữ");
								}
								// gán giá trị địa chỉ cho nhân viên
								nv.setDiachi(txDiachi.getText());
								// thực hiện kiểm tra tính hợp lệ của email
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
											row.add(nv.getDiachi());
											row.add(nv.getEmail());
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
											JOptionPane.showMessageDialog(null, "Lương là số");
										}
									} else {
										JOptionPane.showMessageDialog(null, "Số điệnt hoại này không hợp lệ");
									}
								} else {
									// báo lỗi nếu email không đúng định dạng
									JOptionPane.showMessageDialog(null, "Email này không hợp lệ");
								}
							} else {
								// báo lỗi tên nhân viên
								JOptionPane.showMessageDialog(null, "Tên nhân viên không được bỏ trống");
							}
						} else {
							// báo lỗi họ nhân viên
							JOptionPane.showMessageDialog(null, "Họ nhân viên không được bỏ trống");
							txManv.requestFocus();
						}
					}
				} else {
					// báo lỗi mã nhân viên không hợp lệ
					JOptionPane.showMessageDialog(null, "Mã nhân viên phải có dạng NV + số");
				}
			} else {
				// báo lỗi mã nhân viên trống
				JOptionPane.showMessageDialog(null, "Hãy nhập vào mã nhân viên");
			}
		} else if (evt.getSource() == btnXoa) {
			// lấy giá trị hàng đang được chọn
			int i = tbQLNV.getSelectedRow();
			if (i >= 0) {
				nhanvienBUS bus = new nhanvienBUS();
				nhanvienDTO nv = nhanvienBUS.dsnv.get(i);
				if (JOptionPane.showConfirmDialog(null, "Bạn muốn xóa nhân viên ?", "Confirmation",
						JOptionPane.YES_NO_OPTION) == 0) {
					try {
						bus.Delete(nv);
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e);
					}
					model.removeRow(i);
					tbQLNV.setModel(model);
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
				}
			} else {
				// báo lỗi nếu chưa chọn nhân viên
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên");
			}
		} else if (evt.getSource() == btnSua) {

		} else if (evt.getSource() == btnTailai) {
			txManv.setEditable(true);
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
		}
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// System.out.println(evt.getKeyCode());

	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		DefaultTableModel table = (DefaultTableModel) tbQLNV.getModel();
		String search = txTimkiem.getText().toLowerCase();

		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
		tbQLNV.setRowSorter(tr);
		if (search == null) {
			tr.setRowFilter(null);
		} else {
			String select = (String) comboBox.getSelectedItem();
			

			if (select.equals("Mã nhân viên"))
				tr.setRowFilter(RowFilter.regexFilter("(?i)" + search, 0));
			else {
				if (select.equals("Tên nhân viên")) {
					tr.setRowFilter(RowFilter.regexFilter("(?i)" + search, 2));
				}
			}
		}
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
		// TODO Auto-generated method stubQLNV.

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