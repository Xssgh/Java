package week2;

public class Teacher extends Person implements Teachable, Studyable{
	Teacher(){super();}
	Teacher(String name, int age){
		super(name, "선생님", age);
	}
	Teacher(String name, String job, int age){
		super(name, job, age);
	}
	public void teach(String s) {
	System.out.println(getName() + " 선생님은 " + s + "과목을 가르칩니다.");
}
	public void study(String s) {
	System.out.println(getName() + " 선생님은 " + s + "과목도 공부합니다.");
	}
}
