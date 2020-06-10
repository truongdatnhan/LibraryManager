package GUI;

import BUS.phieumuonBUS;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import BUS.theTVBUS;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class thongkePanel extends JPanel implements ActionListener {

    private tableTheThuVien tableTTV;
    private tablePM tablePMuon;
    private JDateChooser dateStart, dateEnd;
    private JButton btnThongke;
    private JPanel pnThongtin;
    public JTextField txThanhvienmoi;

    public thongkePanel() {

        setBackground(Color.WHITE);
        setLayout(null);

        pnThongtin = new JPanel();
        pnThongtin.setBorder(new TitledBorder(null, "Thông tin thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnThongtin.setBounds(30, 26, 350, 200);
        pnThongtin.setLayout(null);
        add(pnThongtin);

        JLabel lbStart = new JLabel("Ngày bắt đầu");
        lbStart.setBounds(10, 30, 100, 25);
        pnThongtin.add(lbStart);

        dateStart = new JDateChooser();
        dateStart.setBounds(150, 30, 150, 25);
        dateStart.setDateFormatString("yyyy-MM-dd");

        pnThongtin.add(dateStart);

        JLabel lbEnd = new JLabel("Ngày kết thức");
        lbEnd.setBounds(10, 60, 100, 25);
        pnThongtin.add(lbEnd);

        dateEnd = new JDateChooser();
        dateEnd.setDateFormatString("yyyy-MM-dd");
        dateEnd.setBounds(150, 60, 150, 25);

        pnThongtin.add(dateEnd);

        btnThongke = new JButton("Thống kê");
        btnThongke.setBounds(30, 95, 125, 25);
        btnThongke.addActionListener(this);
        pnThongtin.add(btnThongke);

        tableTTV = new tableTheThuVien();
        tableTTV.setBorder(new TitledBorder(null, "Thống kê số lượng thành viên mới", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tableTTV.setBounds(400, 60, 320, 166);
        tableTTV.getTable().getTableHeader().setBackground(new Color(255, 99, 0));
        tableTTV.getTable().getTableHeader().setForeground(Color.WHITE);
        tableTTV.setBackground(Color.LIGHT_GRAY);

        JLabel lbThe = new JLabel("Số lượng thành viên");
        lbThe.setBounds(400, 30, 120, 25);
        add(lbThe);

        theTVBUS bus = new theTVBUS();
        txThanhvienmoi = new JTextField();
        txThanhvienmoi.setBounds(600, 30, 50, 25);
        add(txThanhvienmoi);
        add(tableTTV);

        tablePMuon = new tablePM();
        tablePMuon.setBounds(30, 250, 500, 166);
        tablePMuon.getTable().getTableHeader().setBackground(new Color(255, 99, 0));
        tablePMuon.getTable().getTableHeader().setForeground(Color.WHITE);
        tablePMuon.setBorder(new TitledBorder(null, "Thống kê các phiếu mượn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tablePMuon.setBackground(Color.LIGHT_GRAY);
        add(tablePMuon);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        theTVBUS busTTV = new theTVBUS();
        phieumuonBUS busPM = new phieumuonBUS();
        if (e.getSource() == btnThongke) {
            try {
                if (dateStart.getDate() != null && dateEnd.getDate() != null) {
                    busTTV.loadThongKeTTV(dateStart, dateEnd);
                    busPM.loadThongKePM(dateStart, dateEnd);
                    tableTTV.setData(busTTV.getNewTTVList(dateStart.getDate(), dateEnd.getDate()));
                    txThanhvienmoi.setText(String.valueOf(theTVBUS.newTTV.size()));
                    tableTTV.loadData();

                    busPM.loadThongKePM(dateStart, dateEnd);
                    tablePMuon.setData(busPM.getTKPMList(dateStart.getDate(), dateEnd.getDate()));
                    tablePMuon.loadData();

                } else if (dateStart.getDate() != null && dateEnd.getDate() == null) {
                    Date end = new Date();
                    dateEnd.setDate(end);
                    busTTV.loadThongKeTTV(dateStart, dateEnd);
                    tableTTV.setData(busTTV.getNewTTVList(dateStart.getDate(), dateEnd.getDate()));
                    txThanhvienmoi.setText(String.valueOf(theTVBUS.newTTV.size()));
                    tableTTV.loadData();

                    busPM.loadThongKePM(dateStart, dateEnd);
                    tablePMuon.setData(busPM.getTKPMList(dateStart.getDate(), dateEnd.getDate()));
                    tablePMuon.loadData();

                } else if (dateStart.getDate() == null && dateEnd.getDate() != null) {
                    String temp = "1975-01-01";
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    Date start = formatDate.parse(temp);
                    dateStart.setDate(start);
                    busTTV.loadThongKeTTV(dateStart, dateEnd);
                    tableTTV.setData(busTTV.getNewTTVList(dateStart.getDate(), dateEnd.getDate()));
                    txThanhvienmoi.setText(String.valueOf(theTVBUS.newTTV.size()));
                    tableTTV.loadData();

                    busPM.loadThongKePM(dateStart, dateEnd);
                    tablePMuon.setData(busPM.getTKPMList(dateStart.getDate(), dateEnd.getDate()));
                    tablePMuon.loadData();
                } else {
                    JOptionPane.showMessageDialog(null, "Hãy chọn ngày để hiện thị thống kê");
                }
            } catch (ParseException ex) {
                Logger.getLogger(thongkePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(thongkePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
