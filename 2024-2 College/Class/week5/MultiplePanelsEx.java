//2021863058 장현호
package week5;
import javax.swing.*;
import java.awt.*;


	class NorthPanel extends JPanel{
		public NorthPanel() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			setBackground(Color.LIGHT_GRAY);
			add(new JButton("open"));
			add(new JButton("read"));
			add(new JButton("close"));
		}
		
	}
	
	class CenterPanel extends JPanel{
		public CenterPanel() {
			setLayout(null);
			JLabel[] lb = {new JLabel("Hello"), new JLabel("Love"), new JLabel("Java")};
			for(int i=0; i<lb.length; i++) {
				int x = (int)(Math.random()*200);
				int y = (int)(Math.random()*200);
				lb[i].setLocation(x, y);
				lb[i].setSize(100, 20);
				add(lb[i]);
			}
		}
	}
	public class MultiplePanelsEx extends JFrame{
	
		public MultiplePanelsEx() {	
			setTitle("Multiple Panels and ..");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			c.add(new NorthPanel(), BorderLayout.NORTH);
			c.add(new CenterPanel(), BorderLayout.CENTER);
			
			setSize(300, 300);
			setVisible(true);
		
		}
		public static void main(String[] args) {
			new MultiplePanelsEx();
	
		}
	
	}
