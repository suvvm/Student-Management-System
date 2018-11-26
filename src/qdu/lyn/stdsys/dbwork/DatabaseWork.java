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

import qdu.lyn.stdsys.user.Administrator;

public class DatabaseWork {
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/studentdb";
	protected static String dbUser = "root";
	protected static String dbPwd = "root";
	protected static String dbName = "studentdb";
	
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
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
		JOptionPane.showMessageDialog(null, "数据库连接成功！");
	}
	
	public boolean checkAdministrator(Administrator user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Administrator where username = ?");
			pStatement.setString(1, user.getUserName());
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
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
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
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
	public boolean checkStudent(Administrator user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Student where username = ?");
			pStatement.setString(1, user.getUserName());
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
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
	public boolean confirmStudent(Administrator user) {
		try {
			getConnection();
			pStatement = connection.prepareStatement("select * from Student where username = ? AND password = ?");
			pStatement.setString(1, user.getUserName());
			pStatement.setString(2, user.getUserPassword());
			
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
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
	public void insertStudent(Administrator user) {
		
	}
	public void closeAll() {
		if (resultSet != null) {
			try {
				resultSet.close();
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
