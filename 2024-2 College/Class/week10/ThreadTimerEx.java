//2021863058 장현호	
package week10;

import java.awt.Container;
import java.lang.Thread;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TimerThreadGUI extends Thread {
	private boolean flag = false;
	public void finish() {
		flag = true;
	}
	private int n = 0;
	private JLabel timerLabel;
	public TimerThreadGUI(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	public void run() {
		while (true) {
			System.out.println(n++);
			timerLabel.setText(Integer.toString(n));
			try {
				sleep(1000);
				if (flag)
					return;
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
public class ThreadTimerEx extends JFrame {
	private Thread th;

	public ThreadTimerEx() {
		setTitle("타이머 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		TimerThreadGUI th = new TimerThreadGUI(timerLabel); // 스레드 생성
		// 버튼 붙이기
		JButton btn = new JButton("kill timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// th.interrupt();
				th.finish();
				btn.setEnabled(false); // 버튼 비활성화
			}
		});
		c.add(btn);
		setSize(300, 170);
		setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}
