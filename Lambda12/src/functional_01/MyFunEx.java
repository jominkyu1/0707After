package functional_01;

public class MyFunEx {
    public static void main(String[] args) {
        MyFun mf;

        mf = () -> System.out.println("MyFun");

        mf.method();
    }
}