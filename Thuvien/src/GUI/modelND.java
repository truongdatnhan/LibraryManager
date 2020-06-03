package GUI;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import BUS.nguoidungBUS;
import BUS.phieumuonBUS;
import DTO.nguoidungDTO;
import DTO.phieumuonDTO;

public class modelND extends DefaultTableModel{
	public ArrayList<nguoidungDTO> nguoidungList;
	private static String[] colName = { "Mã nhân viên", "Mật khẩu", "Mã quyền "};

	public modelND() {
		super(colName, 0);
	}

	public void setData(ArrayList<nguoidungDTO> list) {
		this.nguoidungList = list;
	}

	public void loadData() {
		nguoidungBUS bus = new nguoidungBUS();
		for (nguoidungDTO nd : nguoidungList) {
			Vector<String> row = new Vector<String>();
			row.add(nd.getManv());
			row.add(nd.getMkhau());
			row.add(nd.getQuyen());
			super.addRow(row);
		}
	}

	public void addRow(nguoidungDTO nd) {
		if (nd == null) {
			throw new IllegalArgumentException("NULL");
		}
		Vector<Object> row = new Vector<Object>();
		row.add(nd.getManv());
		row.add(nd.getMkhau());
		row.add(nd.getQuyen());
		super.addRow(row);
	}

	public void deleteData(nguoidungDTO nd, int i) {
		super.removeRow(i);
	}

	public void updateData(nguoidungDTO nd, int i) {
		String[] temp = new String[] { nd.getManv(), nd.getMkhau(), nd.getQuyen()};
		for (int j = 0; j < colName.length - 1; j++) {
			super.setValueAt(temp[j], i, j + 1);
		}
	}

	public nguoidungDTO getND(int index) {
		return nguoidungList.get(index);
	}
}
