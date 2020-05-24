package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.nguoidungDTO;

public class nguoidungDAO {
	MyConnectToMySQL conn = null;
	ResultSet rs = null;

	public nguoidungDAO() {
		if (conn == null) {
			conn = new MyConnectToMySQL("localhost", "root", "123456", "Thuvien");
		}
	}

	public ArrayList<nguoidungDTO> docDSND() throws Exception {
		ArrayList<nguoidungDTO> dsnd = new ArrayList<nguoidungDTO>();
		rs = conn.excuteQuery("Select * from `nguoidung`");
		while (rs.next()) {
			nguoidungDTO nguoidung = new nguoidungDTO();
			nguoidung.setManv(rs.getString(1));
			nguoidung.setMkhau(rs.getString(2));
			nguoidung.setQuyen(rs.getString(3));
			dsnd.add(nguoidung);
		}
		return dsnd;
	}

	public void Insert(nguoidungDTO nd) throws Exception {
		String query = "insert into nguoidung(manv,matkhau,maquyen) values ('" + nd.getManv() + "','" + nd.getMkhau() + "','" + nd.getQuyen()
				+ "');";
		rs = conn.excuteQuery(query);
	}
	
	public void Delete(nguoidungDTO nd) throws Exception {
		String query = "delete from `nguoidung` where `manv` = '"+nd.getManv()+"';";
		rs = conn.excuteQuery(query);
	}
	
	void Update(nguoidungDTO nd) throws Exception {
		String query = "update `nguoidung` set `matkhau`='"+nd.getMkhau()+"',`maquyen`='"+nd.getQuyen()+"');";
		rs = conn.excuteQuery(query);
	}

	public void close() throws Exception {
		conn.Close();
	}

	public static void main(String[] args) {
	}
}
