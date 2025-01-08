//2021863058
//장현호
package week2;

public class PersonTest {

	public static void main(String[] args) {
		Person me = new Person("Kongzzi", "햄스터 집사", 20);
		//me.name = "Kongzi";
		//me.age = 20;
		//me.job = "햄스터 집사";
		System.out.println("내 이름은" + me.getName() + "이고," + me.getAge() + "살이야.\n직업은" + me.getJob() + "이지");

	}

}
