package week6;
//2021863058 장현호
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class sumListner  extends JFrame{
	public sumListner() {
		setTitle("Actionlistener sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		c.add(btn);
	}
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
		

		
		setSize(350, 200);
		setVisible(true);
		
		}
	public static void main(String[] args) {
		new MyListenerEx();
	}

}

