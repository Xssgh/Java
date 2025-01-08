//2021863058 장현호
package week10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabAndThreadEx extends JFrame {
	private MyLabel bar = new MyLabel(100);
	public TabAndThreadEx() {
		setTitle("아무 키나 빨리 눌러서 바 채우기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		// 바 그리기
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20, 50);
		bar.setSize(300, 20);
		c.add(bar);

		// 컨텐트팬에 키 이벤트 등록

		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 키를 누를 떄마다 바가 1/100씩 증가
				bar.fill();
			}
		});

		setSize(300, 20);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();

		// 스레드 생성하고 시작
		ConsumerThread th = new ConsumerThread(bar);
		th.start();
	}

	public static void main(String[] args) {
		new TabAndThreadEx();
	}
}
class ConsumerThread extends Thread{
	private MyLabel bar;
	public ConsumerThread(MyLabel bar) {
		this.bar=bar;
	}
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume(); //0.2초마다 bar를 1/100씩 줄임
			}catch(InterruptedException e) {
				return;
			}
		}
	}
	
}
class MyLabel extends JLabel {
	private int barSize; // 보라색 바 사이즈
	private int maxBarSize; // 바의 최대 크기(오렌지색)

	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int) (((double) (this.getWidth())) / maxBarSize * barSize);
		if (width == 0)
			return;
		g.fillRect(0, 0, width, this.getHeight()); // 보라색 바 색 채우기
	}

	synchronized public void fill() {
		// barSize를 증가시키기
		if (barSize == maxBarSize) {
			try {
				wait(); // 바가 최대이면 줄어들떄까지 대기한다.
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint(); // 바의 크기가 변경 -> 다시 그리기
		notify(); // 기다리는 스레드 깨우기
	}
	public void consume() {
		// barSize를 줄이기
		if (barSize == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
			barSize--;
			repaint();
			notify();
		}
	}

