package BUS;

import DAO.ctpnDAO;
import DTO.ctpnDTO;
import DTO.phieunhapDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ctpnBUS {

    public static ArrayList<ctpnDTO> dsctpn;
    ctpnDAO data = new ctpnDAO();

    

    public ArrayList<ctpnDTO> getDSCTPN() throws Exception {
        if (dsctpn == null) {
            dsctpn = new ArrayList<>();
        }
        dsctpn = data.docCTPN();
        return dsctpn;
    }
    // XUÂT THEO MÃ NÈ
    public ArrayList<ctpnDTO> getDSCTPN(String ID) throws Exception {
        ArrayList<ctpnDTO> temp = new ArrayList<>();
        if(dsctpn == null){
            dsctpn = new ArrayList<>();
        }
        for(ctpnDTO ctpn : dsctpn){
            if(ID.equals(ctpn.getMapn())){
                temp.add(ctpn);
            }
        }
        return temp;
    }
    
    

    public void Insert(ctpnDTO ctpn) {
        dsctpn.add(ctpn);
    }

    public void Delete(ctpnDTO ctpn) {
        dsctpn.add(ctpn);
    }

    public void Update(ctpnDTO ctpn) {
        int k = -1;
        for (int i = 0; i < dsctpn.size(); i++) {
            if (ctpn.getMapn().equals(dsctpn.get(i).getMapn()) && ctpn.getMasach().equals(dsctpn.get(i).getMasach())) {
                k = i;
            }
        }
        if (k > -1) {
            dsctpn.set(k, ctpn);
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn chi tiết muốn sửa");
        }
    }

    public void Save() throws Exception {
        for (ctpnDTO ctpn : dsctpn) {
            data.Insert(ctpn);
        }
    }

    public long Sum(String ID) {
        long sum = 0;
        for (int i = 0; i < dsctpn.size(); i++) {
            if (dsctpn.get(i).getMapn().equals(ID)) {
                dsctpn.get(i).setThanhtien(dsctpn.get(i).getSoluong() * dsctpn.get(i).getDongia());
                sum += dsctpn.get(i).getThanhtien();
            }
        }
        return sum;
    }

    public void test() {
        JOptionPane.showMessageDialog(null, dsctpn.size());
    }

    public void countPrice(String Mapn, long price) throws Exception {
        JOptionPane.showConfirmDialog(null, phieunhapBUS.dspn.size());
        for (phieunhapDTO phieunhap : phieunhapBUS.dspn) {
            if (Mapn.equals(phieunhap.getMapn())) {
                phieunhap.setTongtien(price);
            }
        }
    }
}
