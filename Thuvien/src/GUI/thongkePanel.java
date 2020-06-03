package GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import BUS.theTVBUS;

import java.awt.Color;

public class thongkePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private tableTheThuVien table;
	public thongkePanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel pnNhapsach = new JPanel();
		pnNhapsach.setBorder(new TitledBorder(null, "Nhập sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnNhapsach.setBounds(31, 26, 567, 318);
		add(pnNhapsach);
		pnNhapsach.setLayout(null);
		
		JPanel pnPhat = new JPanel();
		pnPhat.setBorder(new TitledBorder(null, "Pha\u0323t", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnPhat.setBounds(31, 375, 320, 233);
		add(pnPhat);
		pnPhat.setLayout(null);
		
		
		
		JPanel pnMuon = new JPanel();
		pnMuon.setBorder(new TitledBorder(null, "M\u01B0\u01A1\u0323n sa\u0301ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnMuon.setBounds(366, 375, 356, 233);
		add(pnMuon);
		pnMuon.setLayout(null);
		
		JPanel pnDangKy = new JPanel();
		pnDangKy.setBorder(new TitledBorder(null, "Tha\u0300nh vi\u00EAn \u0111\u0103ng ky\u0301", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDangKy.setBounds(620, 26, 399, 318);
		//add(pnDangKy);
		pnDangKy.setLayout(null);
		
		table = new tableTheThuVien();
		table.setBounds(620, 26, pnDangKy.getWidth(), pnDangKy.getHeight());
		theTVBUS bus = new theTVBUS();
		try {
			table.setData(bus.getNewTTVList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.loadData();
		pnDangKy.removeAll();
		add(table);
	}
}
