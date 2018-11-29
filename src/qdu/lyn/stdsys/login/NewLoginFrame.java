package qdu.lyn.stdsys.login;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.image.ImageUrl;
import qdu.lyn.stdsys.main.MainFrame;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;

import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalInternalFrameTitlePane;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.swing.JPasswordField;
import java.awt.Color;


public class NewLoginFrame extends JFrame{
	private JTextField userNameField;
	private JPasswordField passwordField;
	
	private DatabaseWork dbWork = new DatabaseWork(); 
	public NewLoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewLoginFrame.class.getResource("/ico/NewPM.png")));
		setSize(1280, 768);
		getContentPane().setLayout(null);
		
		JLabel loginButton = new JLabel("");
		loginButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn.png")));
		loginButton.setBounds(899, 295, 143, 44);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				loginButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				loginButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				Administrator user = new Administrator();
				Student users = new Student();
				user.setUserName(userNameField.getText());
				user.setUserPassword(new String(passwordField.getPassword()));
				
				JOptionPane.showMessageDialog(null, passwordField.getText(), "", JOptionPane.ERROR_MESSAGE);
				users.setUserName(userNameField.getText());
				users.setUserPassword(new String(passwordField.getText()));
				if(dbWork.confirmAdministrator(user)) {
					new MainFrame().setVisible(true);
					NewLoginFrame.this.dispose();
				}else if(dbWork.confirmStudent(users)){
					new MainFrame().setVisible(true);
					NewLoginFrame.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "登录失败", "用户名或密码不匹配", JOptionPane.ERROR_MESSAGE);
	                return;
				}
			}
		});
		getContentPane().add(loginButton);
		
		
		
		JLabel exitButton = new JLabel("");
		exitButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Exitbut.png")));
		exitButton.setBounds(899, 632, 143, 44);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Exitbut_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Exitbut.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				int res=JOptionPane.showConfirmDialog(null, "退出程序", "是否要退出学生管理系统", JOptionPane.YES_NO_OPTION);
                if(res==JOptionPane.YES_OPTION){ 
                      System.exit(1);
                }else{
                    return;
                }
			}
		});
		getContentPane().add(exitButton);
		
		userNameField = new JTextField();
		userNameField.setForeground(Color.WHITE);
		userNameField.setBackground(Color.DARK_GRAY);
		userNameField.setBounds(383, 420, 125, 24);
		getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(642, 420, 125, 24);
		
		getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(257, 666, 74, 30);
		getContentPane().add(label);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/bg/nloginbg.png")));
		bgLabel.setBounds(14, 13, 1280, 768);
		getContentPane().add(bgLabel);
		
		
		
		
	}
	public static void main(String[] args) {
		NewLoginFrame newLoginFrame = new NewLoginFrame();
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					NewLoginFrame frame = new NewLoginFrame(); 
					frame.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		//newLoginFrame.setVisible(true);
	}
}
