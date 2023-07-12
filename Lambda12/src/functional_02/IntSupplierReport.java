package functional_02;

import java.util.function.IntSupplier;
//IntSupplier 함수형 인터페이스와 Thread를 이용한 주사위 숫자 출력 예제
public class IntSupplierReport {
    public static void main(String[] args) {

        IntSupplier is = () -> (int)((Math.random()*6)+1);

        Thread th1 = new Thread(()->{
            int num = is.getAsInt();
            System.out.print(num);
        });

        Thread th2 = new Thread(()->{
            int num = is.getAsInt();
            System.out.print(num);
        });

        th1.start();
        th2.start();
    }
}