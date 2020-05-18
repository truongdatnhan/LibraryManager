package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.nguoidungDAO;
import DTO.nguoidungDTO;

public class nguoidungBUS {
	public static ArrayList<nguoidungDTO> dsnd;

	public void docDSND() throws Exception {
		nguoidungDAO data = new nguoidungDAO();
		if (dsnd == null) {
			dsnd = new ArrayList<nguoidungDTO>();
		}
		dsnd = data.docDSND();
	}

	void Insert(nguoidungDTO nd) throws Exception {
		nguoidungDAO data = new nguoidungDAO();
		data.Insert(nd);
		dsnd.add(nd);
		if (dsnd.add(nd) == true) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại");
		}
	}

	void Delete(nguoidungDTO nd) throws Exception {
		nguoidungDAO data = new nguoidungDAO();
		data.Delete(nd);
		dsnd.remove(nd);
		if (dsnd.remove(nd) == true) {
			JOptionPane.showMessageDialog(null, "Xóa thành công");
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại");
		}
	}

	public boolean checkAccount(String username, String pass, String role) {
		for (int i = 0; i < dsnd.size(); i++) {
			if (username.equals(dsnd.get(i).getManv()) && pass.equals(dsnd.get(i).getMkhau())
					&& role.equals(dsnd.get(i).getQuyen())) {
				return true;
			}
		}
		return false;
	}

	public void close() throws Exception {
		nguoidungDAO data = new nguoidungDAO();
		data.close();
	}
}
