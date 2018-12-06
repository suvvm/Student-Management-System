package qdu.lyn.stdsys.main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import qdu.lyn.stdsys.dbwork.DatabaseWork;
import qdu.lyn.stdsys.login.RegisterFrame;
import qdu.lyn.stdsys.user.Student;
import qdu.lyn.stdsys.user.StudentInf;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class StudentUseFrame extends JFrame{
	private JTable table;
	private List<String[]> listAll;
	private DatabaseWork dbWork = new DatabaseWork();
	
	
	
	public StudentUseFrame(Student std) {
		setTitle("学生端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 768);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		StudentInf studentInf = new StudentInf();
		studentInf.setId(std.getId());
		if(!dbWork.checkStudentInf(studentInf)) {
			
		}
		
		
		JLabel exitLabel = new JLabel("");
		exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut.png")));
		exitLabel.setBounds(885, 620, 145, 42);
		exitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseEntered(e);
				exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseExited(e);
				exitLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/Exitbut.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				super.mouseClicked(e);
				System.exit(1);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(242, 62, 629, 588);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("完善信息");
		label.setBounds(271, 13, 72, 18);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(82, 69, 72, 18);
		panel.add(label_1);
		getContentPane().add(exitLabel);
		
		JLabel backToMainLabel = new JLabel("");
		backToMainLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/but/backToMain.jpg")));
		backToMainLabel.setBounds(885, 577, 145, 42);
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
		selectAllButLabel.setIcon(new ImageIcon(ManagementFrame.class.getResource("/but/joinGameInactive.png")));
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
		lookMyinfButLabel.setIcon(new ImageIcon(StudentUseFrame.class.getResource("/but/joinGameInactive.png")));
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
		
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/bg/newmainmenubg.png")));
		bgLabel.setSize(1280,768);
		getContentPane().add(bgLabel);
		
	}
}
