package functional_01;

import java.util.function.IntBinaryOperator;

//인스턴스 메소드 참조와 정적 메소드 참조
public class Calc01Ex {
    public static void main(String[] args) {
        IntBinaryOperator operator;
        Calc01 obj = new Calc01();
        //int 인자2개 int반환 함수형 인터페이스

        operator = (a, b) -> Calc01.staticMethod(a, b);
        System.out.println(operator.applyAsInt(10, 20));

        operator = Calc01::staticMethod; //정적 메소드참조
        System.out.println(operator.applyAsInt(10, 20));

        operator = (a, b) -> obj.instanceMethod(a, b);
        System.out.println(operator.applyAsInt(10, 20));

        operator = obj::instanceMethod; //인스턴스 메소드참조
        System.out.println(operator.applyAsInt(10, 20));
    }
}