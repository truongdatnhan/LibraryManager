package GUI;

import java.util.ArrayList;

import BUS.nhanvienBUS;
import DAO.nhanvienDAO;
import DTO.nhanvienDTO;
import TOOL.check;

public class Main_Test {

	public static void main(String[] args) {
		nhanvienDAO db = new nhanvienDAO();
		nhanvienBUS bus = new nhanvienBUS();
		
		ArrayList<nhanvienDTO> list = bus.getNVList();
		
		System.out.println(list);
		System.out.println(list.get(1).getTrangthai() == 1);
		
		
	}

}
