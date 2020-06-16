package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import DTO.ctppDTO;


public class ctppDAO {
    MyConnectUnit conn = null;
    ResultSet rs = null;
    protected ArrayList<ctppDTO> dsctpp;

    public ctppDAO() {
        if (conn == null) {
            conn = new MyConnectUnit("localhost", "root", "", "thuvien");
        }
    }
    
    public ArrayList<ctppDTO> docCTPP() throws Exception {
    	dsctpp = new ArrayList<>();
        rs = conn.Select("ctphieuphat");
        while (rs.next()) {
            ctppDTO ctpp = new ctppDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
            dsctpp.add(ctpp);
        }
        if (dsctpp == null) {
            return null;
        } else {
            return dsctpp;
        }
    }
    
    public void Insert(ctppDTO ctpp) throws Exception {
        HashMap<String, Object> insertValue = new HashMap<>();
        insertValue.put("mapp", ctpp.getMapp());
        insertValue.put("masach", ctpp.getMasach());
        insertValue.put("soluong", String.valueOf(ctpp.getSoluong()));
        insertValue.put("maqd", ctpp.getMaqd());
        insertValue.put("thanhtien", String.valueOf(ctpp.getThanhtien()));
        boolean kt = conn.Insert("ctphieuphat", insertValue);
        if (kt == true) {
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }
    
    public void Delete(ctppDTO ctpp) throws Exception {
        boolean kt = conn.Delete("ctphieuphat", "mapp = '" + ctpp.getMapp() + "' and masach = '" + ctpp.getMasach() + "'");
        if (kt == true) {
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }
    
    public void Update(ctppDTO ctpp) throws Exception {
        HashMap<String, Object> updateValue = new HashMap<>();
        updateValue.put("mapp", ctpp.getMapp());
        updateValue.put("masach", ctpp.getMasach());
        updateValue.put("soluong", String.valueOf(ctpp.getSoluong()));
        updateValue.put("maqd", ctpp.getMaqd());
        updateValue.put("thanhtien", String.valueOf(ctpp.getThanhtien()));
        boolean kt = conn.Update("ctphieuphat", updateValue, "mapp = '" + ctpp.getMapp() + "' and masach = '" + ctpp.getMasach() + "'");
        if (kt == true) {
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
        }
    }
    
    public ArrayList<ctppDTO> filteredList(String ID) throws Exception {
        dsctpp = docCTPP();
        ArrayList<ctppDTO> edited = new ArrayList<>();
        for (ctppDTO ctpp : dsctpp) {
            if (ctpp.getMapp().equals(ID)) {
                edited.add(ctpp);
            }
        }
        return edited;
    }
    
}
