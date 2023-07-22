package jdbc_01;

import net.daum.dao.BoardDAOImp1;
import net.daum.vo.BoardVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Board_update {
    public static void main(String[] args) {
        BoardDAOImp1 bdao = new BoardDAOImp1();
        BoardVO eb = new BoardVO();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*  InputStreamReader는 입력받은 바이트를 문자로 변경
            BufferedReader는 입력받은 문자를 버퍼링 즉 임시메모리에 저장한 다음 한번에 읽어들임
        * */

        System.out.print("입력>> ");
        try {
            int bno = Integer.parseInt(br.readLine());
            BoardVO dbNo = bdao.getFindNo(bno);

            if(dbNo==null){
                System.out.println("번호값이 없음");
            }else{
                System.out.print("수정할 글쓴이 입력>> ");
                String bname = br.readLine();

                System.out.print("수정할 제목 입력>> ");
                String btitle = br.readLine();

                System.out.print("수정할 내용 입력>> ");
                String bcont = br.readLine();

                eb.setBno(bno); eb.setBname(bname);
                eb.setBtitle(btitle); eb.setBcont(bcont);

                int re = bdao.editBoard(eb);
                
                if(re==1){
                    System.out.println("게시판 수정 성공");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}