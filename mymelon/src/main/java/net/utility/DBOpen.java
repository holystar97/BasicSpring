package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component // 스프링 컨테이너가 자동으로 객체 생성함 
			//servlet context.xml에서 ->net. utility 를 scan 한 후 자동으로 객체 생성 된다 

public class DBOpen {
	
	public DBOpen() {
		System.out.println("----DBOpen() 객체 생성됨");
	}
	
	
	//데이터 베이스 연결 메소드 
	public Connection getConnection() {
		
		  String url     ="jdbc:oracle:thin:@localhost:1521:xe";
	      String user    ="system";
	      String password="1234";
	      String driver  ="oracle.jdbc.driver.OracleDriver";//ojdbc.jar    
	      Connection con=null;
	    
	      try {
	    	  Class.forName(driver);  
	  	      con=DriverManager.getConnection(url, user, password);
	    	  
	      }catch(Exception e) {
	    	 System.out.println("DB 연결 실패 : "+ e);
	      }
	      
		return con;
		
	} // getConnection() end
} // class end
