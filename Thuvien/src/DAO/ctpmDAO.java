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
	HashMap<String, ArrayList<ctpmDTO>> map = null;
	
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
	
	public void Update(ctpmDTO ctpm) throws Exception {
		HashMap<String, Object> updateValue = new HashMap<String, Object>();
		//updateValue.put("mapm", ctpm.getMapm());
		//updateValue.put("masach", ctpm.getMasach());
		updateValue.put("soluong", ctpm.getSoluong());
		updateValue.put("tinhtrang", ctpm.getTinhtrang());
		updateValue.put("ngaythuctra", ctpm.getNgaythuctra());
		boolean kt = conn.Update("ctphieumuon", updateValue, "mapm = '" + ctpm.getMapm() + "'" + " AND " + "masach = '"
		+ ctpm.getMasach() + "'");
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}
		conn.Close();
	}
	
	public void Delete(ctpmDTO ctpm) throws Exception {
		StringBuilder query = new StringBuilder();
		query.append("mapm = '")
		.append(ctpm.getMapm())
		.append("'")
		.append(" AND ")
		.append("masach = '")
		.append(ctpm.getMasach())
		.append("'");
		System.out.println(query.toString());
		boolean kt = conn.DeleteReal("ctphieumuon", query.toString());
		if (kt == true) {
			JOptionPane.showMessageDialog(null, "Xoá thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xoá thất bại");
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
	
	
	//Sẽ optimal bằng hashmap sau nếu có thời gian 
	public HashMap<String, ArrayList<ctpmDTO>> getMap() throws Exception {
		dsctm = docCTPM();
		
			for(ctpmDTO c: dsctm) {
				if(map.containsKey(c.getMapm())) {
					map.get(c.getMapm()).add(c);
				} else {
					map.put(c.getMapm(), new ArrayList<ctpmDTO>());
					map.get(c.getMapm()).add(c);
				}
			}
			
		return map;
	}
	
}
