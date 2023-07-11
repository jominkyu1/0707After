public class Button01 {
    interface OnClickListener{
        void onClick(); // public abstract 생략됨
    } // 중첩 인터페이스

    OnClickListener listener;

    void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    void touch(){
        listener.onClick();
    }
}
