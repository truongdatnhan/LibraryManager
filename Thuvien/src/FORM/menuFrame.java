package FORM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TOOL.design;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class menuFrame extends JFrame implements MouseListener{

	public JPanel mainPanel;
	protected JPanel pnCaigi,pnDangxuat,pnSach,pnDocgia;
	protected JLabel lbSach,lbSachIcon,lbDocgia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame frame = new menuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuFrame() {
		// đóng là kết thúc chương trình
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocationRelativeTo(null);
		setTitle("Quản lí thư viện");
		mainPanel = new JPanel();
		//mainPanel.setBackground(Color.white);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(45,118,232));
		panel.setBounds(0, 0, 900, 90);
		mainPanel.add(panel);
		
		pnSach = new JPanel();
		pnSach.setBackground(new Color(236, 239, 241));
		pnSach.setBounds(117, 123, 120, 120);
		mainPanel.add(pnSach);
		pnSach.setLayout(null);
		
		lbSachIcon = new JLabel("");
		lbSachIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbSachIcon.setBounds(0, 0, 120, 120);
		pnSach.add(lbSachIcon);
		lbSachIcon.addMouseListener(this);
		ImageIcon iconSach = design.resizeIcon("./icon/icons8_book_64.png", pnSach.getWidth()/2, pnSach.getHeight()/2);
		lbSachIcon.setIcon(iconSach);
		
		pnDocgia = new JPanel();
		pnDocgia.setLayout(null);
		pnDocgia.setBackground(new Color(236, 239, 241));
		pnDocgia.setBounds(307, 123, 120, 120);
		mainPanel.add(pnDocgia);
		
		JLabel lbNguoidocIcon = new JLabel("");
		lbNguoidocIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbNguoidocIcon.setBounds(0, 0, 120, 120);
		lbNguoidocIcon.addMouseListener(this);
		pnDocgia.add(lbNguoidocIcon);
		ImageIcon iconNguoidoc = design.resizeIcon("./icon/icons8_reading_64.png", pnSach.getWidth()/2, pnSach.getHeight()/2);
		lbNguoidocIcon.setIcon(iconNguoidoc);
		
		JPanel pnHoadon = new JPanel();
		pnHoadon.setLayout(null);
		pnHoadon.setBackground(new Color(236, 239, 241));
		pnHoadon.setBounds(476, 123, 120, 120);
		mainPanel.add(pnHoadon);
		
		JLabel lbPhieu = new JLabel("");
		lbPhieu.setBounds(0, 0, 120, 120);
		pnHoadon.add(lbPhieu);
		
		pnCaigi = new JPanel();
		pnCaigi.setLayout(null);
		pnCaigi.setBackground(new Color(236, 239, 241));
		pnCaigi.setBounds(117, 276, 120, 120);
		mainPanel.add(pnCaigi);
		
		pnDangxuat = new JPanel();
		pnDangxuat.setLayout(null);
		pnDangxuat.setBackground(new Color(236, 239, 241));
		pnDangxuat.setBounds(307, 276, 120, 120);
		mainPanel.add(pnDangxuat);
		
		lbSach = new JLabel("Quản lí sách");
		lbSach.setBounds(117, 250, 120, 20);
		mainPanel.add(lbSach);
		lbSach.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbSach.setForeground(new Color(45,118,232));
		lbSach.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbDocgia = new JLabel("Quản lí độc giả");
		lbDocgia.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbDocgia.setForeground(new Color(45,118,232));
		lbDocgia.setHorizontalAlignment(SwingConstants.CENTER);
		lbDocgia.setBounds(307, 250, 120, 20);
		mainPanel.add(lbDocgia);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lbSachIcon) {
		}else {
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lbSachIcon) {
			pnSach.setBackground(Color.LIGHT_GRAY);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lbSachIcon) {
			pnSach.setBackground(new Color(236, 239, 241));
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
