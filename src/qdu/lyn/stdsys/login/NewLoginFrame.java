package qdu.lyn.stdsys.login;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.image.ImageUrl;
import qdu.lyn.stdsys.main.MainFrame;
import qdu.lyn.stdsys.main.ManagementFrame;
import qdu.lyn.stdsys.main.StudentUseFrame;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;

import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalInternalFrameTitlePane;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;


public class NewLoginFrame extends JFrame{
	private JTextField userNameField;
	private JPasswordField passwordField;
	
	private DatabaseWork dbWork = new DatabaseWork(); 
	public NewLoginFrame() {
		
		String cursorUrl = "/img/Cursors/Pointer.png";
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon(MainFrame.class.getResource("/Cursors/Pointer.png")).getImage();
		Cursor cursor = tk.createCustomCursor(img,new Point(10,10),"stick"); 
		setCursor(cursor);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewLoginFrame.class.getResource("/ico/NewPM.png")));
		setSize(1280, 768);
		getContentPane().setLayout(null);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); 
		int screenWidth = screenSize.width/2;
		int screenHeight = screenSize.height/2; 
		int height = this.getHeight();
		int width = this.getWidth();
		setLocation(screenWidth-width/2, screenHeight-height/2);
		
		JLabel loginButton = new JLabel("");
		loginButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn.jpg")));
		loginButton.setBounds(886, 284, 143, 44);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				loginButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				loginButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				Administrator user = new Administrator();
				Student users = new Student();
				user.setUserName(userNameField.getText());
				user.setUserPassword(new String(passwordField.getPassword()));
				
				//JOptionPane.showMessageDialog(null, passwordField.getPassword(), "", JOptionPane.ERROR_MESSAGE);
				users.setUserName(userNameField.getText());
				users.setUserPassword(new String(passwordField.getPassword()));
				if(dbWork.confirmAdministrator(user)){
					//user.setEmail();
					new ManagementFrame(user).setVisible(true);
					NewLoginFrame.this.dispose();
				}else if(dbWork.confirmStudent(users)){
					List<String> list = dbWork.getOneStudent(users);
					//System.out.println(" " + list.get(0)+ " " + list.get(1) + " " + list.get(2));
					users.setName(list.get(0));
					users.setEmail(list.get(1));
					users.setId(Integer.parseInt(list.get(2)));
					
					new StudentUseFrame(users).setVisible(true);
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
		exitButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Exitbut.jpg")));
		exitButton.setBounds(886, 618, 143, 44);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Exitbut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitButton.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Exitbut.jpg")));
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
		userNameField.setBounds(350, 407, 125, 24);
		getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(647, 407, 125, 24);
		
		getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(257, 666, 74, 30);
		getContentPane().add(label);
		
		JLabel backToMain = new JLabel("");
		backToMain.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/backToMain.jpg")));
		backToMain.setBounds(886, 581, 143, 38);
		backToMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				backToMain.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/backToMain_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				backToMain.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/backToMain.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				new MainFrame().setVisible(true);
				NewLoginFrame.this.dispose();
			}
		});
		getContentPane().add(backToMain);
		
		JLabel RegisterLabel = new JLabel("");
		RegisterLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Register.jpg")));
		RegisterLabel.setBounds(886, 326, 143, 44);
		RegisterLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				RegisterLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Register_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				RegisterLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Register.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				new RegisterFrame().setVisible(true);
				NewLoginFrame.this.dispose();
			}
		});
		getContentPane().add(RegisterLabel);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/bg/nloginbg.jpg")));
		bgLabel.setBounds(0, 0, 1280, 768);
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
