package student;

import java.util.ArrayList;

public class Student {
	
	
	
	
	int snumber;
	String id;
	String pw;
	String name;
	String birthday;
	int ban;
	
	
	
	public Student(int snumber, String id, String pw, String name, String birthday, int ban) {
		super();
		this.snumber = snumber;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthday = birthday;
		this.ban = ban;
	}



	public int getSnumber() {
		return snumber;
	}



	public String getId() {
		return id;
	}



	public String getPw() {
		return pw;
	}



	public String getName() {
		return name;
	}



	public String getBirthday() {
		return birthday;
	}



	public int getBan() {
		return ban;
	}
	
	
	
}
