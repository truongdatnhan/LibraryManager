package BUS;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import DAO.linhvucDAO;
import DTO.linhvucDTO;


public class linhvucBUS {
	public static ArrayList<linhvucDTO> dslv;

	public DefaultTableModel docDSLV() throws Exception {
		DefaultTableModel model = new DefaultTableModel();
		if (dslv == null) {
			dslv = new ArrayList<linhvucDTO>();
		}

		dslv = linhvucDAO.docDSLV();
		Vector<String> header = new Vector<String>();
		header.add("Mã loại");
		header.add("Tên loại");
		if (model.getRowCount() == 0) {
			model = new DefaultTableModel(header, 0);
		}
		for (linhvucDTO lv : dslv) {
			Vector<String> row = new Vector<String>();
			row.add(lv.getMalinhvuc());
			row.add(lv.getTenlinhvuc());
			model.addRow(row);
		}
		return model;
	}
}
