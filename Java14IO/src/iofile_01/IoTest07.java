package iofile_01;
//java.io 패키지의 FileOutputStream 클래스는 주어진 파일에 바이트 단위로 기록하기 위한 클래스

import java.io.File;
import java.io.FileOutputStream;

public class IoTest07 {
    public static void main(String[] args) throws Exception {
        int data = 0;
        System.out.print("저장 할 내용 입력: ");

        File f = new File("./src/iofile_01/result.txt");
        FileOutputStream fos = new FileOutputStream(f);

        while ((data = System.in.read()) != 10) {   //10 -> enter
            fos.write((char) data); //파일에 기록
        }
        fos.close();
    }
}