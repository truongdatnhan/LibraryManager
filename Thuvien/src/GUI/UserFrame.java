package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import BUS.nhanvienBUS;
import TOOL.design;

public class UserFrame extends JFrame implements MouseListener {

	protected JPanel mainPanel;
	protected JPanel leftPanel;
	protected JScrollPane scrollpane;
	protected JPanel header, centerPanel, namePanel;
	protected JPanel pnSach;
	protected JPanel pnPhieumuon;
	protected JLabel lbSach, lbPhieumuon;
	protected QLSPanel sach;
	protected JLabel lbName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 */
	public UserFrame() throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new com.jtattoo.plaf.luna.LunaLookAndFeel());
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1200, 650);
		setLocationRelativeTo(null);
		setTitle("Quản lí nhân viên");
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(mainPanel);

		leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(Color.WHITE, 0, true));
		// leftPanel.setPreferredSize(new Dimension(200, 650));
		leftPanel.setBackground(new Color(122, 172, 240));
		// mainPanel.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(null);

		scrollpane = new JScrollPane(leftPanel);
		scrollpane.setPreferredSize(new Dimension(200, 650));
		mainPanel.add(scrollpane, BorderLayout.WEST);

		pnSach = new JPanel();
		pnSach.setBounds(0, 100, 198, 40);
		pnSach.setBackground(new Color(45, 118, 232));
		pnSach.addMouseListener(this);
		leftPanel.add(pnSach);

		lbSach = new JLabel("        Sách");
		lbSach.setForeground(Color.WHITE);
		lbSach.setBounds(0, 0, 198, 40);
		// lbSach.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon iconS = design.resizeIcon("./icon/icons8_book_64.png", pnSach.getWidth() / 3,
				(int) (pnSach.getHeight() * 1.4));
		pnSach.setLayout(null);
		lbSach.setIcon(iconS);
		pnSach.add(lbSach);

		pnPhieumuon = new JPanel();
		pnPhieumuon.setBounds(0, 150, 198, 40);
		pnPhieumuon.setBackground(new Color(45, 118, 232));
		pnPhieumuon.addMouseListener(this);
		leftPanel.add(pnPhieumuon);

		lbPhieumuon = new JLabel("        Phiếu mượn");
		lbPhieumuon.setForeground(Color.WHITE);
		lbPhieumuon.setBounds(0, 0, 198, 40);
		// lbSach.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon iconPM = design.resizeIcon("./icon/icons8_Bill_64.png", pnPhieumuon.getWidth() / 3,
				(int) (pnPhieumuon.getHeight() * 1.5));
		pnPhieumuon.setLayout(null);
		lbPhieumuon.setIcon(iconPM);
		pnPhieumuon.add(lbPhieumuon);

		JPanel pnLogout = new JPanel();
		pnLogout.setBounds(0, 0, 45, 45);
		leftPanel.add(pnLogout);
		pnLogout.setBackground(new Color(122, 172, 240));
		pnLogout.setLayout(null);

		JLabel lbDangxuat = new JLabel("");
		lbDangxuat.setHorizontalAlignment(SwingConstants.CENTER);
		lbDangxuat.setBounds(0, 0, 45, 45);
		pnLogout.add(lbDangxuat);

		ImageIcon iconLogout = design.resizeIcon("./icon/icons8_logout_rounded_left_64.png",
				(int) (pnLogout.getWidth() / 1.5), (int) (pnLogout.getHeight() / 1.5));
		lbDangxuat.setIcon(iconLogout);

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

		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		sach = new QLSPanel();
		centerPanel.add(sach, BorderLayout.CENTER);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pnSach || e.getSource() == lbSach) {
			centerPanel.removeAll();
			try {
				sach = new QLSPanel();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			centerPanel.add(sach, BorderLayout.CENTER);
			centerPanel.repaint();
			centerPanel.revalidate();
			
		}else if(e.getSource()==namePanel||e.getSource()==lbName) {
			suaMKNV sua = new suaMKNV();
			namePanel.setBackground(Color.black);
			sua.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == namePanel) {
			pnSach.setBackground(new Color(43, 110, 214));
		} else if (e.getSource() == pnPhieumuon) {
			pnPhieumuon.setBackground(new Color(43, 110, 214));
		}else if (e.getSource() == namePanel||e.getSource()==lbName) {
			lbName.setFont(new Font("Tomaho", Font.BOLD, 16));
			namePanel.setBackground(Color.black);
//			lbname.setForeground(Color.black);
//			suaMKNV passChange = new suaMKNV();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pnSach) {
			pnSach.setBackground(new Color(45, 118, 232));
		} else if (e.getSource() == pnPhieumuon) {
			pnPhieumuon.setBackground(new Color(45, 118, 232));
		}else if (e.getSource() == namePanel) {
			lbName.setFont(new Font("Tomaho", Font.PLAIN, 16));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
