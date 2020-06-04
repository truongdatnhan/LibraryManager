package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import BUS.ctpmBUS;
import BUS.phieumuonBUS;
import DTO.ctpmDTO;
import DTO.phieumuonDTO;
import TOOL.check;

public class QLPMPanel extends JPanel implements ActionListener {
	private JTextField txMapm;
	private JTextField txManv;
	private JTextField txMathe;
	private JTextField txMsach;
	private JTextField txSoluong;
	private TablePhieuMuon table;
	private JButton btnThemPM, btnXoaPM, btnSuaPM, btnTaiLaiPM;
	private JDateChooser dateNgaymuon, dateNgayquydinhtra;
	private tableCTPM tableCTP;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private check check;

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

		JButton btnThemCTPM = new JButton("Thêm");
		btnThemCTPM.setBounds(40, 467, 183, 29);
		add(btnThemCTPM);

		JButton btnXoaCTPM = new JButton("Xóa");
		btnXoaCTPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnXoaCTPM.setBounds(238, 467, 192, 29);
		add(btnXoaCTPM);

		JButton btnTailaiCTPM = new JButton("Tải lại");
		btnTailaiCTPM.setBounds(40, 512, 183, 29);
		add(btnTailaiCTPM);

		JButton btnSuaCTPM = new JButton("Sưa");
		btnSuaCTPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

		JRadioButton rdDaTra = new JRadioButton("Đã trả");
		buttonGroup.add(rdDaTra);
		rdDaTra.setBounds(180, 381, 84, 29);
		add(rdDaTra);

		JRadioButton rdChuaTra = new JRadioButton("Chưa trả");
		buttonGroup.add(rdChuaTra);
		rdChuaTra.setBounds(331, 378, 99, 29);
		add(rdChuaTra);

		JLabel lbNgaythuctra = new JLabel("Ngày thực trả");
		lbNgaythuctra.setBounds(40, 418, 99, 20);
		add(lbNgaythuctra);

		JDateChooser dateNgaytra = new JDateChooser();
		dateNgaytra.setDateFormatString("yyyy-MM-dd");
		dateNgaytra.setBounds(180, 419, 250, 26);
		add(dateNgaytra);
		phieumuonBUS bus = new phieumuonBUS();

		tableCTP = new tableCTPM();
		tableCTP.setBounds(477, 290, 555, 302);

		add(tableCTP);

		table = new TablePhieuMuon();
		table.setBounds(15, 16, 511, 258);
		try {
			table.setData(bus.getPMList());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		add(table);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(40, 557, 183, 29);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(238, 557, 192, 29);
		add(btnNewButton_3);

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
						if (check.checkDate((String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgaymuon.getDate()))) {
							String dateMuon = (String) new SimpleDateFormat("yyyy-MM-dd").format(dateNgaymuon.getDate());
							if (check.checkDate((String) new SimpleDateFormat("dd-MM-yyyy").format(dateNgayquydinhtra.getDate()))) {
								String dateTra = (String) new SimpleDateFormat("yyyy-MM-dd").format(dateNgayquydinhtra.getDate());
								phieumuonDTO pm = new phieumuonDTO(txMapm.getText(), txManv.getText(), txMathe.getText(),
										dateMuon, dateTra);
								
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

	}
}
