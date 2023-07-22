package jdbc_01;

import net.daum.dao.BoardDAOImp1;
import net.daum.vo.BoardVO;

import java.util.Scanner;

//게시판 번호값을 입력받아서 오라클 DB의 해당 번호값이 있으면 삭제
public class Board_delete {
    public static void main(String[] args) {
        BoardDAOImp1 bdao = new BoardDAOImp1();
        Scanner sc = new Scanner(System.in);

        System.out.println("게시물 삭제하기 연습\n======");
        System.out.print("게시판 번호>> ");
        int bno = Integer.parseInt(sc.nextLine());

        BoardVO dbNo = bdao.getFindNo(bno);
        if (dbNo != null){
            int re = bdao.deleteBoard(bno); // 번호 기준 삭제
            
            if (re==1) System.out.println("삭제 성공");
            else System.out.println("삭제 실패");
        } else { //해당 번호값이 없으면 null
            System.out.println("없는 번호");
        }
    }
}
