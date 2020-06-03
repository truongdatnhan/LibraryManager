package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import DTO.ctpmDTO;

public class ctpmDAO {
	MyConnectUnit conn = null;
	ResultSet rs = null;
	ArrayList<ctpmDTO> dsctm = null;
	
	public ctpmDAO() {
		conn = new MyConnectUnit("localhost", "root", "", "Thuvien");
	}
	
	public ArrayList<ctpmDTO> docCTPM() throws Exception{
		dsctm = new ArrayList<ctpmDTO>();
		rs = conn.Select("ctphieumuon");
		while(rs.next()) {
			ctpmDTO ctpm = new ctpmDTO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
			dsctm.add(ctpm);
		}
		conn.Close();
		return dsctm;
	}
	
	public void Insert(ctpmDTO ctpm) throws Exception {
		HashMap<String, Object> insertValue = new HashMap<String, Object>();
		insertValue.put("mapm", ctpm.getMapm());
		insertValue.put("masach", ctpm.getMasach());
		insertValue.put("soluong", ctpm.getSoluong());
		insertValue.put("tinhtrang", ctpm.getTinhtrang());
		insertValue.put("ngaythuctra", ctpm.getNgaythuctra());
		boolean kt = conn.Insert("ctphieumuon", insertValue);
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
		conn.Close();
	}
	
	public ArrayList<ctpmDTO> filteredList(String ID) throws Exception{
		dsctm = docCTPM();
		ArrayList<ctpmDTO> edited = new ArrayList<ctpmDTO>();
		for(ctpmDTO ctp : dsctm) {
			if(ctp.getMapm().compareTo(ID)==0) {
				edited.add(ctp);
			}
		}
		return edited;
	}
}
