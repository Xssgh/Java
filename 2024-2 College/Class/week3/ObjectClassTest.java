//2021863058 장현호
package week3;

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "Point("+x+", "+y+")";	
	}
	public boolean equals(Object obj) {
		Point p = (Point) obj;
		if(p.x==x && p.y==y)
			return true;
		return false;
	}
}
public class ObjectClassTest {

	public static void main(String[] args) {
		Point p1 = new Point(10, 15);
		Point p2 = new Point(10, 15);
		System.out.println(p1==p2);
		System.out.println(p1.getClass());
		System.out.println(p1.hashCode());
		System.out.println(p1.toString());
		String str1 = "hi";
		System.out.println("hi".equals(str1));
		
	}

}
