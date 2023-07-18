package jdbc_01;

import net.daum.dao.BoardDAOImp1;
import net.daum.vo.BoardVO;

import java.util.List;

public class Board_list {
    public static void main(String[] args) {
        BoardDAOImp1 bdao = new BoardDAOImp1();
        List<BoardVO> blist = bdao.getBoardList();
        System.out.println("레코드 개수: " + blist.size());

        for(BoardVO b :blist){
            System.out.print(b.getBno());
            System.out.println("\t글쓴이: " + b.getBname());
            System.out.println("\t글제목: " + b.getBtitle());
            System.out.println("==================");
        }
    }
}
