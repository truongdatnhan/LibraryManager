package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import DTO.nhanvienDTO;
import DTO.sachDTO;

public class sachDAO {
	static MyConnectUnit conn = null;
	static ResultSet rs = null;

	public static ArrayList<sachDTO> docDSNV() throws Exception {
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		ArrayList<sachDTO> dss = new ArrayList<sachDTO>();
		rs = conn.Select("sach");
//		String query = "SELECT * FROM NHANVIEN";
//		rs = conn.excuteQuery(query);
		while (rs.next()) {
			sachDTO s = new sachDTO();
			s.setMasach(rs.getString(1));
			s.setTensach(rs.getString(2));
			s.setGiasach(Long.parseLong(rs.getString(3)));
			s.setMatheloai(rs.getString(4));
			s.setMatg(rs.getString(5));
			s.setManxb(rs.getString(6));
			s.setMalinhvuc(rs.getString(7));
			s.setHinhanh(rs.getString(8));
			s.setSoluong(Integer.parseInt(rs.getString(9)));
			s.setTrangthai(Integer.parseInt(rs.getString(10)));
			dss.add(s);
		}
		return dss;
	}

	public void Insert(sachDTO s) throws Exception {
		HashMap<String, Object> insertValue = new HashMap<String, Object>();
		insertValue.put("masach", s.getMasach());
		insertValue.put("tensach", s.getTensach());
		insertValue.put("giasach", s.getGiasach());
		insertValue.put("matheloai", s.getMatheloai());
		insertValue.put("matg", s.getMatg());
		insertValue.put("manxb", s.getMalinhvuc());
		insertValue.put("malinhvuc", s.getMalinhvuc());
		insertValue.put("hinhanh", s.getHinhanh());
		insertValue.put("soluong", s.getSoluong());
		insertValue.put("trangthai","1");
		boolean kt = conn.Insert("nhanvien", insertValue);
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
	}

	public void Delete(sachDTO s) throws Exception {
////		String quy
//		boolean kt = conn.Delete("nhanvien", "manv = '" + nv.getManv() + "'");
//		if (kt == true) {
//			JOptionPane.showMessageDialog(null, "Xóa thành công");
//		} else {
//			JOptionPane.showMessageDialog(null, "Xóa thất bại");
//		}
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("masach", s.getMasach());
		updateValue.put("tensach", s.getTensach());
		updateValue.put("giasach", s.getGiasach());
		updateValue.put("matheloai", s.getMatheloai());
		updateValue.put("matg", s.getMatg());
		updateValue.put("manxb", s.getMalinhvuc());
		updateValue.put("malinhvuc", s.getMalinhvuc());
		updateValue.put("hinhanh", s.getHinhanh());
		updateValue.put("soluong", s.getSoluong());
		updateValue.put("trangthai","0");
		boolean kt = conn.Update("nhanvien", updateValue, "masach = '" + s.getMasach() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

	public void Update(sachDTO s) throws Exception {
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("masach", s.getMasach());
		updateValue.put("tensach", s.getTensach());
		updateValue.put("giasach", s.getGiasach());
		updateValue.put("matheloai", s.getMatheloai());
		updateValue.put("matg", s.getMatg());
		updateValue.put("manxb", s.getMalinhvuc());
		updateValue.put("malinhvuc", s.getMalinhvuc());
		updateValue.put("hinhanh", s.getHinhanh());
		updateValue.put("soluong", s.getSoluong());
		updateValue.put("trangthai","1");
		boolean kt = conn.Update("nhanvien", updateValue, "masach = '" + s.getMasach() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}

		// nên suy xét lại thay đổi thành boolean vì thay đổi phải cho hiển thị thông
		// báo thành công và thất bại ra màn hình cho người dùng
	}
}
