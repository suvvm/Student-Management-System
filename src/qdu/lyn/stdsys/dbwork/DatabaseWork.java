package qdu.lyn.stdsys.dbwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineListener;
import javax.swing.JOptionPane;

public class DatabaseWork {
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";// MySQL数据库驱动类的名称
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/studentdb";// 访问MySQL数据库的路径
	protected static String dbUser = "root";// 访问MySQL数据库的用户名
	protected static String dbPwd = "root";// 访问MySQL数据库的密码
	protected static String dbName = "studentdb";// 访问MySQL数据库中的实例(studentdb)
	protected static String second = null;//
	public static Connection conn = null;// MySQL数据库的连接对象
	
	static {
		try {
			if (conn == null) {
				Class.forName(dbClassName);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);	// 连接MySQL数据库
				JOptionPane.showMessageDialog(null,"MySQL Drive now is loaded!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "请确认MySQL的JDBC驱动包是否存在。");// 捕获异常后，弹出提示框
			System.exit(-1);// 系统停止运行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 读取所有客户信息
		public static List getKhInfos() {
			List list = findForList("select id,stuname,username from student");
			return list;
		}
		public static List findForList(String mysql) {
			// TODO 自动生成的方法存根
			List<List> list = new ArrayList<List>();
			
			return null;
		}
}
