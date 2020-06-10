package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import BUS.ctpmBUS;
import BUS.ctpnBUS;
import BUS.nhanvienBUS;
import BUS.phieumuonBUS;
import BUS.phieunhapBUS;
import BUS.sachBUS;
import DTO.ctpnDTO;
import DTO.phieumuonDTO;
import DTO.phieunhapDTO;
import TOOL.check;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class QLPNPanel extends JPanel implements MouseListener, ActionListener {

    private boolean clickedToCreate = false;
    private JTextField txMapn;
    private JTextField txManv;
    private JTextField txMancc;
    private JDateChooser datechooser;
    private JTextField txMsach;
    private JTextField txSoluong;
    private JTextField txDongia;
    private JTextField txNcc;
    private tablePN table;
    private tableCTPN tableCTP;
    private JButton btnThemPN, btnThemCTPN, btnLuu;
    private ctpnBUS busCTPN;
    private phieunhapBUS busPN;
    private sachBUS busSach;
    private nhanvienBUS busNhanvien;

    public QLPNPanel() throws Exception {
        setBackground(Color.WHITE);
        setLayout(null);

        JLabel lbMaPN = new JLabel("Mã phiếu nhập");
        lbMaPN.setBounds(541, 30, 99, 25);
        add(lbMaPN);

        txMapn = new JTextField();
        txMapn.setBounds(675, 29, 191, 25);
        add(txMapn);

        JLabel lbManv = new JLabel("Mã nhân viên");
        lbManv.setBounds(541, 70, 99, 25);
        add(lbManv);

        txManv = new JTextField();
        txManv.setBounds(675, 70, 163, 26);
        add(txManv);

        JButton btnNewButton = new JButton("...");
        btnNewButton.setBounds(841, 70, 25, 25);
        add(btnNewButton);

        JLabel lbNgaynhap = new JLabel("Ngày nhập");
        lbNgaynhap.setBounds(541, 110, 69, 25);
        add(lbNgaynhap);

        datechooser = new JDateChooser();
        datechooser.setBounds(675, 110, 191, 25);
        datechooser.setDateFormatString("yyyy-MM-dd");
        add(datechooser);

        JLabel lbNcc = new JLabel("Mã nhà cung cấp");
        lbNcc.setBounds(541, 150, 99, 25);
        add(lbNcc);

        txNcc = new JTextField();
        txNcc.setBounds(675, 150, 163, 26);
        add(txNcc);

        JButton btnNcc = new JButton("...");
        btnNcc.setBounds(841, 150, 25, 25);
        add(btnNcc);

        table = new tablePN();
        phieunhapBUS bus = new phieunhapBUS();
        table.setData(bus.getDSPN());
        table.loadData();
        table.setBounds(15, 16, 511, 258);
        add(table);

        JLabel lbMsach = new JLabel("Mã sách");
        lbMsach.setBounds(40, 346, 69, 20);
        add(lbMsach);

        txMsach = new JTextField();
        txMsach.setBounds(180, 343, 250, 26);
        add(txMsach);
        txMsach.setColumns(10);

        JLabel lbSoluong = new JLabel("Số lượng");
        lbSoluong.setBounds(40, 382, 69, 20);
        add(lbSoluong);

        txSoluong = new JTextField();
        txSoluong.setBounds(180, 382, 250, 26);
        add(txSoluong);
        txSoluong.setColumns(10);

        JLabel lbDongia = new JLabel("Đơn giá");
        lbDongia.setBounds(40, 419, 69, 20);
        add(lbDongia);

        txDongia = new JTextField();
        txDongia.setBounds(180, 419, 250, 26);
        add(txDongia);
        txDongia.setColumns(10);

        ctpnBUS busCTPN = new ctpnBUS();
        tableCTP = new tableCTPN();
        tableCTP.setBounds(477, 290, 555, 302);
        tableCTP.setData(busCTPN.getDSCTPN());
        tableCTP.loadData();
        add(tableCTP);

        table.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getTable().getSelectedRow();
                phieunhapDTO phieunhap = phieunhapBUS.dspn.get(i);
                if (i >= 0) {
                    try {
                        tableCTP.setData(busCTPN.getDSCTPN(phieunhap.getMapn()));
                        tableCTP.loadData();
                    } catch (Exception ex) {
                        Logger.getLogger(QLPNPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        btnThemPN = new JButton("Tạo phiếu mới");
        btnThemPN.setBounds(541, 190, 150, 25);
        add(btnThemPN);
        btnThemPN.addActionListener(this);

        btnThemCTPN = new JButton("Thêm chi tiết");
        btnThemCTPN.setBounds(40, 460, 150, 25);
        add(btnThemCTPN);
        btnThemCTPN.addActionListener(this);

        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(40, 500, 150, 25);
        add(btnLuu);
        btnLuu.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        busNhanvien = new nhanvienBUS();
        busPN = new phieunhapBUS();
        busCTPN = new ctpnBUS();
        if (e.getSource() == btnThemPN) {
            phieunhapDTO pn = new phieunhapDTO();
            if (check.checkNull(txMapn.getText())) {
                JOptionPane.showMessageDialog(null, "Hãy nhập vào mã phiếu nhập");
            } else {
                pn.setMapn(txMapn.getText());
                nhanvienBUS.dsnv = busNhanvien.getNVList();
                if (check.checkNull(txManv.getText())) {
                    JOptionPane.showMessageDialog(null, "Hãy nhập vào mã nhân viên");
                } else {
                    if (busNhanvien.checkID(txManv.getText())) {
                        pn.setManv(txManv.getText());
                        pn.setMancc(txNcc.getText());
                        Date ngay = new Date();
                        if (datechooser.getDate() == null) {
                            JOptionPane.showConfirmDialog(null, "Hãy chọn ngày nhập");
                        } else {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String date = sdf.format(datechooser.getDate());
                            pn.setNgaynhap(date);

                            try {
                                busPN.Insert(pn);
                            } catch (Exception ex) {
                                Logger.getLogger(QLPNPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            table.addData(pn);

                            clickedToCreate = true;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã nhân viên này chưa tồn tại");
                    }
                }
            }
        } else if (e.getSource() == btnThemCTPN) {
            if (clickedToCreate) {
                ctpnDTO ctpn = new ctpnDTO();
                ctpn.setMapn(txMapn.getText());
                if (check.checkNull(txMsach.getText())) {
                    JOptionPane.showMessageDialog(null, "Hãy nhập vào mã sách");
                } else {
                    ctpn.setMasach(txMsach.getText());
                    if (busSach.sameid(txMsach.getText())==true) {
                        JOptionPane.showMessageDialog(null, "Trùng mã rồi nè");
                    } else {
                        if (check.checkNull(txSoluong.getText()) && check.isNumeric(txSoluong.getText())) {
                            JOptionPane.showConfirmDialog(null, "Hãy kiểm tra lại số lượng");
                        } else {
                            ctpn.setSoluong(Integer.parseInt(txSoluong.getText()));
                            if (check.checkNull(txDongia.getText()) && check.isNumeric(txDongia.getText())) {
                                JOptionPane.showMessageDialog(null, "Hãy kiểm tra lại đơn giá");
                            } else {
                                ctpn.setDongia(Integer.parseInt(txDongia.getText()));
                                ctpn.setThanhtien(ctpn.getDongia() * ctpn.getSoluong());
                                busCTPN.Insert(ctpn);
                                tableCTP.addData(ctpn);
                                try {
                                    busCTPN.countPrice(txMapn.getText(), busCTPN.Sum(txMapn.getText()));
                                } catch (Exception ex) {
                                    Logger.getLogger(QLPNPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                table.loadData();
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Hãy tạo phiếu nhập mới rồi mới thực hiện thao tác này");
            }
        } else if (e.getSource() == btnLuu) {

        }
    }
}
