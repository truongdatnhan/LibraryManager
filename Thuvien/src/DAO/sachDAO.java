package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import DTO.nhanvienDTO;
import DTO.sachDTO;

public class sachDAO {
	MyConnectUnit conn = null;
	ResultSet rs = null;

	public sachDAO() {
		if (conn == null) {
			conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		}
	}

	public ArrayList<nhanvienDTO> docDSNV() throws Exception {
		ArrayList<nhanvienDTO> dsnv = new ArrayList<nhanvienDTO>();
		rs = conn.Select("sach");
//		String query = "SELECT * FROM NHANVIEN";
//		rs = conn.excuteQuery(query);
		while (rs.next()) {
			
		}
		return dsnv;
	}

	public void Insert(sachDTO s) throws Exception {
//		String query = "INSERT INTO NHANVIEN VALUES ('" + nv.getManv() + "','" + nv.getHo() + "','" + nv.getTen()
//				+ "','" + nv.getNgaysinh() + "','" + nv.getGioitinh() + "','" + nv.getDiachi() + "','" + nv.getEmail()
//				+ "','" + nv.getSdt() + "','" + nv.getLuong() + "');";
//		rs = conn.excuteQuery(query);
//		System.out.print(query);
		String query = "INSERT INTO NHANVIEN VALUES ('" + nv.getDiachi() + "','" + nv.getHo() + "','" + nv.getTen()
				+ "','" + nv.getNgaysinh() + "','" + nv.getGioitinh() + "','" + nv.getDiachi() + "','" + nv.getEmail()
				+ "','" + nv.getSdt() + "','" + nv.getLuong() + "');";
		HashMap<String, Object> insertValue = new HashMap<String, Object>();
		insertValue.put("manv", nv.getManv());
		insertValue.put("honv", nv.getHo());
		insertValue.put("tennv", nv.getTen());
		insertValue.put("ngaysinh", nv.getNgaysinh());
		insertValue.put("gioitinh", nv.getGioitinh());
		insertValue.put("diachinv", nv.getDiachi());
		insertValue.put("emailnv", nv.getEmail());
		insertValue.put("sdtnv", nv.getSdt());
		insertValue.put("luong", nv.getLuong());
		boolean kt = conn.Insert("nhanvien", insertValue);
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
	}

//	public static void main(String[] args) throws Exception {
//		sachDTO s = new nhanvienDTO("A","A","A","2020-10-8","A","A","A","A","7");
//		Insert(nv);
//	}
	public void Delete(sachDTO s) throws Exception {
//		String quy
		boolean kt = conn.Delete("nhanvien", "manv = '" + nv.getManv() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

	public void Update(sachDTO s) throws Exception {
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("honv", nv.getHo());
		updateValue.put("tennv", nv.getTen());
		updateValue.put("ngaysinh", nv.getNgaysinh());
		updateValue.put("gioitinh", nv.getGioitinh());
		updateValue.put("diachinv", nv.getDiachi());
		updateValue.put("emailnv", nv.getEmail());
		updateValue.put("sdtnv", nv.getSdt());
		updateValue.put("luong", nv.getLuong());
		boolean kt = conn.Update("nhanvien", updateValue, "manv = '" + nv.getManv() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}

		// nên suy xét lại thay đổi thành boolean vì thay đổi phải cho hiển thị thông
		// báo thành công và thất bại ra màn hình cho người dùng
	}
}
