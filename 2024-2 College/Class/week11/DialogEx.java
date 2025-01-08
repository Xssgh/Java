//2021863058 장현호
package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogEx extends JFrame {
	private MyDialog dialog;

	public DialogEx() {
		setTitle("다이얼로그 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog = new MyDialog(this, "Test Dialog");
		JButton btn = new JButton("Show Dialog");
		getContentPane().add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다이얼로그 작동
				dialog.setVisible(true);
				// 모달 다이얼로그가 종료되어야 아래 코드가 실행
				String text = dialog.getInput();
				if (text == null)
					return;
				JButton b = (JButton) e.getSource();
				b.setText(text);
			}
		});
		MyPanel panel = new MyPanel();
		Container c = getContentPane();
		c.add(panel, BorderLayout.NORTH);
		c.add(btn, BorderLayout.CENTER);
		
		setSize(500, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DialogEx();
	}
}
