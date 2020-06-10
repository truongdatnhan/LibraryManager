package BUS;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import DAO.sachDAO;
import DTO.sachDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class sachBUS {

    public static ArrayList<sachDTO> dss;
    public static ArrayList<sachDTO> dssdaydu;

    public ArrayList<sachDTO> getSachList() {
        if (dss == null) {
            dss = new ArrayList<sachDTO>();
        }
        //Ä‘á»c dá»¯ liá»‡u lĂªn vĂ  truyá»n vĂ o arraylist
        try {
            sachDAO dao = new sachDAO();
            dss = dao.filteredList();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dss;
    }

    public  void getSachListdaydu() {
        if (dssdaydu == null) {
            dssdaydu = new ArrayList<sachDTO>();
        }
        //Ä‘á»c dá»¯ liá»‡u lĂªn vĂ  truyá»n vĂ o arraylist
        try {
            sachDAO dao = new sachDAO();
            dao.docDSS();
            dssdaydu = dao.getdss();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Insert(sachDTO a) throws Exception {
        if (sameid(a.getMasach()) == false) {
            sachDAO dao = new sachDAO();
            dao.Insert(a);
            dss.add(a);
        } else {
            JOptionPane.showMessageDialog(null, "Sách đã tồn tại-Không thể thêm");
        }
    }

    public void Delete(sachDTO a) {
        try {
            a.setTrangthai(0);
            a.setHinhanh("");
            sachDAO dao = new sachDAO();
            dss.remove(sameid(a));
            dao.Delete(a);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa sách");
        }

    }

    public void Update(sachDTO a) {
        try {
            sachDAO dao = new sachDAO();
            dao.Update(a);
            dss.set(sameid(a), a);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa");
        }
    }

    public boolean sameid(String a) {
        for (int i = 0; i < dss.size(); i++) {
            sachDTO temp = ((sachDTO) dss.get(i));
            if (temp.getMasach().equals(a)) {
                return true;                                    //true là trùng 
            }
        }
        return false;
    }

    public int sameid(sachDTO a) {
        for (int i = 0; i < dss.size(); i++) {
            sachDTO temp = ((sachDTO) dss.get(i));
//                JOptionPane.showMessageDialog(null, temp.getMasach());
            if (temp.getMasach().equals(a.getMasach())) {
                return i;
            }
        }
        return -1;
    }

    public boolean sameiddaydu(String a) {
        for (int i = 0; i < dssdaydu.size(); i++) {
            sachDTO temp = ((sachDTO) dssdaydu.get(i));
            if (temp.getMasach().equals(a)) {
                return true;                                    //true là trùng 
            }
        }
        return false;
    }

    public String sinhma() {
        String temp = null;
        if (dssdaydu.size() < 10) {
            temp = "S00" + String.valueOf(dssdaydu.size() + 1);
        } else if (dssdaydu.size() >= 10 && dssdaydu.size() < 100) {
            temp = "S0" + String.valueOf(dssdaydu.size() + 1);
        } else {
            temp = "S" + String.valueOf(dssdaydu.size() + 1);
        }
        return temp;
    }
}
