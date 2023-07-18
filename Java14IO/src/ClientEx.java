// 스레드가 적용 안된 사용자 네트워크 프로그램
// 강사PC 192.168.41.71

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientEx {
    Socket client = null;
    String ipAddress;
    static final int PORT = 5000;
    BufferedReader read;
    InputStream is;
    ObjectInputStream ois;
    OutputStream os;
    ObjectOutputStream oos;

    String sendData; // 보낼 문자열
    String receiveData; // 받은 문자열

    public ClientEx(String ipAddress) {
        this.ipAddress=ipAddress;

        try {
            System.out.println("*****사용자 채팅 프로그램*****");

            client = new Socket(ipAddress, PORT); //서버에서도 소켓이 생성됨
            read = new BufferedReader(new InputStreamReader(System.in));

            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());

            System.out.print("메세지 입력>>");

            while((sendData = read.readLine()) != null){
                oos.writeObject(sendData);
                oos.flush();

                if(sendData.equals("quit")) break;

                receiveData = (String)ois.readObject();
                System.out.println(client.getInetAddress() + "의 메세지: " + receiveData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }finally {
            try{
                if(is!=null)is.close();
                if(ois!=null)ois.close();
                if(os!=null)os.close();
                if(oos!=null)oos.close();
                if (client != null) client.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ClientEx("192.168.0.181");
    }
}