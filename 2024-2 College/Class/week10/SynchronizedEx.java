//2021863058 장현호
package week10;

public class SynchronizedEx {
	public static void main(String[] args) {
		Board board = new Board(); // 공유 집계판 생성

		// 학생 스레드들을 생성해서 집계판에 동시에 접근
		Thread th1 = new StudentThread(board);
		Thread th2 = new StudentThread(board);

		th1.start();
		th1.start();
	}
}

class Board {
	private int sum = 0;

	synchronized public void add() {
		int n = sum;
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + ":" + sum);
	}

	public int getSum() {
		return sum;
	}
}

class StudentThread extends Thread {
	private Board board;

	public StudentThread(Board board) {
		this.board = board;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			board.add();

		}
	}
}
