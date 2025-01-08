//자바프로그래밍 응용 001분반 2021863058 장현호
//1, 2, 10번 혼합
package Practice;
import java.util.*;
import java.io.*;
public class FinalEX0930 {

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
		System.out.println("c:\\Temp\\phone.txt에 저장하였습니다.\n");
		}catch (IOException e) {
			System.out.println("c:\\Temp\\phone.txt에 저장하지 못했습니다. 경로를 다시 확인"); //저장 실패시 등장하는 문구
		}
		InputStreamReader in = null;
		FileInputStream fin = null;

			try {
				fin = new FileInputStream("c:\\Temp\\phone.txt"); //phone.txt에서 글을 가져옴
				in = new InputStreamReader(fin, "UTF8");
	
				System.out.println("c:\\Temp\\phone.txt를 출력합니다.");
					while ((c = in.read()) != -1) { //메모장 글 끝까지 읽기
						System.out.print((char)c);
					}
			in.close();
			fin.close();
			} catch (IOException e) {
				System.out.println("입출력 오휴");
			}
		
	
	    HashMap<String,String> map = new HashMap<>();
	
	    try {
	        BufferedReader bf = new BufferedReader(new FileReader("c:\\Temp\\phone.txt")); //phone.txt의 바이트 개수 세기
	        String str;
	        String [] s = new String[100]; // 스트링 최대 크기으로 설정 
	
	        while((str=bf.readLine())!=null){
	            StringTokenizer stringTokenizer = new StringTokenizer(str," ");
	            int index=0;
	            while(stringTokenizer.hasMoreTokens()){
	                s[index]=stringTokenizer.nextToken();
	                index++;
	            }
	            map.put(s[0],s[1]);
	        }
	
	
	        System.out.println("총 "+map.size()+"개의 전화번호를 읽었습니다."); //전화번호 갯수 확인
	        while(true){
	            System.out.print("이름>> ");
	            String name = scanner.next();
	            if(name.equals("그만"))//"그만 입력시 입력 종료"
	                break;
	
	            if(map.containsKey(name)){//키 이름 설정
	                System.out.println(map.get(name));
	            }
	            else
	                System.out.println("찾는 이름이 없습니다.");//이름이 없는 경우 출력
	        }
	    }
	    catch(IOException e){
	        System.out.println("입출력 오류");
	    }
	    scanner.close();
	}
	}
