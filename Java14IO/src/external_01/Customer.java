package external_01;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// 객체 직렬화를 위한 클래스 설계
// 객체 직렬화화 클래스를 설계하기 위해서 java.io의 Externalizable 인터페이스의 추상 메소드를 오버라이딩함
public class Customer implements Externalizable {
    int id;
    String name;
    int age;
    double height;

    public Customer(){}

    public Customer(int id, String name, int age, double height){
        this.id=id;
        this.name=name;
        this.age=age;
        this.height=height;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(new Integer(id)); // 형변환(오토 박싱), 익명클래스, 업캐스팅
        out.writeObject(name); // 업캐스팅
        out.writeObject(new Integer(age));
        out.writeObject(new Double(height));
    } // 객체 단위로 기록

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (Integer)in.readObject(); // 다운캐스팅, 오토 언박싱
        name = (String)in.readObject();
        age = (Integer)in.readObject();
        height = (Double)in.readObject();
    } // 객체 단위로 읽어오기

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", age:" + age + ", height: " + height;
    }
}
