package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;
import DTO.phieumuonDTO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TablePhieuMuon extends JPanel{
	public JTable table ;
	private modelPM model;
	
	public TablePhieuMuon() {
		model = new modelPM();
		table = new JTable(model);
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
	
	public void  deleteData(phieumuonDTO pm,int i) {
		model.deleteData(pm, i);
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
	
}
