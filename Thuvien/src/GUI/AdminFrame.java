package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BUS.nhanvienBUS;
import TOOL.ThongTinEvent;
import TOOL.ThongTinListener;
import TOOL.design;

public class AdminFrame extends UserFrame implements ActionListener, MouseListener {

	private JLabel lbNhanvien;
	private JLabel lbTaikhoan;
	private QLNVPanel nhanvien;
	private QLTKPanel taikhoan;
	private JPanel pnNhanvien;
	private JPanel pnTaikhoan;
	private suaTT sua;
	
	public AdminFrame() throws Exception {
		super();
		pnPhieumuon.setLocation(0, 250);
		pnSach.setLocation(0, 200);

		pnNhanvien = new JPanel();
		pnNhanvien.setBounds(0, 100, 180, 40);
		pnNhanvien.setBackground(new Color(45, 118, 232));
		pnNhanvien.addMouseListener(this);
		leftPanel.add(pnNhanvien);
		pnNhanvien.setLayout(null);

		lbNhanvien = new JLabel("        Nhân viên");
		lbNhanvien.setForeground(Color.WHITE);
		lbNhanvien.setBounds(0, 0, 180, 40);
		ImageIcon iconNV = design.resizeIcon("./icon/icons8_Resume_64.png", pnNhanvien.getWidth() / 3,
				(int) (pnNhanvien.getHeight() * 1.5));
		lbNhanvien.setIcon(iconNV);
		pnNhanvien.add(lbNhanvien);

		pnTaikhoan = new JPanel();
		pnTaikhoan.setBounds(0, 150, 180, 40);
		pnTaikhoan.setBackground(new Color(45, 118, 232));
		pnTaikhoan.addMouseListener(this);
		leftPanel.add(pnTaikhoan);
		pnTaikhoan.setLayout(null);

		lbTaikhoan = new JLabel("        Tài khoản");
		lbTaikhoan.setForeground(Color.WHITE);
		lbTaikhoan.setBounds(0, 0, 180, 40);
		ImageIcon iconTK = design.resizeIcon("./icon/icons8_user_64.png", pnTaikhoan.getWidth() / 3,
				(int) (pnTaikhoan.getHeight() * 1.5));
		lbTaikhoan.setIcon(iconTK);
		pnTaikhoan.add(lbTaikhoan);

		pnSach.setBounds(0, 200, 180, 40);
		pnSach.addMouseListener(this);

		pnPhieumuon.setBounds(0, 250, 180, 40);
		pnPhieumuon.addMouseListener(this);

		nhanvien = new QLNVPanel();
		centerPanel.add(nhanvien, BorderLayout.CENTER);
		
		sua = new suaTT();
		sua.setThongTinLisnter(new ThongTinListener() {
			@Override
			public void thongTin(ThongTinEvent evt) {
				nhanvien.table.getModel().updateRow(evt.getManv(), evt);
				nhanvienBUS bus = new nhanvienBUS();
				bus.updateThongTinEvent(evt);
				nhanvien.table.setData(bus.getNVList());
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
	}

	@Override

	public void mouseClicked(MouseEvent evt) {
		if (evt.getSource() == pnNhanvien || evt.getSource() == lbNhanvien) {
			centerPanel.removeAll();
			try {
				nhanvien = new QLNVPanel();
			} catch (Exception e) {
				e.printStackTrace();
			}
			centerPanel.add(nhanvien, BorderLayout.CENTER);
			centerPanel.repaint();
			centerPanel.revalidate();
		} else if (evt.getSource() == pnTaikhoan || evt.getSource() == lbTaikhoan) {
			centerPanel.removeAll();
			taikhoan = new QLTKPanel();
			centerPanel.add(taikhoan, BorderLayout.CENTER);
			centerPanel.repaint();
			centerPanel.revalidate();
		} else if (evt.getSource() == pnSach || evt.getSource() == lbSach) {
			centerPanel.removeAll();
			try {
				sach = new QLSPanel();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			centerPanel.add(sach, BorderLayout.CENTER);
			centerPanel.repaint();
			centerPanel.revalidate();
		} else if (evt.getSource() == namePanel || evt.getSource() == lbName) {
			lbName.setFont(new Font("Tomaho", Font.BOLD, 16));
			lbName.setForeground(Color.black);
			sua.setVisible(true);
			sua.loadData();
		} else if (evt.getSource() == pnPhieumuon) {
			centerPanel.removeAll();
			QLPMPanel phieumuon = new QLPMPanel();
			centerPanel.add(phieumuon, BorderLayout.CENTER);
			centerPanel.repaint();
			centerPanel.revalidate();
		} else if(evt.getSource()==panelPhat) {
			/*centerPanel.removeAll();
			thongkePanel thongke = new thongkePanel();
			centerPanel.add(thongke,BorderLayout.CENTER);
			centerPanel.repaint();
			centerPanel.revalidate();*/
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pnNhanvien) {
			pnNhanvien.setBackground(new Color(43, 110, 214));
		} else if (e.getSource() == pnSach) {
			pnSach.setBackground(new Color(43, 110, 214));
		} else if (e.getSource() == pnPhieumuon) {
			pnPhieumuon.setBackground(new Color(43, 110, 214));
		} else if (e.getSource() == pnTaikhoan) {
			pnTaikhoan.setBackground(new Color(43, 110, 214));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == pnNhanvien) {
			pnNhanvien.setBackground(new Color(45, 118, 232));
		} else if (e.getSource() == pnSach) {
			pnSach.setBackground(new Color(45, 118, 232));
		} else if (e.getSource() == pnPhieumuon) {
			pnPhieumuon.setBackground(new Color(45, 118, 232));
		} else if (e.getSource() == pnTaikhoan) {
			pnTaikhoan.setBackground(new Color(45, 118, 232));
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
