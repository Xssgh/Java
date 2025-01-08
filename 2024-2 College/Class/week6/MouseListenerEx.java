package week6;
//2021863058 장현호
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MouseListenerEx extends JFrame{
	private JLabel lb = new JLabel("Hello");
	public MouseListenerEx() {
		setTitle("마우스 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		c.addMouseListener(null);
		c.addMouseListener(null);
		c.setLayout(null);
		
		lb.setSize(50, 20);
		lb.setLocation(30, 20);
		c.add(lb);
		
		setSize(250, 250);
		setVisible(true);
	}
	class MyMouseListener implements MouseListener{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			lb.setLocation(x, y);
		}
		public void mouseClicked(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	public static void main(String[] args) {
		new MouseListenerEx();
	}
}


