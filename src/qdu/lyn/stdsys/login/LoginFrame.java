package qdu.lyn.stdsys.login;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

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
	public LoginPanel getLoginPanel() {
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
	public JTextField get() {
		
	}
	public void initFrame() {
		setTitle("�û���¼");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(getLoginPane());
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
	}

}
