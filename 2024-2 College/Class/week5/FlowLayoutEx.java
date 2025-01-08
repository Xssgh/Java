//2021863058 장현호
package week5;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame{

	public FlowLayoutEx() {	
		setTitle("FlowLayout sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		//flowLayout
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300, 300);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new FlowLayoutEx();

	}

}
