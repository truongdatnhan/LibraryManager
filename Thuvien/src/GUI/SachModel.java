package GUI;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import DTO.sachDTO;
import BUS.sachBUS;

public class SachModel extends DefaultTableModel {

	public ArrayList<sachDTO> sachList;
	private static String[] colName = { "Mã sách", "Tên sách", "Gía sách", "Mã thể loại", "Mã tác giả", "Mã NXB",
			"Mã lĩnh vực", "Số lượng" };

	public SachModel() {
		super(colName, 0);
	}

	@Override
	public boolean isCellEditable(int col, int row) {
		return false;
	}

	public void setData(ArrayList<sachDTO> list) {
		this.sachList = list;
	}

	public void loadData() {
		sachBUS bus = new sachBUS();
		setData(bus.getSachList());
		for (sachDTO nv : sachList) {
			Vector<String> row = new Vector<String>();
			row.add(nv.getMasach());
			row.add(nv.getTensach());
			row.add(String.valueOf(nv.getGiasach()));
			row.add(nv.getMatheloai());
			row.add(nv.getMatg());
			row.add(nv.getManxb());
			row.add(nv.getMalinhvuc());
			row.add(String.valueOf(nv.getSoluong()));
			row.add(nv.getHinhanh());
			row.add(String.valueOf(nv.getTrangthai()));
			super.addRow(row);
		}
	}

	public void addRow(sachDTO nv) {
		if (nv == null) {
			throw new IllegalArgumentException("NULL");
		}
		Vector<String> row = new Vector<String>();
		row.add(nv.getMasach());
		row.add(nv.getTensach());
		row.add(String.valueOf(nv.getGiasach()));
		row.add(nv.getMatheloai());
		row.add(nv.getMatg());
		row.add(nv.getManxb());
		row.add(nv.getMalinhvuc());
		row.add(String.valueOf(nv.getSoluong()));
		row.add(nv.getHinhanh());
		row.add(String.valueOf(nv.getTrangthai()));
		super.addRow(row);
	}

	public sachDTO getSach(int index) {
		return sachList.get(index);
	}

	public void set(int row, sachDTO nv) {
		super.setValueAt(nv.getTensach(), row, 1);
		super.setValueAt(nv.getGiasach(), row, 2);
		super.setValueAt(nv.getMatheloai(), row, 3);
		super.setValueAt(nv.getMatg(), row, 4);
		super.setValueAt(nv.getManxb(), row, 5);
		super.setValueAt(nv.getMalinhvuc(), row, 6);
		super.setValueAt(nv.getSoluong(), row, 7);
	}

	public void removeRow(int index) {
		super.removeRow(index);
	}
}
