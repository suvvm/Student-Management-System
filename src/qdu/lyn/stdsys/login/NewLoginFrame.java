package qdu.lyn.stdsys.login;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class NewLoginFrame extends JFrame{
	public NewLoginFrame() {
		setSize(new Dimension(1280, 768));
		setTitle("StudentManager");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewLoginFrame.class.getResource("/ico/ico.png")));
		getContentPane().setLayout(null);
	}

}
