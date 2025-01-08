//2021863058 장현호
package week5;
import javax.swing.*;
import java.awt.*;

class inputPanel extends JPanel {
public inputPanel(){
setLayout(new FlowLayout(FlowLayout.CENTER));

add(new JLabel("수식입력"));
add(new JTextField(17 ));
setBackground(Color.lightGray);
}
}

class buttonPanel extends JPanel {
public buttonPanel(){
setLayout(new GridLayout(4, 4, 5, 5));
add(new JButton("0"));
add(new JButton("1"));
add(new JButton("2"));
add(new JButton("3"));
add(new JButton("4"));
add(new JButton("5"));
add(new JButton("6"));
add(new JButton("7"));
add(new JButton("8"));
add(new JButton("9"));
add(new JButton("CE"));
add(new JButton("계산"));
JButton line1 = new JButton("+");
JButton line2 = new JButton("-");
JButton line3 = new JButton("x");
JButton line4 = new JButton("/");
line1.setBackground(Color.CYAN);
line2.setBackground(Color.CYAN);
line3.setBackground(Color.CYAN);
line4.setBackground(Color.CYAN);
add(line1);
add(line2);
add(line3);
add(line4);

}
}

class outputPanel extends JPanel {
public outputPanel(){

setLayout(new FlowLayout(FlowLayout.LEFT));
JLabel la = new JLabel("계산 결과");
add(la);
add(new JTextField(15));

setBackground(Color.YELLOW);
}
}

public class Calculator extends JFrame {
public Calculator() {
setTitle("계산기 프레임");

Container c = getContentPane();
c.setLayout(new BorderLayout());

c.add(new inputPanel(), BorderLayout.NORTH);
c.add(new buttonPanel(), BorderLayout.CENTER);
c.add(new outputPanel(), BorderLayout.SOUTH);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setSize(300, 300);
setVisible(true);
}
public static void main(String[] args){
new Calculator();
}
}