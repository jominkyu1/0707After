// 도메인 주소로 IP주소 알아내기


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetWorkTest01 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader;
        String url;
        InetAddress addr=null; //InetAddress 클래스는 IP번호를 처리할 때 사용

        reader = new BufferedReader(new InputStreamReader(System.in));
        //System.in -> 키보드 입력장치와 연결
        //InputStreamReader -> 읽어들인 바이트를 문자로
        //BufferedReader -> 읽어들인 문자를 버퍼(임시 메모리)에 저장

        System.out.print("웹사이트 주소 입력: ");
        url = reader.readLine();

        try{
            addr = InetAddress.getByName(url);
            System.out.println(addr.getHostAddress());
            System.out.println(addr.getHostName());

        }catch(UnknownHostException ue){
            ue.printStackTrace();
        }
    }
}
