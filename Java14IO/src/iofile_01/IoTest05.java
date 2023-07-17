package iofile_01;

import java.io.File;
import java.io.IOException;

public class IoTest05 {
    public static void main(String[] args) throws IOException {

        String path = "./src/iofile_01";
        File dir = new File(path);
        String[] fileNames = dir.list();


        for(String str : fileNames){
            File f = new File(path+"/"+str);
            System.out.println("파일이름: "+ f.getName());
            System.out.println("파일경로: "+ f.getPath());
            System.out.println("부모경로: "+ f.getParent());
            System.out.println("절대경로: "+ f.getAbsolutePath());
            System.out.println("파일여부: "+ f.isFile());
            System.out.println("디렉터리여부: "+ f.isDirectory());
            System.out.println("==========");
        }
    }
}