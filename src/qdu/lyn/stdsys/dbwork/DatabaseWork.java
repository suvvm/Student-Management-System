package qdu.lyn.stdsys.dbwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineListener;
import javax.swing.JOptionPane;

public class DatabaseWork {
	protected static String dbClassName = "com.mysql.cj.jdbc.Driver";// MySQL���ݿ������������
	protected static String dbUrl = "jdbc:mysql://127.0.0.1:3306/studentdb";// ����MySQL���ݿ��·��
	protected static String dbUser = "root";// ����MySQL���ݿ���û���
	protected static String dbPwd = "root";// ����MySQL���ݿ������
	protected static String dbName = "studentdb";// ����MySQL���ݿ��е�ʵ��(studentdb)
	protected static String second = null;//
	public static Connection conn = null;// MySQL���ݿ�����Ӷ���
	
	static {
		try {
			if (conn == null) {
				Class.forName(dbClassName);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);	// ����MySQL���ݿ�
				JOptionPane.showMessageDialog(null,"MySQL Drive now is loaded!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��ȷ��MySQL��JDBC�������Ƿ���ڡ�");// �����쳣�󣬵�����ʾ��
			System.exit(-1);// ϵͳֹͣ����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ��ȡ���пͻ���Ϣ
		public static List getKhInfos() {
			List list = findForList("select id,stuname,username from student");
			return list;
		}
		public static List findForList(String mysql) {
			// TODO �Զ����ɵķ������
			List<List> list = new ArrayList<List>();
			
			return null;
		}
}
