package BUS;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DAO.linhvucDAO;
import DAO.tacgiaDAO;
import DTO.linhvucDTO;
import DTO.tacgiaDTO;

public class tacgiaBUS {
	public static ArrayList<tacgiaDTO> dstg;

	public DefaultTableModel docDSTG() throws Exception {
		DefaultTableModel model = new DefaultTableModel();
		if (dstg == null) {
			dstg = new ArrayList<tacgiaDTO>();
		}

		dstg = tacgiaDAO.docDSTG();
		Vector<String> header = new Vector<String>();
		header.add("Mã tác giả");
		header.add("Họ tác giả");
		header.add("Tên tác giả");
		if (model.getRowCount() == 0) {
			model = new DefaultTableModel(header, 0);
		}
		for (tacgiaDTO tg : dstg) {
			Vector<String> row = new Vector<String>();
			row.add(tg.getMatg());
			row.add(tg.getHotg());
			row.add(tg.getTentg());
			row.add(tg.getEmail());
			model.addRow(row);
		}
		return model;
	}
}
