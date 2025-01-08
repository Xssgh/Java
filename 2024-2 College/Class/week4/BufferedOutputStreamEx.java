//2021863058 장현호
package week4;
import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class BufferedOutputStreamEx {

	public static void main(String[] args) {
		//20바이트의 버퍼를 가지고 표준 출력 스트림에 연결하여 화면 출력
		try {
		//BufferedOutputStream bout = new BufferedOutputStream(System.out, 20);
		//FileReader fin = new FileReader("c:\\windows\\system.ini");
		
		BufferedOutputStream bout = new BufferedOutputStream(System.out, 5);
		FileReader fin = new FileReader("c:\\Temp\\test.txt");	
			
		int c;
		while((c=fin.read()) != -1) {
			bout.write((char)c);
		}
		//new Scanner(System.in).nextLine();
		fin.close();
		bout.close();
		}catch(IOException e) {
			System.out.println("입출력 오휴");
		}
	}

}
