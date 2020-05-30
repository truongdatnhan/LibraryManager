package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.loaiDTO;


public class loaiDAO {
	static MyConnectUnit conn = null;
	static ResultSet rs = null;
	
	public static ArrayList<loaiDTO> docDSL() throws Exception{
		conn = new MyConnectUnit("localhost","root","123456","Thuvien");
		ArrayList<loaiDTO> dsl = new ArrayList<loaiDTO>();
		rs = conn.Select("theloai","trangthai = 1");
		
		while(rs.next()) {
			loaiDTO loai = new loaiDTO();
			loai.setMaloai(rs.getString(1));
			loai.setTenloai(rs.getString(2));
			loai.setTrangthai(Integer.parseInt(rs.getString(3)));
			dsl.add(loai);
		}
		conn.Close();
		return dsl;
	}
	
}
