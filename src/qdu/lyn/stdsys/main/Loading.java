package qdu.lyn.stdsys.main;

import javax.swing.JFrame;

import qdu.lyn.stdsys.login.NewLoginFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class Loading extends JFrame{

	public Loading() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = new ImageIcon(MainFrame.class.getResource("/Cursors/Pointer.png")).getImage();
		Cursor cursor = tk.createCustomCursor(img,new Point(10,10),"stick"); 
		setCursor(cursor);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Loading.class.getResource("/ico/NewPM.png")));
		// TODO 自动生成的构造函数存根
		setTitle("学生管理系统-正在启动");
		setSize(1280, 768);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel bgimgLabel = new JLabel("");
		bgimgLabel.setIcon(new ImageIcon(Loading.class.getResource("/bg/loadingscreen.png")));
		bgimgLabel.setBounds(0, 0, 1262, 721);
		getContentPane().add(bgimgLabel);
		setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		new MainFrame().setVisible(true);
		Loading.this.dispose();
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Loading loading = new Loading();
	}

}
