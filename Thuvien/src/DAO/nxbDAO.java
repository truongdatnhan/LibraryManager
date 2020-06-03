package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.nxbDTO;

public class nxbDAO {
	static MyConnectUnit conn = null;
	static ResultSet rs = null;
	
	public static ArrayList<nxbDTO> docNXB() throws Exception{
		conn = new MyConnectUnit("localhost","root","","thuvien");
		ArrayList<nxbDTO> dsnxb = new ArrayList<nxbDTO>();
		rs = conn.Select("nxb","trangthai=1");
		while(rs.next()) {
			nxbDTO nxb = new nxbDTO();
			nxb.setManxb(rs.getString(1));
			nxb.setTenxb(rs.getString(2));
			nxb.setSdt(rs.getString(3));
			nxb.setEmail(rs.getString(4));
			nxb.setTrangthai(Integer.parseInt(rs.getString(5)));
			dsnxb.add(nxb);
		}
		conn.Close();
		return dsnxb;
	}
}
