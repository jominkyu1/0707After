package iofile_01;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;

//java.io의 FileInputStream  클래스를 활용하여 주어진 파일의 내용을 바이트 단위로 읽어들이는 입력스트림
public class IoTest06 {
    public static void main(String[] args) throws Exception{
        int data=0;

        String path = "./src/iofile_01/IoTest06.java";

        FileInputStream fis = new FileInputStream(path);
//        while((data = fis.read()) != -1){
//            System.out.print((char)data);
//        }

        for(byte b : fis.readAllBytes()){
            System.out.print((char)b);
        }
    }
}