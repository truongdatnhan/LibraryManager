/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.phieuphatDTO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;


public class phieuphatDAO {

    MyConnectUnit conn = null;
    ResultSet rs = null;
    private ArrayList<phieuphatDTO> dspp;

    public phieuphatDAO() {
        if (conn == null) {
            conn = new MyConnectUnit("localhost", "root", "", "thuvien","phieuphatDAO");
        }
    }

    public ArrayList<phieuphatDTO> docDSPP() throws Exception {
        dspp = new ArrayList<>();
        rs = conn.Select("phieuphat");
        while (rs.next()) {
            phieuphatDTO pp = new phieuphatDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getLong(4));
            dspp.add(pp);
        }
        conn.Close();
        return dspp;
    }
    
    public void Insert(phieuphatDTO pp) throws Exception{
        HashMap<String,Object> insertValue = new HashMap<>();
        insertValue.put("mapp", pp.getMapp());
        insertValue.put("mapm", pp.getMapm());
        insertValue.put("ngaylap",pp.getNgaylap());
        insertValue.put("tongtien", String.valueOf(pp.getTongtien()));
        boolean kt =  conn.Insert("phieuphat", insertValue);
        if(kt == true){
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        }else{
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
    }
    
    public void Delete(phieuphatDTO pp) throws Exception{
        boolean kt = conn.Delete("phieuphat","mapp = '"+pp.getMapp()+"'");
        if(kt == true){
            JOptionPane.showConfirmDialog(null, "Xóa thành công");
        }else{
            JOptionPane.showMessageDialog(null, "Xóa thất bại");
        }
    }
    
    public void Update(phieuphatDTO pp) throws Exception{
        HashMap<String,Object> updateValue = new HashMap<>();
        updateValue.put("mapp", pp.getMapp());
        updateValue.put("mapm", pp.getMapm());
        updateValue.put("ngaylap",pp.getNgaylap());
        //updateValue.put("tongtien", String.valueOf(pp.getTongtien()));
        
        boolean kt = conn.Update("phieuphat", updateValue,"mapp = '"+pp.getMapp()+"'");
        if(kt == true){
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        }else{
            JOptionPane.showMessageDialog(null, "Sủa thất bại");
        }
    }
}
