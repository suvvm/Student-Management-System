package qdu.lyn.stdsys.login;

import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;

public class RegisterFrame extends JFrame{
	public RegisterFrame() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/bg/newmainmenubg.png")));
		bgLabel.setSize(1280,768);
		getContentPane().add(bgLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(885, 282, 145, 45);
		getContentPane().add(lblNewLabel);
		
	}

}
