package stream_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest03 {
    public static void main(String[] args) {
        List<Student01> stList = Arrays.asList(
                new Student01("신사임당", 100),
                new Student01("강감찬", 90),
                new Student01("유관순", 80)
        );

        Stream<Student01> st = stList.stream(); //Collection -> Stream
        st.forEach(s -> System.out.println(s.getName()));
    }
}
