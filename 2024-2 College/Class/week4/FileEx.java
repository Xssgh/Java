//2021863058 장현호
package week4;
import java.io.*;
public class FileEx {

	public static void main(String[] args) {
		File f1 = new File("C:\\windows\\system.ini");
		System.out.println(f1.getName());
		System.out.println(f1.getParent()); //부모 확인
		System.out.println(f1.getPath()); //전체 확인
		if(f1.isFile()) System.out.println("파일입니다.");
		else if(f1.isDirectory()) System.out.println("디렉토리입니다.");
		listDirectory(new File("c:\\Temp"));
		
		File f2 = new File("c:\\Temp\\java");
		if(!f2.exists())
			f2.mkdir();
		
		listDirectory(new File("c:\\Temp"));
		
		f2.renameTo(new File("c:\\Temp\\hong"));
		
		listDirectory(new File("c:\\Temp"));
	}
	public static void listDirectory(File dir) {
		System.out.println("-----------"+dir.getPath()+"의 서브 리스트-------");
		File[] subFiles = dir.listFiles();
		for(int i=0; i<subFiles.length; i++) {
			File f = subFiles[i];
			long t = subFiles[i].lastModified();
			System.out.println(f.getName());
			System.out.println("\t파일 크기"+f.length());
			System.out.printf("\t수정한 시간 %tb %td %ta %tT\n", t, t, t, t);
		}
	}
}
