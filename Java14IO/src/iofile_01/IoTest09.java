package iofile_01;
//FileReader는 주어진 파일로부터 문자단위로 읽어들이기 위한 입력스트림이다.

import java.io.*;

public class IoTest09 {
    public static void main(String[] args) {
        String fileName;
        String buf;

        Reader myIn = new InputStreamReader(System.in);
        BufferedReader keyBr = new BufferedReader(myIn);

        try{
            System.out.print("파일명 입력: ");
            fileName = keyBr.readLine();

            FileReader fr = new FileReader(fileName);
            BufferedReader fileBr = new BufferedReader(fr);

            while((buf = fileBr.readLine()) != null){
                System.out.println(buf);
            }


            fileBr.close();
            fr.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}