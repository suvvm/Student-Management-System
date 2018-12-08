package qdu.lyn.stdsys.main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.StudentInf;
import java.awt.Toolkit;


public class ManagementFrame extends JFrame{
	private JTextField nameField;
	private JTextField idField;
	private JTextField classField;
	private JTextField homeField;
	private JTextField phoneNumberField;
	private JTextField qqNumberField;
	private JTable table;
	private JTextField selectEnterIdLabel;
	private JTextField userNameField;
	private JTextField eMailField;
	
	private JTextField deleteIdField;
	private JTextField updateIdField;
	private JTextField updateNameField;
	private JTextField updateClassField;
	private JTextField updateHomeField;
	private JTextField updatePhoneNumberField;
	private JTextField updateQqField;
	private JTextField updateUserNameField;
	private JTextField updateEmailField;
	
	private String fileUrl;
	private String updateFileUrl;
	private DatabaseWork dbWork = new DatabaseWork();
	private List<String> listOne;
	private List<String[]> listAll;
	private JTable vacTable;
	public ManagementFrame(Administrator admin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagementFrame.class.getResource("/ico/NewPM.png")));
		setSize(1280, 768);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(241, 54, 630, 619);
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
		openFilelabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/ChooseImgBut.jpg")));
		openFilelabel.setBounds(311, 281, 104, 32);
		openFilelabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				openFilelabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/ChooseImgBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				openFilelabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/ChooseImgBut.jpg")));
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
		insertlabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/IncsertBut.jpg")));
		insertlabel.setBounds(301, 382, 101, 32);
		insertlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				insertlabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/IncsertBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				insertlabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/IncsertBut.jpg")));
			}
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
					JOptionPane.showMessageDialog(null,  "学生信息已存在", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					dbWork.insertStudnetInf(stdinf);
					JOptionPane.showMessageDialog(null,  "学生信息插入成功", "成功", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		insertPanel.add(insertlabel);
		
		JPanel showPanel = new JPanel();
		tabbedPane.addTab("显示全部", null, showPanel, null);
		showPanel.setLayout(null);
		
		table = new JTable();
		String[] name = new String[] {
				"ID", "\u59D3\u540D", "\u5BB6\u4E61", "\u8054\u7CFB\u7535\u8BDD", "\u7528\u6237\u540D", "QQ\u53F7", "\u7535\u5B50\u90AE\u4EF6", "\u73ED\u7EA7"
			};
		String[][] value = {};
		DefaultTableModel dtm = new DefaultTableModel(value, name);
		table.setModel(dtm);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(37, 47, 546, 349);
		showPanel.add(table);
		
		JLabel selectAllButLabel = new JLabel("");
		selectAllButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/RefreshBut.jpg")));
		selectAllButLabel.setBounds(251, 422, 93, 32);
		selectAllButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				selectAllButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/RefreshBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				selectAllButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/RefreshBut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listAll = dbWork.selectAllStudentInf();
				if (listAll == null) {
					JOptionPane.showMessageDialog(null,  "没有学生信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listAll.size();
					String[] name =  {
							"ID", "\u59D3\u540D", "\u5BB6\u4E61", "\u8054\u7CFB\u7535\u8BDD", "\u7528\u6237\u540D", "QQ\u53F7", "\u7535\u5B50\u90AE\u4EF6", "\u73ED\u7EA7"
						};
					String[][] value = new String[size + 1][8];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listAll.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					table.setModel(dtm);
				}
			}
		});
		showPanel.add(selectAllButLabel);
		
		JPanel updatePanel = new JPanel();
		
		tabbedPane.addTab("更新数据", null, updatePanel, null);
		updatePanel.setLayout(null);
		
		JLabel deleteLabel = new JLabel("删除数据");
		deleteLabel.setBounds(53, 65, 72, 18);
		updatePanel.add(deleteLabel);
		
		JLabel deleteIdLabel = new JLabel("学号");
		deleteIdLabel.setBounds(159, 65, 72, 18);
		updatePanel.add(deleteIdLabel);
		
		deleteIdField = new JTextField();
		deleteIdField.setBounds(261, 62, 120, 24);
		updatePanel.add(deleteIdField);
		deleteIdField.setColumns(10);
		
		JLabel deleteButLabel = new JLabel("");
		deleteButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/DeleteBut.jpg")));
		deleteButLabel.setBounds(432, 54, 101, 32);
		
		deleteButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				deleteButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/DeleteBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				deleteButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/DeleteBut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				StudentInf stdinf = new StudentInf();
				stdinf.setId(Integer.parseInt(deleteIdField.getText()));

				if(!dbWork. checkStudentInf(stdinf)){
					JOptionPane.showMessageDialog(null,  "学生信息不存在", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					dbWork.deleteStudentInf(stdinf);
					JOptionPane.showMessageDialog(null,  "学生信息删除成功", "成功", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		updatePanel.add(deleteButLabel);
		
		JLabel changeInfLabel = new JLabel("修改信息（根据学号选择学生）");
		changeInfLabel.setBounds(53, 107, 226, 18);
		updatePanel.add(changeInfLabel);
		
		JLabel idLabel = new JLabel("学号");
		idLabel.setBounds(293, 107, 72, 18);
		updatePanel.add(idLabel);
		
		updateIdField = new JTextField();
		updateIdField.setBounds(390, 104, 120, 24);
		updatePanel.add(updateIdField);
		updateIdField.setColumns(10);
		
		JLabel enterInfLabel = new JLabel("输入新信息：");
		enterInfLabel.setBounds(53, 146, 106, 18);
		updatePanel.add(enterInfLabel);
		
		JLabel updateNameLabel = new JLabel("姓名");
		updateNameLabel.setBounds(95, 190, 72, 18);
		updatePanel.add(updateNameLabel);
		
		updateNameField = new JTextField();
		updateNameField.setBounds(192, 190, 120, 24);
		updatePanel.add(updateNameField);
		updateNameField.setColumns(10);
		
		JLabel upadtaClassLabel = new JLabel("班级");
		upadtaClassLabel.setBounds(357, 190, 72, 18);
		updatePanel.add(upadtaClassLabel);
		
		updateClassField = new JTextField();
		updateClassField.setBounds(444, 190, 120, 24);
		updatePanel.add(updateClassField);
		updateClassField.setColumns(10);
		
		JLabel updateHomeLabel = new JLabel("家乡");
		updateHomeLabel.setBounds(95, 245, 72, 18);
		updatePanel.add(updateHomeLabel);
		
		updateHomeField = new JTextField();
		updateHomeField.setBounds(192, 245, 120, 24);
		updatePanel.add(updateHomeField);
		updateHomeField.setColumns(10);
		
		JLabel updatePhoneNumberLabel = new JLabel("联系电话");
		updatePhoneNumberLabel.setBounds(355, 247, 72, 18);
		updatePanel.add(updatePhoneNumberLabel);
		
		updatePhoneNumberField = new JTextField();
		updatePhoneNumberField.setBounds(444, 244, 120, 24);
		updatePanel.add(updatePhoneNumberField);
		updatePhoneNumberField.setColumns(10);
		
		JLabel updateQqLabel = new JLabel("QQ号");
		updateQqLabel.setBounds(91, 301, 72, 18);
		updatePanel.add(updateQqLabel);
		
		updateQqField = new JTextField();
		updateQqField.setBounds(192, 298, 120, 24);
		updatePanel.add(updateQqField);
		updateQqField.setColumns(10);
		
		JLabel updateUserNameLabel = new JLabel("用户名");
		updateUserNameLabel.setBounds(357, 301, 72, 18);
		updatePanel.add(updateUserNameLabel);
		
		updateUserNameField = new JTextField();
		updateUserNameField.setBounds(444, 298, 120, 24);
		updatePanel.add(updateUserNameField);
		updateUserNameField.setColumns(10);
		
		JLabel updateEmailLabel = new JLabel("电子邮箱");
		updateEmailLabel.setBounds(87, 361, 72, 18);
		updatePanel.add(updateEmailLabel);
		
		updateEmailField = new JTextField();
		updateEmailField.setBounds(192, 358, 120, 24);
		updatePanel.add(updateEmailField);
		updateEmailField.setColumns(10);
		
		JLabel submitChangeButLabel = new JLabel("");
		submitChangeButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/IncsertBut.jpg")));
		submitChangeButLabel.setBounds(277, 420, 101, 32);
		submitChangeButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				submitChangeButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameActive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				submitChangeButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				StudentInf stdinf = new StudentInf();
				stdinf.setId(Integer.parseInt(updateIdField.getText()));
				stdinf.setClassName(updateClassField.getText());
				stdinf.setEmail(updateEmailField.getText());
				stdinf.setFileUrl(updateFileUrl);
				stdinf.setHome(updateHomeField.getText());
				stdinf.setName(updateNameField.getText());
				stdinf.setPhoneNumber(updatePhoneNumberField.getText());
				stdinf.setQqNumber(updateQqField.getText());
				stdinf.setUserName(updateUserNameField.getText());
				if(!dbWork.checkStudentInf(stdinf)) {
					JOptionPane.showMessageDialog(null,  "学生信息不存在", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					dbWork.updateStudnetInf(stdinf);
					JOptionPane.showMessageDialog(null,  "学生信息修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		updatePanel.add(submitChangeButLabel);
		
		JLabel updateChooseImglabel = new JLabel("图片");
		updateChooseImglabel.setBounds(357, 361, 72, 18);
		updatePanel.add(updateChooseImglabel);
		
		JLabel updateOpenFileButLabel = new JLabel("");
		updateOpenFileButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/ChooseImgBut.jpg")));
		updateOpenFileButLabel.setBounds(445, 358, 106, 32);
		updateOpenFileButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				updateOpenFileButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/optionsActive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				updateOpenFileButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/optionsInactive.png")));
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
		        	updateFileUrl = file.getAbsolutePath(); 
		        }  
		        //System.out.println(jfc.getSelectedFile().getName());
			}
		});
		updatePanel.add(updateOpenFileButLabel);
		
		JPanel selectPanel = new JPanel();
		tabbedPane.addTab("查询学生", null, selectPanel, null);
		selectPanel.setLayout(null);
		
		JLabel selectIdLabel = new JLabel("ID");
		selectIdLabel.setBounds(132, 74, 72, 18);
		selectPanel.add(selectIdLabel);
		
		selectEnterIdLabel = new JTextField();
		selectEnterIdLabel.setBounds(240, 71, 86, 24);
		selectPanel.add(selectEnterIdLabel);
		selectEnterIdLabel.setColumns(10);
		
		
		
		JLabel selectImgLabel = new JLabel("图片：");
		selectImgLabel.setBounds(25, 207, 52, 18);
		selectPanel.add(selectImgLabel);
		
		JLabel selectNameLabel = new JLabel("姓名：");
		selectNameLabel.setBounds(28, 134, 57, 18);
		selectPanel.add(selectNameLabel);
		
		JLabel selectShowNameLabel = new JLabel("");
		selectShowNameLabel.setBounds(95, 135, 72, 18);
		selectPanel.add(selectShowNameLabel);
		
		JLabel selectShowImgLabel = new JLabel("");
		selectShowImgLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/ico/NewPM.png")));
		selectShowImgLabel.setBounds(90, 169, 144, 144);
		selectPanel.add(selectShowImgLabel);
		
		JLabel selectClassLabel = new JLabel("班级：");
		selectClassLabel.setBounds(322, 219, 55, 18);
		selectPanel.add(selectClassLabel);
		
		JLabel selectShowClassLabel = new JLabel("");
		selectShowClassLabel.setBounds(438, 218, 72, 18);
		selectPanel.add(selectShowClassLabel);
		
		JLabel selectPhoneLabel = new JLabel("联系电话：");
		selectPhoneLabel.setBounds(17, 355, 87, 18);
		selectPanel.add(selectPhoneLabel);
		
		JLabel selectShowPhoneLabel = new JLabel("");
		selectShowPhoneLabel.setBounds(142, 355, 72, 18);
		selectPanel.add(selectShowPhoneLabel);
		
		JLabel selectQqLabel = new JLabel("qq号：");
		selectQqLabel.setBounds(320, 355, 72, 18);
		selectPanel.add(selectQqLabel);
		
		JLabel selectShowQqLabel = new JLabel("");
		selectShowQqLabel.setBounds(423, 354, 72, 18);
		selectPanel.add(selectShowQqLabel);
		
		JLabel selectHomeLabel = new JLabel("家乡：");
		selectHomeLabel.setBounds(25, 447, 72, 18);
		selectPanel.add(selectHomeLabel);
		
		JLabel selectShowHomeLable = new JLabel("");
		selectShowHomeLable.setBounds(115, 446, 72, 18);
		selectPanel.add(selectShowHomeLable);
		
		JLabel selectEmailLabel = new JLabel("电子邮件：");
		selectEmailLabel.setBounds(287, 443, 91, 18);
		selectPanel.add(selectEmailLabel);
		
		JLabel selectShowEmailLable = new JLabel("");
		selectShowEmailLable.setBounds(404, 447, 72, 18);
		selectPanel.add(selectShowEmailLable);
		
		JLabel selectUserNlabel = new JLabel("用户名：");
		selectUserNlabel.setBounds(320, 134, 72, 18);
		selectPanel.add(selectUserNlabel);
		
		JLabel selectShowUserNameLabel = new JLabel("");
		selectShowUserNameLabel.setBounds(457, 133, 72, 18);
		selectPanel.add(selectShowUserNameLabel);
		
		JLabel selectOneSubmitLabel = new JLabel("");
		selectOneSubmitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/joinGameInactive.png")));
		selectOneSubmitLabel.setBounds(372, 71, 93, 32);
		selectOneSubmitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				selectOneSubmitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/joinGameActive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				selectOneSubmitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/joinGameInactive.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				StudentInf stdinf = new StudentInf();
				stdinf.setId(Integer.parseInt(selectEnterIdLabel.getText()));

				if(!dbWork. checkStudentInf(stdinf)){
					JOptionPane.showMessageDialog(null,  "学生信息不存在", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					
					listOne = dbWork.selectOneStudentInf(stdinf);
					selectShowNameLabel.setText(listOne.get(0));
					selectShowHomeLable.setText(listOne.get(1));
					selectShowPhoneLabel.setText(listOne.get(2));
					selectShowImgLabel.setIcon(new ImageIcon(listOne.get(3).replace("\\", "\\\\")));
					selectShowUserNameLabel.setText(listOne.get(4));
					selectShowQqLabel.setText(listOne.get(5));
					selectShowEmailLable.setText(listOne.get(6));
					selectShowClassLabel.setText(listOne.get(7));
					JOptionPane.showMessageDialog(null,  "学生信息查找成功", "成功", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		selectPanel.add(selectOneSubmitLabel);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("管理休假", null, panel, null);
		panel.setLayout(null);
		
		vacTable = new JTable();
		String[] vacName = new String[] {
				"Number", "StudentId", "StudnetName", "BegainTime", "EndTime", "Destination"
		};
		String[][] vacValue = {};
		DefaultTableModel vacDtm = new DefaultTableModel(value, name);
		table.setModel(vacDtm);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		vacTable.setBounds(55, 35, 535, 445);
		panel.add(vacTable);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/RefreshBut.jpg")));
		label.setBounds(95, 516, 93, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
		label_1.setBounds(261, 516, 101, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
		label_2.setBounds(435, 516, 101, 32);
		panel.add(label_2);
		JLabel exitButLabel = new JLabel("");
		exitButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/Exitbut.jpg")));
		exitButLabel.setBounds(885, 611, 146, 42);
		exitButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/Exitbut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/Exitbut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				System.exit(1);
			}
		});
		getContentPane().add(exitButLabel);
		
		JLabel backToMainLabel = new JLabel("");
		backToMainLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/backToMain.jpg")));
		backToMainLabel.setBounds(885, 273, 146, 42);
		backToMainLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				backToMainLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/backToMain_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				backToMainLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/backToMain.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				new MainFrame().setVisible(true);
				ManagementFrame.this.dispose();
			}
		});
		getContentPane().add(backToMainLabel);
		
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setBounds(0, 0, 1272, 750);
		bgLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/bg/newmainmenubg.png")));
		getContentPane().add(bgLabel);
		
	}
}
