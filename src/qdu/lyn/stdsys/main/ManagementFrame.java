package qdu.lyn.stdsys.main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class ManagementFrame extends JFrame{
	private JTextField nameField;
	private JTextField idField;
	private JTextField classField;
	private JTextField homeField;
	private JTextField phoneNumberField;
	private JTextField qqNumberField;
	private JTable table;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_1;
	
	
	public ManagementFrame() {
		setSize(1280, 768);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(241, 48, 630, 594);
		tabbedPane.setVisible(true);
		getContentPane().add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(58, 35, 75, 18);
		panel_2.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(330, 35, 72, 18);
		panel_2.add(lblId);
		
		JLabel label = new JLabel("班级");
		label.setBounds(58, 91, 72, 18);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("家乡");
		label_1.setBounds(330, 91, 72, 18);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("联系电话");
		label_2.setBounds(58, 149, 72, 18);
		panel_2.add(label_2);
		
		JLabel lblQq = new JLabel("QQ号");
		lblQq.setBounds(330, 149, 72, 18);
		panel_2.add(lblQq);
		
		nameField = new JTextField();
		nameField.setBounds(151, 32, 120, 24);
		panel_2.add(nameField);
		nameField.setColumns(10);
		
		idField = new JTextField();
		idField.setBounds(416, 32, 120, 24);
		panel_2.add(idField);
		idField.setColumns(10);
		
		classField = new JTextField();
		classField.setBounds(151, 88, 120, 24);
		panel_2.add(classField);
		classField.setColumns(10);
		
		homeField = new JTextField();
		homeField.setBounds(416, 88, 120, 24);
		panel_2.add(homeField);
		homeField.setColumns(10);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setBounds(151, 146, 120, 24);
		panel_2.add(phoneNumberField);
		phoneNumberField.setColumns(10);
		
		qqNumberField = new JTextField();
		qqNumberField.setBounds(416, 146, 120, 24);
		panel_2.add(qqNumberField);
		qqNumberField.setColumns(10);
		
		JLabel insertlabel = new JLabel("");
		insertlabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameActive.png")));
		insertlabel.setBounds(301, 382, 101, 32);
		panel_2.add(insertlabel);
		
		JLabel label_3 = new JLabel("用户名");
		label_3.setBounds(58, 212, 72, 18);
		panel_2.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(151, 209, 120, 24);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel label_4 = new JLabel("电子邮箱");
		label_4.setBounds(330, 212, 72, 18);
		panel_2.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(416, 209, 120, 24);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_5 = new JLabel("图片");
		label_5.setBounds(182, 281, 72, 18);
		panel_2.add(label_5);
		
		JLabel openFilelabel = new JLabel("");
		openFilelabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/optionsActive.png")));
		openFilelabel.setBounds(311, 281, 104, 32);
		openFilelabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				openFilelabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/optionsInactive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				openFilelabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/optionsActive.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        jfc.showDialog(new JLabel(), "选择");  
		        File file=jfc.getSelectedFile();  
		        if(file.isDirectory()){  
		            System.out.println("文件夹:"+file.getAbsolutePath());  
		        }else if(file.isFile()){  
		            System.out.println("文件:"+file.getAbsolutePath());  
		        }  
		        System.out.println(jfc.getSelectedFile().getName());
				
			}
		});
		panel_2.add(openFilelabel);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u59D3\u540D", "ID", "\u73ED\u7EA7", "\u8054\u7CFB\u7535\u8BDD", "QQ\u53F7", "\u7535\u5B50\u90AE\u4EF6"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u59D3\u540D", "ID", "\u73ED\u7EA7", "\u8054\u7CFB\u7535\u8BDD", "QQ\u53F7", "\u7535\u5B50\u90AE\u4EF6"
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(37, 47, 546, 349);
		panel.add(table);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("", new ImageIcon(ManagementFrame.class.getResource("/but/92pxbtn.png")), panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(72, 74, 72, 18);
		panel_3.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(158, 71, 86, 24);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		lblNewLabel_2.setBounds(110, 120, 72, 18);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JLabel backToMainLabel = new JLabel("");
		backToMainLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/Exitbut.png")));
		backToMainLabel.setBounds(885, 611, 146, 42);
		backToMainLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				backToMainLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/Exitbut_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				backToMainLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/Exitbut.png")));
			}
		});
		getContentPane().add(backToMainLabel);
		
		JLabel exitLabel = new JLabel("");
		exitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/backToMain.jpg")));
		exitLabel.setBounds(885, 568, 146, 42);
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/backToMain_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/backToMain.jpg")));
			}
		});
		getContentPane().add(exitLabel);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setBounds(0, 0, 1272, 750);
		bgLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/bg/newmainmenubg.png")));
		getContentPane().add(bgLabel);
		
	}
}
