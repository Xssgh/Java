//2021863058 장현호
package defaultFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class DeleteDialog extends JDialog {
    private JTextField nameField;
    private JButton deleteButton;
    private JTextArea ta;  // 연락처 목록을 표시할 JTextArea

    // 생성자 수정: JTextArea 추가 인자로 받기
    public DeleteDialog(JFrame parent, String title, JTextArea ta) {
        super(parent, title, true);
        this.ta = ta;

        // 다이얼로그 설정
        setLayout(new GridLayout(3, 2));
        nameField = new JTextField(10);
        deleteButton = new JButton("삭제");

        add(new JLabel("삭제할 이름을 입력하세요"));
        add(nameField);
        add(deleteButton);
        //삭제 다이얼로그 색상 변경
        deleteButton.setFocusPainted(false);
        deleteButton.setBackground(new Color(255, 182, 193));
        deleteButton.setForeground(Color.BLACK);

        getContentPane().setBackground(new Color(255, 230, 230));
        nameField.setBackground(new Color(255, 240, 240));
        nameField.setForeground(Color.BLACK);

        // 삭제 버튼 이벤트 처리
        deleteButton.addActionListener(e -> deleteContact(nameField.getText()));

        setSize(300, 150);
        setLocationRelativeTo(parent);
    }

    // 연락처 삭제 기능
    private void deleteContact(String name) {
        File file = new File("contacts.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "연락처 파일이 존재하지 않습니다.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 연락처 목록을 읽어들이고 삭제할 이름을 찾음
            List<String> contacts = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contacts.add(line);
                }
            }

            boolean contactFound = false;
            // 삭제할 이름을 포함하는 연락처만 제거
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String contact : contacts) {
                    String[] parts = contact.split(",");
                    if (parts[0].equalsIgnoreCase(name)) {
                        contactFound = true;  // 삭제된 연락처가 존재함
                        continue;  // 해당 연락처를 건너뛰고 삭제
                    }
                    writer.write(contact);
                    writer.newLine();
                }
            }

            if (contactFound) {
                JOptionPane.showMessageDialog(this, "연락처가 삭제되었습니다.");
                // JTextArea 업데이트
                updateContactList();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "해당 이름의 연락처를 찾을 수 없습니다.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "연락처 삭제 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 연락처 목록을 불러와 JTextArea에 표시
    private void updateContactList() {
        File file = new File("contacts.txt");

        // 연락처 파일이 존재할 경우, JTextArea에 내용 갱신
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                // 연락처 목록이 추가되기 전에 JTextArea 초기화 (중복 방지)
                ta.setText("");  // 초기화

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
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
}
