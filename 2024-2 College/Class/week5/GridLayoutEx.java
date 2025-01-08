//2021863058 장현호
package week5;
import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame{
	
	public GridLayoutEx() {
		setTitle("GridLayout sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
				c.setLayout(new GridLayout(4, 3, 0, 5));
				c.add(new JLabel("이름"));
				c.add(new JTextField(""));
				c.add(new JLabel("학번"));
				c.add(new JTextField(""));
				c.add(new JLabel("학과"));
				c.add(new JTextField(""));
				c.add(new JLabel("과목"));
				c.add(new JTextField(""));
				
		
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutEx();

	}

}
