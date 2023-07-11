public class Anonymous { //익명클래스 문법
    Person01 field = new Person01(){
        void work() {
            System.out.println("출근합니다.");
        }

        @Override
        void wake() {
            System.out.println("6시에 일어납니다.");
        }
    }; //첫번째 익명클래스 (Anonymous$1.class)

    void method01(){
        Person01 localVar = new Person01(){
            void walk(){
                System.out.println("산책을 합니다.");
            }

            @Override
            void wake() {
                System.out.println("8시에 일어납니다.");
            }
        };//두번째 익명클래스

        localVar.wake();
    }

    void method02(Person01 person){
        person.wake();
    }
}
