//2021863058 장현호
package week10;

import java.awt.*;

import javax.swing.*;

public class TimeOutEx extends JFrame {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    
    private JLabel timeLabel;
    private TimerThread timerThread;

    public TimeOutEx() {
        setTitle("간단한 시계");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Gothic", Font.ITALIC, 60));
        c.add(timeLabel);


        timerThread = new TimerThread();
        timerThread.start();

        setSize(400, 200);
        setVisible(true);
    }

    private class TimerThread extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    seconds++;
                    if (seconds == 60) {
                        seconds = 0;
                        minutes++;
                    }
                    if (minutes == 60) {
                        minutes = 0;
                        hours++;
                    }
                    if (hours == 24) {
                        hours = 0;
                    }
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
                        }
                    });

                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new TimeOutEx();
    }
}
