public class Main01 {
    public static void main(String[] args) {
        A a = new A();

        A.B b = a.new B();
        b.field01=3;
        b.method01();

        A.C c = new A.C();
        c.field01=3;
        c.method01();;

        A.C.field02=10;
        A.C.method02();

        a.method();
    }
}
