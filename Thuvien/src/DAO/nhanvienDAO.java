package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DTO.nguoidungDTO;
import DTO.nhanvienDTO;

public class nhanvienDAO {
	static MyConnectUnit conn = null;
	static ResultSet rs = null;

	public static ArrayList<nhanvienDTO> docDSNV() throws Exception {
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		ArrayList<nhanvienDTO> dsnv = new ArrayList<nhanvienDTO>();
		rs = conn.Select("nhanvien", "trangthai = 1");
//		String query = "SELECT * FROM NHANVIEN";
//		rs = conn.excuteQuery(query);
		while (rs.next()) {
			nhanvienDTO nhanvien = new nhanvienDTO();
			nhanvien.setManv(rs.getString(1));
			nhanvien.setHo(rs.getString(2));
			nhanvien.setTen(rs.getString(3));
			nhanvien.setNgaysinh(rs.getString(4));
			nhanvien.setGioitinh(rs.getString(5));
			nhanvien.setDiachi(rs.getString(6));
			nhanvien.setEmail(rs.getString(7));
			nhanvien.setSdt(rs.getString(8));
			nhanvien.setLuong(rs.getString(9));
			nhanvien.setTrangthai(Integer.parseInt(rs.getString(10)));
			dsnv.add(nhanvien);
		}
		conn.Close();
		return dsnv;
	}

	public static void Insert(nhanvienDTO nv) throws Exception {
//		String query = "INSERT INTO NHANVIEN VALUES ('" + nv.getManv() + "','" + nv.getHo() + "','" + nv.getTen()
//				+ "','" + nv.getNgaysinh() + "','" + nv.getGioitinh() + "','" + nv.getDiachi() + "','" + nv.getEmail()
//				+ "','" + nv.getSdt() + "','" + nv.getLuong() + "');";
//		rs = conn.excuteQuery(query);
//		System.out.print(query);
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
//		String query = "INSERT INTO NHANVIEN VALUES ('" + nv.getDiachi() + "','" + nv.getHo() + "','" + nv.getTen()
//				+ "','" + nv.getNgaysinh() + "','" + nv.getGioitinh() + "','" + nv.getDiachi() + "','" + nv.getEmail()
//				+ "','" + nv.getSdt() + "','" + nv.getLuong() + "');";
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
		insertValue.put("trangthai", "1");
		boolean kt = conn.Insert("nhanvien", insertValue);
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
		conn.Close();
	}

//	public static void main(String[] args) throws Exception {
//		nhanvienDTO nv = new nhanvienDTO("A","A","A","2020-10-8","A","A","A","A","7");
//		Insert(nv);
//	}
	public static void Delete(nhanvienDTO nv) throws Exception {
//		String quy
		// conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("honv", nv.getHo());
		updateValue.put("tennv", nv.getTen());
		updateValue.put("ngaysinh", nv.getNgaysinh());
		updateValue.put("gioitinh", nv.getGioitinh());
		updateValue.put("diachinv", nv.getDiachi());
		updateValue.put("emailnv", nv.getEmail());
		updateValue.put("sdtnv", nv.getSdt());
		updateValue.put("luong", nv.getLuong());
		updateValue.put("trangthai", "0");
		boolean kt = conn.Update("nhanvien", updateValue, "manv = '" + nv.getManv() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		}
		// conn.Close();
		conn.Close();
	}

	public static void active() {

	}

	public static void Update(nhanvienDTO nv) throws Exception {
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("honv", nv.getHo());
		updateValue.put("tennv", nv.getTen());
		updateValue.put("ngaysinh", nv.getNgaysinh());
		updateValue.put("gioitinh", nv.getGioitinh());
		updateValue.put("diachinv", nv.getDiachi());
		updateValue.put("emailnv", nv.getEmail());
		updateValue.put("sdtnv", nv.getSdt());
		updateValue.put("luong", nv.getLuong());
		updateValue.put("trangthai", nv.getTrangthai());
		boolean kt = conn.Update("nhanvien", updateValue, "manv = '" + nv.getManv() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}
		conn.Close();
		// nên suy xét lại thay đổi thành boolean vì thay đổi phải cho hiển thị thông
		// báo thành công và thất bại ra màn hình cho người dùng
	}

	public static int count(String tableName, String column) throws Exception {
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		int k = 0;
		rs = conn.Select("nhanvien");
		while (rs.next()) {
			k++;
		}
		conn.Close();
		return k;
	}
}
