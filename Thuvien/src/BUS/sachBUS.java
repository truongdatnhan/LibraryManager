package BUS;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DAO.nhanvienDAO;
import DTO.nhanvienDTO;
import DTO.sachDTO;


public class sachBUS {
	public static ArrayList<sachDTO> dss;
	
	public DefaultTableModel docDSND() throws Exception {
		//khai báo defaulttablemodel
		DefaultTableModel model = new DefaultTableModel();
		//khai báo đối tượng data từ lớp nhanvienDAO
		//nếu danh sách nhân viên null thì sẽ tạo ra một arraylist mới
		if (dss == null) {
			dss = new ArrayList<sachDTO>();
		}
		//đọc dữ liệu lên và truyền vào arraylist
		dsnv = nhanvienDAO.docDSNV();
		//gắn tiêu đề cho model
		Vector<String> header = new Vector<String>();
		header.add("Mã sách");
		header.add("Tên sách");
		header.add("");
		header.add("Ngày sinh");
		header.add("Giới tính");
		header.add("Địa chỉ");
		header.add("Email");
		header.add("Số điện thoại");
		header.add("Lương");
		//đếm số dòng trong model nếu bằng không tạo một model mới với header
		if (model.getRowCount() == 0) {
			model = new DefaultTableModel(header, 0);
		}
		//cho chạy từng nhan viên trong danh sách nhân viên
		for (nhanvienDTO nv : dsnv) {
			Vector<String> row = new Vector<String>();
			row.add(nv.getManv());
			row.add(nv.getHo());
			row.add(nv.getTen());
			row.add(nv.getNgaysinh());
			row.add(nv.getGioitinh());
			row.add(nv.getDiachi());
			row.add(nv.getEmail());
			row.add(nv.getSdt());
			row.add(nv.getLuong());
			model.addRow(row);
		}
		//trả về giá trị của của model
		return model;
	}
}
