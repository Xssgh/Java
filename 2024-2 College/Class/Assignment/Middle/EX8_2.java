//2021863058 장현호 001분반
////0930 과제 (8장 실습 문제 2번) 
package Practice;
import java.io.*;

public class EX8_2 {

	public static void main(String[] args) {
			InputStreamReader in = null;
			FileInputStream fin = null;
			
			try {
				fin = new FileInputStream("c:\\Temp\\phone.txt");
				in = new InputStreamReader(fin, "UTF8");
				int c;
				
				System.out.println("c:\\Temp\\phone.txt를 출력합니다.");
				while ((c = in.read()) != -1) {
					System.out.print((char)c);
				}
				in.close();
				fin.close();
			}catch (IOException e) {
				System.out.println("입출력 오휴");
			}
			



		
	}

}
