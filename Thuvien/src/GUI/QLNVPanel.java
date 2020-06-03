package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import BUS.nhanvienBUS;
import DTO.nhanvienDTO;
import TOOL.ThongTinEvent;
import TOOL.check;

public class QLNVPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	private JTextField txManv;
	private JTextField txHo;
	private JTextField txTen;
	private JTextField txDiachi;
	private JTextField txEmail;
	private JTextField txSDT;
	private JTextField txLuong;
	private JButton btnThem, btnXoa, btnSua, btnTailai,btnIn;
	private JRadioButton rbNu, rbNam;
	private JDateChooser dateChooser;
	private JTextField txTimkiem;
	private ButtonGroup groupGioitinh;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboThang;
	private JTextField luong1;
	private JTextField luong2;
	private suaTT suaTT;
	public TableNhanVien table;

	public QLNVPanel() throws Exception {
		// set background cho nó
		setBackground(Color.WHITE);
		// set layout cho nó
		setLayout(null);
		// g�?i lớp bus lên
		nhanvienBUS bus = new nhanvienBUS();

		JLabel lbManv = new JLabel("Mã nhân viên :");
		lbManv.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbManv.setHorizontalAlignment(SwingConstants.LEFT);
		lbManv.setBounds(50, 30, 120, 25);
		add(lbManv);

		txManv = new JTextField();
		txManv.setEditable(false);
		txManv.setBounds(175, 30, 372, 25);
		add(txManv);
		txManv.setColumns(10);

		JLabel lbHo = new JLabel("Họ :");
		lbHo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbHo.setBounds(50, 70, 114, 25);
		add(lbHo);

		txHo = new JTextField();
		txHo.setBounds(175, 70, 185, 25);
		add(txHo);
		txHo.setColumns(10);

		JLabel lbTen = new JLabel("Tên :");
		lbTen.setHorizontalAlignment(SwingConstants.CENTER);
		lbTen.setBounds(368, 69, 50, 25);
		add(lbTen);

		txTen = new JTextField();
		txTen.setBounds(420, 71, 127, 26);
		add(txTen);
		txTen.setColumns(10);

		JLabel lblNgaysinh = new JLabel("Ngày sinh :");
		lblNgaysinh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNgaysinh.setBounds(50, 110, 100, 25);
		add(lblNgaysinh);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(175, 110, 372, 25);
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
		rbNu.setBounds(356, 150, 114, 25);
		add(rbNu);

		groupGioitinh = new ButtonGroup();
		groupGioitinh.add(rbNam);
		groupGioitinh.add(rbNu);

		JLabel lbDiachi = new JLabel("Địa chỉ :");
		lbDiachi.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbDiachi.setBounds(624, 30, 70, 25);
		add(lbDiachi);

		txDiachi = new JTextField();
		txDiachi.setBounds(746, 28, 284, 25);
		add(txDiachi);
		txDiachi.setColumns(10);

		JLabel lbEmail = new JLabel("Email :");
		lbEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbEmail.setBounds(624, 70, 70, 25);
		add(lbEmail);

		txEmail = new JTextField();
		txEmail.setBounds(746, 68, 284, 25);
		add(txEmail);
		txEmail.setColumns(10);

		JLabel lbSDT = new JLabel("Số điện thoại :");
		lbSDT.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbSDT.setBounds(624, 110, 120, 25);
		add(lbSDT);

		txSDT = new JTextField();
		txSDT.setBounds(746, 108, 284, 26);
		add(txSDT);
		txSDT.setColumns(10);

		JLabel lbLuong = new JLabel("Lương :");
		lbLuong.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbLuong.setBounds(624, 150, 70, 25);
		add(lbLuong);

		txLuong = new JTextField();
		txLuong.setBounds(746, 148, 284, 25);
		add(txLuong);
		txLuong.setColumns(10);

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
		btnTailai.setBounds(544, 205, 150, 25);
		btnTailai.addActionListener(this);
		add(btnTailai);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnSua.setIcon(new ImageIcon("./icon/icons8_change_32.png"));
		btnSua.setBounds(379, 205, 150, 25);
		btnSua.addActionListener(this);
		add(btnSua);

		table = new TableNhanVien();
		table.setData(bus.getNVList());
		Dimension dm = new Dimension();
		dm = Toolkit.getDefaultToolkit().getScreenSize();
		table.setBounds(5, 295,1050 , 300);
		add(table);
		table.loadData();

		txTimkiem = new JTextField();
		txTimkiem.setBounds(763, 253, 212, 25);
		txTimkiem.addKeyListener(this);
		add(txTimkiem);
		txTimkiem.setColumns(10);

		JButton btnNewButton = new JButton("Xuất Excel");
		btnNewButton.setIcon(new ImageIcon("./icon/icons8_Microsoft_Excel_2019_32.png"));
		btnNewButton.setBounds(715, 204, 150, 25);
		add(btnNewButton);

		comboThang = new JComboBox();
		comboThang.addKeyListener(this);
		comboThang.setModel(new DefaultComboBoxModel(
				new String[] { "--Vui lòng chọn--", "Tháng 1", "Tháng 2 ", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6",
						"Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
		comboThang.setBounds(583, 253, 175, 25);
		add(comboThang);

		JLabel lbThang = new JLabel("Tháng ");
		lbThang.setBounds(528, 253, 50, 25);
		add(lbThang);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "--Vui lòng chọn--", "Mã nhân viên", "Tên nhân viên" }));
		comboBox.setBounds(10, 253, 154, 26);
		add(comboBox);

		luong1 = new JTextField();
		luong1.setBounds(220, 253, 140, 26);
		add(luong1);
		luong1.setColumns(10);

		JLabel lblLng = new JLabel("Lương");
		lblLng.setBounds(173, 253, 50, 25);
		add(lblLng);

		JLabel label = new JLabel("-");
		label.setBounds(370, 260, 56, 16);
		add(label);

		luong2 = new JTextField();
		luong2.setBounds(380, 253, 140, 26);
		add(luong2);

		luong1.addKeyListener(this);
		luong2.addKeyListener(this);

		luong2.setColumns(10);
		
		
		btnIn = new JButton("In");
		btnIn.setIcon(new ImageIcon("./icon/icons8_print_32.png"));
		btnIn.setBounds(880, 204, 150, 25);
		add(btnIn);
		table.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					nhanvienDTO nv = new nhanvienDTO();
					nv = table.getModel().getNV(i);
					txManv.setEditable(true);
					txManv.setText(nv.getManv());

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
			nv.setManv(bus.autoCreateID());
			// kiểm tra h�? nhân viên, h�? nhân viên không được b�? trống
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
								JOptionPane.showMessageDialog(null, "Nhân viên vửa thêm có mà là : " + nv.getManv());
								table.addData(nv);
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
								groupGioitinh.clearSelection();
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
				// báo lỗi h�? nhân viên
				JOptionPane.showMessageDialog(null, "Họ nhân viên không được bỏ trống");
				txManv.requestFocus();
			}
		} else if (evt.getSource() == btnXoa) {
			// lấy giá trị hàng đang được ch�?n
			nhanvienBUS bus = new nhanvienBUS();
			int i = table.getSelectedRow();
			if (i >= 0) {
				nhanvienDTO nv = nhanvienBUS.dsnv.get(i);
				if (JOptionPane.showConfirmDialog(null, "Bạn muốn xóa nhân viên ?", "Confirmation",
						JOptionPane.YES_NO_OPTION) == 0) {
					try {
						bus.Delete(nv);
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, e);
					}
					table.deleteData(nv, i);
					nhanvienBUS.dsnv.remove(nv);
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
				// báo lỗi nếu chưa ch�?n nhân viên
				JOptionPane.showMessageDialog(null, "Bạn chưa ch�?n nhân viên");
			}
		} else if (evt.getSource() == btnSua) {
			int i = table.getSelectedRow();
			nhanvienBUS bus = new nhanvienBUS();
			if (i >= 0) {
				nhanvienDTO nv = nhanvienBUS.dsnv.get(i);
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
									try {
										bus.Update(nv);
									} catch (Exception e) {
										e.printStackTrace();
									}
									table.updateData(nv, i);
									nhanvienBUS.dsnv.set(i, nv);
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
					// báo lỗi học nhân viên
					JOptionPane.showMessageDialog(null, "Họ nhân viên không được bỏ trống");
					txManv.requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Hãy chọn nhân viên muốn sửa");
			}
		} else if (evt.getSource() == btnTailai) {
			// txManv.setEditable(true);
			txManv.setText(null);
			txHo.setText(null);
			txTen.setText(null);
			dateChooser.setDate(null);
			groupGioitinh.clearSelection();
			txDiachi.setText(null);
			txEmail.setText(null);
			txSDT.setText(null);
			txLuong.setText(null);
		}
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub

		DefaultTableModel test = table.getModel();
		String search = txTimkiem.getText().toLowerCase();

		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(test);
		table.setRowSorter(tr);

		RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
			@Override
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				String birth = entry.getStringValue(3);
				String[] data = birth.split("-");
				int thang = Integer.parseInt(data[1]);
				switch (thang) {
				case 1:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 2:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 3:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 4:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 5:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 6:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 7:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 8:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 9:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 10:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 11:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				case 12:
					if (thang == comboThang.getSelectedIndex()) {
						return true;
					}
				}
				return false;
			}

		};

		RowFilter<Object, Object> between = new RowFilter<Object, Object>() {

			@Override
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				int luong = Integer.parseInt(entry.getStringValue(8));

				if ((!luong1.getText().isEmpty()) && (!luong2.getText().isEmpty())) {
					int luongMin = Integer.parseInt(luong1.getText());
					int luongMax = Integer.parseInt(luong2.getText());
					if (luong >= luongMin && luong <= luongMax) {
						return true;
					}
				}

				if (luong1.getText().isEmpty()) {
					if (luong2.getText().isEmpty()) {
						return false;
					} else {
						int luongMax = Integer.parseInt(luong2.getText());
						if (luong >= 0 && luong <= luongMax) {
							return true;
						}
					}
				}

				if (luong2.getText().isEmpty()) {
					if (luong1.getText().isEmpty()) {
						return false;
					} else {
						int luongMin = Integer.parseInt(luong1.getText());
						if (luongMin <= luong) {
							return true;
						}
					}
				}

				return false;
			}

		};

		if (search == null) {
			tr.setRowFilter(null);
		} else {
			switch (comboBox.getSelectedIndex()) {
			case 1:
				tr.setRowFilter(RowFilter.regexFilter("(?i)" + search, 0));
				break;
			case 2:
				tr.setRowFilter(RowFilter.regexFilter("(?i)" + search, 2));
			}
		}
		if (evt.getSource() == comboThang) {
			if (comboThang.getSelectedIndex() != 0) {
				TableRowSorter oldSorter = (TableRowSorter) table.getTable().getRowSorter();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(
						(DefaultTableModel) table.getTable().getModel());
				table.setRowSorter(sorter);
				sorter.setRowFilter(filter);
			}
		}
		tr.setRowFilter(between);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
