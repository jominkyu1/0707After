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

    public BoardVO getFindNo(int bno) {
        BoardVO dbno = null;

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            sql = "select * from tbl_board10 where bno=?";
                    //번호를 기준으로 해당 테이블 레코드 검색
            pt = con.prepareStatement(sql);
            pt.setInt(1, bno); //첫번째 물음표에 정수숫자로 번호값 저장
            rs = pt.executeQuery();

            if(rs.next()){
                dbno = new BoardVO();
                dbno.setBno(rs.getInt(1)); // 첫번째 컬럼
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(pt!=null) pt.close();
                if(con!=null) con.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return dbno;
    }

    public int editBoard(BoardVO eb) {
        int re = -1; //수정실패시 반환값

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            sql = "update tbl_board10 set bname=?, btitle=?, bcont=? where bno=?";
            pt = con.prepareStatement(sql);

            pt.setString(1, eb.getBname());
            pt.setString(2, eb.getBtitle());
            pt.setString(3, eb.getBcont());
            pt.setInt(4, eb.getBno());

            re = pt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pt!=null) pt.close();
                if(con !=null) con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return re;
    }

    public int deleteBoard(int bno) {
        int result = -1;

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            sql = "delete from tbl_board10 where bno=?";
            pt = con.prepareStatement(sql);
            pt.setInt(1, bno);

            result = pt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(con!=null) con.close();
                if(pt!=null) pt.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }
}