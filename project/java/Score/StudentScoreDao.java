package Score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentScoreDao {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String password="tiger";
	
Connection con =null;
	
public static void main(String[] args){
	StudentScoreDao dao = new StudentScoreDao();
	dao.dbCon();
	
}


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
	
public void inserttable(StudentScore s) {
		
		try {
			dbCon();
			String sql="insert into Score_info values(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s.getScore_num());
			pst.setInt(2, s.getSnumber());
			pst.setInt(3, s.getKor());
			pst.setInt(4, s.getEng());
			pst.setInt(5, s.getMath());
			pst.setInt(6, s.getTotal());
			pst.setDouble(7, s.getAvg());
			
			pst.executeQuery();
			
			pst.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public StudentScore tablemember(String score_num) {
	StudentScore ss =null;
	
	try {
		dbCon();
		String sql="select * from Score_info where score_num=?";
		PreparedStatement pst;
		pst = con.prepareStatement(sql);
		pst.setString(1, score_num);
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			  ss=new StudentScore(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getDouble(7));
			}
		rs.close();
		pst.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ss;
}


public ArrayList<StudentScore> table(){
	ArrayList<StudentScore> list = new ArrayList<>();
	try {
		dbCon();
		Statement st = null;
		st = con.createStatement();
		
		String sql="select score_num 점수번호 , snumber 학생번호 , kor 국어 , eng 영어 , math 수학 , total 총점 , avg 평균"
				+ "       , rank() over (order by total desc) 석차"
				+ "       from score_info"
				+ "       order by total desc";
		ResultSet rs = st.executeQuery(sql);
		
		while( rs.next()) {
			StudentScore s = new StudentScore (rs.getString(1) , rs.getInt(2) , rs.getInt(3) , 
					rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getDouble(7),rs.getString(8));
			list.add(s);
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
public void updatetable(String score_num, int snumber, int kor, int eng, int math) {
	
	try {
		StudentScore s = new StudentScore();
		
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);
		dbCon();
		String sql="update Score_info set snumber=?,kor=?,eng=?,math=? where score_num=?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, snumber);
		pst.setInt(2, kor);
		pst.setInt(3, eng);
		pst.setInt(4, math);
		pst.setString(5, score_num);
		
		pst.executeUpdate();
		pst.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
	
	public StudentScore Studenttablemember(String score_num) {
		StudentScore s =null;
		
		try {
			dbCon();
			String sql="SELECT s.id , sc.snumber , sc.kor , sc.eng ,sc.math, sc.total , sc.avg"
					+ " FROM score_info sc"
					+ " JOIN s_info s"
					+ " ON sc.snumber =s.snumber       "
					+ " where id = ?";
			PreparedStatement pst;
			pst = con.prepareStatement(sql);
			pst.setString(1, score_num);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				  s=new StudentScore(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getDouble(7));
				}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
		
		
	
	
	
}
	

}
