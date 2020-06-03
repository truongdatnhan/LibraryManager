package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import javax.swing.JOptionPane;

import DTO.theTVDTO;

public class theTVDAO {
	MyConnectUnit conn = null;
	ResultSet rs = null;
	private ArrayList<theTVDTO> dsttv;

	public theTVDAO() {
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
	}

	public void docDSTV() throws Exception {
		dsttv = new ArrayList<theTVDTO>();
		rs = conn.Select("thethuvien");
		while (rs.next()) {
			theTVDTO the = new theTVDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getInt(5));
			dsttv.add(the);
		}
		conn.Close();
	}

	public void Insert(theTVDTO the) throws Exception {
		HashMap<String, Object> insertValue = new HashMap<String, Object>();
		insertValue.put("mathe", the.getMathe());
		insertValue.put("madg", the.getMadg());
		insertValue.put("ngaycap", the.getNgaycap());
		insertValue.put("ngayhethan", the.getNgayhethan());
		insertValue.put("trangthai", 1);
		boolean kt = conn.Insert("thethuvien", insertValue);
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
		conn.Close();
	}

	public void Delete(theTVDTO the) throws Exception {
		boolean kt = conn.Delete("thethuvien", "mathe = '" + the.getMathe() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
		conn.Close();
	}

	public void Update(theTVDTO the) throws Exception {
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("mathe", the.getMathe());
		updateValue.put("madg", the.getMadg());
		updateValue.put("ngaycap", the.getNgaycap());
		updateValue.put("ngayhethan", the.getNgayhethan());
		updateValue.put("trangthai", 1);
		boolean kt = conn.Update("thethuvien", updateValue, "mathe = '" + the.getMathe() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}
	}

	public ArrayList<theTVDTO> filteredList() throws Exception {
		docDSTV();
		ArrayList<theTVDTO> temp = new ArrayList<theTVDTO>();
		for (theTVDTO the : dsttv) {
			if (the.getTrangthai() == 1) {
				temp.add(the);
			}
		}
		conn.Close();
		return temp;
	}

	public ArrayList<theTVDTO> newCardList() throws Exception {
		ArrayList<theTVDTO> temp1 = filteredList();
		ArrayList<theTVDTO> temp2 = new ArrayList<theTVDTO>();
		Date today = new Date();
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dayFormat.format(today);
		String[] compareDate = date.split("-");
		for (theTVDTO the : temp1) {
			String[] ngaylap = the.getNgaycap().split("-");
			int ngay = Integer.parseInt(ngaylap[2]);
			//int thang = Integer.parseInt(ngaylap[1]);
			//int nam = Integer.parseInt(ngaylap[0]);
			if (30 - ngay <= 20) {
				temp2.add(the);
			}
			//tem.out.print(date[0]+" "+ngaylap);
		}
		
		return temp2;
	}
}
