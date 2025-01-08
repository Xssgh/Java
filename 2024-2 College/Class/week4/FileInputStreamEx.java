//2021863058 장현호
package week4;
import java.io.*;
public class FileInputStreamEx {

	public static void main(String[] args) {
		byte b[] = new byte[6];
		try {
			FileInputStream fin = new FileInputStream("c:\\Temp\\ttt.out");
			int n = 0, c;
			while((c=fin.read()) != -1) {
				b[n] = (byte)c;
				n++;
			}
			System.out.println("c:\\Temp\\ttt.out에서 읽은 배열 출력");
			for(int i=0; i<b.length; i++)
				System.out.print(b[i]+" ");
		}catch(IOException e) {
			System.out.println("경로명을 확인하세요. 저장 실패");
			return;
		}
			System.out.println("저장 완료");
	}

}