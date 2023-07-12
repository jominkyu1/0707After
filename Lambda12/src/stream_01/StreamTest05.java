package stream_01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest05 {
    static int result =0;

    public static void main(String[] args) {

        //문제: IntStream의 하위의 rangeClosed(int a, int b) 메소드를 활용하여 1부터 100까지
        //순차적으로 제공하는 스트림 객체를 생성한 다음 해당 자연수의 누적합을 구해서 출력
        IntStream is = IntStream.rangeClosed(1, 100);
        is.forEach(value -> result += value);

        System.out.println(result);

        int result2=0;
        for (int i = 51; i <= 100; i++) result2 += i;
        System.out.println(result2);

        System.out.println("\n==================\n");

        int total=0;
        int total2=0;

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int j = (int)(Math.random()*10)+1;
            numList.add(j);
            total+=j;
        }
        System.out.println(total);

        for(int i:numList){
            total2 += i;
        }
        System.out.println(total2);
    }
}