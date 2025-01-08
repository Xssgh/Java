//2021863058 장현호
package week3;
import java.util.*;
public class CollectionsEx {
	static void printList(LinkedList<String> l) {
		Iterator<String> it = l.iterator();
		while(it.hasNext()) {
			String e = it.next();
			String s;
			if(it.hasNext())
				s = "->";
			else
				s = "\n";
			System.out.print(e+s);
		}
		//for(String e:l) {
			//System.out.print(e+"/");
		}
	//}
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("해리포터");
		myList.add(0, "아바타");
		myList.add(2, "터미네이터");
		
		System.out.println(myList);
		
		Collections.sort(myList);
		printList(myList);
		
		Collections.reverse(myList);
		printList(myList);
		
		int index = Collections.binarySearch(myList,"아바타");
		System.out.println("아바타는" + index+"번째 요소입니다.");
	}
}
