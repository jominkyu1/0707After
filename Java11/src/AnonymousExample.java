public class AnonymousExample {
    public static void main(String[] args) {
        Anonymous anony = new Anonymous();
        anony.field.wake();
        anony.method01();

        anony.method02(new Person01(){
            void study(){
                System.out.println("자바 공부를 합니다.");
            }
            @Override
            void wake() {
                System.out.println("9시에 일어납니다.");
                study();
            }
        });
    }
}