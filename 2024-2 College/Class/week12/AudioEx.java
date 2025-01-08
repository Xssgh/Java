//2021863058 장현호
package week12;
import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class AudioEx extends JFrame {
    private  JButton[] btns = {
            new JButton("Play"),
            new JButton("Stop"),
            new JButton("Play again")
    };
    private Clip clip;
    public AudioEx(){
        setTitle("오디오 제어");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        MyAudioListener listener = new MyAudioListener(); // 이벤트리스너 생성
        for (int i =0; i < btns.length; i++){
            c.add(btns[i]); //버튼 생성
        }

        setSize(300,150);
        setVisible(true);

        loadAudio();
        }

        private void loadAudio(){
        try {
            clip = AudioSystem.getClip(); //비어있는 오디오 클립 만들기
            File audioFile = new File("images/korea.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

        }catch (LineUnavailableException e){
            e.printStackTrace();
        }catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //이벤트 리스너 클래스
    class MyAudioListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //눌러진 버튼에 따라 오디오 제어
            String cmd = e.getActionCommand();
            switch (cmd){
                case "Play":
                    clip.start();
                    break;
                case  "Stop":
                    clip.stop();
                    break;
                case "Play again":
                    clip.setFramePosition(0);
                    break;
            }
        }
    }

    public static void main(String[] args){
        new AudioEx();
    }
}
