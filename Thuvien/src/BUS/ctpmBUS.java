package BUS;

import java.util.ArrayList;

import DAO.ctpmDAO;
import DAO.nhanvienDAO;
import DTO.ctpmDTO;
import DTO.nhanvienDTO;

public class ctpmBUS {
	public static ArrayList<ctpmDTO> dsctpm;
	//public static String userID;
	//nhanvienDAO data = new nhanvienDAO();
	ctpmDAO data = new ctpmDAO();
	public ArrayList<ctpmDTO> getNVList(String ID) {
		if (dsctpm == null) {
			dsctpm = new ArrayList<ctpmDTO>();
		}

		// đọc dữ liệu lên và truyền vào arraylist
		try {
			dsctpm = data.filteredList(ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsctpm;
	}
	
	public void removeList() {
		for(int i = 0;i< dsctpm.size();i++) {
			dsctpm.remove(i);
		}
	}
}
