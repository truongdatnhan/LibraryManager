package BUS;

import java.util.ArrayList;
import javax.swing.*;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.nhanvienDAO;
import DTO.nhanvienDTO;
import TOOL.check;

public class nhanvienBUS {
	public static ArrayList<nhanvienDTO> dsnv;

	public DefaultTableModel docDSND() throws Exception {
		//khai báo defaulttablemodel
		DefaultTableModel model = new DefaultTableModel();
		//khai báo đối tượng data từ lớp nhanvienDAO
		nhanvienDAO data = new nhanvienDAO();
		//nếu danh sách nhân viên null thì sẽ tạo ra một arraylist mới
		if (dsnv == null) {
			dsnv = new ArrayList<nhanvienDTO>();
		}
		//đọc dữ liệu lên và truyền vào arraylist
		dsnv = data.docDSNV();
		//gắn tiêu đề cho model
		Vector<String> header = new Vector<String>();
		header.add("Mã nhân viên");
		header.add("Họ");
		header.add("Tên");
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

	public void Insert(nhanvienDTO nv) throws Exception {
		nhanvienDAO data = new nhanvienDAO();
		data.Insert(nv);
		dsnv.add(nv);
	}

	public void Delete(nhanvienDTO nv) throws Exception {
		nhanvienDAO data = new nhanvienDAO();
		data.Delete(nv);
		dsnv.remove(nv);
		
	}

	public void Update(nhanvienDTO nv) throws Exception {
		nhanvienDAO data = new nhanvienDAO();
		data.Update(nv);
		// phần thêm
		int k = 0;
		for (int i = 0; i < dsnv.size(); i++) {
			if (((nhanvienDTO) dsnv.get(i)).getManv().equals(nv.getManv())) {
				k = i;
			}
		}
		dsnv.set(k, nv);
	}
	
	public boolean checkID(String manv) {
		int k = 0;
		for(nhanvienDTO nv : dsnv) {
			if(manv.compareToIgnoreCase(nv.getManv())==0) {
				JOptionPane.showMessageDialog(null,"Mã nhân viên này đã tồn tại");
				k++;
			}
		} 
		if(k==0) {
			//là false thì không trùng
			return false;
		}else {
			//true là trùng
			return true;
		}
	}

}
