package jdbc_01;

//tbl_board10 테이블 레코드 저장 소스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Board_Insert {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        //오라클 접속주소, xe는 데이터베이스명

        String user = "night";
        String password = "123456";

        Connection con=null;
        Statement stmt=null;
        String sql=null;

        try{
            Class.forName(driver); //오라클 JDBC 드라이버 클래스 로드
            con = DriverManager.getConnection(url, user, password);
                //연결주소, 사용자, 비밀번호

            Scanner scan = new Scanner(System.in);
            System.out.println("tbl_board10 테이블에 레코드 저장");
            System.out.print("글쓴이: ");
            String bname = scan.nextLine();

            System.out.print("글제목: ");
            String btitle = scan.nextLine();

            System.out.print("글내용: ");
            String bcont = scan.nextLine();

            stmt=con.createStatement();

            sql="insert into tbl_board10 (bno, bname, btitle, bcont, bdate) values"
            + "(bno_seq10.nextval, '" + bname + "', '" + btitle + "', '" + bcont + "', sysdate)";
            //sysdate는 오라클 날짜함수

            int re = stmt.executeUpdate(sql);
            
            if(re==1) System.out.println("저장 성공");

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}