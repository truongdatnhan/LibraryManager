package GUI;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable{
	private DefaultTableModel model;
	public MyTable() {
		JTable table = new JTable();
		table.setModel(model);
	}
}
