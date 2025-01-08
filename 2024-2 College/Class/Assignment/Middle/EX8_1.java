//2021863058 장현호 001분반
//0930 과제 (8장 실습 문제 1번) 
package Practice;
import java.util.*;
import java.io.*;
public class EX8_1 {

	public static void main(String[] args) {
		System.out.println("전화번호 입력 프로그램입니다.");
		Scanner scanner = new Scanner(System.in);
		
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\Temp\\phone.txt"); //phone.txt에 이름과 전화번호를 작성
			while(true) {
				System.out.println("이름 전화번호 >> "); //이름과 전화번호 작성 안내창
				String line = scanner.nextLine(); //빈 칸도 포함해서 읽기
				if (line.equalsIgnoreCase("그만")) //"그만"을 입력하면 종료
					break;
				fout.write(line, 0, line.length()); // 문자열을 파일에 저장
				fout.write("\r\n", 0, 2); // 한 줄 띄우기 위해 \n \r 저장
			}
			fout.close();
		System.out.println("c:\\Temp\\phone.txt에 저장하였습니다.");
		}catch (IOException e) {
			System.out.println("c:\\Temp\\phone.txt에 저장하지 못했습니다. 경로를 다시 확인"); //저장 실패시 등장하는 문구
		}
		scanner.close();
	}
}
