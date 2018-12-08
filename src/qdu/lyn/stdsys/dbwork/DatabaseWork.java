package qdu.lyn.stdsys.dbwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineListener;
import javax.swing.JOptionPane;

import qdu.lyn.stdsys.inf.Vacation;
import qdu.lyn.stdsys.user.Administrator;
import qdu.lyn.stdsys.user.Student;
import qdu.lyn.stdsys.user.StudentInf;

public class DatabaseWork {
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/StudentDB?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
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
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPassword());
			pStatement.setString(3, user.getName());
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
			String insertVac = "insert into Vacation values(null, ?, ?, ?, ?, ?, ?)";
			
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
				list.add(new String[] {rSet.getString("stuid"), rSet.getString("stuName"), rSet.getString("beginTime"), rSet.getString("endTime"), rSet.getString("reason"), rSet.getString("destination")});
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
