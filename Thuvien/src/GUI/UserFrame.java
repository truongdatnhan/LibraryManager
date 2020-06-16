package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import BUS.nhanvienBUS;
import TOOL.design;

public class UserFrame extends JFrame implements MouseListener {

    protected JPanel mainPanel;
    protected JPanel leftPanel, headLeft, bodyLeft;
    protected JScrollPane scrollpane;
    protected JPanel header, centerPanel, namePanel;
    protected JPanel pnSach;
    protected JPanel pnPhieumuon;
    protected JLabel lbSach, lbPhieumuon, lbPhieuphat;
    protected QLSPanel sach;
    protected JLabel lbName, lbLogOut;
    private JPanel logOutPanel;
    private ImageIcon imgLogout;
    private JLabel lbLogo;
    protected JPanel panelPhat;
    protected JPanel pnPhieuphat;
    protected QLPPPanel phieuphat;

    public UserFrame() throws UnsupportedLookAndFeelException {
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280, 750);

        setLocationRelativeTo(null);
        setTitle("Quản lí nhân viên");
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(mainPanel);

        leftPanel = new JPanel();
        leftPanel.setBorder(new LineBorder(Color.WHITE, 0, true));
        leftPanel.setPreferredSize(new Dimension(200, 650));
        leftPanel.setBackground(new Color(122, 172, 240));
        leftPanel.setLayout(null);
        mainPanel.add(leftPanel, BorderLayout.WEST);

        pnSach = new JPanel();
        pnSach.setBounds(0, 100, 200, 40);
        pnSach.setBackground(new Color(45, 118, 232));
        pnSach.addMouseListener(this);
        leftPanel.add(pnSach);

        lbSach = new JLabel("        Sách");
        lbSach.setForeground(Color.WHITE);
        lbSach.setBounds(0, 0, 200, 40);
        ImageIcon iconS = design.resizeIcon("./icon/icons8_book_64.png", pnSach.getWidth() / 3,
                (int) (pnSach.getHeight() * 1.4));
        pnSach.setLayout(null);
        lbSach.setIcon(iconS);
        pnSach.add(lbSach);

        pnPhieumuon = new JPanel();
        pnPhieumuon.setBounds(0, 150, 200, 40);
        pnPhieumuon.setBackground(new Color(45, 118, 232));
        pnPhieumuon.addMouseListener(this);
        leftPanel.add(pnPhieumuon);

        lbPhieumuon = new JLabel("        Phiếu mượn");
        lbPhieumuon.setForeground(Color.WHITE);
        lbPhieumuon.setBounds(0, 0, 200, 40);
        ImageIcon iconPM = design.resizeIcon("./icon/icons8_Bill_64.png", pnPhieumuon.getWidth() / 3,
                (int) (pnPhieumuon.getHeight() * 1.5));
        pnPhieumuon.setLayout(null);
        lbPhieumuon.setIcon(iconPM);
        pnPhieumuon.add(lbPhieumuon);

        pnPhieuphat = new JPanel();
        pnPhieuphat.setBounds(0, 200, 200, 40);
        pnPhieuphat.setBackground(new Color(45, 118, 232));
        pnPhieuphat.addMouseListener(this);
        leftPanel.add(pnPhieuphat);
        
        lbPhieuphat = new JLabel("        Phiếu phạt");
        lbPhieuphat.setForeground(Color.WHITE);
        lbPhieuphat.setBounds(0, 0, 200, 40);
        ImageIcon iconPP = design.resizeIcon("./icon/icons8_Bill_64.png", pnPhieuphat.getWidth() / 3,
                (int) (pnPhieuphat.getHeight() * 1.5));
        pnPhieuphat.setLayout(null);
        lbPhieuphat.setIcon(iconPM);
        pnPhieuphat.add(lbPhieuphat);
        
        lbLogo = new JLabel("");
        lbLogo.setBounds(54, 14, 70, 70);
        leftPanel.add(lbLogo);

        
        
        ImageIcon logo = design.resizeIcon("./icon/book1.png", lbLogo.getWidth(), lbLogo.getHeight());
        lbLogo.setIcon(logo);

        panelPhat = new JPanel();
        panelPhat.setBounds(0, 453, 200, 58);
        panelPhat.addMouseListener(this);
        leftPanel.add(panelPhat);
        panelPhat.setLayout(null);

        JLabel lblNewLabel = new JLabel("Thống kê");
        lblNewLabel.setBounds(65, 5, 69, 20);
        panelPhat.add(lblNewLabel);

        header = new JPanel();
        header.setPreferredSize(new Dimension(1200, 40));
        header.setBackground(new Color(45, 118, 232));
        mainPanel.add(header, BorderLayout.NORTH);
        header.setLayout(null);

        nhanvienBUS bus = new nhanvienBUS();
        JLabel lbXinchao = new JLabel("Xin chào : ");

        lbXinchao.setHorizontalAlignment(SwingConstants.CENTER);
        lbXinchao.setForeground(Color.WHITE);
        lbXinchao.setBounds(740, 0, 60, 36);
        header.add(lbXinchao);

        namePanel = new JPanel();
        namePanel.setBounds(815, 0, 200, 40);
        namePanel.setBackground(new Color(45, 118, 232));
        namePanel.setLayout(null);
        namePanel.addMouseListener(this);
        header.add(namePanel);

        lbName = new JLabel(bus.findName());
        lbName.setHorizontalAlignment(SwingConstants.CENTER);
        lbName.setBounds(0, 0, 200, 40);
        lbName.addMouseListener(this);
        namePanel.add(lbName);

        logOutPanel = new JPanel();
        logOutPanel.setBounds(0, 0, 41, 40);
        logOutPanel.setBackground(new Color(45, 118, 232));
        header.add(logOutPanel);
        logOutPanel.setLayout(null);

        lbLogOut = new JLabel("");
        lbLogOut.setBounds(0, 0, 40, 40);
        logOutPanel.add(lbLogOut);

        imgLogout = design.resizeIcon("./icon/icons8_logout_rounded_left_64.png", logOutPanel.getWidth(),
                logOutPanel.getHeight());
        lbLogOut.setIcon(imgLogout);
        lbLogOut.addMouseListener(this);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        sach = new QLSPanel();
        centerPanel.add(sach, BorderLayout.CENTER);

        //pack();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pnSach || e.getSource() == lbSach) {
            centerPanel.removeAll();
            try {
                sach = new QLSPanel();
            } catch (Exception e1) {
                System.out.println(e1);
            }
            centerPanel.add(sach, BorderLayout.CENTER);
            centerPanel.repaint();
            centerPanel.revalidate();
        } else if (e.getSource() == namePanel || e.getSource() == lbName) {
            lbName.setFont(new Font("Tomaho", Font.ITALIC, 10));
            lbName.setForeground(Color.black);
            suaTT sua;
            try {
                sua = new suaTT();
                sua.setVisible(true);
                sua.loadData();
            } catch (UnsupportedLookAndFeelException e1) {
                System.out.println(e1);
            }
        } else if (e.getSource() == lbLogOut || e.getSource() == logOutPanel) {
            try {
                logInForm login = new logInForm();
                login.setVisible(true);
                dispose();
            } catch (Exception e1) {
                System.out.println(e1);
            }
        } else if (e.getSource() == pnPhieumuon || e.getSource() == lbPhieumuon) {
            centerPanel.removeAll();
            QLPMPanel phieumuon = new QLPMPanel();
            centerPanel.add(phieumuon, BorderLayout.CENTER);
            centerPanel.repaint();
            centerPanel.revalidate();
        } else if (e.getSource() == pnPhieuphat || e.getSource() == lbPhieuphat) {
            centerPanel.removeAll();
            QLPPPanel phieuphat = new QLPPPanel();
            centerPanel.add(phieuphat, BorderLayout.CENTER);
            centerPanel.repaint();
            centerPanel.revalidate();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == pnSach) {
            pnSach.setBackground(new Color(43, 110, 214));
        } else if (e.getSource() == pnPhieumuon) {
            pnPhieumuon.setBackground(new Color(43, 110, 214));
        } else if (e.getSource() == pnPhieuphat) {
        	pnPhieuphat.setBackground(new Color(43, 110, 214));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == pnSach) {
            pnSach.setBackground(new Color(45, 118, 232));
        } else if (e.getSource() == pnPhieumuon) {
            pnPhieumuon.setBackground(new Color(45, 118, 232));
        } else if (e.getSource() == namePanel) {
            lbName.setFont(new Font("Tomaho", Font.PLAIN, 16));
        } else if (e.getSource() == pnPhieuphat) {
        	pnPhieuphat.setBackground(new Color(45, 118, 232));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) {}
}
