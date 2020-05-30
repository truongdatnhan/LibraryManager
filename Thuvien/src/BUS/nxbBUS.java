package BUS;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DAO.nxbDAO;
import DTO.nxbDTO;
public class nxbBUS {
	public static ArrayList<nxbDTO> dsnxb;
	public DefaultTableModel docNXB() throws Exception {
		DefaultTableModel model = new DefaultTableModel();
		if(dsnxb == null) {
			dsnxb = new ArrayList<nxbDTO>();
		}
		dsnxb = nxbDAO.docNXB();
		
		Vector<String> header = new Vector<String>();
		header.add("Mã NXB");
		header.add("Tên");
		header.add("Số điện thoại");
		header.add("Email");
		
		if(model.getRowCount()==0) {
			model = new DefaultTableModel(header,0);
		}
		
		for(nxbDTO nxb : dsnxb) {
			Vector<String> row = new Vector<String>();
			row.add(nxb.getManxb());
			row.add(nxb.getTenxb());
			row.add(nxb.getSdt());
			row.add(nxb.getEmail());
			model.addRow(row);
		}
		return model;
	}
}
