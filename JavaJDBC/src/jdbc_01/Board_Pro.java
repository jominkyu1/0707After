package jdbc_01;

//자바에서 오라클에 정의된 저장프로시저 호출해서 실행하는 예제

import java.sql.*;
import java.util.Scanner;

public class Board_Pro {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        //오라클 접속주소, xe는 데이터베이스명

        String user = "night";
        String password = "123456";

        Connection con=null; //데이터 베이스 연결 con
        PreparedStatement pt=null; // 쿼리문 수행할 pt
        ResultSet rs = null; // 검색결과를 가져올 rs
        CallableStatement cs = null; // 저장프로시저를 수행할 cs
        String sql=null;

        try(Scanner sc = new Scanner(System.in)){
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            System.out.print("게시판 번호>>");
            int bno = sc.nextInt();
            sql = "select * from tbl_board10 where bno=?";
            pt = con.prepareStatement(sql);
            pt.setInt(1, bno);

            rs = pt.executeQuery();

            if(rs.next()){
                sql = "{call sel_board10(?, ?, ?, ?)}"; //sel_board 저장 프로시저 호출문
                cs = con.prepareCall(sql); // 저장 프로시저를 호출할 cs 생성
                cs.setInt(1, bno);
                cs.registerOutParameter(2, Types.VARCHAR);
                //두번째 물음표에 해당하는 컬럼으로부터 레코드값을 얻어오기 위해서 미리 타입을 지정
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.registerOutParameter(4, Types.VARCHAR);

                cs.execute();

                System.out.println("번호\t 글쓴이 \t 제목 \t 글내용");
                System.out.println("==========================");
                System.out.printf("%d\t %s\t %s\t %s", bno, cs.getString(2),
                        cs.getString(3), cs.getString(4));
            }else {
                System.out.println("없는 번호");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs!=null) rs.close();
                if(con!=null) con.close();
                if(pt!=null) pt.close();
                if(cs!=null) cs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}