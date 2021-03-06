package qdu.lyn.stdsys.login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.main.MainFrame;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Color;

//import propertymanagement.view.RegisterFrame;


public class RegisterFrame extends JFrame{
	private JTextField userNameField;
	private JTextField nameField;
	private JTextField passwordField;
	private JTextField emailField;
	private DatabaseWork dbWork = new DatabaseWork();
	private JTextField IdField;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	public RegisterFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon(MainFrame.class.getResource("/Cursors/Pointer.png")).getImage();
		Cursor cursor = tk.createCustomCursor(img,new Point(10,10),"stick"); 
		setCursor(cursor);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterFrame.class.getResource("/ico/NewPM.png")));
		
		
		
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel registerLabel = new JLabel("");
		registerLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Register.jpg")));
		registerLabel.setBounds(885, 282, 145, 45);
		registerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				registerLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Register_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				registerLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Register.jpg")));
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
                        	new MainFrame().setVisible(true);
                    		RegisterFrame.this.dispose();
                        }
                	}else {
                		JOptionPane.showMessageDialog(null, "输错了？还是根本没有？只要去github寻找用户suvvm找到本项目readme就可以获取密码╮(╯▽╰)╭", "密码错误",JOptionPane.ERROR_MESSAGE); 
                	}
                    
                }else if(res==JOptionPane.NO_OPTION){
                	Student student = new Student();
                	student.setUserName(userNameField.getText());
                	student.setUserPassword(passwordField.getText());
                	student.setName(nameField.getText());
                	student.setEmail(emailField.getText());
                	student.setId(Integer.parseInt(IdField.getText()));
                	
                	if(dbWork.checkStudent(student)){
                		JOptionPane.showConfirmDialog(RegisterFrame.this, "用户已存在！", "警告", 
								JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                	}else {
                		dbWork.insertStudent(student);
                    	new MainFrame().setVisible(true);
                		RegisterFrame.this.dispose();
                	}
                }
			}
		});
		getContentPane().add(registerLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(547, 224, 145, 24);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		userNameField = new JTextField();
		userNameField.setBounds(547, 161, 145, 24);
		getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(547, 283, 145, 24);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		IdField = new JTextField();
		IdField.setBounds(547, 404, 145, 24);
		getContentPane().add(IdField);
		IdField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(547, 345, 145, 24);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel exitLabel = new JLabel("");
		exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut.jpg")));
		exitLabel.setBounds(885, 620, 145, 42);
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				System.exit(1);
			}
		});
		
		
		getContentPane().add(exitLabel);
		
		JLabel backToMainLabel = new JLabel("");
		backToMainLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/backToMain.jpg")));
		backToMainLabel.setBounds(885, 577, 145, 42);
		backToMainLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				backToMainLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/backToMain_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				backToMainLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/backToMain.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				new MainFrame().setVisible(true);
				RegisterFrame.this.dispose();
			}
		});
		getContentPane().add(backToMainLabel);
		
		label = new JLabel("用户名");
		label.setForeground(Color.DARK_GRAY);
		label.setBounds(439, 164, 72, 18);
		getContentPane().add(label);
		
		label_1 = new JLabel("密码");
		label_1.setBounds(439, 227, 72, 18);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("姓名");
		label_2.setBounds(439, 282, 72, 18);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("邮箱");
		label_3.setBounds(439, 348, 72, 18);
		getContentPane().add(label_3);
		
		label_4 = new JLabel("学号");
		label_4.setBounds(439, 407, 72, 18);
		getContentPane().add(label_4);
		
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/bg/reBg.jpg")));
		bgLabel.setSize(1280,768);
		getContentPane().add(bgLabel);
		
	}
}
