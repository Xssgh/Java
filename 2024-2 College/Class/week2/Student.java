//2021863058
//장현호
package week2;

public class Student extends Person{
	Student(){super();}
	Student(String name, String job, int age){
		super(name, job, age);
	}
	public void eat(String s) {
		System.out.println(getName()+"의 오늘 급식은 " +s+"입니다.");
	}
	public void study(String s) {
		System.out.println(getName() + "은(는)" + "를 공부합니다.");
	}

}
