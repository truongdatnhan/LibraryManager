package GUI;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DTO.ctpmDTO;

public class CTPMModel extends DefaultTableModel {
	public ArrayList<ctpmDTO> ctpmList;
	private static String[] colName = { "Mã phiếu mượn", "Mã sách", "Số lượng", "Tình trạng",
			"Ngày thực trả" };
	
	public CTPMModel() {
		super(colName, 0);
	}
	
	public void setData(ArrayList<ctpmDTO> list) {
		this.ctpmList = list;
	}
	
	public void loadData() {
		for(ctpmDTO ctp : ctpmList) {
			Vector<String> row = new Vector<String>();
			row.add(ctp.getMapm());
			row.add(ctp.getMasach());
			row.add(String.valueOf(ctp.getSoluong()));
			row.add(ctp.getTinhtrang());
			row.add(ctp.getNgaythuctra());
			super.addRow(row);
		}
	}
}
