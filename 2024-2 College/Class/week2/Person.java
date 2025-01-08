//2021863058
//장현호
package week2;
public class Person {

	private String name;
	private String job;
	private int age;

	
	Person(){
		//this("이름없음", "직업 없음", 10); 무조건 제일 위에 있어야함, 아래와 같은 의미
		this.name = "김계동"; // 필드가 메개체를 구분하기 위해 this.붙이기
		this.job = "무직";
		this.age = 10;
	}
	
	public void setAge(int age) {
		if(age>=0)
			this.age = age;
		else 
			System.out.println("나이를 올바르게 입력하세요");
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getJob() {
		return job;
	}
	Person(String name, String job, int age){//기본 생성사
		this.name = name; // 필드가 메개체를 구분하기 위해 this.붙이기
		this.job = job;
		this.age = age;
	}
	
	public void say(String s) {
		System.out.println("\"" + s + "\"");
	}
	public void eat(String s) {
		System.out.println(getName() +"이(가)" + s+ "를 먹습니다.");
	}
	public void sleep(String s) {
		System.out.println(name + "이 잠을 쿨쿨 자고 있습니다.");
	}

}
