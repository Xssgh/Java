//2021863058 장현호
package week4;
import java.io.*;
public class FileOutputStreamEx {

	public static void main(String[] args) {
		byte b[] = {7,21,3,4,-1,24};
		try {
			FileOutputStream fout  = new FileOutputStream ("c:\\Temp\\ttt.out");
			for(int i = 0; i<b.length; i++) {
				fout.write(b[i]);
			}
			fout.close();
		}catch(IOException e) {
			System.out.println("경로명을 확인하세요. 저장 실패");
			return;
		}
			System.out.println("저장 완료");
	}

}
