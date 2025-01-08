package week6;
//2021863058 장현호
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class MyListenerEx  extends JFrame{
	public MyListenerEx() {
		setTitle("Actionlistener sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		c.add(btn);
		
		setSize(350, 200);
		setVisible(true);
		
		}
	public static void main(String[] args) {
		new MyListenerEx();
	}

}
