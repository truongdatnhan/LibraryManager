package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import BUS.ctpmBUS;
import BUS.phieumuonBUS;
import DTO.phieumuonDTO;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class QLPMPanel extends JPanel {
	private JTextField txMapm;
	private JTextField txManv;
	private JTextField txMathe;
	private JTextField txMsach;
	private JTextField txSoluong;
	private TablePhieuMuon table;
	private tableCTPM tableCTP;

	public QLPMPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lbMaHD = new JLabel("Mã phiếu mượn");
		lbMaHD.setBounds(541, 30, 99, 25);
		add(lbMaHD);

		txMapm = new JTextField();
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

		JDateChooser dateNgaymuon = new JDateChooser();
		dateNgaymuon.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateNgaymuon.setBounds(675, 151, 191, 26);
		add(dateNgaymuon);

		JLabel lbNgayquydinhtra = new JLabel("Ngày quy định trả");
		lbNgayquydinhtra.setBounds(541, 194, 143, 25);
		add(lbNgayquydinhtra);

		JDateChooser dateNgayquyidinhtra = new JDateChooser();
		dateNgayquyidinhtra.setBounds(675, 193, 191, 26);
		add(dateNgayquyidinhtra);

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

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Đã trả");
		rdbtnNewRadioButton.setBounds(180, 381, 84, 29);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Chưa trả");
		rdbtnNewRadioButton_1.setBounds(331, 378, 99, 29);
		add(rdbtnNewRadioButton_1);

		JLabel lbNgaythuctra = new JLabel("Ngày thực trả");
		lbNgaythuctra.setBounds(40, 418, 99, 20);
		add(lbNgaythuctra);

		JDateChooser dateNgaytra = new JDateChooser();
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
		table.loadData();
		table.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				int i = table.getTable().getSelectedRow();
//				phieumuonDTO pm = phieumuonBUS.dspm.get(i);
//				ctpmBUS bus = new ctpmBUS();
//				
//				if (i >= 0) {	
//					tableCTP.setData(bus.getNVList(pm.getMapm()));
//					tableCTP.loadData();
//					
//				}
//			
			}
		});

		
	}
}
