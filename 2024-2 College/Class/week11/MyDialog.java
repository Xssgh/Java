//2021863058 장현호
package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyDialog extends JDialog {
	private JTextField tf = new JTextField(10);
	private JButton okbtn = new JButton("OK");

	public String getInput() {
		if (tf.getText().length() == 0)
			return null;
		else
			return tf.getText();
	}

	public MyDialog(JFrame f, String title) {
		super(f, title, true);
		setLayout(new FlowLayout());
		add(tf);
		add(okbtn);
		setSize(200, 100);
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
