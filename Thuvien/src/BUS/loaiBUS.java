package BUS;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DAO.loaiDAO;
import DTO.loaiDTO;


public class loaiBUS {
	public static ArrayList<loaiDTO> dsl;
	public DefaultTableModel docDSL() throws Exception {
		DefaultTableModel model = new DefaultTableModel();
		if(dsl==null) {
			dsl = new ArrayList<loaiDTO>();
		}
		
		dsl = loaiDAO.docDSL();
		Vector<String> header = new Vector<String>();
		header.add("Mã loại");
		header.add("Tên loại");
		if(model.getRowCount()==0) {
			model = new DefaultTableModel(header, 0);		
		}
		for(loaiDTO l : dsl) {
			Vector<String> row = new Vector<String>();
			row.add(l.getMaloai());
			row.add(l.getTenloai());
			model.addRow(row);
		}
		return model;
	}
}
