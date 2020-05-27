package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import DTO.nhanvienDTO;

public class TableNhanVien extends JPanel {

	private JTable table;
	private NhanVienModel nvModel;
	
	public TableNhanVien() {
		
		nvModel = new NhanVienModel();
		table = new JTable(nvModel);
		
		table.setEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.setRowHeight(30);
		table.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	}
	
	public void setData(ArrayList<nhanvienDTO> list) {
		nvModel.setData(list);
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}
	
	public void refresh() {
		nvModel.fireTableDataChanged();
	}
	
	public void loadData() {
		nvModel.loadData();
	}
	
	public void addData(nhanvienDTO nv) {
		nvModel.addRow(nv);
	}
	
	public NhanVienModel getModel() {
		return nvModel;
	}
	
	public void setRowSorter(TableRowSorter sorter) {
		table.setRowSorter(sorter);
	}

	public JTable getTable() {
		return table;
	}
	
}
