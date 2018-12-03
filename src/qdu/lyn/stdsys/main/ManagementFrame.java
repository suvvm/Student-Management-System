package qdu.lyn.stdsys.main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import propertymanagement.view.RegisterFrame;
import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.user.StudentInf;


public class ManagementFrame extends JFrame{
	private JTextField nameField;
	private JTextField idField;
	private JTextField classField;
	private JTextField homeField;
	private JTextField phoneNumberField;
	private JTextField qqNumberField;
	private JTable table;
	private JTextField textField_6;
	private JTextField userNameField;
	private JTextField eMailField;
	private String fileUrl;
	private DatabaseWork dbWork = new DatabaseWork();
	
	public ManagementFrame() {
		setSize(1280, 768);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(241, 48, 630, 594);
		tabbedPane.setVisible(true);
		getContentPane().add(tabbedPane);
		
		JPanel insertPanel = new JPanel();
		tabbedPane.addTab("插入学生", null, insertPanel, null);
		insertPanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setBounds(58, 35, 75, 18);
		insertPanel.add(nameLabel);
		JLabel idLable = new JLabel("ID");
		idLable.setBounds(330, 35, 72, 18);
		insertPanel.add(idLable);
		JLabel classLabel = new JLabel("班级");
		classLabel.setBounds(58, 91, 72, 18);
		insertPanel.add(classLabel);
		JLabel homeLabel = new JLabel("家乡");
		homeLabel.setBounds(330, 91, 72, 18);
		insertPanel.add(homeLabel);
		JLabel phoneNumberLabel = new JLabel("联系电话");
		phoneNumberLabel.setBounds(58, 149, 72, 18);
		insertPanel.add(phoneNumberLabel);
		JLabel qqNumberLable = new JLabel("QQ号");
		qqNumberLable.setBounds(330, 149, 72, 18);
		insertPanel.add(qqNumberLable);
		nameField = new JTextField();
		nameField.setBounds(151, 32, 120, 24);
		insertPanel.add(nameField);
		nameField.setColumns(10);
		idField = new JTextField();
		idField.setBounds(416, 32, 120, 24);
		insertPanel.add(idField);
		idField.setColumns(10);
		classField = new JTextField();
		classField.setBounds(151, 88, 120, 24);
		insertPanel.add(classField);
		classField.setColumns(10);
		homeField = new JTextField();
		homeField.setBounds(416, 88, 120, 24);
		insertPanel.add(homeField);
		homeField.setColumns(10);
		phoneNumberField = new JTextField();
		phoneNumberField.setBounds(151, 146, 120, 24);
		insertPanel.add(phoneNumberField);
		phoneNumberField.setColumns(10);
		qqNumberField = new JTextField();
		qqNumberField.setBounds(416, 146, 120, 24);
		insertPanel.add(qqNumberField);
		qqNumberField.setColumns(10);
		JLabel userNameLabel = new JLabel("用户名");
		userNameLabel.setBounds(58, 212, 72, 18);
		insertPanel.add(userNameLabel);
		userNameField = new JTextField();
		userNameField.setBounds(151, 209, 120, 24);
		insertPanel.add(userNameField);
		userNameField.setColumns(10);
		JLabel eMailLabel = new JLabel("电子邮箱");
		eMailLabel.setBounds(330, 212, 72, 18);
		insertPanel.add(eMailLabel);
		eMailField = new JTextField();
		eMailField.setBounds(416, 209, 120, 24);
		insertPanel.add(eMailField);
		eMailField.setColumns(10);
		JLabel imglLabel = new JLabel("图片");
		imglLabel.setBounds(182, 281, 72, 18);
		insertPanel.add(imglLabel);
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
		        	JOptionPane.showMessageDialog(null,  "选择错误", "所选非文件", JOptionPane.ERROR_MESSAGE);
		        }else if(file.isFile()){  
		        	fileUrl = file.getAbsolutePath(); 
		        }  
		        //System.out.println(jfc.getSelectedFile().getName());
			}
		});
		insertPanel.add(openFilelabel);
		JLabel insertlabel = new JLabel("");
		insertlabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameActive.png")));
		insertlabel.setBounds(301, 382, 101, 32);
		insertlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				StudentInf stdinf = new StudentInf();
				stdinf.setId(Integer.parseInt(idField.getText()));
				stdinf.setClassName(classField.getText());
				stdinf.setEmail(eMailField.getText());
				stdinf.setFileUrl(fileUrl);
				stdinf.setHome(homeField.getText());
				stdinf.setName(nameField.getText());
				stdinf.setPhoneNumber(phoneNumberField.getText());
				stdinf.setQqNumber(qqNumberField.getText());
				stdinf.setUserName(userNameField.getText());
				if(dbWork.checkStudentInf(stdinf)) {
					JOptionPane.showMessageDialog(null,  "用户已存在", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					dbWork.insertStudnetInf(stdinf);
				}
				
			}
		});
		insertPanel.add(insertlabel);
		
		JPanel showPanel = new JPanel();
		tabbedPane.addTab("显示全部", null, showPanel, null);
		showPanel.setLayout(null);
		
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
		showPanel.add(table);
		
		JPanel export = new JPanel();
		tabbedPane.addTab("导出数据", null, export, null);
		
		JPanel selectPanel = new JPanel();
		tabbedPane.addTab("查询学生", null, selectPanel, null);
		selectPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(72, 74, 72, 18);
		selectPanel.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(158, 71, 86, 24);
		selectPanel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		lblNewLabel_2.setBounds(110, 120, 72, 18);
		selectPanel.add(lblNewLabel_2);
		
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
		
		JLabel A = new JLabel("AAAA");
		A.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
		A.setBounds(885, 274, 146, 42);

		getContentPane().add(A);
		
		JLabel B = new JLabel("BBBBBBB");
		B.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
		B.setBounds(885, 318, 146, 42);
	
		getContentPane().add(B);
		
		JLabel C = new JLabel("DDDDDDD");
		C.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
		C.setBounds(885, 362, 146, 42);
	
		getContentPane().add(C);
		
		JLabel D = new JLabel("EEEEEE");
		D.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/mainbtn - 副本 - 副本.png")));
		D.setBounds(885, 405, 153, 42);
		
		getContentPane().add(D);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setBounds(0, 0, 1272, 750);
		bgLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/bg/newmainmenubg.png")));
		getContentPane().add(bgLabel);
		
	}
}
