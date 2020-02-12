package kr.co.form1.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBClose;
import net.utility.DBOpen;

public class MemberDAO {
  private DBOpen dbopen=null;  
  private Connection con=null;
  private PreparedStatement pstmt=null;
  private ResultSet rs=null;
  private StringBuilder sql=null;
  
  public MemberDAO() {
    dbopen=new DBOpen();
  }
  
  public int duplecateID(String id) {
    int cnt=0;
    try {
      con=dbopen.getConnection();          
      sql=new StringBuilder();
      sql.append(" SELECT COUNT(id) as cnt");
      sql.append(" FROM member");
      sql.append(" WHERE id=?");
      pstmt=con.prepareStatement(sql.toString());
      pstmt.setString(1, id);
      rs=pstmt.executeQuery();
      if(rs.next()) {
        cnt=rs.getInt("cnt");
      }
    }catch (Exception e) {
      System.out.println("아이디 중복 확인 실패 : " + e);
    }finally {
      DBClose.close(con, pstmt, rs);
    }//try end
    return cnt;
  }//duplecateID() end
  
  
  
  
  
  
  
  
    
  
  
}//class end
