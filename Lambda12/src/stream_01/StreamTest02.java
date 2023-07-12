package stream_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest02 {
    public static void main(String[] args) {
        List<Student01> list = Arrays.asList(
                new Student01("홍길동", 90),
                new Student01("이순신", 100)
        );

        Stream<Student01> stream = list.stream();
        stream.forEach(s -> {
            String name = s.getName();
            int score = s.getScore();

            System.out.println(name+", "+score);
        });
    }
}