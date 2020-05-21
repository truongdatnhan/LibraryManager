package FORM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import TOOL.design;

public class menuFrameAdmin extends menuFrame{

	private JPanel mainPanel;
	private JPanel pnNhanvien;
	private JLabel lbNhanvienIcon ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame frame = new menuFrameAdmin();
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
	public menuFrameAdmin() {
		
		
		
		super();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnNhanvien = new JPanel();
		pnNhanvien.setBackground(new Color(236, 239, 241));
		pnNhanvien.setBounds(306, 276, 120, 120);
		pnNhanvien.setLayout(null);
		super.mainPanel.add(pnNhanvien);
		

		lbNhanvienIcon = new JLabel("");
		lbNhanvienIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanvienIcon.setBounds(0, 0, 120, 120);
		lbNhanvienIcon.addMouseListener(this);
		pnNhanvien.add(lbNhanvienIcon);
		ImageIcon iconNhanvien = design.resizeIcon("./icon/icons8_user_filled_64.png", pnNhanvien.getWidth()/2, pnNhanvien.getHeight()/2);
		lbNhanvienIcon.setIcon(iconNhanvien);
		
		JLabel lbNhanvien = new JLabel("Quản lí nhân viên");
		lbNhanvien.setBounds(295, 408, 140, 20);
		super.mainPanel.add(lbNhanvien);
		lbNhanvien.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbNhanvien.setForeground(new Color(45,118,232));
		lbNhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbNhanvien.addMouseListener(this);
		
		pnDangxuat.setBounds(476, 276, 120, 120);
		
	}
	public void mouseClicked(MouseEvent e)  {
		// TODO Auto-generated method stub
		if(e.getSource()==lbSachIcon) {
		}else if (e.getSource()==lbNhanvienIcon){
			try {
				QLNVFrame frame = new QLNVFrame();
				frame.setVisible(true);
				this.dispose();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
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
