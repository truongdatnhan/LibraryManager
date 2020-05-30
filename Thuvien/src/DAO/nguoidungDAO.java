package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import DTO.nguoidungDTO;

public class nguoidungDAO {
	MyConnectUnit conn = null;
	ResultSet rs = null;
	ArrayList<nguoidungDTO> dsnd = null;

	public nguoidungDAO() {
		if (conn == null) {
			conn = new MyConnectUnit("localhost", "root", "", "Thuvien");
		}
	}

	public ArrayList<nguoidungDTO> docDSND() throws Exception {
		dsnd = new ArrayList<nguoidungDTO>();
		rs = conn.Select("nguoidung");
		while (rs.next()) {
			nguoidungDTO nguoidung = new nguoidungDTO();
			nguoidung.setManv(rs.getString(1));
			nguoidung.setMkhau(rs.getString(2));
			nguoidung.setQuyen(rs.getString(3));
			dsnd.add(nguoidung);
		}
		conn.Close();
		return dsnd;
	}

	public void Insert(nguoidungDTO nd) throws Exception {
		HashMap<String, Object> insertValue = new HashMap<String, Object>();
		insertValue.put("manv", nd.getManv());
		insertValue.put("matkhau", nd.getMkhau());
		insertValue.put("maquyen", nd.getQuyen());
		insertValue.put("trangthai", 1);
		boolean kt = conn.Insert("nguoidung", insertValue);
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
		conn.Close();
	}

	public void Delete(nguoidungDTO nd) throws Exception {
		boolean kt = conn.Delete("nguoidung", "manv = '" + nd.getManv() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

	public void Update(nguoidungDTO nd) throws Exception {
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("manv",nd.getManv());
		updateValue.put("matkhau", nd.getMkhau());
		updateValue.put("maquyen", nd.getQuyen());
		updateValue.put("trangthai", nd.getTrangthai());
		boolean kt = conn.Update("nguoidung", updateValue,"manv = '" + nd.getManv() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Thay đổi thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thay đổi thất bại thất bại");
		}
		
		conn.Close();
	}

	public ArrayList<nguoidungDTO> filteredList() {
		try {
			dsnd = docDSND();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<nguoidungDTO> edited = new ArrayList<nguoidungDTO>();
		for (nguoidungDTO nd : dsnd) {
			if (nd.getTrangthai() == 1) {
				edited.add(nd);
			}
		}
		return edited;
	}
}
