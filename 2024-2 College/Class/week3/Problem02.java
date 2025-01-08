//2021863058 장현호
package week3;
import java.util.*;
public class Problem02 {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		System.out.println(set);
		
	}

}
