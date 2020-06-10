package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import com.toedter.calendar.JDateChooser;

import BUS.ctpmBUS;
import BUS.phieumuonBUS;
import DTO.ctpmDTO;
import DTO.phieumuonDTO;
import TOOL.check;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class QLPMPanel extends JPanel implements ActionListener,KeyListener,PropertyChangeListener {
	private JTextField txMapm;
	private JTextField txManv;
	private JTextField txMathe;
	private JTextField txMsach;
	private JTextField txSoluong;
	private tablePM table;
	private JButton btnThemPM, btnXoaPM, btnSuaPM, btnTaiLaiPM, btnThemCTPM, btnXoaCTPM, btnTailaiCTPM, btnSuaCTPM;
	private JDateChooser dateNgaymuon, dateNgayquydinhtra, dateNgaytra,findStartDate,findEndDate;
	private tableCTPM tableCTP;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdDaTra, rdChuaTra;
	private check check;
	private JTextField txFindPM;
	private JTextField txFindNV;
	private JTextField txFindMT;
	private JComboBox comboFindThang;

	public QLPMPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		check = new check();

		JLabel lbMaHD = new JLabel("Mã phiếu mượn");
		lbMaHD.setBounds(541, 30, 99, 25);
		add(lbMaHD);

		txMapm = new JTextField();
		txMapm.setEditable(false);
		txMapm.setBounds(675, 29, 191, 25);
		add(txMapm);
		txMapm.setColumns(10);

		JLabel lbManv = new JLabel("Mã nhân viên");
		lbManv.setBounds(541, 71, 99, 25);
		add(lbManv);

		txManv = new JTextField();
		txManv.setBounds(675, 70, 163, 26);
		add(txManv);
		txManv.setColumns(10);

		JButton btnNewButton = new JButton("...");
		btnNewButton.setBounds(841, 70, 25, 25);
		add(btnNewButton);

		JLabel lbMathe = new JLabel("Mã thẻ");
		lbMathe.setBounds(541, 112, 69, 25);
		add(lbMathe);

		txMathe = new JTextField();
		txMathe.setBounds(675, 109, 163, 26);
		add(txMathe);
		txMathe.setColumns(10);

		JButton btnNewButton_1 = new JButton("...");
		btnNewButton_1.setBounds(841, 110, 25, 25);
		add(btnNewButton_1);

		JLabel lbPhieumuon = new JLabel("Ngày mượn");
		lbPhieumuon.setBounds(541, 151, 99, 25);
		add(lbPhieumuon);

		dateNgaymuon = new JDateChooser();
		dateNgaymuon.setDateFormatString("yyyy-MM-dd");
		dateNgaymuon.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateNgaymuon.setBounds(675, 151, 191, 26);
		add(dateNgaymuon);

		JLabel lbNgayquydinhtra = new JLabel("Ngày quy định trả");
		lbNgayquydinhtra.setBounds(541, 194, 143, 25);
		add(lbNgayquydinhtra);

		dateNgayquydinhtra = new JDateChooser();
		dateNgayquydinhtra.setDateFormatString("yyyy-MM-dd");
		dateNgayquydinhtra.setBounds(675, 193, 191, 26);
		add(dateNgayquydinhtra);

		JLabel lbMasach = new JLabel("Mã sách ");
		lbMasach.setBounds(40, 305, 99, 25);
		add(lbMasach);

		txMsach = new JTextField();
		txMsach.setBounds(180, 304, 250, 26);
		add(txMsach);
		txMsach.setColumns(10);

		btnThemCTPM = new JButton("Thêm");
		btnThemCTPM.setBounds(40, 467, 183, 29);
		btnThemCTPM.addActionListener(this);
		add(btnThemCTPM);

		btnXoaCTPM = new JButton("Xóa");
		btnXoaCTPM.addActionListener(this);
		btnXoaCTPM.setBounds(238, 467, 192, 29);
		btnXoaCTPM.addActionListener(this);
		add(btnXoaCTPM);

		btnTailaiCTPM = new JButton("Tải lại");
		btnTailaiCTPM.setBounds(40, 512, 183, 29);
		btnTailaiCTPM.addActionListener(this);
		add(btnTailaiCTPM);

		btnSuaCTPM = new JButton("Sưa");
		btnSuaCTPM.addActionListener(this);
		btnSuaCTPM.setBounds(238, 512, 192, 29);
		add(btnSuaCTPM);

		JLabel lbSoluong = new JLabel("Số lượng");
		lbSoluong.setBounds(40, 346, 69, 20);
		add(lbSoluong);

		txSoluong = new JTextField();
		txSoluong.setBounds(180, 343, 250, 26);
		add(txSoluong);
		txSoluong.setColumns(10);

		JLabel lbTinhTrang = new JLabel("Tình trạng");
		lbTinhTrang.setBounds(40, 382, 79, 20);
		add(lbTinhTrang);

		rdDaTra = new JRadioButton("Đã trả");
		buttonGroup.add(rdDaTra);
		rdDaTra.setBounds(180, 381, 84, 29);
		rdDaTra.setActionCommand("Đã trả");
		add(rdDaTra);

		rdChuaTra = new JRadioButton("Chưa trả");
		buttonGroup.add(rdChuaTra);
		rdChuaTra.setBounds(331, 378, 99, 29);
		rdChuaTra.setActionCommand("Chưa trả");
		add(rdChuaTra);

		JLabel lbNgaythuctra = new JLabel("Ngày thực trả");
		lbNgaythuctra.setBounds(40, 418, 99, 20);
		add(lbNgaythuctra);

		dateNgaytra = new JDateChooser();
		dateNgaytra.setDateFormatString("yyyy-MM-dd");
		dateNgaytra.setBounds(180, 419, 250, 26);
		add(dateNgaytra);
		phieumuonBUS bus = new phieumuonBUS();

		tableCTP = new tableCTPM();
		tableCTP.setBounds(477, 290, 555, 302);

		add(tableCTP);

		table = new tablePM();
		table.setBounds(15, 16, 511, 258);
		try {
			table.setData(bus.getPMList());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		add(table);

		btnThemPM = new JButton("Thêm");
		btnThemPM.setBounds(886, 30, 97, 25);
		add(btnThemPM);

		btnXoaPM = new JButton("Xoá");
		btnXoaPM.setBounds(886, 71, 97, 25);
		add(btnXoaPM);

		btnSuaPM = new JButton("Sửa");
		btnSuaPM.setBounds(886, 112, 97, 25);
		add(btnSuaPM);

		btnTaiLaiPM = new JButton("Tải lại");
		btnTaiLaiPM.setBounds(886, 151, 97, 25);
		add(btnTaiLaiPM);

		btnThemPM.addActionListener(this);
		btnXoaPM.addActionListener(this);
		btnSuaPM.addActionListener(this);
		btnTaiLaiPM.addActionListener(this);
		
		JLabel lbFindPM = new JLabel("Mã Phiếu mượn :");
		lbFindPM.setBounds(541, 246, 99, 25);
		add(lbFindPM);
		
		txFindPM = new JTextField();
		txFindPM.setBounds(652, 245, 69, 26);
		add(txFindPM);
		txFindPM.setColumns(10);
		txFindPM.addKeyListener(this);
		
		JLabel lbFindNV = new JLabel("Mã nhân viên :");
		lbFindNV.setBounds(733, 246, 97, 25);
		add(lbFindNV);
		
		txFindNV = new JTextField();
		txFindNV.setBounds(825, 245, 67, 26);
		add(txFindNV);
		txFindNV.setColumns(10);
		txFindNV.addKeyListener(this);
		
		JLabel lbFindMT = new JLabel("Mã thẻ :");
		lbFindMT.setBounds(900, 246, 56, 25);
		add(lbFindMT);
		
		txFindMT = new JTextField();
		txFindMT.setBounds(955, 245, 69, 26);
		add(txFindMT);
		txFindMT.setColumns(10);
		txFindMT.addKeyListener(this);
		
		findStartDate = new JDateChooser();
		findStartDate.setBounds(40, 557, 183, 29);
		add(findStartDate);
		findStartDate.addPropertyChangeListener(this);
		
		findEndDate = new JDateChooser();
		findEndDate.setBounds(238, 557, 192, 29);
		add(findEndDate);
		findEndDate.addPropertyChangeListener(this);
		
		comboFindThang = new JComboBox();
		comboFindThang.setModel(new DefaultComboBoxModel(new String[] {"--Vui lòng chọn--", "Ngày mượn", "Ngày quy định trả"}));
		comboFindThang.setBounds(1031, 207, 143, 22);
		add(comboFindThang);

		table.loadData();
		table.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getTable().getSelectedRow();
				phieumuonDTO pm = phieumuonBUS.dspm.get(i);

				txMapm.setText(pm.getMapm());
				txManv.setText(pm.getManv());
				txMathe.setText(pm.getMathe());
				try {
					dateNgaymuon.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(pm.getNgaymuon()));
					dateNgayquydinhtra.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(pm.getNgayquidinhtra()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ctpmBUS bus = new ctpmBUS();

				if (i >= 0) {
					tableCTP.setData(bus.getNVList(pm.getMapm()));
					tableCTP.loadData();
				}

			}
		});

		tableCTP.getTable().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableCTP.getTable().getSelectedRow();
				ctpmBUS bus = new ctpmBUS();
				ctpmDTO ct = bus.getNVList(txMapm.getText()).get(i);

				txMsach.setText(ct.getMasach());
				txSoluong.setText(String.valueOf(ct.getSoluong()));
				if ("Đã trả".equals(ct.getTinhtrang())) {
					rdDaTra.setSelected(true);
				} else {
					rdChuaTra.setSelected(true);
				}
				try {
					if (!(ct.getNgaythuctra() == null)) {
						dateNgaytra.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ct.getNgaythuctra()));
					} else {
						dateNgaytra.setDate(null);
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnThemPM) {
			if (check.checkID(txManv.getText(), "NV")) {
				if (check.checkID(txMathe.getText(), "TTV")) {
					if (check.checkDate((String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgaymuon.getDate()))) {
						String dateMuon = (String) new SimpleDateFormat("yyyy-MM-dd").format(dateNgaymuon.getDate());
						if (check.checkDate(
								(String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgayquydinhtra.getDate()))) {
							String dateTra = (String) new SimpleDateFormat("yyyy-MM-dd")
									.format(dateNgayquydinhtra.getDate());
							phieumuonBUS busPM = new phieumuonBUS();

							phieumuonDTO pm = null;
							try {
								pm = new phieumuonDTO(busPM.autoCreateID(), txManv.getText(), txMathe.getText(),
										dateMuon, dateTra);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							try {
								if (pm == null) {
									System.out.println("Lỗi quá trình thêm");
								}
								busPM.Insert(pm);
								table.addData(pm);
								table.setData(busPM.getPMList());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}

		}

		if (evt.getSource() == btnSuaPM) {
			int i = table.getTable().getSelectedRow();
			if (i >= 0) {
				phieumuonBUS busPM = new phieumuonBUS();
				if (check.checkID(txManv.getText(), "NV")) {
					if (check.checkID(txMathe.getText(), "TTV")) {
						if (check.checkDate(
								(String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgaymuon.getDate()))) {
							String dateMuon = (String) new SimpleDateFormat("yyyy-MM-dd")
									.format(dateNgaymuon.getDate());
							if (check.checkDate(
									(String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgayquydinhtra.getDate()))) {
								String dateTra = (String) new SimpleDateFormat("yyyy-MM-dd")
										.format(dateNgayquydinhtra.getDate());
								phieumuonDTO pm = new phieumuonDTO(txMapm.getText(), txManv.getText(),
										txMathe.getText(), dateMuon, dateTra);

								try {
									busPM.Update(pm);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								table.updateData(pm, i);
								try {
									table.setData(busPM.getPMList());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}

			}
		}
		if (evt.getSource() == btnThemCTPM) {
			int i = table.getTable().getSelectedRow();
			if (i >= 0) {
				if (!txMapm.getText().isEmpty()) {
					ctpmBUS bus = new ctpmBUS();
					if (check.checkID(txMsach.getText(), "S")) {
						if (check.isNumeric(txSoluong.getText())) {
							if (rdChuaTra.isSelected() || rdDaTra.isSelected()) {
								String dateTra = (String) new SimpleDateFormat("dd-MM-yyyy")
										.format(dateNgaytra.getDate());
								if (check.checkDate(dateTra)) {
									dateTra = (String) new SimpleDateFormat("yyyy-MM-dd").format(dateNgaytra.getDate());
									ctpmDTO ctpm = new ctpmDTO();
									ctpm.setMapm(txMapm.getText());
									ctpm.setMasach(txMsach.getText());
									ctpm.setNgaythuctra(dateTra);
									ctpm.setSoluong(Integer.parseInt(txSoluong.getText()));
									ctpm.setTinhtrang((String) buttonGroup.getSelection().getActionCommand());

									tableCTP.addData(ctpm);
									bus.insert(ctpm);
								}
							}
						}
					}
				}
			}
		}

		if (evt.getSource() == btnXoaCTPM) {
			int i = tableCTP.getTable().getSelectedRow();
			if (i >= 0) {
				ctpmBUS bus = new ctpmBUS();
				String dateTra = (String) new SimpleDateFormat("yyyy-MM-dd").format(dateNgaytra.getDate());
				ctpmDTO ctpm = new ctpmDTO();
				ctpm.setMapm(txMapm.getText());
				ctpm.setMasach(txMsach.getText());
				ctpm.setNgaythuctra(dateTra);
				ctpm.setSoluong(Integer.parseInt(txSoluong.getText()));
				ctpm.setTinhtrang((String) buttonGroup.getSelection().getActionCommand());
				System.out.println(i);
				tableCTP.deleteRow(i);
				try {
					bus.delete(ctpm);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		if (evt.getSource() == btnSuaCTPM) {
			ctpmBUS bus = new ctpmBUS();
			String dateTra = (String) new SimpleDateFormat("yyyy-MM-dd").format(dateNgaytra.getDate());
			ctpmDTO ctpm = new ctpmDTO();
			ctpm.setMapm(txMapm.getText());
			ctpm.setMasach(txMsach.getText());
			ctpm.setNgaythuctra(dateTra);
			ctpm.setSoluong(Integer.parseInt(txSoluong.getText()));
			ctpm.setTinhtrang((String) buttonGroup.getSelection().getActionCommand());

			tableCTP.updateData(ctpm);
			try {
				bus.update(ctpm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		RowFilter<Object,Object> dateFilter = new RowFilter<Object, Object>() {
			@Override
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				if(comboFindThang.getSelectedIndex() == 1) {
					LocalDate d1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findStartDate.getDate()));
					LocalDate d2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findEndDate.getDate()));
					LocalDate d3 = LocalDate.parse(entry.getStringValue(3));
					Period period = Period.between(d1, d2);
					int diff = period.getDays();
					
					Period periodActual = Period.between(d3, d2);
					int diffActual = periodActual.getDays();
					
					if(diffActual <= diff) {
						return true;
					}
				}
				if(comboFindThang.getSelectedIndex() == 2) {
					LocalDate d1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findStartDate.getDate()));
					LocalDate d2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findEndDate.getDate()));
					LocalDate d3 = LocalDate.parse(entry.getStringValue(4));
					Period period = Period.between(d1, d2);
					int diff = period.getDays();
					
					Period periodActual = Period.between(d3, d2);
					int diffActual = periodActual.getDays();
					
					if(diffActual <= diff) {
						return true;
					}
				}
				return false;
			}
			
		};
		
		ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
		filters.add(RowFilter.regexFilter("(?i)" + txFindPM.getText().toLowerCase(), 0));
		filters.add(RowFilter.regexFilter("(?i)" + txFindNV.getText().toLowerCase(), 1));
		filters.add(RowFilter.regexFilter("(?i)" + txFindMT.getText().toLowerCase(), 2));
		//filters.add(dateFilter);
		RowFilter rf = RowFilter.andFilter(filters);
		
		
		if(txFindPM.getText().isEmpty() && txFindNV.getText().isEmpty() && txFindMT.getText().isEmpty()) {
			table.getTr().setRowFilter(null);
		} else {
			table.getTr().setRowFilter(rf);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		RowFilter<Object,Object> dateFilter = new RowFilter<Object, Object>() {
			@Override
			public boolean include(Entry<? extends Object, ? extends Object> entry) {
				if(comboFindThang.getSelectedIndex() == 1) {
					LocalDate d1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findStartDate.getDate()));
					LocalDate d2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findEndDate.getDate()));
					LocalDate d3 = LocalDate.parse(entry.getStringValue(3));
					Period period = Period.between(d1, d2);
					int diff = period.getDays();
					
					Period periodActual = Period.between(d3, d2);
					int diffActual = periodActual.getDays();
					if(diffActual >=0) {
						if(diffActual <= diff) {
							return true;
						}
					}
				}
				if(comboFindThang.getSelectedIndex() == 2) {
					LocalDate d1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findStartDate.getDate()));
					LocalDate d2 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(findEndDate.getDate()));
					LocalDate d3 = LocalDate.parse(entry.getStringValue(4));
					Period period = Period.between(d1, d2);
					int diff = period.getDays();
					
					Period periodActual = Period.between(d3, d2);
					int diffActual = periodActual.getDays();
					if(diffActual >=0) {
						if(diffActual <= diff) {
							return true;
						}
					}	
				}
				return false;
			}
			
		};
		
		ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
		filters.add(RowFilter.regexFilter("(?i)" + txFindPM.getText().toLowerCase(), 0));
		filters.add(RowFilter.regexFilter("(?i)" + txFindNV.getText().toLowerCase(), 1));
		filters.add(RowFilter.regexFilter("(?i)" + txFindMT.getText().toLowerCase(), 2));
		filters.add(dateFilter);
		RowFilter rf = RowFilter.andFilter(filters);
		
		
		if(txFindPM.getText().isEmpty() && txFindNV.getText().isEmpty() && txFindMT.getText().isEmpty()) {
			table.getTr().setRowFilter(null);
		} else {
			table.getTr().setRowFilter(rf);
		}
		
	}
}
