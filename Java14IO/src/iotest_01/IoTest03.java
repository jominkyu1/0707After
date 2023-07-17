package iotest_01;
//InputStream은 키보드 입력장치인 System.in과 연결되고, OutputStream은 모니터 출력장치인
//System.out과 연결된다.


import java.io.InputStream;
import java.io.OutputStream;

public class IoTest03 {
    public static void main(String[] args) throws Exception{

        int data=0;
        InputStream myIn = System.in;
        OutputStream myOut = System.out;

        System.out.print("문자 입력: ");

        while((data = myIn.read()) != -1){
            if(data == 'x' || data=='X'){
                break;
            }
            System.out.print((char)data);
        }
    }
}
