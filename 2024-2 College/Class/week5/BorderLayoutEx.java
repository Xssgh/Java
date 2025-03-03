//2021863058 장현호
package week5;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame{

	public BorderLayoutEx() {	
		setTitle("BorderLayout sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		//BorderLayout
		c.setLayout(new BorderLayout(30, 20));
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		
		setSize(300, 200);
		setVisible(true);
		c.add(c);
	}
	
	
	
	public static void main(String[] args) {
		new BorderLayoutEx();

	}

}
