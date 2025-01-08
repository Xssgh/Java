//2021863058 장현호
package week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuEx extends JFrame {
	private JLabel imgLabel = new JLabel();

	public MenuEx() {
		setTitle("메뉴 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMenu(); // 밑에 메뉴 만들기 호출
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);//툴팁 설명이 나타나는 시간 제어
		m.setDismissDelay(5000); //툴팁 설명이 사라지는 시간 제어 (5sec)
		
		
		JToolBar toolBar = new JToolBar("ToolBar");
		JButton btn = new JButton("New");
		btn.setToolTipText("파일을 생성합니다.");
		toolBar.add(btn);
		toolBar.add(new JButton(new ImageIcon("images/open.jpg")));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("images/save.jpg")));
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField(8));

		JComboBox<String> combo = new JComboBox<>();
		combo.addItem("Java");
		combo.addItem("c#");
		combo.addItem("c");
		combo.addItem("Python");
		combo.addItem("Mango");
		toolBar.add(combo);

		Container c = getContentPane();
		c.add(toolBar, BorderLayout.NORTH);
		c.add(imgLabel, BorderLayout.CENTER);
		getContentPane().add(imgLabel, BorderLayout.CENTER);// 이미지
		setSize(500, 500);
		setVisible(true);

	}

	public void createMenu() {
		// 메뉴 만들기
		// 1. 메뉴바 만들기
		JMenuBar mb = new JMenuBar();
		// 2. 메뉴 만들기 -> 메뉴바에 붙임
		JMenu screenMenu = new JMenu("Screen");
		mb.add(screenMenu);
		mb.add(new JMenu("Edit")); // 추가로 메뉴 만들기
		mb.add(new JMenu("Edit2"));
		mb.add(new JMenu("Edit3"));
		// 3. 메뉴 아이템 만들기 -> 메뉴에 붙임
		// 반복문 사용
		JMenuItem[] items = new JMenuItem[4];
		String[] titles = { "Load", "Hide", "ReShow", "Exit" };

		MenuActionListener listener = new MenuActionListener();
		for (int i = 0; i < titles.length; i++) {
			items[i] = new JMenuItem(titles[i]);
			items[i].addActionListener(listener);
			screenMenu.add(items[i]);
			if (i == 2) {// 특정 구역에만 줄 만들기
				screenMenu.addSeparator();
			}

		}

		// 반복문을 사용하지 않은 메뉴 요소
		// JMenuItem load = new JMenuItem("Load");
		// screenMenu.add(load);
		// screenMenu.add(new JMenuItem("no add"));
		// 4. 메뉴바를 프레임에 붙이기
		setJMenuBar(mb);

	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "Load":
				if (imgLabel.getIcon() != null)
					return;
				imgLabel.setIcon(new ImageIcon("images/bird.JFIF"));
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "ReShow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;

			}
		}
	}

	public static void main(String[] args) {

		new MenuEx();
	}

}
