//2021863058 장현호
package week12;
import javax.swing.*;
import java.awt.*;

public class TabbedPaneEx extends JFrame{
	public TabbedPaneEx() {
		
		setTitle("탭팬 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTabbedPane pane = createTabbedPane();

		c.add(pane, BorderLayout.CENTER);
		setSize(250, 250);
		setVisible(true);
	}
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg")));
		pane.addTab("tab2", new JLabel(new ImageIcon("images/img2.jpg")));
		pane.addTab("tab3", new MyPanel2());
		return pane;
	}
	class MyPanel2 extends JPanel{
		public MyPanel2() {
			this.setBackground(Color.YELLOW);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10,  10,  50,  50);
			
		}
	}
	
	public static void main(String[] args) {
		new TabbedPaneEx();
	}

}
