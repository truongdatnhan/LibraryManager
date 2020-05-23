package FORM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TOOL.design;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class QLNVFrame extends JFrame implements ActionListener, MouseListener {

	private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel pnTaikhoan;
	private JLabel lbNv;
	private JLabel lbTaikhoan;
	private JPanel pnNhanvien;
	private JPanel pnMenu;
	private JLabel lbMenu;
	private ImageIcon iconNav;
	private QLNVPanel nhanvien;
	private QLTKPanel taikhoan;
	private JLabel lbreturn;
	private JPanel centerPanel;
	private JLabel lbAvatarIcon;
	private JPanel panelIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNVFrame frame = new QLNVFrame();
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
	 * @throws Exception
	 */
	public QLNVFrame() throws Exception {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		setLocationRelativeTo(null);
		setTitle("Quản lí nhân viên");
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(mainPanel);

		leftPanel = new JPanel();
		leftPanel.setBorder(new LineBorder(Color.WHITE, 0, true));
		leftPanel.setPreferredSize(new Dimension(200, 650));
		leftPanel.setBackground(new Color(45, 118, 232));
		mainPanel.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(null);

		pnNhanvien = new JPanel();
		pnNhanvien.setBorder(new EmptyBorder(0, 0, 2, 0));
		pnNhanvien.setBounds(0, 173, 200, 60);
		pnNhanvien.setBackground(new Color(45, 118, 232));
		leftPanel.add(pnNhanvien);
		pnNhanvien.setLayout(null);
		
				lbNv = new JLabel("Nhân viên");
				lbNv.setBounds(0, 0, 200, 60);
				pnNhanvien.add(lbNv);
				lbNv.setHorizontalAlignment(SwingConstants.CENTER);
				lbNv.setFont(new Font("Times New Roman", Font.BOLD, 20));
				lbNv.setForeground(Color.WHITE);
				lbNv.addMouseListener(this);
		pnNhanvien.addMouseListener(this);

		pnTaikhoan = new JPanel();
		pnTaikhoan.setBorder(new EmptyBorder(0, 0, 2, 0));
		pnTaikhoan.setBounds(0, 249, 200, 60);
		pnTaikhoan.setBackground(new Color(45, 118, 232));
		leftPanel.add(pnTaikhoan);
		pnTaikhoan.setLayout(null);
		
				lbTaikhoan = new JLabel("Tài khoản");
				lbTaikhoan.setBounds(0, 0, 200, 60);
				pnTaikhoan.add(lbTaikhoan);
				lbTaikhoan.setForeground(Color.WHITE);
				lbTaikhoan.setHorizontalAlignment(SwingConstants.CENTER);
				lbTaikhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
				lbTaikhoan.addMouseListener(this);
		pnTaikhoan.addMouseListener(this);

		pnMenu = new JPanel();
		pnMenu.setBounds(160, 0, 40, 40);
		pnMenu.setBackground(new Color(45, 118, 232));
		pnMenu.addMouseListener(this);
		leftPanel.add(pnMenu);
		pnMenu.setLayout(null);

		iconNav = design.resizeIcon("./icon/icons8_menu_filled_64.png", pnMenu.getWidth(), pnMenu.getHeight());
		lbMenu = new JLabel("");
		lbMenu.setBounds(0, 0, 40, 40);
		lbMenu.setIcon(iconNav);
		lbMenu.addMouseListener(this);
		pnMenu.add(lbMenu);
		
		lbAvatarIcon = new JLabel("");
		lbAvatarIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbAvatarIcon.setBounds(61, 55, 80, 80);
		ImageIcon avatarIcon = design.resizeIcon("./icon/icons8_user_64.png", lbAvatarIcon.getHeight(), lbAvatarIcon.getWidth());
		lbAvatarIcon.setIcon(avatarIcon);
		leftPanel.add(lbAvatarIcon);
		
		panelIcon = new JPanel();
		panelIcon.setBackground(new Color(45,118,232));
		panelIcon.setBounds(84, 455, 40, 40);
		leftPanel.add(panelIcon);
		panelIcon.setLayout(null);
		
		lbreturn = new JLabel("");
		lbreturn.setBounds(0, 0, 40, 40);
		panelIcon.add(lbreturn);
		
		//lbreturn.setIcon(new ImageIcon("./icon/icons8_return_64.png"));
		lbreturn.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon returnIcon = design.resizeIcon("./icon/icons8_return_64.png", (int)(panelIcon.getWidth()),(int) (panelIcon.getHeight()));
		lbreturn.setIcon(returnIcon);
		lbreturn.addMouseListener(this);
		
//		taikhoan = new QLTKPanel();
//		mainPanel.add(taikhoan,BorderLayout.CENTER);
		
		nhanvien = new QLNVPanel();
		mainPanel.add(nhanvien,BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}
	@Override

	public void mouseClicked(MouseEvent evt) {
//		// TODO Auto-generated method stub
//		if(evt.getSource()==lbNv) {
//			taikhoan.setVisible(false);
//			nhanvien.setVisible(true);
//		}else {
//			taikhoan.setVisible(true);
//			nhanvien.setVisible(false);
//		}
		if(evt.getSource()==lbreturn) {
			menuFrameAdmin frame = new menuFrameAdmin();
			frame.setVisible(true);
			dispose();
		}
		
	}
	
		
	

	@Override
	public void mouseEntered(MouseEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource()==lbreturn) {
			panelIcon.setBackground(new Color(1,87,155));
		}

	}

	@Override
	public void mouseExited(MouseEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource()==lbreturn) {
			panelIcon.setBackground(new Color(45,118,232));
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
