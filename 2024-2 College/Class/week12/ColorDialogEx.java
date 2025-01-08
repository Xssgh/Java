//2021863058 장현호
package week12;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;

public class ColorDialogEx extends JFrame {
	private JLabel label = new JLabel("Hello");

	public ColorDialogEx() {
		setTitle("JColorChooser 응용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ravie", Font.ITALIC, 30));
		// 메뉴만들기
		createMenu();
		setSize(350, 200);
		setVisible(true);
	}

	private void createMenu() {
		// 메뉴바 만들기
		JMenuBar mb = new JMenuBar();
		// 메뉴 만들기
		JMenu fileMenu = new JMenu("Text");
		mb.add(fileMenu);
		// 메뉴아이템 만들기
		JMenuItem openItem = new JMenuItem("Color");
		fileMenu.add(openItem);
		// 메뉴바를 프레임에 붙이기
		setJMenuBar(mb);
		OpenActionListener listener = new OpenActionListener();
		openItem.addActionListener(listener);
	}

	class OpenActionListener implements ActionListener {
		private JFileChooser chooser;

		public OpenActionListener() {
		}

		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("Color")) {
				Color selectedColor = JColorChooser.showDialog(null,  "Color", Color.GREEN);
				if(selectedColor != null) {
					label.setForeground(selectedColor);
				}
			}
		}
	}

	public static void main(String[] args) {
		new ColorDialogEx();
	}
}