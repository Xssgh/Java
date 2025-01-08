//2021863058 장현호
package week10;

import java.awt.Container;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

public class ThreadFinishFlagEx extends JFrame {
	private RandomThread th; // 스레드 레퍼런스

	public ThreadFinishFlagEx() {
		setTitle("Flag를 이용한 스레드 종료");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		setSize(300, 200);
		setVisible(true);
		th = new RandomThread(c);
		th.start();
	}

	public static void main(String[] args) {
		new ThreadFinishFlagEx();
	}
}

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag = false;

	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}

	void finish() {
		flag = true;
	}

	public void run() {
		while (true) {
			int x = ((int) (Math.random() * contentPane.getWidth()));
			int y = ((int) (Math.random() * contentPane.getHeight()));
			JLabel label = new JLabel("Java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();
			try {
				Thread.sleep(300);
				if (flag == true) {
					contentPane.removeAll(); // 컨텐트팬에 있는 모든 레이블 지우기
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.repaint();
					return; // 스레드 종료
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}