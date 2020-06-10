package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import DTO.nhanvienDTO;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class tableNhanvien extends JPanel {

    public JTable table;
    private NhanVienModel nvModel;
    TableRowSorter<DefaultTableModel> tr;
    
    public tableNhanvien() {

        nvModel = new NhanVienModel();
        table = new JTable(nvModel);
        tr = new TableRowSorter<DefaultTableModel>(nvModel);
	table.setRowSorter(tr);
        table.setEnabled(true);
        table.getTableHeader().setBackground(Color.BLUE);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(15);
        table.getColumnModel().getColumn(7).setPreferredWidth(15);
        table.getColumnModel().getColumn(8).setPreferredWidth(15);
        table.setRowHeight(30);
        table.setFont(new Font("Calibri", Font.PLAIN, 18));
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

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

    public void deleteData(nhanvienDTO nv, int i) {
        nvModel.deleteData(nv, i);
    }

    public void updateData(nhanvienDTO nv, int i) {
        nvModel.updateData(nv, i);
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
    public TableRowSorter<DefaultTableModel> getTr() {
	return tr;
    }

    public void setTr(TableRowSorter<DefaultTableModel> tr) {
	this.tr = tr;
    }

}
