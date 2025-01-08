//2021863058 장현호
package week9;
import javax.swing.*;
import java.awt.*;

public class GraphicsDrawImageEx1 extends JFrame{
	private MyPanel panel = new MyPanel();
	public GraphicsDrawImageEx1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 420);
		setVisible(true);

	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage(); // 이미지 객체
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//원본 크기로 그리기
		//g.drawImage(img, 20, 20, this);
		//패널에 꽉 차게 그리기
		g.setClip(100, 20, 150, 150);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Gulim", Font.ITALIC, 40));
		g.drawString("반갑습니다 반가워요", 10, 150);

		//일부분만 그리기
		//g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this);
		}
		public static void main(String[] args) {
			new GraphicsDrawImageEx1();
		}
}
}
