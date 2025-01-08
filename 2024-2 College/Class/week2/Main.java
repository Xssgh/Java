//2021863058
//장현호
package week2;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person(); //사람이라고 하는 타입 생성
		//p1.name = "김계동"; //이름 생성, .추가로 미리 만들어둔 메소드를 호출 가능
		//p1.job = "수의사"; //직업
		//p1.age = 100;
		
		System.out.println("내 이름은 "+p1.getName() +" 직업은 "+ p1.getJob()+"이야");
		System.out.println("나이는 "+p1.getAge()+"살이야");
		p1.sleep(null);
		p1.eat("삼겹살");
		
		Student s1 = new Student("홍길동", "고등학생", 17);
		s1.sleep(null);
		if(s1 instanceof Student) ((Student)s1).study("국어");
		s1.eat("흔들도시락");
		
		Teacher t1 = new Teacher("나천채", 40);
		t1.teach("수학");
		t1.sleep(null);
		t1.study("영어");
	}

}
