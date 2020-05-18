package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.nhanvienDAO;
import DTO.nhanvienDTO;
import TOOL.check;


public class nhanvienBUS {
	public static ArrayList<nhanvienDTO> dsnv;

	public void docDSND() throws Exception {
		nhanvienDAO data = new nhanvienDAO();
		if (dsnv == null) {
			dsnv = new ArrayList<nhanvienDTO>();
		}
		dsnv = data.docDSNV();
	}
	
	public void Insert(nhanvienDTO nv) throws Exception {
		nhanvienDAO data = new nhanvienDAO();
		data.Insert(nv);
		dsnv.add(nv);
		
	}
	public void Delete(nhanvienDTO nv) throws Exception {
		nhanvienDAO data = new nhanvienDAO();
		data.Delete(nv);
		dsnv.remove(nv);
	}
	public void Update(nhanvienDTO nv) throws Exception {
		nhanvienDAO data = new nhanvienDAO();
		data.Update(nv);
	}
	public boolean checkSameId(String s) {
		for(nhanvienDTO nv : dsnv) {
			if(nv.getManv().compareTo(s)==0) {
				return false;
			}
		}
		return true;
	}
}
