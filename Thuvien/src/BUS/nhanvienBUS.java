package BUS;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.nhanvienDAO;
import DTO.nhanvienDTO;

public class nhanvienBUS {
	public static ArrayList<nhanvienDTO> dsnv;
	public static String userID;
	nhanvienDAO data = new nhanvienDAO();

	public ArrayList<nhanvienDTO> getNVList() {
		if (dsnv == null) {
			dsnv = new ArrayList<nhanvienDTO>();
		}

		// đọc dữ liệu lên và truyền vào arraylist
		try {
			dsnv = data.filteredList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}

	public void Insert(nhanvienDTO nv) throws Exception {
		data.Insert(nv);
		dsnv.add(nv);
	}

	public void Delete(nhanvienDTO nv) throws Exception {
		data.Delete(nv);
		dsnv.remove(nv);
	}

	public void Update(nhanvienDTO nv) throws Exception {
		data.Update(nv);
		// phần thêm
		int k = 0;
		for (int i = 0; i < dsnv.size(); i++) {
			if ((dsnv.get(i)).getManv().equals(nv.getManv())) {
				k = i;
			}
		}
		dsnv.set(k, nv);
	}

	public String findName() {
		String name = "";
		try {
			dsnv = data.docDSNV();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (nhanvienDTO nv : dsnv) {
			if (nv.getManv().compareTo(userID) == 0) {
				name = nv.getHo() + " " + nv.getTen();
			}
		}
		return name;
	}

	public boolean checkID(String manv) {
		int k = 0;
		for (nhanvienDTO nv : dsnv) {
			if (manv.compareToIgnoreCase(nv.getManv()) == 0) {
				JOptionPane.showMessageDialog(null, "Mã nhân viên này đã tồn tại");
				k++;
			}
		}
		if (k == 0) {
			// là false thì không trùng
			return false;
		} else {
			// true là trùng
			return true;
		}
	}

	public String autoCreateID() {
		String ID = null;
		nhanvienDAO data = new nhanvienDAO();
		try {
			dsnv = data.docDSNV();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dsnv.size() < 10) {
			ID = "NV00" + String.valueOf(dsnv.size() + 1);
		} else if (dsnv.size() >= 10 && dsnv.size() < 100) {
			ID = "NV0" + String.valueOf(dsnv.size() + 1);
		} else if (dsnv.size() >= 100) {
			ID = "NV" + String.valueOf(dsnv.size() + 1);
		}
		return ID;
	}
	
	
}
