package net.daum.controller;

import net.daum.dao.GuDAOImp1;
import net.daum.vo.GuVO;

import java.util.List;

public class Gu_List {
    public static void main(String[] args) {
        GuDAOImp1 gd = new GuDAOImp1();

        List<GuVO> arr = gd.getGuList();
        arr.forEach(e -> {
            System.out.printf("글번호: %d\n글쓴이: %s\n글제목: %s\n글내용: %s\n작성일자: %s\n=========\n",
                             e.getGno(), e.getGname(), e.getGtitle(), e.getGcont(), e.getGdate());
        });

    }
}
