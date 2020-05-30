package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.linhvucDTO;

public class linhvucDAO {
	static MyConnectUnit conn = null;
	static ResultSet rs = null;

	public static ArrayList<linhvucDTO> docDSLV() throws Exception {
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		ArrayList<linhvucDTO> dslv = new ArrayList<linhvucDTO>();
		rs = conn.Select("linhvuc", "trangthai = 1");

		while (rs.next()) {
			linhvucDTO linhvuc = new linhvucDTO();
			linhvuc.setMalinhvuc(rs.getString(1));
			linhvuc.setTenlinhvuc(rs.getString(2));
			linhvuc.setTrangthai(Integer.parseInt(rs.getString(3)));
			dslv.add(linhvuc);
		}
		conn.Close();
		return dslv;
	}
}