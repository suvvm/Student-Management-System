package qdu.lyn.stdsys.main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.inf.MessagesInf;
import qdu.lyn.stdsys.inf.Vacation;
import qdu.lyn.stdsys.login.RegisterFrame;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;
import qdu.lyn.stdsys.user.StudentInf;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import jxl.biff.drawing.MsoDrawingGroupRecord;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class StudentUseFrame extends JFrame{
	private JTable table;
	private JTable atdTable;
	private List<String[]> listAll;
	private List<String> myInfList;
	private List<String[]> listMyVac;
	private List<String[]> listSchedule;
	private List<String[]> listMyAtd;
	private List<String[]> listAllMes;
	private List<String[]> listNotMes;
	
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
	private JTable myMessagesTable;
	private JTextField toUserNameField;
	private JTextField themeNameField;
	
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
		
		JLabel monday_12Label = new JLabel("12");
		monday_12Label.setBounds(46, 45, 60, 80);
		panel.add(monday_12Label);
		
		JLabel monday_34Label = new JLabel("34");
		monday_34Label.setBounds(46, 138, 60, 80);
		panel.add(monday_34Label);
		
		JLabel monday_56Label = new JLabel("56");
		monday_56Label.setBounds(46, 231, 60, 80);
		panel.add(monday_56Label);
		
		JLabel monday_78Label = new JLabel("78");
		monday_78Label.setBounds(46, 324, 60, 80);
		panel.add(monday_78Label);
		
		JLabel mondayTagLabel = new JLabel("星期一");
		mondayTagLabel.setBounds(46, 14, 60, 18);
		panel.add(mondayTagLabel);
		
		JLabel tuesdayTagLabel = new JLabel("星期二");
		tuesdayTagLabel.setBounds(124, 14, 60, 18);
		panel.add(tuesdayTagLabel);
		
		JLabel wednesdayTagLabel = new JLabel("星期三");
		wednesdayTagLabel.setBounds(198, 14, 60, 18);
		panel.add(wednesdayTagLabel);
		
		JLabel thursdayTagLabel = new JLabel("星期四");
		thursdayTagLabel.setBounds(272, 14, 60, 18);
		panel.add(thursdayTagLabel);
		
		JLabel fridayTagLabel = new JLabel("星期五");
		fridayTagLabel.setBounds(346, 14, 60, 18);
		panel.add(fridayTagLabel);
		
		JLabel staurdayTagLabel = new JLabel("星期六");
		staurdayTagLabel.setBounds(420, 14, 60, 18);
		panel.add(staurdayTagLabel);
		
		JLabel sundayTagLabel = new JLabel("星期日");
		sundayTagLabel.setBounds(494, 14, 72, 18);
		panel.add(sundayTagLabel);
		
		JLabel tuesday_12Label = new JLabel("12");
		tuesday_12Label.setBounds(120, 45, 60, 80);
		panel.add(tuesday_12Label);
		
		JLabel tuesday_34Label = new JLabel("34");
		tuesday_34Label.setBounds(124, 138, 60, 80);
		panel.add(tuesday_34Label);
		
		JLabel tuesday_56Label = new JLabel("56");
		tuesday_56Label.setBounds(124, 231, 60, 80);
		panel.add(tuesday_56Label);
		
		JLabel tuesday_78Label = new JLabel("78");
		tuesday_78Label.setBounds(124, 324, 60, 80);
		panel.add(tuesday_78Label);
		
		JLabel wednesday_78Label = new JLabel("78");
		wednesday_78Label.setBounds(198, 324, 60, 80);
		panel.add(wednesday_78Label);
		
		JLabel thursday_78Label = new JLabel("78");
		thursday_78Label.setBounds(272, 324, 60, 80);
		panel.add(thursday_78Label);
		
		JLabel friday_78Label = new JLabel("78");
		friday_78Label.setBounds(346, 324, 60, 80);
		panel.add(friday_78Label);
		
		JLabel staurday_78Label = new JLabel("78");
		staurday_78Label.setBounds(420, 324, 60, 80);
		panel.add(staurday_78Label);
		
		JLabel sunday_78Label = new JLabel("78");
		sunday_78Label.setBounds(494, 324, 60, 80);
		panel.add(sunday_78Label);
		
		JLabel wednesday_56Label = new JLabel("56");
		wednesday_56Label.setBounds(198, 231, 60, 80);
		panel.add(wednesday_56Label);
		
		JLabel thursday_56Label = new JLabel("56");
		thursday_56Label.setBounds(272, 231, 60, 80);
		panel.add(thursday_56Label);
		
		JLabel friday_56Label = new JLabel("56");
		friday_56Label.setBounds(346, 231, 60, 80);
		panel.add(friday_56Label);
		
		JLabel staurday_56Label = new JLabel("56");
		staurday_56Label.setBounds(420, 231, 60, 80);
		panel.add(staurday_56Label);
		
		JLabel sunday_56Label = new JLabel("56");
		sunday_56Label.setBounds(494, 231, 60, 80);
		panel.add(sunday_56Label);
		
		JLabel wednesday_34Label = new JLabel("34");
		wednesday_34Label.setBounds(198, 138, 60, 80);
		panel.add(wednesday_34Label);
		
		JLabel thursday_34Label = new JLabel("34");
		thursday_34Label.setBounds(272, 138, 60, 80);
		panel.add(thursday_34Label);
		
		JLabel friday_34Label = new JLabel("34");
		friday_34Label.setBounds(346, 138, 60, 80);
		panel.add(friday_34Label);
		
		JLabel staurday_34Label = new JLabel("34");
		staurday_34Label.setBounds(420, 138, 60, 80);
		panel.add(staurday_34Label);
		
		JLabel sunday_34Label = new JLabel("34");
		sunday_34Label.setBounds(494, 138, 60, 80);
		panel.add(sunday_34Label);
		
		JLabel wednesday_12Label = new JLabel("12");
		wednesday_12Label.setBounds(198, 45, 60, 80);
		panel.add(wednesday_12Label);
		
		JLabel thursday_12Label = new JLabel("12");
		thursday_12Label.setBounds(272, 45, 60, 80);
		panel.add(thursday_12Label);
		
		JLabel friday_12Label = new JLabel("12");
		friday_12Label.setBounds(346, 45, 60, 80);
		panel.add(friday_12Label);
		
		JLabel staurday_12Label = new JLabel("12");
		staurday_12Label.setBounds(420, 45, 60, 80);
		panel.add(staurday_12Label);
		
		JLabel sunday_12Label = new JLabel("12");
		sunday_12Label.setBounds(494, 45, 60, 80);
		panel.add(sunday_12Label);
		
		JLabel monday_910Label = new JLabel("910");
		monday_910Label.setBounds(46, 417, 60, 80);
		panel.add(monday_910Label);
		
		JLabel tuesday_910Label = new JLabel("910");
		tuesday_910Label.setBounds(124, 417, 60, 80);
		panel.add(tuesday_910Label);
		
		JLabel wednesday_910Label = new JLabel("910");
		wednesday_910Label.setBounds(198, 417, 60, 80);
		panel.add(wednesday_910Label);
		
		JLabel thursday_910Label = new JLabel("910");
		thursday_910Label.setBounds(272, 417, 60, 80);
		panel.add(thursday_910Label);
		
		JLabel friday_910Label = new JLabel("910");
		friday_910Label.setBounds(346, 417, 60, 80);
		panel.add(friday_910Label);
		
		JLabel staurday_910Label = new JLabel("910");
		staurday_910Label.setBounds(420, 417, 60, 80);
		panel.add(staurday_910Label);
		
		JLabel sunday_910Label = new JLabel("910");
		sunday_910Label.setBounds(494, 417, 60, 80);
		panel.add(sunday_910Label);
		
		JLabel scheduleRefreshLabel = new JLabel("");
		scheduleRefreshLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
		scheduleRefreshLabel.setBounds(257, 511, 93, 32);
		scheduleRefreshLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listSchedule = dbWork.selectSchedule();
				monday_12Label.setText(listSchedule.get(0)[0]);
				monday_34Label.setText(listSchedule.get(0)[1]);
				monday_56Label.setText(listSchedule.get(0)[2]);
				monday_78Label.setText(listSchedule.get(0)[3]);
				monday_910Label.setText(listSchedule.get(0)[4]);
				
				tuesday_12Label.setText(listSchedule.get(1)[0]);
				tuesday_34Label.setText(listSchedule.get(1)[1]);
				tuesday_56Label.setText(listSchedule.get(1)[2]);
				tuesday_78Label.setText(listSchedule.get(1)[3]);
				tuesday_910Label.setText(listSchedule.get(1)[4]);
				
				wednesday_12Label.setText(listSchedule.get(2)[0]);
				wednesday_34Label.setText(listSchedule.get(2)[1]);
				wednesday_56Label.setText(listSchedule.get(2)[2]);
				wednesday_78Label.setText(listSchedule.get(2)[3]);
				wednesday_910Label.setText(listSchedule.get(2)[4]);
				
				thursday_12Label.setText(listSchedule.get(3)[0]);
				thursday_34Label.setText(listSchedule.get(3)[0]);
				thursday_56Label.setText(listSchedule.get(3)[0]);
				thursday_78Label.setText(listSchedule.get(3)[0]);
				thursday_910Label.setText(listSchedule.get(3)[0]);
				
				friday_12Label.setText(listSchedule.get(4)[0]);
				friday_34Label.setText(listSchedule.get(4)[1]);
				friday_56Label.setText(listSchedule.get(4)[2]);
				friday_78Label.setText(listSchedule.get(4)[3]);
				friday_910Label.setText(listSchedule.get(4)[4]);
				
				staurday_12Label.setText(listSchedule.get(5)[0]);
				staurday_34Label.setText(listSchedule.get(5)[1]);
				staurday_56Label.setText(listSchedule.get(5)[2]);
				staurday_78Label.setText(listSchedule.get(5)[3]);
				staurday_910Label.setText(listSchedule.get(5)[4]);
				
				sunday_12Label.setText(listSchedule.get(6)[0]);
				sunday_34Label.setText(listSchedule.get(6)[1]);
				sunday_56Label.setText(listSchedule.get(6)[2]);
				sunday_78Label.setText(listSchedule.get(6)[3]);
				sunday_910Label.setText(listSchedule.get(6)[4]);
				
			}
			
		});
		panel.add(scheduleRefreshLabel);
		
		
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
		
		JPanel myAttendancePanel = new JPanel();
		tabbedPane.addTab("签到", null, myAttendancePanel, null);
		myAttendancePanel.setLayout(null);
		atdTable = new JTable();
		String[] atdname = new String[] {
				"编号", "签到名称", "开始时间", "持续时长", "出席状态"
			};
		String[][] atdvalue = {};
		DefaultTableModel atdDtm = new DefaultTableModel(atdvalue, atdname);
		atdTable.setModel(atdDtm);
		atdTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		atdTable.setBounds(12, 5, 600, 474);
		atdTable.setVisible(true);
		myAttendancePanel.add(atdTable);
		
		JLabel refuseAttendanceLabel = new JLabel("");
		refuseAttendanceLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
		refuseAttendanceLabel.setBounds(254, 498, 93, 32);
		refuseAttendanceLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				refuseAttendanceLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut_c.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				refuseAttendanceLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listMyAtd = dbWork.selectOneStudentAttendance(studentInf.getName());
				if (listMyAtd == null) {
					JOptionPane.showMessageDialog(null,  "没有签到信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listMyAtd.size();
					String[] name =  {
							"编号", "签到名称", "开始时间", "持续时长", "出席状态"
						};
					String[][] value = new String[size + 1][5];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listMyAtd.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					atdTable.setModel(dtm);
					atdTable.setSelectionMode(0);
				}
			}
		});
		myAttendancePanel.add(refuseAttendanceLabel);
		
		JLabel attendanceSubmitLabel = new JLabel("");
		attendanceSubmitLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/leaveGameInactive.png")));
		attendanceSubmitLabel.setBounds(384, 498, 101, 32);
		attendanceSubmitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				int row = atdTable.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null,  "没有选择请假信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					String temp = atdTable.getValueAt(row, 0).toString();
	                //System.out.println("$" + temp);
	                int num = Integer.parseInt(temp);
	                //System.out.println(num);
	                //stdinf.setId(Integer.parseInt(idField.getText()));
	                try {
	                	System.out.println(num + " " + studentInf.getName());
	                	Timestamp timestamp =  new Timestamp(System.currentTimeMillis());
	                    if(dbWork.studentAttendanceSubmit(num, studentInf.getName(), timestamp)) {
	                    	listMyAtd = dbWork.selectOneStudentAttendance(studentInf.getName());
	        				if (listMyAtd == null) {
	        					JOptionPane.showMessageDialog(null,  "没有签到信息", "警告", JOptionPane.WARNING_MESSAGE);
	        				}else {
	        					int size = listMyAtd.size();
	        					String[] name =  {
	        							"编号", "签到名称", "开始时间", "持续时长", "出席状态"
	        						};
	        					String[][] value = new String[size + 1][5];
	        					value[0] = name;
	        					for(int i = 0; i < size; i++) {
	        						value[i + 1] = listMyAtd.get(i);
	        					}
	        					DefaultTableModel dtm = new DefaultTableModel(value, name);
	        					atdTable.setModel(dtm);
	        					atdTable.setSelectionMode(0);
	        				}
	                    }
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
				}
			}
		});
		myAttendancePanel.add(attendanceSubmitLabel);
		
		JPanel myMessagesPanel = new JPanel();
		tabbedPane.addTab("我的消息", null, myMessagesPanel, null);
		myMessagesPanel.setLayout(null);
		
		myMessagesTable = new JTable();
		myMessagesTable.setBounds(45, 44, 445, 245);
		myMessagesPanel.add(myMessagesTable);
		
		JLabel myMessagesLabel = new JLabel("我的消息");
		myMessagesLabel.setBounds(14, 13, 72, 18);
		myMessagesPanel.add(myMessagesLabel);
		
		JLabel refuseAllLabel = new JLabel("");
		refuseAllLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/joinGameInactive.png")));
		refuseAllLabel.setBounds(504, 107, 93, 32);
		refuseAllLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				super.mouseClicked(e);
				listAllMes = dbWork.selectAllMessage(std.getUserName());
				if (listAllMes == null) {
					JOptionPane.showMessageDialog(null,  "没有消息", "提示", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listAllMes.size();
					System.out.println(size);
					String[] name =  {
							"编号", "主题", "是否已读", "发送者", "内容"
						};
					String[][] value = new String[size + 1][5];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listAllMes.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					myMessagesTable.setModel(dtm);
					myMessagesTable.setSelectionMode(0);
				}
				
			}
		});
		myMessagesPanel.add(refuseAllLabel);
		
		JLabel refreshNotReadLabel = new JLabel("");
		refreshNotReadLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/joinGameInactive.png")));
		refreshNotReadLabel.setBounds(504, 201, 93, 32);
		refreshNotReadLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				listNotMes = dbWork.selectNotReadMessage(std.getUserName());
				if (listNotMes == null) {
					JOptionPane.showMessageDialog(null,  "没有消息", "提示", JOptionPane.WARNING_MESSAGE);
				}else {
					int size = listNotMes.size();
					System.out.println(size);
					String[] name =  {
							"编号", "主题", "是否已读", "发送者", "内容"
						};
					String[][] value = new String[size + 1][4];
					value[0] = name;
					for(int i = 0; i < size; i++) {
						value[i + 1] = listNotMes.get(i);
					}
					DefaultTableModel dtm = new DefaultTableModel(value, name);
					myMessagesTable.setModel(dtm);
					myMessagesTable.setSelectionMode(0);
				}
			}
		});
		myMessagesPanel.add(refreshNotReadLabel);
		
		JLabel toUserLabel = new JLabel("收件人");
		toUserLabel.setBounds(14, 313, 72, 18);
		myMessagesPanel.add(toUserLabel);
		
		toUserNameField = new JTextField();
		toUserNameField.setBounds(100, 310, 120, 24);
		myMessagesPanel.add(toUserNameField);
		toUserNameField.setColumns(10);
		
		JLabel themeNameLabel = new JLabel("主题");
		themeNameLabel.setBounds(247, 313, 72, 18);
		myMessagesPanel.add(themeNameLabel);
		
		themeNameField = new JTextField();
		themeNameField.setBounds(311, 310, 120, 24);
		myMessagesPanel.add(themeNameField);
		themeNameField.setColumns(10);
		
		JTextArea contentArea = new JTextArea();
		contentArea.setBounds(62, 359, 428, 88);
		myMessagesPanel.add(contentArea);
		
		JLabel contentLabel = new JLabel("内容");
		contentLabel.setBounds(14, 361, 72, 18);
		myMessagesPanel.add(contentLabel);
		
		JLabel sendLabel = new JLabel("");
		sendLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/leaveGameInactive.png")));
		sendLabel.setBounds(311, 480, 101, 32);
		sendLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				MessagesInf ms = new MessagesInf();
				ms.setName(themeNameField.getText());
				ms.setIsRead("未读");
				ms.setSendUser(std.getUserName());
				ms.setToUser(toUserNameField.getText());
				ms.setContent(contentArea.getText());
				Student sd = new Student();
				sd.setUserName(toUserNameField.getText());
				Administrator ad = new Administrator();
				ad.setUserName(toUserNameField.getText());
				if(!dbWork.checkAdministrator(ad) && !dbWork.checkStudent(sd)) {
					JOptionPane.showMessageDialog(null, "发送失败", "目标用户不存在", JOptionPane.ERROR_MESSAGE);
				}else {
					dbWork.insertMessages(ms);
					JOptionPane.showMessageDialog(null, "发送成功", "目标用户已经收到信息", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		myMessagesPanel.add(sendLabel);
		
		JLabel reSendLabel = new JLabel("");
		reSendLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/leaveGameInactive.png")));
		reSendLabel.setBounds(123, 480, 101, 32);
		reSendLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				MessagesInf ms = new MessagesInf();
				ms.setName(themeNameField.getText());
				ms.setIsRead("未读");
				ms.setSendUser(std.getUserName());
				int row = myMessagesTable.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null,  "没有选择需要回复的信息", "警告", JOptionPane.WARNING_MESSAGE);
				}else {
					String temp = myMessagesTable.getValueAt(row, 3).toString();
	                //System.out.println("$" + temp);
	                //int num = Integer.parseInt(temp);
	                ms.setToUser(temp);
	                ms.setContent(contentArea.getText());
	                dbWork.insertMessages(ms);
	                JOptionPane.showMessageDialog(null, "发送成功", "目标用户已收到信息", JOptionPane.INFORMATION_MESSAGE);
	           
				}
			}
		});
		myMessagesPanel.add(reSendLabel);

		
		
		
		
		
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
