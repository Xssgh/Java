//2021863058 장현호
package week7;
import java.awt.*;

import javax.swing.*;

public class CheckBoxEx extends JFrame{
	public CheckBoxEx() {
		setTitle("CHeckBox sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//이미지 불러오기
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectesCherryIcon = new ImageIcon("images/selectedCherry.jpg");

		//체크박스 만들기
		JCheckBox apple = new JCheckBox("사과");
		c.add(apple);
		JCheckBox pear = new JCheckBox("배");
		c.add(pear);
		//체크박스 만들기 -완-
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		//이미지 체크박스 만들기
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);
		cherry.setSelectedIcon(selectedCherryIcon);
		c.add(cherry);
		cherry.setBorderPainted(true);
		
		
		setSize(200, 150);
		setVisible(true);
	}
	public static void main(String[]args) {
		new CheckBoxEx();
	}
}
