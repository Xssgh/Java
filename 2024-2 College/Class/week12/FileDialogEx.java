//2021863058 장현호
package week12;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;

public class FileDialogEx extends JFrame {
	private JLabel imgLabel = new JLabel();

	public FileDialogEx() {
		setTitle("JMenu와 JFileChooser 응용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(imgLabel);

		// 메뉴만들기
		createMenu();
		
		setSize(350, 200);
		setVisible(true);
	}

	private void createMenu() {
		// 메뉴바 만들기
		JMenuBar mb = new JMenuBar();
		// 메뉴 만들기
		JMenu fileMenu = new JMenu("File");
		mb.add(fileMenu);
		// 메뉴아이템 만들기
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		// 메뉴바를 프레임에 붙이기
		setJMenuBar(mb);
		OpenActionListener listener = new OpenActionListener();
		openItem.addActionListener(listener);
	}
	class OpenActionListener implements ActionListener {
		private JFileChooser chooser;

		public OpenActionListener() {
			chooser = new JFileChooser(); // 파일 다이얼로그 생성
		}
		public void actionPerformed(ActionEvent e) {
			// 파일 확장자 필터 사용하기
			FileNameExtensionFilter filter = new FileNameExtensionFilter("image files", "jpg", "png", "jpge", "gif");
			chooser.setFileFilter(filter);
			// 파일 오픈 다이얼로그 띄우기
			int result = chooser.showOpenDialog(null);

			// 취소, 파일 다이얼로그를 강제로 종료한 경우
			if (result == JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
			String path = chooser.getSelectedFile().getPath(); // 파일 경로명 받기
			imgLabel.setIcon(new ImageIcon(path)); // 경로에 받은 이미지 이미지레이블에 받기
			pack();
			; // 이미지 크기에 맞추어 프레임 크기 조절
		}
	}
	public static void main(String[] args) {
		new FileDialogEx();
	}
}
