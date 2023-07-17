package external_01;
//객체 직렬화 클래스 Customer.java를 활용하여 객체 단위로 기록하기위한 예제

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class IoTest10 {
    public static void main(String[] args) throws Exception {
        Customer cus = new Customer(10, "홍길동", 23, 173.0);

        System.out.println(cus.toString());

        FileOutputStream fos = new FileOutputStream("./src/external_01/result10.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cus);

        oos.close(); fos.close();
    }
}
