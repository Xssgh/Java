package Graphic;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MouseAvoidGame extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public MouseAvoidGame() {
		setTitle("마우스 피하기 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(panel);
		
		setVisible(true);
		setSize(1366, 768); // 모니터 사이즈
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyPanel extends JPanel implements MouseMotionListener {
		//버튼, 라벨
		private JLabel [] obstacleLabel = new JLabel [14];
		private JLabel goalLabel = new JLabel("");
		private JButton startButton = new JButton("게임시작");
		private ArrayList<Point> points;
		
		//리스너, 어댑터
		private avoidObstacles AO = new avoidObstacles();
		private startButtonListener SBL = new startButtonListener();
		private GoalIn1 GI1 = new GoalIn1();
		
		public MyPanel() {
			setLayout(null);
			
			//창이 열림과 동시에 마우스 위치 게임시작 버튼 위로 초기화
			try {
				Robot robot = new Robot();  
				robot.mouseMove(1245, 665); 
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			
			//마우스 궤적 그리기용 제네릭 컬렉션 객체
			points = new ArrayList<>();
			addMouseMotionListener(this);
			
			//시작 버튼
			startButton.setOpaque(true);
			startButton.setBackground(Color.YELLOW);
			startButton.setForeground(Color.BLACK); 
			startButton.setFont(new Font("바탕체", Font.BOLD, 20));
			startButton.setLocation(1170, 620);
			startButton.setSize(150, 50);
			startButton.addActionListener(SBL);
			startButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					obstacleLabel[13].setVisible(false);
				}
			});
			add(startButton);
			
			//장애물
			for(int i=0; i<obstacleLabel.length; i++) {
				obstacleLabel[i] = new JLabel("");
				obstacleLabel[i].setOpaque(true);
				obstacleLabel[i].setBackground(Color.BLACK);
			}
	
			obstacleLabel[0].setLocation(0, 0); //블럭1
			obstacleLabel[0].setSize(200, 150);
			
			obstacleLabel[1].setLocation(250, 0); //블럭2
			obstacleLabel[1].setSize(1366, 150);
			
			obstacleLabel[2].setLocation(0, 150); //블럭3
			obstacleLabel[2].setSize(200, 50);
			
			obstacleLabel[3].setLocation(0, 200); //블럭4
			obstacleLabel[3].setSize(1300, 50);

			obstacleLabel[4].setLocation(1250, 250); //블럭5(세로기둥1)
			obstacleLabel[4].setSize(50, 250);

			obstacleLabel[5].setLocation(1150, 300); //블럭6(세로기둥2)
			obstacleLabel[5].setSize(50, 250);

			obstacleLabel[6].setLocation(1050, 250); //블럭7(세로기둥3)
			obstacleLabel[6].setSize(50, 250);
			
			obstacleLabel[7].setLocation(950, 300); //블럭(세로기둥4)
			obstacleLabel[7].setSize(50, 250);
			
			obstacleLabel[8].setLocation(850, 250); //블럭9(세로기둥5)
			obstacleLabel[8].setSize(50, 250);
			
			obstacleLabel[9].setLocation(150, 450); //블럭10(가로기둥1)
			obstacleLabel[9].setSize(700, 50);
			
			obstacleLabel[10].setLocation(50, 300); //블럭11(가로기둥2)
			obstacleLabel[10].setSize(750, 50);
			
			obstacleLabel[11].setLocation(50, 350); //블럭12(세로기둥6)
			obstacleLabel[11].setSize(50, 200); 
			
			obstacleLabel[12].setLocation(50, 550); //게임시작 바로 위 긴 가로블럭
			obstacleLabel[12].setSize(1366, 40);
			
			obstacleLabel[13].setBackground(Color.RED);
			obstacleLabel[13].setLocation(1100, 596); //입구를 막고 있는 블럭
			obstacleLabel[13].setSize(5, 123);
			
			for(int i=0; i<obstacleLabel.length; i++) {
				obstacleLabel[i].addMouseListener(AO);
				add(obstacleLabel[i]);
			}
		
			//도착지점 세팅
			goalLabel.setOpaque(true);
			goalLabel.setBackground(Color.GREEN);
			goalLabel.setLocation(215, 50);
			goalLabel.setSize(20, 20);
			goalLabel.addMouseListener(GI1);
			add(goalLabel);			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//설계도
			g.setColor(Color.BLACK);
			
			g.drawRect(0, 0, 200, 150); // 1
			g.drawRect(250, 0, 1366, 150); // 2
			g.drawRect(0, 150, 200, 50); // 3
			g.drawRect(0, 200, 1300, 50); // 4
			g.drawRect(1250, 250, 50, 250); //5, 세로기둥1
			g.drawRect(1150, 300, 50, 250); //6, 세로기둥2
			g.drawRect(1050, 250, 50, 250); //7, 세로기둥3
			g.drawRect(950, 300, 50, 250); //8, 세로기둥4
			g.drawRect(850, 250, 50, 250); //9, 세로기둥5
			g.drawRect(150, 450, 700, 50); //10, 가로기둥1
			g.drawRect(50, 300, 750, 50); //11, 가로기둥2
			g.drawRect(50, 350, 50, 200); //12, 세로기둥 6
			g.drawRect(50, 550, 1366, 40); //13, 게임시작 바로 위 긴가로기둥1
			//g.drawRect(1100, 596, 5, 123); //입구막기용 블럭
			
			drawPath(g); //마우스 궤적을 그리는 메소드
		}
		
		private void drawPath(Graphics g) {
			if (points.size() < 2) {
				return;
			}
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.YELLOW);
			g2d.setStroke(new BasicStroke(5)); //선 굵기 설정
			
			for (int i=1; i<points.size(); i++) {
				Point p1 = points.get(i-1);
				Point p2 = points.get(i);
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
			}
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			points.add(e.getPoint());
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class startButtonListener implements ActionListener { //버튼을 누르면 마우스 위치를 시작지점으로 옮겨주는 마우스 리스너
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			b.setVisible(false);
			try {
				Robot robot = new Robot(); //마우스 이동을 위한 모듈로 java.awt.Robot 사용 
				robot.mouseMove(1245, 665); //마우스 위치를 자동으로 옮기는 객체
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class avoidObstacles extends MouseAdapter { //장애물에 닿으면 게임오버창을 출력하는 마우스 리스너
		public void mouseEntered(MouseEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "Retry?", "Game Over!!",
					JOptionPane.YES_NO_OPTION);
			
			if(result == JOptionPane.CLOSED_OPTION) {
				System.exit(0);
			} 
			else if(result == JOptionPane.YES_OPTION) {
				try {
					Robot robot = new Robot();
					robot.mouseMove(1245, 665); //마우스 위치를 시작위치로 초기화
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			} 
			else {
				System.exit(0);
			}
		}
	}
		
	class GoalIn1 extends MouseAdapter { //골인 지점에 도착하면 클리어창을 출력하는 마우스 리스너
		public void mouseEntered(MouseEvent e) {
			JOptionPane.showMessageDialog(null, "Congratulations!!", "CLEAR!!!", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new MouseAvoidGame();
	}
}