	//2021863058 장현호
	package week5;
	import java.awt.Container;
	import javax.swing.*;
	

	//public class MyPanel extends JPanel{
	
	public class MyFrame extends JFrame{
	
		public MyFrame(){
			//프레임 구성
		setTitle("스윙 프레임"); // 프레임의 제목 표시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫으면 프로그램 무한 실행이 안되도록 만들어줌
		
		Container c = getContentPane();
		JButton b = new JButton("버튼을 눌러주세요");
		c.add(b); //컨텐트 팬에 버튼 (컴포넌트 붙이기)	
		
		
		setSize(300, 300);
		setVisible(true);
		
		}
		public static void main (String[] args) {
			MyFrame frame = new MyFrame();
			//frame.setContentPane(new MyPanel());
		
			
		}
	
	}
