//2021863058 장현호
package week8;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class PaintEx extends JFrame{
	public PaintEx() {
		setTitle("그림 그리기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setContentPane(new MyPanel());
		setSize(800, 800);
		setVisible(true);

	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			//원 그리기
			g.drawOval(20, 20, 80, 100);
			g.drawOval(150, 20, 100, 80);
			g.drawOval(300, 20, 100, 100);
			g.setColor(Color.PINK);
			//네모네모
			g.drawRect(20, 150, 80, 100);
			g.drawRect(150, 150, 100, 80);
			g.drawRect(300, 150, 100, 100);
			g.setColor(Color.BLUE);
			//모서리가 둥근 도형 그리기
			g.drawRoundRect(20,  300,  120,  80,  40,  60);
			g.drawRoundRect(150,  300,  120,  80,  40,  40);
			
			g.setColor(Color.MAGENTA);
			//호 그리기
			g.drawArc(300,  300,  100,  100,  90,  180);
			g.drawArc(450,  300,  100,  100,  90,  -270);
			
			g.setColor(Color.BLACK);
			//다각형 그리기
			int[] x = {480, 440, 480, 520};
			int[] y = {40, 120, 200, 120};
			g.fillPolygon(x, y, 4);//색 채워넣기(외곽선과 내부 전부 칠함.
			g.setColor(Color.CYAN);//색 정하기
			g.drawPolygon(x, y, 4);//그냥 그리기
			//g.drawString("자바는 재미가 있다.", 30, 30);
			//g.setColor(Color.RED);
			//g.drawString("얼마나 하늘만큼 땅만큼", 60, 60);
			//g.setColor(Color.BLUE);
			//Font f = new Font("Arial", Font.ITALIC, 30);
			//g.setFont(f);
			//g.drawString("How much", 100, 100);
		
		}
	}
	public static void main (String[] args) {
		new PaintEx();
	}
}
