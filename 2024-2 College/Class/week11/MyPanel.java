//2021863058 장현호
package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel {
	private JButton inputBtn = new JButton("Input Name");
	private JButton confirmBtn = new JButton("Confirm");
	private JButton messageBtn = new JButton("Message");
	private JTextField tf = new JTextField(10);

	public MyPanel() {
		setBackground(Color.LIGHT_GRAY);
		add(inputBtn);
		add(messageBtn);
		add(confirmBtn);
		add(tf);
		messageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(null, "조심하세요", "Message", JOptionPane.WARNING_MESSAGE);
			}
		});
		inputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("이름을 입력");
				if (name != null)
					tf.setText(name);
			}
		});
		confirmBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null,  "계속하기", "confirm", JOptionPane.YES_OPTION);
			if (result == JOptionPane.YES_OPTION)
				tf.setText("Yes");
			else
				tf.setText("No");
			}
	});
}
}
