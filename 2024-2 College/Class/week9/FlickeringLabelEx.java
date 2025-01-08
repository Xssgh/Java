package week9;
import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.lang.Thread;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FlickeringLabelEx extends JFrame{
	public FlickeringLabelEx() {
	setTitle("깜빡이는 레이블 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = getContentPane();
	c.setLayout(new FlowLayout());
	
	FlickeringLabel fLabel = new FlickeringLabel("깜빡", 500);
	
	JLabel label = new JLabel("안깜빡");
	
	FlickeringLabel fLabel2 = new FlickeringLabel("여기도 깜빡", 300);
	c.add(fLabel);
	c.add(label);
	c.add(fLabel2);
	
	setSize(300, 150);
	setVisible(true);
	}
	
	public static void main(String []args) {
		new FlickeringLabelEx();
	}
}
