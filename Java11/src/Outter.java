/*  메소드호출이 끝나면 메소드내의 지역변수나 매개변수는 스택 메모리에서 사라진다.
    하지만, 메소드 내부의 로컬지역클래스는 메모리에 남는다. 로컬지역 내부 클래스에서 메소드의
    매개변수나 지역번수를 복사를 해놓고 사용하다보니 값 불일치 현상이 발생할 수 있다.

    때문에 JDK1.8이후부터는 final을 묵시적으로 제공
* */
public class Outter {
    //JDK1.7 이전
    public void method01(final int arg){
        final int localVariable=10;

        class Inner{ //로컬지역 내부클래스 (Outter$1Inner.class)
            public void method(){
                int result = arg + localVariable;
            }
        }
    }
    
    //JDK1.8 이후
    public void method02(int arg){
        int localVariable=10;

        class Inner{ //로컬지역 내부클래스 (Outter$2Inner.class)
            int result = arg + localVariable;
        }
    }
}