package net.daum.controller;

import net.daum.dao.GuDAOImp1;
import net.daum.vo.GuVO;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class Gu_Frame extends JFrame{
    JPanel jp = new JPanel();
    JButton jb = new JButton("확인");
    JTextField gname = new JTextField("글쓴이");
    JTextField gtitle = new JTextField("글제목");
    JTextField gcont = new JTextField("글내용");
    GuVO gv = new GuVO();
    GuDAOImp1 gdi = new GuDAOImp1();
    int result = -1;

    Gu_Frame(){
        setTitle("DB Insert");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        jp.setLayout(new GridLayout(4,1));
        jp.add(gname);
        jp.add(gtitle);
        jp.add(gcont);
        jp.add(jb);

        add(jp);
        setVisible(true);

        jb.addActionListener(e -> {
            gv.setGname(gname.getText());
            gv.setGtitle(gtitle.getText());
            gv.setGcont(gcont.getText());

            result = gdi.insertGu(gv);
            
            if(result==1){
                JOptionPane.showMessageDialog(null, "Insert 완료");
                gname.setText(null);
                gtitle.setText(null);
                gcont.setText(null);
            }else {
                JOptionPane.showMessageDialog(null, "Insert 실패");
            }
        });
    }
}
public class Gu_Insert{
    public static void main(String[] args) {
        new Gu_Frame();
//        Scanner sc = new Scanner(System.in);
//        GuDAOImp1 gd = new GuDAOImp1();
//        GuVO gv = new GuVO();
//
//        System.out.print("글쓴이>> ");
//        gv.setGname(sc.nextLine());
//
//        System.out.print("글제목>> ");
//        gv.setGtitle(sc.nextLine());
//
//        System.out.print("글내용>> ");
//        gv.setGcont(sc.nextLine());
//
//        int result = gd.insertGu(gv);
//
//        if (result==1) System.out.println("Insert 완료");
//        else System.out.println("Insert 실패");
//
//        sc.close();
    }
}

 /*  문제 겸 과제)
            1. create table tbl_gu(
                gno int primary key,
                gname varchar(20) not null,
                gtitle varchar(200) not null,
                gcont varchar(4000) not null,
                gdate date default sysdate
                );

            2. net.daum.vo 패키지의 GuVO.java 데이터 저장 빈 클래스를 생성하고
               tbl_gu테이블의 컬럼명과 같은 변수 정의 세터 게터또한 정의

            3. gno_seq10 시퀀스 생성 1부터 1씩증가 nocache

            4. net.daum.dao패키지에 GuDAOImp1.java 오라클 db연동 클래스 만들어서 JDBC프로그래밍
             가. Gu_Insert.java에서 스캐너로 입력한 글쓴이, 글제목, 글내용, 글번호 저장하는
             public int insertGu(GuVO g){}메서드 작성

            5. net.daum.controller 패키지에 방명록 목록을 가져오는 Gu_List.java를 작성해서 목록을
            가져오는 public List(GuVO) getGuList(){} 를 GuDAOImp1.java에 작성한다.
        * */