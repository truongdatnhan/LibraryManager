/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.phieunhapDAO;
import DTO.phieunhapDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class phieunhapBUS {

    public static ArrayList<phieunhapDTO> dspn;
    phieunhapDAO data = new phieunhapDAO();

    public ArrayList<phieunhapDTO> getDSPN() throws Exception {
        if (dspn == null) {
            dspn = new ArrayList<>();
        }
        dspn = data.docDSPN();
        return dspn;
    }

    public void Insert(phieunhapDTO pn) throws Exception {
        dspn.add(pn);
       // data.Insert(pn);
    }

    public void Delete(phieunhapDTO pn) throws Exception {
        dspn.remove(pn);
        //data.Delete(pn);
    }

    public void Update(phieunhapDTO pn) throws Exception {
        int k = -1;
        for (int i = 0; i < dspn.size(); i++) {
            if (pn.getMapn().equals(dspn.get(i).getMapn())) {
                k = i;
            }
        }
        if (k > -1) {
            dspn.set(k, pn);
           // data.Update(pn);
        }else{
            JOptionPane.showMessageDialog(null,"Hãy chọn phiếu nhập cần thay đổi");
        }
    }
    
    public void Save(phieunhapDTO pn) throws Exception{
        data.Insert(pn);
    }
    
}
