package BUS;

import java.util.ArrayList;
import DAO.sachDAO;
import DTO.sachDTO;
import javax.swing.JOptionPane;

public class sachBUS {
	public static ArrayList<sachDTO> dss;

	public ArrayList<sachDTO> getSachList() {
		if (dss == null) {
			dss = new ArrayList<sachDTO>();
		}
		// Ä‘á»c dá»¯ liá»‡u lĂªn vĂ  truyá»n vĂ o arraylist
		try {
			sachDAO dao = new sachDAO();
			dss = dao.filteredList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dss;
	}

	public void Insert(sachDTO a) throws Exception {
		if (sameid(a.getMasach()) == false) {
			sachDAO dao = new sachDAO();
			dao.Insert(a);
			dss.add(a);
		} else
			JOptionPane.showMessageDialog(null, "Sách đã tồn tại-Không thể thêm");
	}

	public void Delete(sachDTO a) {
		try {
			a.setTrangthai(0);
			a.setHinhanh("");
			sachDAO dao = new sachDAO();
			dss.remove(sameid(a));
			dao.Delete(a);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa sách");
		}

	}

	public void Update(sachDTO a) {
		try {
			sachDAO dao = new sachDAO();
			dao.Update(a);
			dss.set(sameid(a), a);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa");
		}
	}

	public boolean sameid(String a) {
		for (int i = 0; i < dss.size(); i++) {
			sachDTO temp = ((sachDTO) dss.get(i));
			if (temp.getMasach().equals(a))
				return true; // true là trùng
		}
		return false;
	}

	public int sameid(sachDTO a) {
		for (int i = 0; i < dss.size(); i++) {
			sachDTO temp = ((sachDTO) dss.get(i));
			if (temp.getMasach().equals(a.getMasach()))
				return i;
		}
		return -1;
	}

}
