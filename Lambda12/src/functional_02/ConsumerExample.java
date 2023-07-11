package functional_02;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

//매개값은 있고 리턴값이 없는 함수형 인터페이스 Consumer
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> cs = t -> System.out.println(t+"8");

        cs.accept("12");

        BiConsumer<String, String> bcs = (x, y) -> System.out.println(x+y);

        bcs.accept("123", "456");
    }
}
