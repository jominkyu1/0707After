package iofile_01;
// java.io패키지의 File api 내장 클래스는 파일과 디렉터리를 다룬다.
// 웹개발에서는 주로 자료실을 만들 때 많이 사용한다.

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

public class IoTest04 {
    public static void main(String[] args) {
        File filePath = new File("./src/iotest_01");

        String[] fileList = filePath.list();

        Arrays.asList(fileList).forEach(System.out::println);
    }
}
