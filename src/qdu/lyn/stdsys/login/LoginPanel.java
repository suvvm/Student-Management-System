package qdu.lyn.stdsys.login;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LoginPanel extends JPanel{
	private int height, weight;
	private Image image;
	public int geth() {
		return height;
	}
	public int getw() {
		return weight;
	}
	public LoginPanel() {
		super();
		URL url = getClass().getResource("***");
		image = new ImageIcon(url).getImage(); 
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paintComponent(g);	//super.���Ƕ����ǵ��û��๹�캯�����﷨
		g.drawImage(image, 0, 0, this);		//���Ƶ�ǰ����ͼƬ
		
	}
}
