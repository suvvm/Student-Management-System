package qdu.lyn.stdsys.login;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import qdu.lyn.stdsys.login.LoginFrame;

public class LoginFrame extends JFrame{
	private LoginPanel loginPanel;
	private JLabel userLable;
	private JTextField userField;
	private JLabel passwordLable;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton exitButton;
	
	public LoginFrame() {
		// TODO �Զ����ɵĹ��캯�����
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			initFrame();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private LoginPanel getLoginPanel() {
		if(loginPanel == null) {
			userLable = new JLabel();
			userLable.setBounds(new Rectangle(85, 41, 56, 18));
			userLable.setText("�û���");
			passwordLable = new JLabel();
			passwordLable.setBounds(new Rectangle(86, 71, 55, 18));
			passwordLable.setText("��   ��");
			
			loginPanel = new LoginPanel();
			loginPanel.setLayout(null);
			loginPanel.setBackground(Color.GREEN);
			
			loginPanel.add(userLable);
			loginPanel.add(getUserFirld());
			loginPanel.add(passwordLable);
			loginPanel.add(getPasswordFirld());
			loginPanel.add(getButtonLogin());
			loginPanel.add(getButtonExit());
		}
		return loginPanel;
	}
	private JTextField getUserFirld(){
		if(userField == null) {
			userField = new JTextField();
			userField.setBounds(new Rectangle(142, 39, 127, 22));
		}
		return userField;
	}
	private JPasswordField getPasswordFirld(){
		if(passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));
			passwordField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO �Զ����ɵķ������
					if (arg0.getKeyChar() == '\n')// ���µİ����ǻس�ʱ
						loginButton.doClick();// ����¼����ťִ�е���¼�
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO �Զ����ɵķ������
					
				}
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO �Զ����ɵķ������
					
				}
			});
		}
		return passwordField;
	}
	private JButton getButtonLogin() {
		if(loginButton == null) {
			loginButton = new JButton();
			loginButton.setText("��¼");
			loginButton.setBounds(new Rectangle(80, 114, 90, 45));
			loginButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO �Զ����ɵķ������
					try {
						//userStr = userField.getText();
						//String passStr = new String(passwordField.getPassword());
						if (true) {	//!***.checkLogin(userStr, passStr)
							JOptionPane.showMessageDialog(LoginFrame.this, "�û��������벻ƥ�䣬�޷���¼", "��¼ʧ��",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return loginButton;
	}
	private JButton getButtonExit() {
		if(exitButton == null) {
			exitButton = new JButton();
			exitButton.setText("�˳�");
			exitButton.setBounds(new Rectangle(185, 114, 90, 45));
			exitButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO �Զ����ɵķ������
					System.exit(0);
				}
			});
		}
		return exitButton;
	}
	public void initFrame() {
		setTitle("�û���¼");
		setSize(350, 230);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(getLoginPanel());
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		LoginFrame loginFrame = new LoginFrame();
	}

}
