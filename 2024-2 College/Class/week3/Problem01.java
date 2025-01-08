//2021863058 장현호
package week3;
import java.util.*;

public class Problem01 {
	static String[] morse = {".-", "-...", "-.-", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

	public static void main(String[] args) {
		String letter = ".... . .-.. .-.. ---";
		System.out.println(letter + "->"+ morse(letter));
	}
	static String morse(String letter) {
		String msg="";
		//letter를 공백을 사용하여 나누기 : split("") 사용
		String[] words = letter.split(" ");
		//System.out.println(Arrays.toString(words));
		
		//모스부호 맵 만들기
		HashMap<String, Character> morse_map = new HashMap<>();
		char start = 'a';
		for(String m:morse) {
			morse_map.put(m, start++);
			//System.out.println(morse_map);
		}
		
		//해석하기
		for(String w:words) {
			msg += morse_map.get(w);
		}
		
		
		
		return msg;
	}

}
