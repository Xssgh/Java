//2021863058 장현호
package week8;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;


public class SliderChangeEx extends JFrame{
	private JLabel colorLabel;
	private JSlider[] sl = new JSlider[3];
	public SliderChangeEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		//슬라이더 만들기
		for(int i=0; i<sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			c.add(sl[i]);
			sl[i].setPaintTicks(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(50);
			sl[i].setPaintLabels(true);
		}
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.BLUE);
		sl[2].setForeground(Color.GREEN);
		
		int r = sl[0].getValue();
		int g = sl[0].getValue();
		int b = sl[0].getValue();
		
		colorLabel = new JLabel("SLIDER EXAMPLE");
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(r, g, b));
		c.add(colorLabel);
		setSize(300, 300);
		setVisible(true);
	}
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		colorLabel.setBackground(new Color(r,g,b));
		}
		}

	public static void main (String[] args) {
		new SliderChangeEx();
	}
}
