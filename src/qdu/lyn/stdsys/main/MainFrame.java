package qdu.lyn.stdsys.main;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import qdu.lyn.stdsys.login.NewLoginFrame;
import qdu.lyn.stdsys.login.RegisterFrame;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;


public class MainFrame extends JFrame{
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	public MainFrame() {
		setTitle("主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel = new JLabel("");
		loginLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/but/Loginbtn.png")));
		loginLabel.setBounds(885, 285, 145, 38);
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
				// TODO 自动生成的方法存根
				new NewLoginFrame().setVisible(true);
				MainFrame.this.dispose();
			}
		});
		contentPane.add(loginLabel);
		
		JLabel registerLabel = new JLabel("");
		registerLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
		registerLabel.setBounds(885, 323, 145, 44);
		registerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				registerLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				registerLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				new RegisterFrame().setVisible(true);
				MainFrame.this.dispose();
			}
		});
		contentPane.add(registerLabel);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(MainFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
		lblNewLabel_3.setBounds(885, 368, 145, 44);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				lblNewLabel_3.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				lblNewLabel_3.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				//tabbedPane.setVisible(true);
				new ManagementFrame().setVisible(true);
				MainFrame.this.dispose();
			}
		});
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(MainFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
		lblNewLabel_4.setBounds(885, 620, 145, 44);
		contentPane.add(lblNewLabel_4);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1252, 768);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/bg/newmainmenubg.png")));
		contentPane.add(lblNewLabel);
	}
}
