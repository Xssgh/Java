package week9;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
	public class MyButtonEx extends JFrame{
		public MyButtonEx() {
			setTitle("새로운 버튼 만들기");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container c = getContentPane();
			c.setLayout(new FlowLayout());
			//버튼 만들기
				MyButton b = new MyButton("새 버튼입니다");
			b.setOpaque(true);
			b.setBackground(Color.RED);
				c.add(b);
				setSize(250,200);
				setVisible(true);
			}
		class MyButton extends JButton {
			MyButton(String s) {
				super(s);
			}
			public void paintComponent(Graphics g) {
			super.paintComponent(g);
				g.setColor(Color.RED);
				g.drawOval(0,0,this.getWidth()-1, this.getHeight()-1);
			}
			}
		public static void main(String [] args) {
				new MyButtonEx();
		}
		}