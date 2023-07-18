package net.daum.dao;

import net.daum.vo.BoardVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImp1 {
    String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    //오라클 접속주소, xe는 데이터베이스명

    String user = "night";
    String password = "123456";

    Connection con=null; //데이터 베이스 연결 con
    PreparedStatement pt=null; //쿼리문 수행 pt
    ResultSet rs=null;
    String sql=null; //쿼리문 저장 변수

    public List<BoardVO> getBoardList() {
        List<BoardVO> blist = new ArrayList<>();

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            sql = "select * from tbl_board10 order by bno desc";
            pt = con.prepareStatement(sql); // 쿼리문을 미리 컴파일 하여 수행할 pt 생성
            rs = pt.executeQuery(); // select문 수행 후 검색 결과 레코드를 rs에 저장



            while(rs.next()){
                BoardVO b = new BoardVO();
                b.setBno(rs.getInt("bno"));
                b.setBname(rs.getString("bname"));
                b.setBtitle(rs.getString("btitle"));
                blist.add(b);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                pt.close();
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return blist;
    }
}
