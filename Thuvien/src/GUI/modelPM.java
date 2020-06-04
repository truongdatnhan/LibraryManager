package GUI;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import BUS.phieumuonBUS;
import DTO.phieumuonDTO;

public class modelPM extends DefaultTableModel {
	public ArrayList<phieumuonDTO> phieumuonList;
	private static String[] colName = { "Mã phiếu nhập", "Mã nhân viên", "Mã thẻ", "Ngày mượn",
			"Ngày quy định trả" };

	public modelPM() {
		super(colName, 0);
	}

	public void setData(ArrayList<phieumuonDTO> list) {
		this.phieumuonList = list;
	}

	public void loadData() {
		phieumuonBUS bus = new phieumuonBUS();
		for (phieumuonDTO pm : phieumuonList) {
			Vector<String> row = new Vector<String>();
			row.add(pm.getMapm());
			row.add(pm.getManv());
			row.add(pm.getMathe());
			row.add(pm.getNgaymuon());
			row.add(pm.getNgayquidinhtra());
			super.addRow(row);
		}
	}

	public void addRow(phieumuonDTO pm) {
		if (pm == null) {
			throw new IllegalArgumentException("NULL");
		}
		Vector<Object> row = new Vector<Object>();
		row.add(pm.getMapm());
		row.add(pm.getManv());
		row.add(pm.getMathe());
		row.add(pm.getNgaymuon());
		row.add(pm.getNgayquidinhtra());
		super.addRow(row);
	}

	public void deleteData (int i) {
		super.removeRow(i);
	}

	public void updateData(phieumuonDTO pm, int i) {
		String[] temp = new String[] { pm.getManv(), pm.getMathe(), pm.getNgaymuon(),
				pm.getNgayquidinhtra() };
		for (int j = 0; j < colName.length - 2; j++) {
			super.setValueAt(temp[j], i, j + 1);
		}
	}

	public phieumuonDTO getPM(int index) {
		return phieumuonList.get(index);
	}
}
