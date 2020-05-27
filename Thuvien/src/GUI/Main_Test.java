package GUI;

import java.util.ArrayList;

import BUS.nhanvienBUS;
import DTO.nhanvienDTO;

public class Main_Test {
	public static void main(String[] args) {
		nhanvienBUS bus = new nhanvienBUS();
		
		ArrayList<nhanvienDTO> list = bus.getNVList();
		String birth = "07";
		int month = Integer.parseInt(birth);
		
		System.out.println(month);
		
		System.out.println(list);
		
	}
}
