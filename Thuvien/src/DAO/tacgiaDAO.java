package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.linhvucDTO;
import DTO.tacgiaDTO;

public class tacgiaDAO {
	static MyConnectUnit conn = null;
	static ResultSet rs = null;

	public static ArrayList<tacgiaDTO> docDSTG() throws Exception {
		conn = new MyConnectUnit("localhost", "root", "123456", "Thuvien");
		ArrayList<tacgiaDTO> dstg = new ArrayList<tacgiaDTO>();
		rs = conn.Select("tacgia", "trangthai = 1");

		while (rs.next()) {
			tacgiaDTO tacgia = new tacgiaDTO();
			tacgia.setMatg(rs.getString(1));
			tacgia.setHotg(rs.getString(2));
			tacgia.setTentg(rs.getString(3));
			tacgia.setEmail(rs.getString(4));
			tacgia.setTrangthai(Integer.parseInt(rs.getString(5)));
			dstg.add(tacgia);
		}
		conn.Close();
		return dstg;
	}
}
