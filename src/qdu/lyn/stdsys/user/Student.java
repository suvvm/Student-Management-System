package qdu.lyn.stdsys.user;

public class Student{
	private String userName;
	private String password;
	private String name;
	private String email;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int tId) {
		id = tId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String tEmail) {
		email = tEmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String tName) {
		name = tName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String tUserName) {
		userName = tUserName;
	}
	public String getUserPassword() {
		return password;
	}
	public void setUserPassword(String tPassword) {
		password = tPassword;
	}
}
