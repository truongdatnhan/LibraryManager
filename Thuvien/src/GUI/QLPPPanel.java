package GUI;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
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

public class QLPPPanel extends JPanel implements ActionListener,KeyListener,PropertyChangeListener {
	private JTextField txMaPP;
	private JTextField txMaPM;
	private JTextField txTongTien;
	private tablePP table;
	private JButton btnThemPP, btnXoaPP, btnSuaPP, btnTailaiPP;
	private JButton btnThemCTPP, btnXoaCTPP, btnTailaiCTPP, btnSuaCTPP;
	private JDateChooser dateNgayLap,findStartDate,findEndDate;
	private check check;
	private JTextField txFindPM;
	private JTextField txFindNV;
	private JTextField txFindMT;
	private tableCTPP tableCTPP;
	private JTextField txMsach, txSoluong;
	private JTextField txMaqd;
	private JLabel lbThanhtien;
	private JTextField textField;
	private JLabel lblT;
	private JLabel lbln;
	
	public QLPPPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		check = new check();

		JLabel lbMaPP = new JLabel("Mã phiếu phạt");
		lbMaPP.setBounds(554, 17, 99, 25);
		add(lbMaPP);

		txMaPP = new JTextField();
		txMaPP.setEditable(false);
		txMaPP.setBounds(688, 16, 191, 25);
		add(txMaPP);
		txMaPP.setColumns(10);

		JLabel lbMaPM = new JLabel("Mã phiếu mượn");
		lbMaPM.setBounds(554, 58, 99, 25);
		add(lbMaPM);

		txMaPM = new JTextField();
		txMaPM.setBounds(688, 57, 163, 26);
		add(txMaPM);
		txMaPM.setColumns(10);

		JButton btnNewButton = new JButton("...");
		btnNewButton.setBounds(854, 57, 25, 25);
		add(btnNewButton);

		JLabel lbTongTien = new JLabel("Tổng tiền");
		lbTongTien.setBounds(554, 99, 69, 25);
		add(lbTongTien);

		txTongTien = new JTextField();
		txTongTien.setBounds(688, 96, 163, 26);
		add(txTongTien);
		txTongTien.setColumns(10);

		JButton btnNewButton_1 = new JButton("...");
		btnNewButton_1.setBounds(854, 97, 25, 25);
		add(btnNewButton_1);

		JLabel lbNgayLap = new JLabel("Ngày lập");
		lbNgayLap.setBounds(554, 138, 99, 25);
		add(lbNgayLap);

		dateNgayLap = new JDateChooser();
		dateNgayLap.setDateFormatString("yyyy-MM-dd");
		dateNgayLap.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateNgayLap.setBounds(688, 138, 191, 26);
		add(dateNgayLap);


		//phieuphatBUS bus = new phieuphatBUS();

		table = new tablePP();
		//table.setData(list);
        //table.loadData();
        table.setFont(new Font("Calibri", Font.PLAIN, 18));
        table.setBounds(15, 16, 511, 258);
        add(table);

		btnThemPP = new JButton("Thêm");
		btnThemPP.setBounds(899, 17, 97, 25);
		add(btnThemPP);

		btnXoaPP = new JButton("Xoá");
		btnXoaPP.setBounds(899, 58, 97, 25);
		add(btnXoaPP);

		btnSuaPP = new JButton("Sửa");
		btnSuaPP.setBounds(899, 99, 97, 25);
		add(btnSuaPP);

		btnTailaiPP = new JButton("Tải lại");
		btnTailaiPP.setBounds(899, 138, 97, 25);
		add(btnTailaiPP);

		btnThemPP.addActionListener(this);
		btnXoaPP.addActionListener(this);
		btnSuaPP.addActionListener(this);
		btnTailaiPP.addActionListener(this);
		
		JLabel lbFindPM = new JLabel("Mã Phiếu mượn :");
		lbFindPM.setBounds(554, 178, 99, 25);
		add(lbFindPM);
		
		txFindPM = new JTextField();
		txFindPM.setBounds(665, 177, 69, 26);
		add(txFindPM);
		txFindPM.setColumns(10);
		txFindPM.addKeyListener(this);
		
		JLabel lbFindNV = new JLabel("Mã nhân viên :");
		lbFindNV.setBounds(746, 178, 97, 25);
		add(lbFindNV);
		
		txFindNV = new JTextField();
		txFindNV.setBounds(838, 177, 67, 26);
		add(txFindNV);
		txFindNV.setColumns(10);
		txFindNV.addKeyListener(this);
		
		JLabel lbFindMT = new JLabel("Mã thẻ :");
		lbFindMT.setBounds(913, 178, 56, 25);
		add(lbFindMT);
		
		txFindMT = new JTextField();
		txFindMT.setBounds(968, 177, 56, 26);
		add(txFindMT);
		txFindMT.setColumns(10);
		txFindMT.addKeyListener(this);
		
		findStartDate = new JDateChooser();
		findStartDate.setBounds(593, 234, 183, 29);
		add(findStartDate);
		findStartDate.addPropertyChangeListener(this);
		
		findEndDate = new JDateChooser();
		findEndDate.setBounds(832, 234, 192, 29);
		add(findEndDate);
		findEndDate.addPropertyChangeListener(this);
		
		tableCTPP = new tableCTPP();
		tableCTPP.setBounds(477, 290, 555, 302);
		add(tableCTPP);

		btnThemCTPP = new JButton("Thêm");
		btnThemCTPP.setBounds(40, 467, 183, 29);
		btnThemCTPP.addActionListener(this);
		add(btnThemCTPP);

		btnXoaCTPP = new JButton("Xóa");
		btnXoaCTPP.addActionListener(this);
		btnXoaCTPP.setBounds(238, 467, 192, 29);
		btnXoaCTPP.addActionListener(this);
		add(btnXoaCTPP);

		btnTailaiCTPP = new JButton("Tải lại");
		btnTailaiCTPP.setBounds(40, 512, 183, 29);
		btnTailaiCTPP.addActionListener(this);
		add(btnTailaiCTPP);

		btnSuaCTPP = new JButton("Sửa");
		btnSuaCTPP.addActionListener(this);
		btnSuaCTPP.setBounds(238, 512, 192, 29);
		add(btnSuaCTPP);
		
		JLabel lbMasach = new JLabel("Mã sách :");
		lbMasach.setBounds(40, 305, 99, 25);
		add(lbMasach);

		txMsach = new JTextField(10);
		txMsach.setBounds(180, 305, 250, 26);
		add(txMsach);
		
		JLabel lbSoluong = new JLabel("Số lượng :");
		lbSoluong.setBounds(40, 345, 69, 20);
		add(lbSoluong);

		txSoluong = new JTextField(10);
		txSoluong.setBounds(180, 345, 250, 26);
		add(txSoluong);
		
		JLabel lbMaqd = new JLabel("Mã quy định :");
		lbMaqd.setBounds(40, 385, 90, 16);
		add(lbMaqd);
		
		txMaqd = new JTextField();
		txMaqd.setBounds(180, 385, 222, 25);
		add(txMaqd);
		txMaqd.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("...");
		btnNewButton_2.setBounds(406, 385, 25, 25);
		add(btnNewButton_2);
		
		lbThanhtien = new JLabel("Thành tiền :");
		lbThanhtien.setBounds(40, 425, 90, 16);
		add(lbThanhtien);
		
		textField = new JTextField();
		textField.setBounds(180, 425, 250, 25);
		add(textField);
		textField.setColumns(10);
		
		lblT = new JLabel("Từ :");
		lblT.setBounds(554, 234, 56, 25);
		add(lblT);
		
		lbln = new JLabel("Đến :");
		lbln.setBounds(795, 234, 56, 25);
		add(lbln);
		
		//table.loadData();
		table.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*int i = table.getTable().getSelectedRow();
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
*/
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnThemPP) {
			if (check.checkID(txMaPM.getText(), "NV")) {
				if (check.checkID(txTongTien.getText(), "TTV")) {
					if (check.checkDate((String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgayLap.getDate()))) {
						String dateMuon = (String) new SimpleDateFormat("yyyy-MM-dd").format(dateNgayLap.getDate());
						if (check.checkDate(
								(String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgayquydinhtra.getDate()))) {
							String dateTra = (String) new SimpleDateFormat("yyyy-MM-dd")
									.format(dateNgayquydinhtra.getDate());
							phieumuonBUS busPM = new phieumuonBUS();

							phieumuonDTO pm = null;
							try {
								pm = new phieumuonDTO(busPM.autoCreateID(), txMaPM.getText(), txTongTien.getText(),
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

		if (evt.getSource() == btnSuaPP) {
			int i = table.getTable().getSelectedRow();
			if (i >= 0) {
				phieumuonBUS busPM = new phieumuonBUS();
				if (check.checkID(txMaPM.getText(), "NV")) {
					if (check.checkID(txTongTien.getText(), "TTV")) {
						if (check.checkDate(
								(String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgayLap.getDate()))) {
							String dateMuon = (String) new SimpleDateFormat("yyyy-MM-dd")
									.format(dateNgayLap.getDate());
							if (check.checkDate(
									(String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgayquydinhtra.getDate()))) {
								String dateTra = (String) new SimpleDateFormat("yyyy-MM-dd")
										.format(dateNgayquydinhtra.getDate());
								phieumuonDTO pm = new phieumuonDTO(txMaPP.getText(), txMaPM.getText(),
										txTongTien.getText(), dateMuon, dateTra);

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
		
		if(evt.getSource() == btnTailaiPP) {
			phieumuonBUS bus = new phieumuonBUS();
			try {
				table.setData(bus.getPMList());
				table.loadData();
				JOptionPane.showMessageDialog(this, "Đã tải lại");
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
