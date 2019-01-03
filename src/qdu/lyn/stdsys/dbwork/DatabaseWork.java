package qdu.lyn.stdsys.dbwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineListener;
import javax.swing.JOptionPane;

import com.mysql.cj.Messages;

import qdu.lyn.stdsys.inf.Attendance;
import qdu.lyn.stdsys.inf.MessagesInf;
import qdu.lyn.stdsys.inf.Schedule;
import qdu.lyn.stdsys.inf.Vacation;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;
import qdu.lyn.stdsys.user.StudentInf;

public class DatabaseWork {
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost/StudentDB?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	protected static String dbUser = "root";
	protected static String dbPwd = "root";
	protected static String dbName = "StudentDB";
	
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet rSet;
	
	
	
	static {
		try {
				Class.forName(dbClassName);
				JOptionPane.showMessageDialog(null,"MySQL Drive now is loaded!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请确认MYSQL驱动是否正常安装！");
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getConnection() throws SQLException {
		connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		//JOptionPane.showMessageDialog(null, "数据库连接成功！");
	}
	
	public boolean checkAdministrator(Administrator user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Administrator where username = ?");
			pStatement.setString(1, user.getUserName());
			rSet = pStatement.executeQuery();
			if(rSet.next()) {
				return true;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public boolean confirmAdministrator(Administrator user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Administrator where username = ? AND password = ?");
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPassword());
			System.out.println("username："+user.getUserName()+"  password："+user.getUserPassword());
			rSet = pStatement.executeQuery();
			//System.out.println("username："+rSet.getInt(1)+"  password："+rSet.getString(2));
			//return true;
			if(rSet.next()) {
				return true;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public boolean checkStudent(Student user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Student where username = ?");
			pStatement.setString(1, user.getUserName());
			
			rSet = pStatement.executeQuery();
			
			if(rSet.next()) {
				return true;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public boolean confirmStudent(Student user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Student where username = ? AND password = ?");
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPassword());
			
			rSet = pStatement.executeQuery();
			
			if(rSet.next()) {
				return true;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public void insertAdministrator(Administrator user) {
		try {
			getConnection();
			String insertAdministrator = "insert into Administrator values(null, ?, ?, ?, ?)";
			
			pStatement = connection.prepareStatement(insertAdministrator);
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPassword());
			pStatement.setString(3, user.getName());
			pStatement.setString(4, user.getEmail());
			
			pStatement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void insertStudent(Student user) {
		try {
			getConnection();
			String insertStudent = "insert into Student values(null, ?, ?, ?, ?, ?)";
			
			pStatement = connection.prepareStatement(insertStudent);
			pStatement.setString(1, user.getName());
			pStatement.setString(2, user.getUserName());
			pStatement.setString(3, user.getUserPassword());
			pStatement.setString(4, user.getEmail());
			pStatement.setInt(5, user.getId());
			
			pStatement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public boolean checkStudentInf(StudentInf user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from StudentInf where id = ?");
			pStatement.setInt(1, user.getId());
			
			rSet = pStatement.executeQuery();
			
			if(rSet.next()) {
				return true;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public void insertStudnetInf(StudentInf user) {
		try {
			getConnection();
			String insertStudnetInf = "insert into StudentInf values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pStatement = connection.prepareStatement(insertStudnetInf);
			pStatement.setInt(1, user.getId());
			pStatement.setString(2, user.getName());
			pStatement.setString(3, user.getHome());
			pStatement.setString(4, user.getPhoneNumber());
			pStatement.setString(5, user.getFileUrl());
			pStatement.setString(6, user.getUserName());
			pStatement.setString(7, user.getQqNumber());
			pStatement.setString(8, user.getEmail());
			pStatement.setString(9, user.getClassName());
			
			pStatement.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	public void updateStudnetInf(StudentInf user) {
		try {
			getConnection();
			String insertStudnetInf = "update StudentInf set name = ?, home = ?, phoneNumber = ?, img = ?, username = ?, qqNUmber = ?, e_mail = ?, className = ? where id = ?";
			//UPDATE 表名字 SET 列1=值1,列2=值2 WHERE 条件;
			pStatement = connection.prepareStatement(insertStudnetInf);
			pStatement.setString(1, user.getName());
			pStatement.setString(2, user.getHome());
			pStatement.setString(3, user.getPhoneNumber());
			pStatement.setString(4, user.getFileUrl());
			pStatement.setString(5, user.getUserName());
			pStatement.setString(6, user.getQqNumber());
			pStatement.setString(7, user.getEmail());
			pStatement.setString(8, user.getClassName());
			pStatement.setInt(9, user.getId());
			
			pStatement.executeUpdate();
			insertStudnetInf = "insert into Student values(null, ?, ?, ?, ?, ?)";
			pStatement = connection.prepareStatement(insertStudnetInf);
			
			pStatement.setString(1, user.getName());
			pStatement.setString(2, user.getUserName());
			String tpas = JOptionPane.showInputDialog(null,"请输入更改后新密码：\n","确认密码",JOptionPane.PLAIN_MESSAGE);
			pStatement.setString(3, tpas);
			pStatement.setString(4, user.getEmail());
			pStatement.setInt(5, user.getId());
			
			pStatement.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public List<String> selectOneStudentInf(StudentInf stdinf) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from StudentInf where id = ?");
			pStatement.setInt(1, stdinf.getId());
			
			rSet = pStatement.executeQuery();
			List<String> list = new ArrayList<String>();
			while(rSet.next()) {
				list.add(rSet.getString("name"));
				list.add(rSet.getString("home"));
				list.add(rSet.getString("phoneNumber"));
				list.add(rSet.getString("img"));
				list.add(rSet.getString("username"));
				list.add(rSet.getString("qqNumber"));
				list.add(rSet.getString("e_mail"));
				list.add(rSet.getString("className"));
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public List<String> getOneStudent(Student std) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Student where username = ? and password = ?");
			pStatement.setString(1, std.getUserName());
			pStatement.setString(2, std.getUserPassword());
			
			rSet = pStatement.executeQuery();
			if(rSet.next()) {
				//System.out.println("@@@" + rSet.getString("stuname") + " " + rSet.getString("e_mail") + " " + rSet.getString("id"));
				List<String> list = new ArrayList<String>();
				list.add( rSet.getString("stuname"));
				list.add( rSet.getString("e_mail"));
				list.add( rSet.getString("id"));
				return list;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public List<String[]> selectAllStudentInf() {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from StudentInf");
			
			rSet = pStatement.executeQuery();
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				list.add(new String[] {rSet.getString("id"), rSet.getString("name"), rSet.getString("home"), rSet.getString("phoneNumber"), rSet.getString("username"), rSet.getString("qqNumber"), rSet.getString("e_mail"), rSet.getString("className")});
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public boolean deleteStudentInf(StudentInf user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("delete from StudentInf where id = ?");
			pStatement.setInt(1, user.getId());
			pStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public void insertVacation(Vacation vac) {
		try {
			getConnection();
			String insertVac = "insert into Vacation values(null, ?, ?, ?, ?, ?, ?, 0)";
			
			pStatement = connection.prepareStatement(insertVac);
			pStatement.setInt(1, vac.getStuid());
			pStatement.setString(2, vac.getStuName());
			pStatement.setString(3, vac.getBgTime());
			pStatement.setString(4, vac.getEdTime());
			pStatement.setString(5, vac.getReason());
			pStatement.setString(6, vac.getVacDestination());
			
			pStatement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public List<String[]> selectAllVacation() {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Vacation");
			
			rSet = pStatement.executeQuery();
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				list.add(new String[] {rSet.getString("num"), rSet.getString("stuid"), rSet.getString("stuName"), rSet.getString("beginTime"), rSet.getString("endTime"), rSet.getString("reason"), rSet.getString("destination"), rSet.getString("approval")});
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public List<String[]> selectOneVacation(int id) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Vacation where stuid = ?");
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				list.add(new String[] {rSet.getString("num"), rSet.getString("beginTime"), rSet.getString("endTime"), rSet.getString("reason"), rSet.getString("destination"), rSet.getString("approval")});
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public boolean approvalVacation(int num) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("update Vacation set approval = 1 where num = ?");
			pStatement.setInt(1, num);
			pStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public boolean refuseVacation(int num) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("update Vacation set approval = 2 where num = ?");
			pStatement.setInt(1, num);
			pStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public void updateSchedule(Schedule sch, int day) {
		try {
			getConnection();
			switch (day) {
			case 1:
				pStatement = connection.prepareStatement("update monday set course_12 = ?, course_34 = ?, course_56 = ?, course_78 = ?, course_910 = ? where num = 1");
				pStatement.setString(1, sch.getMonday().getCourse_12());
				pStatement.setString(2, sch.getMonday().getCourse_34());
				pStatement.setString(3, sch.getMonday().getCourse_56());
				pStatement.setString(4, sch.getMonday().getCourse_78());
				pStatement.setString(5, sch.getMonday().getCourse_910());
				//pStatement.executeUpdate();
				break;
			case 2:
				
				pStatement = connection.prepareStatement("update tuesday set course_12 = ?,  course_34 = ?,  course_56 = ?,  course_78 = ?, course_910 = ? where num = 1");
				pStatement.setString(1, sch.getTuesday().getCourse_12());
				pStatement.setString(2, sch.getTuesday().getCourse_34());
				pStatement.setString(3, sch.getTuesday().getCourse_56());
				pStatement.setString(4, sch.getTuesday().getCourse_78());
				pStatement.setString(5, sch.getTuesday().getCourse_910());
				break;
			case 3:
				pStatement = connection.prepareStatement("update wednesday set course_12 = ?,  course_34 = ?,  course_56 = ?,  course_78 = ?, course_910 = ? where num = 1");
				pStatement.setString(1, sch.getWednesday().getCourse_12());
				pStatement.setString(2, sch.getWednesday().getCourse_34());
				pStatement.setString(3, sch.getWednesday().getCourse_56());
				pStatement.setString(4, sch.getWednesday().getCourse_78());
				pStatement.setString(5, sch.getWednesday().getCourse_910());
				break;
			case 4:
				pStatement = connection.prepareStatement("update thursday set course_12 = ?,  course_34 = ?,  course_56 = ?,  course_78 = ?, course_910 = ? where num = 1");
				pStatement.setString(1, sch.getThursday().getCourse_12());
				pStatement.setString(2, sch.getThursday().getCourse_34());
				pStatement.setString(3, sch.getThursday().getCourse_56());
				pStatement.setString(4, sch.getThursday().getCourse_78());
				pStatement.setString(5, sch.getThursday().getCourse_910());
				break;
			case 5:
				pStatement = connection.prepareStatement("update friday set course_12 = ?,  course_34 = ?,  course_56 = ?,  course_78 = ?, course_910 = ? where num = 1");
				pStatement.setString(1, sch.getFriday().getCourse_12());
				pStatement.setString(2, sch.getFriday().getCourse_34());
				pStatement.setString(3, sch.getFriday().getCourse_56());
				pStatement.setString(4, sch.getFriday().getCourse_78());
				pStatement.setString(5, sch.getFriday().getCourse_910());
				break;
			case 6:
				pStatement = connection.prepareStatement("update saturday set course_12 = ?,  course_34 = ?,  course_56 = ?,  course_78 = ?, course_910 = ? where num = 1");
				pStatement.setString(1, sch.getStaurday().getCourse_12());
				pStatement.setString(2, sch.getStaurday().getCourse_34());
				pStatement.setString(3, sch.getStaurday().getCourse_56());
				pStatement.setString(4, sch.getStaurday().getCourse_78());
				pStatement.setString(5, sch.getStaurday().getCourse_910());
				break;
			case 7:
				pStatement = connection.prepareStatement("update sunday set course_12 = ?,  course_34 = ?,  course_56 = ?,  course_78 = ?, course_910 = ? where num = 1");
				pStatement.setString(1, sch.getSunday().getCourse_12());
				pStatement.setString(2, sch.getSunday().getCourse_34());
				pStatement.setString(3, sch.getSunday().getCourse_56());
				pStatement.setString(4, sch.getSunday().getCourse_78());
				pStatement.setString(5, sch.getSunday().getCourse_910());
				break;
			default:
				break;
			}
			pStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public List<String[]> selectSchedule() {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from monday, tuesday, wednesday, thursday, friday, saturday, sunday");
			rSet = pStatement.executeQuery();
			List<String[]> listSchedule = new ArrayList<String[]>();
			while(rSet.next()) {
				//System.out.println(rSet.getString(3) + "$" + rSet.getString(4) + "$" + rSet.getString(5) + "$" + rSet.getString(6) + "$" + rSet.getString(7) + "$" + rSet.getString(10) + "$" + rSet.getString(11) + "$" + rSet.getString(12) + "$" + rSet.getString(13) + "$" + rSet.getString(14));
				listSchedule.add(new String[] {rSet.getString(3), rSet.getString(4), rSet.getString(5), rSet.getString(6), rSet.getString(7)});
				listSchedule.add(new String[] {rSet.getString(10), rSet.getString(11), rSet.getString(12), rSet.getString(13), rSet.getString(14)});
				listSchedule.add(new String[] {rSet.getString(17), rSet.getString(18), rSet.getString(19), rSet.getString(20), rSet.getString(21)});
				listSchedule.add(new String[] {rSet.getString(24), rSet.getString(25), rSet.getString(26), rSet.getString(27), rSet.getString(28)});
				listSchedule.add(new String[] {rSet.getString(31), rSet.getString(32), rSet.getString(33), rSet.getString(34), rSet.getString(35)});
				listSchedule.add(new String[] {rSet.getString(38), rSet.getString(39), rSet.getString(40), rSet.getString(41), rSet.getString(42)});
				listSchedule.add(new String[] {rSet.getString(45), rSet.getString(46), rSet.getString(47), rSet.getString(48), rSet.getString(49)});
						
			}
			return listSchedule;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public void insertAttendance(Attendance atd) {
		try {
			getConnection();
			String insertAtd = "insert into attendance values(null, ?, ?, ?, ?, ?)";
			
			pStatement = connection.prepareStatement(insertAtd);
			pStatement.setString(1, atd.getName());
			pStatement.setTimestamp(2, atd.getBgtime());
			pStatement.setInt(3, atd.getDuration());
			pStatement.setString(4, atd.getStudentName());
			pStatement.setString(5, atd.getAttendInf());
			
			pStatement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public List<String[]> selectAllAttendance() {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from attendance");
			
			rSet = pStatement.executeQuery();
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				list.add(new String[] {rSet.getString("num"), rSet.getString("name"), rSet.getString("bgtime"), rSet.getString("duration"), rSet.getString("studentName"), rSet.getString("attendInf")});
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public List<String[]> selectOneAttendance(String atdName) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from attendance where name = ?");
			pStatement.setString(1, atdName);
			rSet = pStatement.executeQuery();
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				list.add(new String[] {rSet.getString("num"), rSet.getString("bgtime"), rSet.getString("duration"), rSet.getString("studentName"), rSet.getString("attendInf")});
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public List<String[]> selectOneStudentAttendance(String stdName) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from attendance where studentName = ?");
			pStatement.setString(1, stdName);
			rSet = pStatement.executeQuery();
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				list.add(new String[] {rSet.getString("num"), rSet.getString("name"), rSet.getString("bgtime"), rSet.getString("duration"), rSet.getString("attendInf")});
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public boolean studentAttendanceSubmit(int num, String stdname, Timestamp timeNow) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from attendance where studentName = ? and num = ?");
			pStatement.setString(1, stdname);
			pStatement.setInt(2, num);
			rSet = pStatement.executeQuery();
			long duration = 0;
			Timestamp bgtime = new Timestamp(System.currentTimeMillis());
			while(rSet.next()) {
//				System.out.println(rSet.getString("num") + rSet.getString("name"));
				bgtime = rSet.getTimestamp("bgtime");
				duration = rSet.getLong("duration");
			}
			long flag = (timeNow.getTime() - bgtime.getTime())/(1000*60);
			String atdinf;
		if (duration < flag) {
				atdinf = "迟到";
			}else {
				atdinf = "出勤";
			}
			pStatement = connection.prepareStatement("update attendance set attendInf = ? where num = ? and studentName = ?");
			pStatement.setString(1, atdinf);
			pStatement.setInt(2, num);
			pStatement.setString(3, stdname);
			pStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public void insertBroadcast(MessagesInf brc) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from student");
			rSet = pStatement.executeQuery();
			String toUser;
			while(rSet.next()) {
				String insertBro = "insert into Messages values(null, ?, ?, ?, ?, ?)";
				pStatement = connection.prepareStatement(insertBro);
				toUser = rSet.getString("username");
				pStatement.setString(1, brc.getName());
				pStatement.setString(2, brc.getIsRead());
				pStatement.setString(3, brc.getSendUser());
				pStatement.setString(4, toUser);
				pStatement.setString(5, brc.getContent());
				pStatement.executeUpdate();
			}
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void insertMessages(MessagesInf brc) {
		try {
			getConnection();
			System.out.println(brc.getName());
			System.out.println(brc.getIsRead());
			System.out.println(brc.getSendUser());
			System.out.println(brc.getToUser());
			System.out.println(brc.getContent());
			String insertBro = "insert into messages values(null, ?, ?, ?, ?, ?)";
			pStatement = connection.prepareStatement(insertBro);
			pStatement.setString(1, brc.getName());
			pStatement.setString(2, brc.getIsRead());
			pStatement.setString(3, brc.getSendUser());
			pStatement.setString(4, brc.getToUser());
			pStatement.setString(5, brc.getContent());
			pStatement.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/*public void readMessages(int num) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("update Messages set isRead = ? where num = ?");
			pStatement.setString(1, "已读");
			pStatement.setInt(2, num);
			pStatement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}*/
	public List<String[]> selectNotReadMessage(String userName) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from messages where toUser = ?");
			pStatement.setString(1, userName);
			rSet = pStatement.executeQuery();
			pStatement = connection.prepareStatement("update Messages set isRead = ? where num = ?");
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				if(rSet.getString("isRead").equals("已读"))
					continue;
				list.add(new String[] {rSet.getString("num"), rSet.getString("name"), rSet.getString("isRead"), rSet.getString("sendUser"), rSet.getString("content")});
				pStatement.setString(1, "已读");
				pStatement.setInt(2, Integer.parseInt(rSet.getString("num")));
				pStatement.executeUpdate();
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public List<String[]> selectAllMessage(String userName) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from messages where toUser = ?");
			pStatement.setString(1, userName);
			rSet = pStatement.executeQuery();
			pStatement = connection.prepareStatement("update Messages set isRead = ? where num = ?");
			List<String[]> list = new ArrayList<String[]>();
			while(rSet.next()) {
				list.add(new String[] {rSet.getString("num"), rSet.getString("name"), rSet.getString("isRead"), rSet.getString("sendUser"), rSet.getString("content")});
				pStatement.setString(1, "已读");
				pStatement.setInt(2, Integer.parseInt(rSet.getString("num")));
				pStatement.executeUpdate();
			}
			return list;
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	public void closeAll() {
		if (rSet != null) {
			try {
				rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (pStatement != null) {
			try {
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
}
