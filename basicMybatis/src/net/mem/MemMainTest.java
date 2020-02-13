package net.mem;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemMainTest {
  public static void main(String[] args) {
    //myBatis기반 JDBC연습
    try {
      //1)DB 환경 설정 관련 파일 가져오기
      String resource="config/jdbc.xml";
      InputStream is=Resources.getResourceAsStream(resource);
      
      //2)DB연결하기 위한 팩토리빈 생성
      //-> DBOpen + MemberDAO
      SqlSessionFactory ssf
                 =new SqlSessionFactoryBuilder().build(is);
      
      System.out.println("DB연결 성공");
      
      //3)쿼리문 생성 및 변환
      //PreparedStatement와 비슷한 기능
      SqlSession sql=ssf.openSession(true);
      
      //4)쿼리문 실행
      //->a)행추가
      //int result=sql.insert("mem.insertRow", new MemDTO("진달래", 40));
      //System.out.println("행추가 결과 : "+result);
      
      
      //->c)수정
      //int result=sql.update("mem.updateRow", new MemDTO(5, "김연아", 60));
      //System.out.println("행수정 결과 : "+result);
      
      
      //->d)삭제
      //->나이가 30이하 행 삭제
      int result=sql.delete("mem.deleteRow", 30);
      System.out.println("행삭제 결과 : "+result);

      
      //->b)전체 목록
      List<MemDTO> list = sql.selectList("mem.selectAll");
      for(int idx=0; idx<list.size(); idx++) {
          MemDTO dto = list.get(idx);
          System.out.print(dto.getNum() + " ");
          System.out.print(dto.getName() + " ");
          System.out.print(dto.getAge() + " ");
          System.out.println();
      }//end
      
      
      
      
      
      
      
      
      
    }catch (Exception e) {
      System.out.println("실패 : " + e);
    }//try end    

  }//main() end
}//class end
