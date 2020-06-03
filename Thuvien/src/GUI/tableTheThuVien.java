package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import DTO.nhanvienDTO;
import DTO.theTVDTO;

public class tableTheThuVien extends JPanel{
	public JTable table;
	private modelTTV model;

	public tableTheThuVien() {

		model = new modelTTV();
		table = new JTable(model);
		table.setEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		table.getColumnModel().getColumn(0).setPreferredWidth(10);
//		table.getColumnModel().getColumn(2).setPreferredWidth(30);
//		table.getColumnModel().getColumn(3).setPreferredWidth(40);
//		table.getColumnModel().getColumn(4).setPreferredWidth(5);
//		table.getColumnModel().getColumn(5).setPreferredWidth(15);
//		table.getColumnModel().getColumn(7).setPreferredWidth(15);
//		table.getColumnModel().getColumn(8).setPreferredWidth(15);
//		table.setRowHeight(30);
//		table.setFont(new Font("Calibri", Font.PLAIN, 18));
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);

	}

	public void setData(ArrayList<theTVDTO> list) {
		model.setData(list);
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}

	public void refresh() {
		model.fireTableDataChanged();
	}

	public void loadData() {
		model.loadData();
	}
	
	public void addData(theTVDTO the) {
		model.addRow(the);
	}

	public void deleteRow(theTVDTO the, int i) {
		model.deleteRow(the, i);
	}

	public void updateData(theTVDTO the, int i) {
		model.updateData(the, i);
	}

	public modelTTV getModel() {
		return model;
	}

	public void setRowSorter(TableRowSorter sorter) {
		table.setRowSorter(sorter);
	}

	public JTable getTable() {
		return table;
	}

}