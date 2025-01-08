//2021863058 장현호
//블록 단위로 바이너리 파일 고속 복사i
package week4;
import java.io.*;

public class BlockBinaryCopyEx {

	public static void main(String[] args) {
	File src = new File("c:\\Temp\\ele.jpg"); //원본
	File dest = new File("c:\\Temp\\copyele.jpg"); //복사
	try {
		FileInputStream fi = new FileInputStream(src);//파일 입력 바이트 스트림 생성
		FileOutputStream fo = new FileOutputStream(dest);//파일 출력 바이트 스트림 생성
		byte [] buf = new byte[1024*10];		//10KB버퍼
		while(true) {
			int n = fi.read(buf); //버퍼 크기만큼 읽기. n : 실제 읽은 바이트
			fo.write(buf, 0, n); //buf[0]부터 n바이트 쓰기
			if(n<buf.length)
				break;		//버퍼 크기보다 작게 읽음. 파일 끝이라서 복사 종료.
		}
		fi.close();
		fo.close();
	} catch (IOException e) {
		System.out.println("파일 복사 오류");
	}

	}

}
