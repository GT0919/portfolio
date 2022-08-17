package teacher;

public class TeacherTable {
	String pnumber;
	String p_id;
	String p_pw;
	String p_name;
	String main;
	String ban;
	public TeacherTable(String pnumber, String p_id, String p_pw, String p_name, String main, String ban) {
		super();
		this.pnumber = pnumber;
		this.p_id = p_id;
		this.p_pw = p_pw;
		this.p_name = p_name;
		this.main = main;
		this.ban = ban;
	}
	public String getpnumber() {
		return pnumber;
	}
	public String getp_id() {
		return p_id;
	}
	public String getp_pw() {
		return p_pw;
	}
	public String getp_name() {
		return p_name;
	}
	public String getMain() {
		return main;
	}
	public String getBan() {
		return ban;
	}
	
	

}
