package stream_01;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentTest04 {

    public static void main(String[] args) {

        // 배열 -> Stream
        String[] strArr = {"홍길동", "이순신", "강감찬"};
        Stream<String> strStream = Arrays.stream(strArr);

        strStream.forEach(System.out::println);

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intSt = Arrays.stream(intArr);

        intSt.forEach(System.out::print);
    }
}