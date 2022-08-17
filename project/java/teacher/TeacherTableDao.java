package teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherTableDao {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
	Connection con = null;
	
	public void dbCon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void inserttable(TeacherTable t) {
		
		try {
			dbCon();
			String sql="insert into Pro_info values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getpnumber());
			pst.setString(2, t.getp_id());
			pst.setString(3, t.getp_pw());
			pst.setString(4, t.getp_name());
			pst.setString(5, t.getMain());
			pst.setString(6, t.getBan());
			pst.executeQuery();
			
			pst.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public TeacherTable tablemember(String pnumber) {
		TeacherTable ta =null;
		
		try {
			dbCon();
			String sql="select * from Pro_info where pnumber=?";
			PreparedStatement pst;
			pst = con.prepareStatement(sql);
			pst.setString(1, pnumber);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				  ta=new TeacherTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ta;
	}
	public TeacherTable tablemember2(String p_id) {
		TeacherTable ta =null;
		
		try {
			dbCon();
			String sql="select * from Pro_info where p_id=?";
			PreparedStatement pst;
			pst = con.prepareStatement(sql);
			pst.setString(1, p_id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				  ta=new TeacherTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ta;
	}
	
	public ArrayList<TeacherTable> table(){
		ArrayList<TeacherTable> list = new ArrayList<>();
		try {
			dbCon();
			Statement st = null;
			st = con.createStatement();
			
			String sql="select * from Pro_info order by pnumber";
			ResultSet rs = st.executeQuery(sql);
			
			while( rs.next()) {
				TeacherTable l = new TeacherTable (rs.getString(1) , rs.getString(2) , rs.getString(3) , 
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(l);
			}	
			rs.close();
			st.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public void updatetable(String pnumber, String p_pw, String p_name, String cl, String ban) {
		
		try {
			dbCon();
			String sql="update Pro_info set p_pw=?,p_name=?,class=?,ban=? where pnumber=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p_pw);
			pst.setString(2, p_name);
			pst.setString(3, cl);
			pst.setString(4, ban);
			pst.setString(5, pnumber);
			
			pst.executeUpdate();
			pst.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
