//2021863058 장현호
package defaultFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class MyDialog extends JDialog {
    private JTextField name = new JTextField(10);
    private JTextField phone = new JTextField(10);
    private JTextField email = new JTextField(10);
    private JButton Okbtn = new JButton("추가");
    private JButton photoButton = new JButton("사진 선택");
    private JTextArea ta;  // 연락처 목록을 표시할 JTextArea
    private JLabel photoLabel = new JLabel();  // 사진을 표시할 레이블
    private String photoPath = "";  // 사진 파일 경로를 저장하는 변수
    private JPanel photozone;  // 사진을 출력하는 중앙 패널 (연락처 리스트와 연동)

    public MyDialog(JFrame frame, String title, JTextArea ta, JPanel photozone) {
        super(frame, title, true);
        this.ta = ta;
        this.photozone = photozone;

        // 다이얼로그 배경 및 텍스트 필드 색상 설정
        getContentPane().setBackground(new Color(255, 230, 230));
        name.setBackground(new Color(255, 240, 240));
        name.setForeground(Color.BLACK);
        phone.setBackground(new Color(255, 240, 240));
        phone.setForeground(Color.BLACK);
        email.setBackground(new Color(255, 240, 240));
        email.setForeground(Color.BLACK);

        setLayout(new GridLayout(6, 3));
        add(new JLabel("이름"));
        add(name);
        add(new JLabel("전화번호"));
        add(phone);
        add(new JLabel("e-mail"));
        add(email);
        add(new JLabel("사진"));
        add(photoButton);
        add(new JLabel());
        add(Okbtn);
        //add(photoLabel); 다이얼로그에 사진 추가
        Okbtn.setFocusPainted(false);
        Okbtn.setBackground(new Color(255, 182, 193));
        Okbtn.setForeground(Color.BLACK);
        photoButton.setFocusPainted(false);
        photoButton.setBackground(new Color(255, 182, 193));
        photoButton.setForeground(Color.BLACK);

        setSize(300, 200);
        setLocationRelativeTo(frame);

        // 사진 선택 버튼 이벤트 처리
        photoButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("사진을 선택하세요");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                photoPath = selectedFile.getAbsolutePath();  // 선택된 사진 경로 저장

                // 사진을 JLabel에 표시
                ImageIcon icon = new ImageIcon(photoPath);
                photoLabel.setIcon(icon);
                photoLabel.setText(""); // 기존 텍스트 제거
            }
        });

        // 추가 버튼 이벤트 처리
        Okbtn.addActionListener(e -> {
            String name2 = name.getText();
            String phone2 = phone.getText();
            String email2 = email.getText();
            if (!name2.isEmpty() && !phone2.isEmpty() && !email2.isEmpty() && !photoPath.isEmpty()) {
                // 사진 저장
                savePhotoToFileSystem(name2);
                // 연락처와 사진 경로를 파일에 저장
                saveContactToFile(name2, phone2, email2, photoPath);
                // 추가된 연락처 정보를 JTextArea에 표시
                ta.append(name2 + "\n");
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(MyDialog.this, "이름, 전화번호, 이메일, 사진을 모두 입력하세요.", "전부 입력하세요", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // 연락처 목록을 불러와 JTextArea에 표시
    private void loadContacts() {
        File file = new File("contacts.txt");

        // 연락처 파일이 존재할 경우, JTextArea에 내용 갱신
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                // 연락처 목록이 추가되기 전에 JTextArea 초기화 (중복 방지)
                ta.setText(""); // 초기화

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 4) {
                        String name = parts[0];
                        // 기존 연락처 이름을 JTextArea에 표시
                        ta.append(name + "\n");
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "연락처를 불러오는 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    // 사진을 파일 시스템에 저장
    private void savePhotoToFileSystem(String name) {
        if (photoPath != null && !photoPath.isEmpty()) {
            File folder = new File("photos");
            if (!folder.exists()) {
                folder.mkdir();
            }
            String newPhotoPath = "photos/" + name + "_photo.jpg";

            try {
                Path sourcePath = Paths.get(photoPath);
                Path targetPath = Paths.get(newPhotoPath);
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                photoPath = newPhotoPath;  // 사진 경로 업데이트
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "사진 저장 중 오류가 발생했습니다.");
                e.printStackTrace();
            }
        }
    }

    // 연락처와 사진 경로를 파일에 저장
    private void saveContactToFile(String name, String phone, String email, String photoPath) {
        File file = new File("contacts.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(name + "," + phone + "," + email + "," + photoPath);
                writer.newLine();
                JOptionPane.showMessageDialog(null, "연락처가 성공적으로 저장되었습니다.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "파일 저장 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
