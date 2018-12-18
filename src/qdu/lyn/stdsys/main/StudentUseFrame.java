package qdu.lyn.stdsys.main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.inf.Vacation;
import qdu.lyn.stdsys.login.RegisterFrame;
import qdu.lyn.stdsys.user.Student;
import qdu.lyn.stdsys.user.StudentInf;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class StudentUseFrame extends JFrame{
	private JTable table;
	private List<String[]> listAll;
	private List<String> myInfList;
	private List<String[]> listMyVac;
	private DatabaseWork dbWork = new DatabaseWork();
	private String myImgUrl;
	
	
	private JTextField addMyHomeField;
	private JTextField addMyQqField;
	private JTextField addMyPhoneField;
	private JTextField addMyClassField;
	private JTextField vacBeginTimeField;
	private JTextField vacEndTimeField;
	private JTextField vacDestinationField;
	private JTable myVacationTable;
	
	
	
	public StudentUseFrame(Student std) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentUseFrame.class.getResource("/ico/NewPM.png")));
		setTitle("学生端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		StudentInf studentInf = new StudentInf();
		studentInf.setId(std.getId());
		studentInf.setUserName(std.getUserName());
		studentInf.setEmail(std.getEmail());
		studentInf.setName(std.getName());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel exitLabel = new JLabel("");
		exitLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/Exitbut.jpg")));
		exitLabel.setBounds(885, 620, 145, 42);
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				System.exit(1);
			}
		});
		
		
		getContentPane().add(exitLabel);
		
		JLabel backToMainLabel = new JLabel("");
		backToMainLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/backToMain.jpg")));
		backToMainLabel.setBounds(885, 283, 145, 42);
		backToMainLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				backToMainLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/backToMain_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				backToMainLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/backToMain.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				new MainFrame().setVisible(true);
				StudentUseFrame.this.dispose();
			}
		});
		getContentPane().add(backToMainLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(242, 62, 629, 588);
		getContentPane().add(tabbedPane);
		
		JPanel selectStudentPanel = new JPanel();
		tabbedPane.addTab("所有学生", null, selectStudentPanel, null);
		selectStudentPanel.setLayout(null);
		table = new JTable();
		String[] name = new String[] {
				"ID", "\u59D3\u540D", "\u5BB6\u4E61", "\u8054\u7CFB\u7535\u8BDD", "\u7528\u6237\u540D", "QQ\u53F7", "\u7535\u5B50\u90AE\u4EF6", "\u73ED\u7EA7"
			};
		String[][] value = {};
		DefaultTableModel dtm = new DefaultTableModel(value, name);
		table.setModel(dtm);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(12, 5, 600, 474);
		table.setVisible(true);
		
		
		selectStudentPanel.add(table);
		
		JLabel selectAllButLabel = new JLabel("");
		selectAllButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
		selectAllButLabel.setBounds(270, 496, 93, 32);
		selectAllButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				selectAllButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/joinGameActive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				selectAllButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/joinGameInactive.png")));
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
		selectStudentPanel.add(selectAllButLabel);
		
		
		
		
		
		
		
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("课程表", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("12");
		lblNewLabel.setBounds(46, 45, 60, 80);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("34");
		label_1.setBounds(46, 138, 60, 80);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("56");
		label_2.setBounds(46, 231, 60, 80);
		panel.add(label_2);
		
		JLabel lblNewLabel_2 = new JLabel("78");
		lblNewLabel_2.setBounds(46, 324, 60, 80);
		panel.add(lblNewLabel_2);
		
		JLabel label_3 = new JLabel("星期一");
		label_3.setBounds(46, 14, 60, 18);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("星期二");
		label_4.setBounds(124, 14, 60, 18);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("星期三");
		label_5.setBounds(198, 14, 60, 18);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("星期四");
		label_6.setBounds(272, 14, 60, 18);
		panel.add(label_6);
		
		JLabel fridayTagLabel = new JLabel("星期五");
		fridayTagLabel.setBounds(346, 14, 60, 18);
		panel.add(fridayTagLabel);
		
		JLabel label_8 = new JLabel("星期六");
		label_8.setBounds(420, 14, 60, 18);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("星期日");
		label_9.setBounds(494, 14, 72, 18);
		panel.add(label_9);
		
		JLabel lblNewLabel_1 = new JLabel("12");
		lblNewLabel_1.setBounds(120, 45, 60, 80);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("34");
		lblNewLabel_3.setBounds(124, 138, 60, 80);
		panel.add(lblNewLabel_3);
		
		JLabel label_10 = new JLabel("56");
		label_10.setBounds(124, 231, 60, 80);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("78");
		label_11.setBounds(124, 324, 60, 80);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("78");
		label_12.setBounds(198, 324, 60, 80);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("78");
		label_13.setBounds(272, 324, 60, 80);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("78");
		label_14.setBounds(346, 324, 60, 80);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("78");
		label_15.setBounds(420, 324, 60, 80);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("78");
		label_16.setBounds(494, 324, 60, 80);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("56");
		label_17.setBounds(198, 231, 60, 80);
		panel.add(label_17);
		
		JLabel label_18 = new JLabel("56");
		label_18.setBounds(272, 231, 60, 80);
		panel.add(label_18);
		
		JLabel label_19 = new JLabel("56");
		label_19.setBounds(346, 231, 60, 80);
		panel.add(label_19);
		
		JLabel label_20 = new JLabel("56");
		label_20.setBounds(420, 231, 60, 80);
		panel.add(label_20);
		
		JLabel label_21 = new JLabel("56");
		label_21.setBounds(494, 231, 60, 80);
		panel.add(label_21);
		
		JLabel label_22 = new JLabel("34");
		label_22.setBounds(198, 138, 60, 80);
		panel.add(label_22);
		
		JLabel label_23 = new JLabel("34");
		label_23.setBounds(272, 138, 60, 80);
		panel.add(label_23);
		
		JLabel label_24 = new JLabel("34");
		label_24.setBounds(346, 138, 60, 80);
		panel.add(label_24);
		
		JLabel label_25 = new JLabel("34");
		label_25.setBounds(420, 138, 60, 80);
		panel.add(label_25);
		
		JLabel label_26 = new JLabel("34");
		label_26.setBounds(494, 138, 60, 80);
		panel.add(label_26);
		
		JLabel label_27 = new JLabel("12");
		label_27.setBounds(198, 45, 60, 80);
		panel.add(label_27);
		
		JLabel label_28 = new JLabel("12");
		label_28.setBounds(272, 45, 60, 80);
		panel.add(label_28);
		
		JLabel label_29 = new JLabel("12");
		label_29.setBounds(346, 45, 60, 80);
		panel.add(label_29);
		
		JLabel label_30 = new JLabel("12");
		label_30.setBounds(420, 45, 60, 80);
		panel.add(label_30);
		
		JLabel label_31 = new JLabel("12");
		label_31.setBounds(494, 45, 60, 80);
		panel.add(label_31);
		
		JLabel label_32 = new JLabel("910");
		label_32.setBounds(46, 417, 60, 80);
		panel.add(label_32);
		
		JLabel label_33 = new JLabel("910");
		label_33.setBounds(124, 417, 60, 80);
		panel.add(label_33);
		
		JLabel label_34 = new JLabel("910");
		label_34.setBounds(198, 417, 60, 80);
		panel.add(label_34);
		
		JLabel label_35 = new JLabel("910");
		label_35.setBounds(272, 417, 60, 80);
		panel.add(label_35);
		
		JLabel label_36 = new JLabel("910");
		label_36.setBounds(346, 417, 60, 80);
		panel.add(label_36);
		
		JLabel label_37 = new JLabel("910");
		label_37.setBounds(420, 417, 60, 80);
		panel.add(label_37);
		
		JLabel label_38 = new JLabel("910");
		label_38.setBounds(494, 417, 60, 80);
		panel.add(label_38);
		
		
		JPanel myInfPanel = new JPanel();
		tabbedPane.addTab("我的信息", null, myInfPanel, null);
		myInfPanel.setLayout(null);
		
		JLabel myNameLabel = new JLabel("姓名");
		myNameLabel.setBounds(41, 13, 72, 18);
		myInfPanel.add(myNameLabel);
		
		JLabel myImgLabel = new JLabel("图片");
		myImgLabel.setBounds(41, 126, 72, 18);
		myInfPanel.add(myImgLabel);
		
		JLabel myClassLabel = new JLabel("班级");
		myClassLabel.setBounds(347, 13, 72, 18);
		myInfPanel.add(myClassLabel);
		
		JLabel myIDLable = new JLabel("ID");
		myIDLable.setBounds(347, 63, 72, 18);
		myInfPanel.add(myIDLable);
		
		JLabel myPhoneNumberLabel = new JLabel("联系电话");
		myPhoneNumberLabel.setBounds(347, 126, 72, 18);
		myInfPanel.add(myPhoneNumberLabel);
		
		JLabel myQqLable = new JLabel("QQ");
		myQqLable.setBounds(347, 187, 72, 18);
		myInfPanel.add(myQqLable);
		
		JLabel myEmsilLabel = new JLabel("电子邮箱");
		myEmsilLabel.setBounds(347, 247, 72, 18);
		myInfPanel.add(myEmsilLabel);
		
		JLabel showMyImgLabel = new JLabel("");
		showMyImgLabel.setBounds(99, 126, 234, 244);
		myInfPanel.add(showMyImgLabel);
		
		JLabel showMyNameLabel = new JLabel("");
		showMyNameLabel.setBounds(99, 13, 110, 18);
		myInfPanel.add(showMyNameLabel);
		
		JLabel showMyClassLabel = new JLabel("");
		showMyClassLabel.setBounds(450, 13, 110, 18);
		myInfPanel.add(showMyClassLabel);
		
		JLabel showMyIdLabel = new JLabel("");
		showMyIdLabel.setBounds(450, 63, 110, 18);
		myInfPanel.add(showMyIdLabel);
		
		JLabel showMyPhoneNumberLabel = new JLabel("");
		showMyPhoneNumberLabel.setBounds(450, 126, 110, 18);
		myInfPanel.add(showMyPhoneNumberLabel);
		
		JLabel showMyQqLabel = new JLabel("");
		showMyQqLabel.setBounds(450, 187, 110, 18);
		myInfPanel.add(showMyQqLabel);
		
		JLabel showMyEmailLabel = new JLabel("");
		showMyEmailLabel.setBounds(450, 247, 110, 18);
		myInfPanel.add(showMyEmailLabel);
		
		JLabel myHomeLabel = new JLabel("家乡");
		myHomeLabel.setBounds(41, 63, 72, 18);
		myInfPanel.add(myHomeLabel);
		
		JLabel showMyHomeLabel = new JLabel("");
		showMyHomeLabel.setBounds(99, 63, 110, 18);
		myInfPanel.add(showMyHomeLabel);
		
		JLabel myUserNameLabel = new JLabel("用户名");
		myUserNameLabel.setBounds(347, 315, 72, 18);
		myInfPanel.add(myUserNameLabel);
		
		JLabel showMyUserNameLabel = new JLabel("");
		showMyUserNameLabel.setBounds(450, 315, 110, 18);
		myInfPanel.add(showMyUserNameLabel);
		
		JLabel showSucLabel = new JLabel("显示成功");
		showSucLabel.setBounds(393, 461, 72, 18);
		showSucLabel.setVisible(false);
		myInfPanel.add(showSucLabel);
		
		JLabel lookMyinfButLabel = new JLabel("");
		lookMyinfButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
		lookMyinfButLabel.setBounds(249, 447, 93, 32);
		lookMyinfButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				lookMyinfButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				lookMyinfButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				myInfList = dbWork.selectOneStudentInf(studentInf);
				showMyNameLabel.setText(myInfList.get(0));
				showMyHomeLabel.setText(myInfList.get(1));
				showMyPhoneNumberLabel.setText(myInfList.get(2));
				myImgUrl = myInfList.get(3).replace("//", "////");
				showMyImgLabel.setIcon(new ImageIcon(myImgUrl));
				showMyUserNameLabel.setText(myInfList.get(4));
				showMyQqLabel.setText(myInfList.get(5));
				showMyEmailLabel.setText(myInfList.get(6));
				showMyClassLabel.setText(myInfList.get(7));
				showMyIdLabel.setText(String.valueOf(studentInf.getId()));
				//showSucLabel.setVisible(true);
				//showSucLabel.getVisibleRect()
			}
		});
		myInfPanel.add(lookMyinfButLabel);
		
		JPanel AskingForVacationPanel = new JPanel();
		tabbedPane.addTab("申请休假", null, AskingForVacationPanel, null);
		AskingForVacationPanel.setLayout(null);
		
		JLabel vacTextLabel = new JLabel("申请休假");
		vacTextLabel.setBounds(278, 13, 72, 18);
		AskingForVacationPanel.add(vacTextLabel);
		
		JLabel vacBgTimeLabel = new JLabel("开始时间");
		vacBgTimeLabel.setBounds(55, 70, 72, 18);
		AskingForVacationPanel.add(vacBgTimeLabel);
		
		JLabel vacEndTimeLabel = new JLabel("结束时间");
		vacEndTimeLabel.setBounds(55, 142, 72, 18);
		AskingForVacationPanel.add(vacEndTimeLabel);
		
		vacBeginTimeField = new JTextField();
		vacBeginTimeField.setBounds(141, 67, 120, 24);
		AskingForVacationPanel.add(vacBeginTimeField);
		vacBeginTimeField.setColumns(10);
		
		vacEndTimeField = new JTextField();
		vacEndTimeField.setBounds(141, 139, 120, 24);
		AskingForVacationPanel.add(vacEndTimeField);
		vacEndTimeField.setColumns(10);
		
		JLabel vacReasonLabel = new JLabel("申请理由");
		vacReasonLabel.setBounds(55, 216, 72, 18);
		AskingForVacationPanel.add(vacReasonLabel);
		
		JTextArea vacReasonArea = new JTextArea();
		vacReasonArea.setBounds(141, 214, 362, 186);
		AskingForVacationPanel.add(vacReasonArea);
		
		JLabel vacDestinationLabel = new JLabel("目的地");
		vacDestinationLabel.setBounds(297, 70, 72, 18);
		AskingForVacationPanel.add(vacDestinationLabel);
		
		vacDestinationField = new JTextField();
		vacDestinationField.setBounds(383, 67, 120, 24);
		AskingForVacationPanel.add(vacDestinationField);
		vacDestinationField.setColumns(10);
		
		JLabel askingForVacationButLabel = new JLabel("");
		askingForVacationButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/leaveGameInactive.png")));
		askingForVacationButLabel.setBounds(268, 448, 101, 32);
		askingForVacationButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				Vacation vac = new Vacation();
				vac.setStuid(std.getId());
				vac.setStuName(std.getName());
				vac.setBgTime(vacBeginTimeField.getText());
				vac.setEdTime(vacEndTimeField.getText());
				vac.setReason(vacReasonArea.getText());
				vac.setVacDestination(vacDestinationField.getText());
				dbWork.insertVacation(vac);
				JOptionPane.showMessageDialog(null, "休假申请已提交，请等待管理员审核", "成功", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		AskingForVacationPanel.add(askingForVacationButLabel);
		
		JPanel lookMyVacationPanel = new JPanel();
		tabbedPane.addTab("查看申请状态", null, lookMyVacationPanel, null);
		lookMyVacationPanel.setLayout(null);
		
		myVacationTable = new JTable();
		String[] lookMyVacName = new String[] {
				"序号", "请假开始", "请假结束", "请假原因", "请假去向", "是否批准"
		};
		String[][] myVacValue = {};
		DefaultTableModel myVacdtm = new DefaultTableModel(myVacValue, name);
		myVacationTable.setModel(myVacdtm);
		myVacationTable.setBounds(61, 38, 524, 388);
		lookMyVacationPanel.add(myVacationTable);
		
		JLabel lookVacRefreshLabel = new JLabel("");
		lookVacRefreshLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
		lookVacRefreshLabel.setBounds(172, 461, 93, 32);
		lookVacRefreshLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listMyVac = dbWork.selectOneVacation(std.getId());
				if (listMyVac == null) {
					JOptionPane.showMessageDialog(null,  "没有请假信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listMyVac.size();
					String[] name =  {
							"序号", "请假开始", "请假结束", "请假原因", "请假去向", "是否批准"
						};
					String[][] value = new String[size + 1][6];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listMyVac.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					myVacationTable.setModel(dtm);
					myVacationTable.setSelectionMode(0);					
				}
			}
		});
		lookMyVacationPanel.add(lookVacRefreshLabel);
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel addMyInfPanel = new JPanel();
		addMyInfPanel.setBounds(242, 62, 629, 588);
		addMyInfPanel.setVisible(false);
		getContentPane().add(addMyInfPanel);
		if(!dbWork.checkStudentInf(studentInf)) {
			addMyInfPanel.setVisible(true);
		}else {
			addMyInfPanel.setVisible(false);
		}
		addMyInfPanel.setLayout(null);
		
		JLabel label = new JLabel("完善信息");
		label.setBounds(271, 13, 72, 18);
		addMyInfPanel.add(label);
		
		JLabel addMyHomeLabel = new JLabel("家乡");
		addMyHomeLabel.setBounds(90, 153, 72, 18);
		addMyInfPanel.add(addMyHomeLabel);
		
		addMyHomeField = new JTextField();
		addMyHomeField.setBounds(194, 150, 130, 24);
		addMyInfPanel.add(addMyHomeField);
		addMyHomeField.setColumns(10);
		
		JLabel addMyQqLable = new JLabel("QQ");
		addMyQqLable.setBounds(90, 84, 72, 18);
		addMyInfPanel.add(addMyQqLable);
		
		addMyQqField = new JTextField();
		addMyQqField.setBounds(194, 81, 130, 24);
		addMyInfPanel.add(addMyQqField);
		addMyQqField.setColumns(10);
		
		JLabel addMyPhoneLabel = new JLabel("联系电话");
		addMyPhoneLabel.setBounds(90, 223, 72, 18);
		addMyInfPanel.add(addMyPhoneLabel);
		
		addMyPhoneField = new JTextField();
		addMyPhoneField.setBounds(194, 220, 130, 24);
		addMyInfPanel.add(addMyPhoneField);
		addMyPhoneField.setColumns(10);
		
		JLabel addMyClassLabel = new JLabel("班级");
		addMyClassLabel.setBounds(90, 290, 72, 18);
		addMyInfPanel.add(addMyClassLabel);
		
		addMyClassField = new JTextField();
		addMyClassField.setBounds(194, 287, 130, 24);
		addMyInfPanel.add(addMyClassField);
		addMyClassField.setColumns(10);
		
		JLabel addMyImgLabel = new JLabel("图片");
		addMyImgLabel.setBounds(370, 84, 72, 18);
		addMyInfPanel.add(addMyImgLabel);
		
		JLabel addShowMyImgLabel = new JLabel("");
		addShowMyImgLabel.setBounds(370, 115, 202, 199);
		addMyInfPanel.add(addShowMyImgLabel);
		
		JLabel addMyImgButLabel = new JLabel("");
		addMyImgButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/optionsInactive.png")));
		addMyImgButLabel.setBounds(456, 70, 104, 32);
		addMyImgButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
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
		        	myImgUrl = file.getAbsolutePath();
		        	addShowMyImgLabel.setIcon(new ImageIcon(myImgUrl.replace("//", "////")));
		        	JOptionPane.showMessageDialog(null,  "成功", "已获得图片", JOptionPane.INFORMATION_MESSAGE);
		        	
		        }  
			}
		});
		addMyInfPanel.add(addMyImgButLabel);
		
		
		
		JLabel addMySubmitButLabel = new JLabel("");
		addMySubmitButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/leaveGameInactive.png")));
		addMySubmitButLabel.setBounds(289, 420, 101, 32);
		addMySubmitButLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				addMySubmitButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/leaveGameActive.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				addMySubmitButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/leaveGameInactive.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				studentInf.setUserName(std.getUserName());
				studentInf.setName(std.getName());
				studentInf.setId(std.getId());
				studentInf.setClassName(addMyClassField.getText());
				studentInf.setFileUrl(myImgUrl);
				studentInf.setHome(addMyHomeField.getText());
				studentInf.setPhoneNumber(addMyPhoneField.getText());
				studentInf.setQqNumber(addMyQqField.getText());
				studentInf.setEmail(std.getEmail());
				dbWork.insertStudnetInf(studentInf);
				JOptionPane.showMessageDialog(null,  "个人信息更新成功", "成功", JOptionPane.INFORMATION_MESSAGE);
				addMyInfPanel.setVisible(false);
				
			}
		});
		addMyInfPanel.add(addMySubmitButLabel);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/bg/newmainmenubg.png")));
		bgLabel.setSize(1280,768);
		getContentPane().add(bgLabel);
		
	}
}
