package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	
	Connection con=null;
	
	
	public void updatePassword(String id, String pw) {
		
		
		try {
			dbCon();
			
			String sql = "update s_info set pw = ? where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, pw);
			pst.setString(2, id);
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public Student getStudent(String id) {
		Student s =null;
		dbCon();
		String sql="select * from s_info where id =?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			
			if(rs.next()) {
				
				s = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
		
	}
	

	public void insertMember(Student s) { 
		
		try {
			
			dbCon();
			String sql="insert into s_info values(?,?,?,?,?,?)" ;
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setInt(1, s.getSnumber());
			pst.setString(2, s.getId());
			pst.setString(3, s.getPw());
			pst.setString(4, s.getName());
			pst.setString(5, s.getBirthday());
			pst.setInt(6, s.getBan());
								
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
 
	
	
	
	public ArrayList<Student> listMembers(){
				
		ArrayList<Student> list = new ArrayList<>();
		 try {
			 
			 
			dbCon();
			Statement st  =con.createStatement();
			String sql="select snumber,id,pw,name,to_char(birthday,'yy-mm-dd'),ban  from S_info";
			ResultSet rs  =st.executeQuery(sql);
			
			while( rs.next()) {
				Student s = new Student (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				list.add(s);
			}	
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}		 
		 
		 return list;
		
		 
	}
	
	
	
	
	
	 void dbCon() {			
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	
	
	

}
