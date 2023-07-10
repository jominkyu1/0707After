public class A {
    public static void main(String[] args) {
        new A().new B();
    }
    
    A(){
        System.out.println("A생성자 호출");
    }

    //인스턴스 멤버 내부클래스: 외부클래스$내부클래스명.class
    public class B{ //A$B.class
        //인스턴스 멤버 내부클래스에는 인스턴스 변수와 메서드만 올 수 있다.
        //정적(static) 변수와 정적메소드는 불가능
        
        B(){
            System.out.println("B생성자 호출");

        }

        int field01; //인스턴스 변수
        void method01(){} //인스턴스 메소드
    }
    
    //정적(static) 멤버 내부클래스
    static class C{
        // static, 인스턴스 모두 가능
        C(){
            System.out.println("C생성자 호출");
        }
        int field01;
        static int field02;
        void method01(){}
        static void method02(){}
    }

    void method(){
        //메소드 내에서 클래스 생성가능 (로컬 지역클래스: 외부클래스$1내부클래스명.class)
        class D{// 로컬지역클래스에는 static 불가능
            D(){
                System.out.println("D생성자 호출");
            }
            int field01;
            void method01(){}
        }

        D d = new D();
        d.field01=3;
        d.method01();
    }
}