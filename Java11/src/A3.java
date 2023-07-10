public class A3 {   //외부클래스 A3
    int field01;    //instance variable
    void method01(){}

    static int field02; //static variable
    static void method02(){}

    class B{
        void method01(){ //내부클래스에서 외부클래스의 static, instance 모두 접근가능
            field01=10;
            method01();

            field02=20;
            method02();
        }
    }
}