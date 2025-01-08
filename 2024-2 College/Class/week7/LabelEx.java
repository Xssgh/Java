//2021863058 장현호
package week7;
import java.awt.*;
import javax.swing.*;

public class LabelEx extends JFrame{
	public LabelEx() {
		setTitle("Label sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("사랑합니다");
		c.add(textLabel);
		
		ImageIcon beaty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beaty);
		c.add(imageLabel);
		
		
		//이미지와 텍스트가 같이 있는

		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		JLabel label = new JLabel("보고 싶으면 전화하세요", normalIcon, SwingConstants.CENTER);
		
		setSize(400, 600);
		setVisible(true);
	}
	public static void main(String[]args) {
		new LabelEx();
	}
}
