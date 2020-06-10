package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;
import DTO.phieumuonDTO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class tablePM extends JPanel{
	public JTable table ;
	private modelPM model;
	TableRowSorter<DefaultTableModel> tr;
	
	public tablePM() {
		model = new modelPM();
		table = new JTable(model);
		tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		
		table.setEnabled(true);
		setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setData(ArrayList<phieumuonDTO> list) {
		model.setData(list);
	}
	
	public void refresh() {
		model.fireTableDataChanged();
	}
	
	public void loadData() {
		model.loadData();
	}
	
	public void addData(phieumuonDTO pm) {
		model.addRow(pm);
	}
	
	public void  deleteData(int i) {
		model.deleteData(i);
	}
	
	public void updateData(phieumuonDTO pm,int i ) {
		model.updateData(pm, i);
	}
	
	public modelPM getModel() {
		return model;
	}
	
	public JTable getTable() {
		return table;
	}

	public TableRowSorter<DefaultTableModel> getTr() {
		return tr;
	}

	public void setTr(TableRowSorter<DefaultTableModel> tr) {
		this.tr = tr;
	}
}
