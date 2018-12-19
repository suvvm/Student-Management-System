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
import java.sql.Timestamp;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.inf.Attendance;
import qdu.lyn.stdsys.inf.Schedule;
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
	private List<String[]> listAllVac;
	private List<String[]> listOneAtd;
	private List<String[]> listAllAtd;
	private JTable vacTable;
	private JTable atdTable;
	private JTextField startAttendanceNameField;
	private JTextField startAttendanceLongField;
	private JTextField startAttendanceCourseField;
	private JTextField selectAtdNameField;
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
		
		JPanel vacationPanel = new JPanel();
		tabbedPane.addTab("管理休假", null, vacationPanel, null);
		vacationPanel.setLayout(null);
		
		vacTable = new JTable();
		String[] vacName = new String[] {
				"Number", "StudentId", "StudnetName", "BegainTime", "EndTime", "Destination"
		};
		String[][] vacValue = {};
		DefaultTableModel vacDtm = new DefaultTableModel(value, name);
		table.setModel(vacDtm);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		vacTable.setBounds(55, 35, 535, 445);
		vacationPanel.add(vacTable);
		
		JLabel refreshLabel = new JLabel("");
		refreshLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/RefreshBut.jpg")));
		refreshLabel.setBounds(95, 516, 93, 32);
		refreshLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				refreshLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/RefreshBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				refreshLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/RefreshBut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listAllVac = dbWork.selectAllVacation();
				if (listAllVac == null) {
					JOptionPane.showMessageDialog(null,  "没有请假信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listAllVac.size();
					String[] name =  {
							"序号", "学号", "姓名", "请假开始", "请假结束",  "请假原因", "请假去向", "是否批准"
						};
					String[][] value = new String[size + 1][8];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listAllVac.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					vacTable.setModel(dtm);
					vacTable.setSelectionMode(0);
					
				}
			}
		});
		vacationPanel.add(refreshLabel);
		
		JLabel approvalLabel = new JLabel("");
		approvalLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
		approvalLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				approvalLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameActive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				approvalLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				int row = vacTable.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null,  "没有选择请假信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					String temp = vacTable.getValueAt(row, 0).toString();
	                //System.out.println("$" + temp);
	                int num = Integer.parseInt(temp);
	                //System.out.println(num);
	                //stdinf.setId(Integer.parseInt(idField.getText()));
	                try {
	                    if(dbWork.approvalVacation(num)) {
	                    	listAllVac = dbWork.selectAllVacation();
	        				if (listAllVac == null) {
	        					JOptionPane.showMessageDialog(null,  "没有请假信息", "警告", JOptionPane.WARNING_MESSAGE);
	        				}else {
	        					int size = listAllVac.size();
	        					String[] name =  {
	        							"序号", "学号", "姓名", "请假开始", "请假结束",  "请假原因", "请假去向", "是否批准"
	        						};
	        					String[][] value = new String[size + 1][8];
	        					value[0] = name;
	        					for(int i = 0; i < size; i++) {
	        						value[i + 1] = listAllVac.get(i);
	        					}
	        					DefaultTableModel dtm = new DefaultTableModel(value, name);
	        					vacTable.setModel(dtm);
	        					vacTable.setSelectionMode(0);
	        				}
	                    }
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
				}
			}
		});
		approvalLabel.setBounds(261, 516, 101, 32);
		
		vacationPanel.add(approvalLabel);
		
		JLabel refuseLabel = new JLabel("");
		refuseLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
		refuseLabel.setBounds(435, 516, 101, 32);
		refuseLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				refuseLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameActive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				refuseLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				int row = vacTable.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null,  "没有选择请假信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					String temp = vacTable.getValueAt(row, 0).toString();
	                //System.out.println("$" + temp);
	                int num = Integer.parseInt(temp);
	                //System.out.println(num);
	                //stdinf.setId(Integer.parseInt(idField.getText()));
	                try {
	                    if(dbWork.refuseVacation(num)) {
	                    	listAllVac = dbWork.selectAllVacation();
	        				if (listAllVac == null) {
	        					JOptionPane.showMessageDialog(null,  "没有请假信息", "警告", JOptionPane.WARNING_MESSAGE);
	        				}else {
	        					int size = listAllVac.size();
	        					String[] name =  {
	        							"序号", "学号", "姓名", "请假开始", "请假结束",  "请假原因", "请假去向", "是否批准"
	        						};
	        					String[][] value = new String[size + 1][8];
	        					value[0] = name;
	        					for(int i = 0; i < size; i++) {
	        						value[i + 1] = listAllVac.get(i);
	        					}
	        					DefaultTableModel dtm = new DefaultTableModel(value, name);
	        					vacTable.setModel(dtm);
	        					vacTable.setSelectionMode(0);
	        				}
	                    }
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
				}
			}
		});
		vacationPanel.add(refuseLabel);
		
		JPanel schedulePanel = new JPanel();
		tabbedPane.addTab("课程表", null, schedulePanel, null);
		schedulePanel.setLayout(null);
		
		JLabel monday_12Label = new JLabel("12");
		monday_12Label.setBounds(17, 45, 72, 80);
		monday_12Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = monday_12Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					monday_12Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(monday_12Label);
		
		JLabel monday_34Label = new JLabel("34");
		monday_34Label.setBounds(17, 138, 72, 80);
		monday_34Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = monday_34Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					monday_34Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(monday_34Label);
		
		JLabel monday_56Label = new JLabel("56");
		monday_56Label.setBounds(17, 231, 72, 80);
		monday_56Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = monday_56Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					monday_56Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(monday_56Label);
		
		JLabel monday_78Label = new JLabel("78");
		monday_78Label.setBounds(17, 324, 72, 80);
		monday_78Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = monday_78Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					monday_78Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(monday_78Label);
		
		JLabel mondayTagLabel = new JLabel("星期一");
		mondayTagLabel.setBounds(17, 14, 72, 18);
		schedulePanel.add(mondayTagLabel);
		
		JLabel tuesdayTagLabel = new JLabel("星期二");
		tuesdayTagLabel.setBounds(103, 14, 72, 18);
		schedulePanel.add(tuesdayTagLabel);
		
		JLabel wednesdayTagLabel = new JLabel("星期三");
		wednesdayTagLabel.setBounds(198, 14, 70, 18);
		schedulePanel.add(wednesdayTagLabel);
		
		JLabel thursdayTagLabel = new JLabel("星期四");
		thursdayTagLabel.setBounds(282, 14, 73, 18);
		schedulePanel.add(thursdayTagLabel);
		
		JLabel fridayTagLabel = new JLabel("星期五");
		fridayTagLabel.setBounds(369, 14, 72, 18);
		schedulePanel.add(fridayTagLabel);
		
		JLabel staurdayTagLabel = new JLabel("星期六");
		staurdayTagLabel.setBounds(455, 14, 75, 18);
		schedulePanel.add(staurdayTagLabel);
		
		JLabel sundayTagLabel = new JLabel("星期日");
		sundayTagLabel.setBounds(544, 14, 72, 18);
		schedulePanel.add(sundayTagLabel);
		
		JLabel tuesday_12Label = new JLabel("12");
		tuesday_12Label.setBounds(103, 45, 72, 80);
		tuesday_12Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = tuesday_12Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					tuesday_12Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(tuesday_12Label);
		
		JLabel tuesday_34Label = new JLabel("34");
		tuesday_34Label.setBounds(103, 138, 72, 80);
		tuesday_34Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = tuesday_34Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					tuesday_34Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(tuesday_34Label);
		
		JLabel tuesday_56Label = new JLabel("56");
		tuesday_56Label.setBounds(103, 231, 72, 80);
		tuesday_56Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = tuesday_56Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					tuesday_56Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(tuesday_56Label);
		
		JLabel tuesday_78Label = new JLabel("78");
		tuesday_78Label.setBounds(103, 324, 72, 80);
		tuesday_78Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = tuesday_78Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					tuesday_78Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(tuesday_78Label);
		
		JLabel wednesday_78Label = new JLabel("78");
		wednesday_78Label.setBounds(198, 324, 70, 80);
		wednesday_78Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = wednesday_78Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					wednesday_78Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(wednesday_78Label);
		
		JLabel thursday_78Label = new JLabel("78");
		thursday_78Label.setBounds(282, 324, 73, 80);
		thursday_78Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = thursday_78Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					thursday_78Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(thursday_78Label);
		
		JLabel friday_78Label = new JLabel("78");
		friday_78Label.setBounds(369, 324, 72, 80);
		friday_78Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = friday_78Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					friday_78Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(friday_78Label);
		
		JLabel staurday_78Label = new JLabel("78");
		staurday_78Label.setBounds(455, 324, 75, 80);
		staurday_78Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = staurday_78Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					staurday_78Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(staurday_78Label);
		
		JLabel sunday_78Label = new JLabel("78");
		sunday_78Label.setBounds(544, 324, 72, 80);
		sunday_78Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = sunday_78Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					sunday_78Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(sunday_78Label);
		
		JLabel wednesday_56Label = new JLabel("56");
		wednesday_56Label.setBounds(198, 231, 70, 80);
		wednesday_56Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = wednesday_56Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					wednesday_56Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(wednesday_56Label);
		
		JLabel thursday_56Label = new JLabel("56");
		thursday_56Label.setBounds(282, 231, 73, 80);
		thursday_56Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = thursday_56Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					thursday_56Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(thursday_56Label);
		
		JLabel friday_56Label = new JLabel("56");
		friday_56Label.setBounds(369, 231, 72, 80);
		friday_56Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = friday_56Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					friday_56Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(friday_56Label);
		
		JLabel staurday_56Label = new JLabel("56");
		staurday_56Label.setBounds(455, 231, 75, 80);
		staurday_56Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = staurday_56Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					staurday_56Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(staurday_56Label);
		
		JLabel sunday_56Label = new JLabel("56");
		sunday_56Label.setBounds(544, 231, 72, 80);
		sunday_56Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = sunday_56Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					sunday_56Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(sunday_56Label);
		
		JLabel wednesday_34Label = new JLabel("34");
		wednesday_34Label.setBounds(198, 138, 70, 80);
		wednesday_34Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = wednesday_34Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					wednesday_34Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(wednesday_34Label);
		
		JLabel thursday_34Label = new JLabel("34");
		thursday_34Label.setBounds(282, 138, 73, 80);
		thursday_34Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = thursday_34Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					thursday_34Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(thursday_34Label);
		
		JLabel friday_34Label = new JLabel("34");
		friday_34Label.setBounds(369, 138, 72, 80);
		friday_34Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = friday_34Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					friday_34Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(friday_34Label);
		
		JLabel staurday_34Label = new JLabel("34");
		staurday_34Label.setBounds(455, 138, 75, 80);
		staurday_34Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = staurday_34Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					staurday_34Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(staurday_34Label);
		
		JLabel sunday_34Label = new JLabel("34");
		sunday_34Label.setBounds(544, 138, 72, 80);
		sunday_34Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = sunday_34Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					sunday_34Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(sunday_34Label);
		
		JLabel wednesday_12Label = new JLabel("12");
		wednesday_12Label.setBounds(198, 45, 70, 80);
		wednesday_12Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = wednesday_12Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					wednesday_12Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(wednesday_12Label);
		
		JLabel thursday_12Label = new JLabel("12");
		thursday_12Label.setBounds(282, 45, 73, 80);
		thursday_12Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = thursday_12Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					thursday_12Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(thursday_12Label);
		
		JLabel friday_12Label = new JLabel("12");
		friday_12Label.setBounds(369, 45, 72, 80);
		friday_12Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = friday_12Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					friday_12Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(friday_12Label);
		
		JLabel staurday_12Label = new JLabel("12");
		staurday_12Label.setBounds(455, 45, 75, 80);
		staurday_12Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = staurday_12Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					staurday_12Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(staurday_12Label);
		
		JLabel sunday_12Label = new JLabel("12");
		sunday_12Label.setBounds(544, 45, 72, 80);
		sunday_12Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = sunday_12Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					sunday_12Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(sunday_12Label);
		
		JLabel monday_910Label = new JLabel("910");
		monday_910Label.setBounds(17, 417, 72, 80);
		monday_910Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = monday_910Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					monday_910Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(monday_910Label);
		
		JLabel tuesday_910Label = new JLabel("910");
		tuesday_910Label.setBounds(103, 417, 72, 80);
		tuesday_910Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = tuesday_910Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					tuesday_910Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(tuesday_910Label);
		
		JLabel wednesday_910Label = new JLabel("910");
		wednesday_910Label.setBounds(198, 417, 69, 80);
		wednesday_910Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = wednesday_910Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					wednesday_910Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(wednesday_910Label);
		
		JLabel friday_910Label = new JLabel("910");
		friday_910Label.setBounds(369, 417, 72, 80);
		friday_910Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = friday_910Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					friday_910Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(friday_910Label);
		
		JLabel thursday_910Label = new JLabel("910");
		thursday_910Label.setBounds(282, 417, 71, 80);
		thursday_910Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = thursday_910Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					thursday_910Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(thursday_910Label);
		
		JLabel staurday_910Label = new JLabel("910");
		staurday_910Label.setBounds(455, 417, 75, 80);
		staurday_910Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = staurday_910Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					staurday_910Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(staurday_910Label);
		
		JLabel sunday_910Label = new JLabel("910");
		sunday_910Label.setBounds(544, 417, 75, 80);
		sunday_910Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				if(e.getClickCount() == 2) {
					String preCourse = sunday_910Label.getText();
					String newCourse = JOptionPane.showInputDialog("请输入新课程：\n", preCourse);
					if(newCourse== null || newCourse.equals("")) {
						newCourse = preCourse;
					}
					sunday_910Label.setText(newCourse);
				}
			}
		});
		schedulePanel.add(sunday_910Label);
		
		JLabel mondayUpdateLabel = new JLabel("更新");
		mondayUpdateLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		mondayUpdateLabel.setBounds(14, 510, 75, 18);
		mondayUpdateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseClicked(arg0);
				Schedule schedule = new Schedule();
				schedule.getMonday().setCourse_12(monday_12Label.getText());
				schedule.getMonday().setCourse_34(monday_34Label.getText());
				schedule.getMonday().setCourse_56(monday_56Label.getText());
				schedule.getMonday().setCourse_78(monday_78Label.getText());
				schedule.getMonday().setCourse_910(monday_910Label.getText());
				int day = 1;
				dbWork.updateSchedule(schedule, day);
			}
		});
		schedulePanel.add(mondayUpdateLabel);
		
		JLabel tuesdayUpdateLabel = new JLabel("");
		tuesdayUpdateLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		tuesdayUpdateLabel.setBounds(103, 510, 75, 18);
		tuesdayUpdateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseClicked(arg0);
				Schedule schedule = new Schedule();
				schedule.getTuesday().setCourse_12(tuesday_12Label.getText());
				schedule.getTuesday().setCourse_34(tuesday_34Label.getText());
				schedule.getTuesday().setCourse_56(tuesday_56Label.getText());
				schedule.getTuesday().setCourse_78(tuesday_78Label.getText());
				schedule.getTuesday().setCourse_910(tuesday_910Label.getText());
				int day = 2;
				dbWork.updateSchedule(schedule, day);
			}
		});
		schedulePanel.add(tuesdayUpdateLabel);
		
		JLabel wednesdayUpdateLabel = new JLabel("");
		wednesdayUpdateLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		wednesdayUpdateLabel.setBounds(192, 510, 75, 18);
		wednesdayUpdateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseClicked(arg0);
				Schedule schedule = new Schedule();
				schedule.getWednesday().setCourse_12(wednesday_12Label.getText());
				schedule.getWednesday().setCourse_34(wednesday_34Label.getText());
				schedule.getWednesday().setCourse_56(wednesday_56Label.getText());
				schedule.getWednesday().setCourse_78(wednesday_78Label.getText());
				schedule.getWednesday().setCourse_910(wednesday_910Label.getText());
				int day = 3;
				dbWork.updateSchedule(schedule, day);
			}
		});
		schedulePanel.add(wednesdayUpdateLabel);
		
		JLabel thursdayUpdateLabel = new JLabel("");
		thursdayUpdateLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		thursdayUpdateLabel.setBounds(281, 510, 75, 18);
		thursdayUpdateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseClicked(arg0);
				Schedule schedule = new Schedule();
				schedule.getThursday().setCourse_12(thursday_12Label.getText());
				schedule.getThursday().setCourse_34(thursday_34Label.getText());
				schedule.getThursday().setCourse_56(thursday_56Label.getText());
				schedule.getThursday().setCourse_78(thursday_78Label.getText());
				schedule.getThursday().setCourse_910(thursday_910Label.getText());
				int day = 4;
				dbWork.updateSchedule(schedule, day);
			}
		});
		schedulePanel.add(thursdayUpdateLabel);
		
		JLabel fridayUpdateLabel = new JLabel("");
		fridayUpdateLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		fridayUpdateLabel.setBounds(366, 510, 75, 18);
		fridayUpdateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseClicked(arg0);
				Schedule schedule = new Schedule();
				schedule.getFriday().setCourse_12(friday_12Label.getText());
				schedule.getFriday().setCourse_34(friday_34Label.getText());
				schedule.getFriday().setCourse_56(friday_56Label.getText());
				schedule.getFriday().setCourse_78(friday_78Label.getText());
				schedule.getFriday().setCourse_910(friday_910Label.getText());
				int day = 5;
				dbWork.updateSchedule(schedule, day);
			}
		});
		schedulePanel.add(fridayUpdateLabel);
		
		JLabel staurdayUpdateLabel = new JLabel("");
		staurdayUpdateLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		staurdayUpdateLabel.setBounds(455, 510, 75, 18);
		staurdayUpdateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseClicked(arg0);
				Schedule schedule = new Schedule();
				schedule.getStaurday().setCourse_12(staurday_12Label.getText());
				schedule.getFriday().setCourse_34(staurday_34Label.getText());
				schedule.getFriday().setCourse_56(staurday_56Label.getText());
				schedule.getFriday().setCourse_78(staurday_78Label.getText());
				schedule.getFriday().setCourse_910(staurday_910Label.getText());
				int day = 6;
				dbWork.updateSchedule(schedule, day);
			}
		});
		schedulePanel.add(staurdayUpdateLabel);
		
		JLabel sundayUpdateLabel = new JLabel("");
		sundayUpdateLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/75pxbtn.png")));
		sundayUpdateLabel.setBounds(544, 510, 75, 18);
		sundayUpdateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseClicked(arg0);
				Schedule schedule = new Schedule();
				schedule.getSunday().setCourse_12(sunday_12Label.getText());
				schedule.getSunday().setCourse_34(sunday_34Label.getText());
				schedule.getSunday().setCourse_56(sunday_56Label.getText());
				schedule.getSunday().setCourse_78(sunday_78Label.getText());
				schedule.getSunday().setCourse_910(sunday_910Label.getText());
				int day = 7;
				dbWork.updateSchedule(schedule, day);
			}
		});
		schedulePanel.add(sundayUpdateLabel);
		
		JPanel newAttendancePanel = new JPanel();
		tabbedPane.addTab("新建签到", null, newAttendancePanel, null);
		newAttendancePanel.setLayout(null);
		
		startAttendanceNameField = new JTextField();
		startAttendanceNameField.setBounds(318, 88, 130, 24);
		newAttendancePanel.add(startAttendanceNameField);
		startAttendanceNameField.setColumns(10);
		
		JLabel startAttendanceNameLabel = new JLabel("签到名");
		startAttendanceNameLabel.setBounds(195, 91, 72, 18);
		newAttendancePanel.add(startAttendanceNameLabel);
		
		JLabel startAttendanceLongLabel = new JLabel("签到时长(分钟)");
		startAttendanceLongLabel.setBounds(195, 236, 109, 18);
		newAttendancePanel.add(startAttendanceLongLabel);
		
		startAttendanceLongField = new JTextField();
		startAttendanceLongField.setBounds(318, 233, 130, 24);
		newAttendancePanel.add(startAttendanceLongField);
		startAttendanceLongField.setColumns(10);
		
		JLabel startAttendanceCourseLabel = new JLabel("签到课程");
		startAttendanceCourseLabel.setBounds(195, 159, 72, 18);
		newAttendancePanel.add(startAttendanceCourseLabel);
		
		startAttendanceCourseField = new JTextField();
		startAttendanceCourseField.setBounds(318, 156, 130, 24);
		newAttendancePanel.add(startAttendanceCourseField);
		startAttendanceCourseField.setColumns(10);
		
		JLabel startAttendanceSubmitLabel = new JLabel("");
		startAttendanceSubmitLabel.setBounds(265, 324, 142, 24);
		startAttendanceSubmitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/142pxbtn.png")));
		startAttendanceSubmitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseEntered(arg0);
				startAttendanceSubmitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/142pxbtn_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				super.mouseExited(arg0);
				startAttendanceSubmitLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/142pxbtn.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listAll = dbWork.selectAllStudentInf();
				if (listAll == null) {
					JOptionPane.showMessageDialog(null,  "没有学生信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					//System.out.println(timestamp);
					Attendance atd = new Attendance();
					atd.setName(startAttendanceNameField.getText());
					atd.setAttendInf("缺勤");
					atd.setBgtime(timestamp);
					atd.setDuration(Integer.parseInt(startAttendanceLongField.getText()));
					int size = listAll.size();
					for(int i = 0; i < size; i++) {
						//listAll.get(i)[1];
						atd.setStudentName(listAll.get(i)[1]);
						dbWork.insertAttendance(atd);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					table.setModel(dtm);
				}
			}
		});
		newAttendancePanel.add(startAttendanceSubmitLabel);
		
		JPanel selectAttendancePanel = new JPanel();
		tabbedPane.addTab("查询签到", null, selectAttendancePanel, null);
		selectAttendancePanel.setLayout(null);
		atdTable = new JTable();
		String[] atdname = new String[] {
				"编号", "开始时间", "持续时长", "学生姓名", "出席状态"
			};
		String[][] atdvalue = {};
		DefaultTableModel atdDtm = new DefaultTableModel(atdvalue, atdname);
		atdTable.setModel(atdDtm);
		atdTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		atdTable.setBounds(12, 5, 600, 474);
		atdTable.setVisible(true);
		
		
		selectAttendancePanel.add(atdTable);
		
		selectAtdNameField = new JTextField();
		selectAtdNameField.setBounds(202, 492, 130, 24);
		selectAttendancePanel.add(selectAtdNameField);
		selectAtdNameField.setColumns(10);
		
		JLabel selectAtdNameLabel = new JLabel("请输入签到名称");
		selectAtdNameLabel.setBounds(60, 492, 124, 18);
		selectAttendancePanel.add(selectAtdNameLabel);
		
		JLabel selectAtdNameButLabel = new JLabel("");
		selectAtdNameButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/SearchBut.jpg")));
		selectAtdNameButLabel.setBounds(379, 492, 101, 32);
		selectAtdNameButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				selectAtdNameButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/SearchBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				selectAtdNameButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/SearchBut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				String atdName = selectAtdNameField.getText();
				listOneAtd = dbWork.selectOneAttendance(atdName);
				if (listOneAtd == null) {
					JOptionPane.showMessageDialog(null,  "没有签到信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listOneAtd.size();
					String[] name =  {
							"编号", "开始时间", "持续时间", "学生姓名", "出席情况"
						};
					String[][] value = new String[size + 1][5];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listOneAtd.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					atdTable.setModel(dtm);
				}
			}
		});
		selectAttendancePanel.add(selectAtdNameButLabel);
		
		JLabel selectAtdAllLabel = new JLabel("");
		selectAtdAllLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/leaveGameInactive.png")));
		selectAtdAllLabel.setBounds(231, 542, 101, 32);
		selectAtdAllLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listAllAtd = dbWork.selectAllAttendance();
				if (listAllAtd == null) {
					JOptionPane.showMessageDialog(null,  "没有学生信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listAllAtd.size();
					String[] name =  {
							"编号", "签到名称", "开始时间", "持续时间", "学生姓名", "出席情况"
						};
					String[][] value = new String[size + 1][6];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listAllAtd.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					atdTable.setModel(dtm);
				}
			}
		});
		selectAttendancePanel.add(selectAtdAllLabel);
		
		
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
