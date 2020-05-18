package FORM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.nguoidungBUS;
import DTO.nguoidungDTO;
import TOOL.check;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class logInForm extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel mainPanel;
	private JTextField txUserName;
	private JPasswordField tpPassword;
	private JPanel pnLogin;
	private JLabel lbLogin;
	private JLabel lbUsername;
	private JLabel lbPassword;
	private nguoidungBUS bus;
	private JLabel lbTitle;
	private JLabel lbClose;
	private JPanel closePanel;
	private JLabel lbForgetPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInForm frame = new logInForm();
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
	public logInForm() throws Exception {
		bus = new nguoidungBUS();
		bus.docDSND();
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		setLocationRelativeTo(null);
		setUndecorated(true);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(154, 206, 235));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		JLabel lbIcon = new JLabel("");
		lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbIcon.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\ThuVien\\icon\\book1.png"));
		lbIcon.setBackground(Color.WHITE);
		lbIcon.setBounds(315, 56, 200, 94);
		mainPanel.add(lbIcon);

		JPanel navPanel = new JPanel();
		navPanel.setBackground(new Color(31, 117, 254));
		navPanel.setBounds(0, 0, 800, 40);
		mainPanel.add(navPanel);
		navPanel.setLayout(null);

		lbTitle = new JLabel("QUẢN LÍ THƯ VIỆN");
		lbTitle.setBackground(new Color(0, 0, 0));
		lbTitle.setForeground(new Color(0, 0, 0));
		lbTitle.setFont(new Font("Calibri", Font.BOLD, 25));
		lbTitle.setBounds(315, 0, 215, 40);
		navPanel.add(lbTitle);

		closePanel = new JPanel();
		closePanel.setBounds(760, 0, 40, 40);
		closePanel.setBackground(new Color(31, 117, 254));
		navPanel.add(closePanel);
		closePanel.setLayout(null);

		lbClose = new JLabel("");
		lbClose.setBounds(0, 0, 40, 40);
		closePanel.add(lbClose);

		lbClose.setIcon(new ImageIcon("D:\\Program Files\\Eclipse\\ThuVien\\icon\\close.png_32.png"));
		lbClose.setHorizontalAlignment(SwingConstants.CENTER);
		lbClose.addMouseListener(this);
		closePanel.addMouseListener(this);

		txUserName = new JTextField();
		txUserName.setBounds(315, 166, 200, 30);
		mainPanel.add(txUserName);
		txUserName.setColumns(10);
		txUserName.addKeyListener(this);

		tpPassword = new JPasswordField();
		tpPassword.setBounds(315, 223, 200, 30);
		mainPanel.add(tpPassword);
		tpPassword.addKeyListener(this);

		pnLogin = new JPanel();
		pnLogin.setBackground(new Color(25, 166, 210));
		pnLogin.setBounds(315, 273, 200, 30);
		mainPanel.add(pnLogin);
		pnLogin.setLayout(null);

		lbLogin = new JLabel("Đăng nhập");
		lbLogin.setBounds(0, 0, 200, 30);
		pnLogin.add(lbLogin);
		lbLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		lbLogin.setHorizontalAlignment(SwingConstants.CENTER);
		pnLogin.addMouseListener(this);

		lbUsername = new JLabel("Tài khoản");
		lbUsername.setFont(new Font("Calibri", Font.BOLD, 18));
		lbUsername.setBounds(200, 166, 100, 40);
		mainPanel.add(lbUsername);

		lbPassword = new JLabel("Mật khẩu");
		lbPassword.setFont(new Font("Calibri", Font.BOLD, 18));
		lbPassword.setBounds(200, 219, 100, 40);
		mainPanel.add(lbPassword);

		lbForgetPass = new JLabel("Quên mật khẩu ?");
		lbForgetPass.setForeground(new Color(0, 0, 139));
		lbForgetPass.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbForgetPass.setHorizontalAlignment(SwingConstants.LEFT);
		lbForgetPass.setBounds(315, 319, 137, 20);
		lbForgetPass.addMouseListener(this);
		mainPanel.add(lbForgetPass);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pnLogin || e.getSource() == lbLogin) {
			if (check.checkNull(txUserName.getText())) {
				txUserName.setBorder(BorderFactory.createLineBorder(Color.red));
				JOptionPane.showMessageDialog(null, "Hãy nhập vào tài khoản");
			} else if (check.checkNull(new String(tpPassword.getPassword()))) {
				tpPassword.setBorder(BorderFactory.createLineBorder(Color.red));
				JOptionPane.showMessageDialog(null, "Hãy nhập vào mật khẩu");
			} else {
				nguoidungDTO nguoidung = new nguoidungDTO();
				nguoidung.setManv(txUserName.getText());
				nguoidung.setMkhau(new String(tpPassword.getPassword()));
				if (bus.checkAccount(nguoidung.getManv(), nguoidung.getMkhau(), "MQ001") == true) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					menu Menu;
					try {
						Menu = new menu();
						Menu.setVisible(true);
						setVisible(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (bus.checkAccount(nguoidung.getManv(), nguoidung.getMkhau(), "MQ002") == true) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					menu Menu;
					try {
						Menu = new menu();
						Menu.setVisible(true);
						setVisible(false);
						Menu.tabbedPane.removeTabAt(0);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
				}
			}
		} else if (e.getSource() == lbClose) {
			if (JOptionPane.showConfirmDialog(null, "Bạn muốn đóng ứng dụng ?", "Confirmation",
					JOptionPane.YES_NO_OPTION) == 0) {
				try {
					bus.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				logInForm.this.dispose();

			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pnLogin || e.getSource() == lbLogin) {
			pnLogin.setBackground(new Color(31, 117, 254));
		} else if (e.getSource() == lbClose) {
			closePanel.setBackground(new Color(253, 64, 83));
		} else if (e.getSource() == lbForgetPass) {
			lbForgetPass.setForeground(new Color(143, 80, 157));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pnLogin || e.getSource() == lbLogin) {
			pnLogin.setBackground(new Color(25, 166, 210));
		} else if (e.getSource() == lbClose) {
			closePanel.setBackground(new Color(31, 117, 254));
		} else if (e.getSource() == lbForgetPass) {
			lbForgetPass.setForeground(new Color(0, 0, 139));
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

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == txUserName) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				tpPassword.requestFocus(true);
			}
		} else if (e.getSource() == tpPassword) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				pnLogin.setBackground(new Color(31, 117, 254));
				lbLogin.requestFocus(true);

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
