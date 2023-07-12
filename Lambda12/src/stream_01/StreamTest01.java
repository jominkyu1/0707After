package stream_01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest01 {
    public static void main(String[] args) {
        
        List<String> list = Arrays.asList("홍길동", "이순신", "강감찬"); //배열을 컬렉션 List로 변환
        System.out.println(list);
        
        //기존방법인 Iterator를 사용한 예
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //람다식과 스트림을 활용한 예 (JDK 1.8~)
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }
}