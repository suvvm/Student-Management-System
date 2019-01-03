package qdu.lyn.stdsys.main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;

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
import java.awt.Toolkit;


public class MainFrame extends JFrame{
	private JPanel contentPane;
	//private String cursorUrl;
	
	/*public static void main(String[] args) {
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
	}	*/
	public MainFrame() {
		
		String cursorUrl = "/img/Cursors/Pointer.png";
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();  
		Image img = new ImageIcon(MainFrame.class.getResource("/Cursors/Pointer.png")).getImage();
		Cursor cursor = tk.createCustomCursor(img,new Point(10,10),"stick"); 
		setCursor(cursor);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/ico/NewPM.png")));
		setTitle("主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginLabel = new JLabel("");
		loginLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/but/Loginbtn.jpg")));
		loginLabel.setBounds(885, 285, 145, 38);
		loginLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				loginLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				loginLabel.setIcon(new ImageIcon(NewLoginFrame.class.getResource("/but/Loginbtn.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				new NewLoginFrame().setVisible(true);
				MainFrame.this.dispose();
			}
		});
		//loginLabel.setCursor(cursor);
		contentPane.add(loginLabel);
		
		JLabel registerLabel = new JLabel("");
		registerLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/but/Register.jpg")));
		registerLabel.setBounds(885, 323, 145, 44);
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
				// TODO 自动生成的方法存根
				new RegisterFrame().setVisible(true);
				MainFrame.this.dispose();
			}
		});
		contentPane.add(registerLabel);
		
		
		
		/*JLabel lblNewLabel_3 = new JLabel("New label");
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
				//new ManagementFrame().setVisible(true);
				//MainFrame.this.dispose();
			}
		});
		contentPane.add(lblNewLabel_3);*/
		
		JLabel exitLabel = new JLabel("");
		exitLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/but/Exitbut.jpg")));
		exitLabel.setBounds(885, 620, 145, 44);
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/but/Exitbut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/but/Exitbut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				System.exit(1);
			}
		});
		contentPane.add(exitLabel);
		
		/*JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/Cursors/Pointer.png")));
		lblNewLabel_1.setBounds(502, 259, 54, 66);
		contentPane.add(lblNewLabel_1);*/
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1252, 768);
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/bg/mainFrameBg.jpg")));
		//lblNewLabel.setCursor(cursor);
		contentPane.add(lblNewLabel);
		//add(contentPane);
	}
}
