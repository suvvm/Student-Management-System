package qdu.lyn.stdsys.inf;

import java.sql.Timestamp;

public class Attendance {
	private String name;
	private Timestamp bgtime;
	private int duration;
	private String studentName;
	private String attendInf;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getBgtime() {
		return bgtime;
	}
	public void setBgtime(Timestamp bgtime) {
		this.bgtime = bgtime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAttendInf() {
		return attendInf;
	}
	public void setAttendInf(String attendInf) {
		this.attendInf = attendInf;
	}
	
}
