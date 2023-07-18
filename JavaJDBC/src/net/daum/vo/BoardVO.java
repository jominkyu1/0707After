package net.daum.vo;

public class BoardVO { //중간에 자료 저장하는 데이터 저장 빈 클래스
        //되도록이면 tbl_board10 테이블의 컬럼명과 빈클래스 변수명은 같게한다.
    private int bno, bhit;
    private String bname, btitle, bcont, bdate;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getBhit() {
        return bhit;
    }

    public void setBhit(int bhit) {
        this.bhit = bhit;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcont() {
        return bcont;
    }

    public void setBcont(String bcont) {
        this.bcont = bcont;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }
}