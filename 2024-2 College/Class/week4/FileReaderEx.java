//2021863058 장현호
package week4;
import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		try {
		//FileReader fin = new FileReader("c:\\windows\\system.ini");
		//FileReader in = new FileReader("c:\\Temp\\hangul.txt");
		FileInputStream fis = new FileInputStream("c:\\Temp\\hangul.txt");
		InputStreamReader in = new InputStreamReader(fis, "UTF8");
		int c;
		System.out.println("인코딩 문자 집합 : "+in.getEncoding());
		while((c=in.read()) != -1) {
			System.out.print((char)c);
			}
		}catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
