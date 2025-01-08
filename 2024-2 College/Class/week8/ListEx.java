//2021863058 장현호
package week8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ListEx extends JFrame{
	private JTextField tf = new JTextField(10); 
	private Vector<String> v = new Vector<>();//이름 저장 벡터 1개 사용 위치
	private JList<String> nameList = new JList<>(v);//이름 리스트 0개 사용 위치
	//private String[] fruits = {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	//private ImageIcon[] images = {
			//new ImageIcon("images/icon1.png"),
			//new ImageIcon("images/icon2.png"),
			//new ImageIcon("images/icon3.png"),
			//new ImageIcon("images/icon4.png")
			//};
	public ListEx() {
		setTitle("리스트 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 입력 후 <ENTER> :"));
		c.add(tf);
		c.add(nameList);
		v.add("뽀로로");
		v.add("루피");
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100); //가로 길이 정하기
		c.add(nameList);
		c.add(new JScrollPane(nameList));
		
		
		//문자열 리스트
		//JList<String> strList = new JList<>(fruits);
		//c.add(new JScrollPane(strList));
		
		//JList<ImageIcon> imageList = new JList<>(images);
		//c.add(imageList);

		//c.add(strList);
		//이미지 리스트
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JTextField t = (JTextField)e.getSource();
			v.add(t.getText());
			t.setText("");
			nameList.setListData(v);
			}
			});

		setSize(300, 300);
		setVisible(true);
	}
	public static void main (String[] args) {
		new ListEx();
	}
}
