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
	private DatabaseWork dbWork = new DatabaseWork();
	private String myImgUrl;
	
	private JTextField addMyHomeField;
	private JTextField addMyQqField;
	private JTextField addMyPhoneField;
	private JTextField addMyClassField;
	private JTextField vacBeginTimeField;
	private JTextField vacEndTimeField;
	private JTextField vacDestinationField;
	
	
	
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
		
		
		JPanel myInfPanel = new JPanel();
		tabbedPane.addTab("我的信息", null, myInfPanel, null);
		myInfPanel.setLayout(null);
		
		JLabel myNameLabel = new JLabel("姓名");
		myNameLabel.setBounds(41, 13, 72, 18);
		myInfPanel.add(myNameLabel);
		
		JLabel myImgLabel = new JLabel("图片");
		myImgLabel.setBounds(41, 63, 72, 18);
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
		myQqLable.setBounds(347, 204, 72, 18);
		myInfPanel.add(myQqLable);
		
		JLabel myEmsilLabel = new JLabel("电子邮箱");
		myEmsilLabel.setBounds(347, 272, 72, 18);
		myInfPanel.add(myEmsilLabel);
		
		JLabel lookMyinfButLabel = new JLabel("");
		lookMyinfButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/RefreshBut.jpg")));
		lookMyinfButLabel.setBounds(249, 447, 93, 32);
		myInfPanel.add(lookMyinfButLabel);
		
		JLabel showMyImgLabel = new JLabel("");
		showMyImgLabel.setBounds(99, 71, 234, 244);
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
		showMyQqLabel.setBounds(450, 204, 110, 18);
		myInfPanel.add(showMyQqLabel);
		
		JLabel showMyEmailLabel = new JLabel("");
		showMyEmailLabel.setBounds(450, 272, 110, 18);
		myInfPanel.add(showMyEmailLabel);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("12");
		lblNewLabel.setBounds(75, 45, 66, 104);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("34");
		label_1.setBounds(75, 150, 66, 104);
		panel.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(75, 262, 66, 29);
		panel.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("56");
		label_2.setBounds(75, 304, 66, 104);
		panel.add(label_2);
		
		JLabel lblNewLabel_2 = new JLabel("78");
		lblNewLabel_2.setBounds(75, 409, 66, 103);
		panel.add(lblNewLabel_2);
		
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
		
		
		
		
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/bg/newmainmenubg.png")));
		bgLabel.setSize(1280,768);
		getContentPane().add(bgLabel);
		
	}
}
