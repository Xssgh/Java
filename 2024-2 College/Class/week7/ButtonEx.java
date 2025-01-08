//2021863058 장현호
package week7;
import java.awt.*;
import javax.swing.*;

public class ButtonEx extends JFrame{
	public ButtonEx() {
		setTitle("Button sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//버튼 이미지 불러오기
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		//이미지 버튼 생성
		JButton btn = new JButton(normalIcon);
		btn.setRolloverIcon(rolloverIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setHorizontalAlignment(SwingConstants.LEFT);
		c.add(btn);
		setVisible(true);
		
		setSize(200, 150);
	}
	public static void main(String[]args) {
		new ButtonEx();
	}
}