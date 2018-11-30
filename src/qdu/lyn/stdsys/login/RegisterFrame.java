package qdu.lyn.stdsys.login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.main.MainFrame;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

//import propertymanagement.view.RegisterFrame;


public class RegisterFrame extends JFrame{
	private JTextField userNameField;
	private JTextField nameField;
	private JTextField passwordField;
	private JTextField emailField;
	private DatabaseWork dbWork = new DatabaseWork();
	public RegisterFrame() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel loginLabel = new JLabel("");
		loginLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Loginbtn.png")));
		loginLabel.setBounds(885, 282, 145, 45);
		loginLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				loginLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				loginLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int res=JOptionPane.showConfirmDialog(null, "注册管理员", "请选择是否注册管理员", JOptionPane.YES_NO_OPTION);
                if(res==JOptionPane.YES_OPTION){
                	String AdminRegister = JOptionPane.showInputDialog(null,"请输入管理员注册码：\n","确认注册码",JOptionPane.PLAIN_MESSAGE); 
                	System.out.println(AdminRegister);
                	if(AdminRegister.equals("111")) {
                		JOptionPane.showMessageDialog(null, "欢迎你，管理员同志", "注册成功",JOptionPane.ERROR_MESSAGE); 
                		new MainFrame().setVisible(true);
                		RegisterFrame.this.dispose();
                		Administrator administrator = new Administrator();
                        administrator.setUserName(userNameField.getText());
                        administrator.setUserPassword(passwordField.getText());
                        administrator.setName(nameField.getText());
                        administrator.setEmail(emailField.getText());
                        if(dbWork.checkAdministrator(administrator)) {
                        	JOptionPane.showConfirmDialog(RegisterFrame.this, "用户已存在！", "警告", 
    								JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                        }else {
                        	dbWork.insertAdministrator(administrator);
                        }
                	}else {
                		JOptionPane.showMessageDialog(null, "输错了？还是根本没有？只要去github寻找用户suvvm就可以获取密码╮(╯▽╰)╭", "密码错误",JOptionPane.ERROR_MESSAGE); 
                	}
                    
                }else{
                	//Student student = new Student();
                }
			}
		});
		getContentPane().add(loginLabel);
		
		passwordField = new JTextField();
		passwordField.setText("密码");
		passwordField.setBounds(382, 353, 86, 24);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		userNameField = new JTextField();
		userNameField.setText("用户名");
		userNameField.setBounds(382, 278, 86, 24);
		getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setText("姓名");
		nameField.setBounds(536, 282, 86, 24);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setText("邮箱");
		emailField.setBounds(536, 353, 86, 24);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/bg/newmainmenubg.png")));
		bgLabel.setSize(1280,768);
		getContentPane().add(bgLabel);
		
	}
}
