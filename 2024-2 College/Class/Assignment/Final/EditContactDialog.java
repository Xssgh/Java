//2021863058 장현호
package defaultFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class EditContactDialog extends JDialog {
    private JTextField nameField, phoneField, emailField;
    private JButton editButton, photoButton;
    private JLabel photoLabel;
    private String oldName, photoPath;
    private JTextArea ta; // 연락처 목록을 표시할 JTextArea

    public EditContactDialog(JFrame parent, String title, JTextArea ta, String oldName)  {
        super(parent, title, true);
        // 기존 연락처 정보 불러오기 및 UI 초기화

        this.ta = ta;
        this.oldName = oldName;


        // UI 컴포넌트 초기화
        nameField = new JTextField(10);  // 초기화
        phoneField = new JTextField(10); // 초기화
        emailField = new JTextField(10); // 초기화
        photoLabel = new JLabel(); // 초기화
        editButton = new JButton("Edit");
        photoButton = new JButton("Photo");

        // 연락처 정보 불러오기
        loadContactInfo();

        setLayout(new GridLayout(6, 3));
        add(new JLabel("이름"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("전화번호"));
        phoneField = new JTextField(10);
        add(phoneField);

        add(new JLabel("e-mail"));
        emailField = new JTextField(10);
        add(emailField);

        add(new JLabel("사진"));
        photoButton = new JButton("사진 선택");
        add(photoButton);

        editButton = new JButton("수정");
        add(new JLabel());
        add(editButton);

        getContentPane().setBackground(new Color(255, 230, 230));

        //버튼 꾸미기
        nameField.setBackground(new Color(255, 240, 240));
        nameField.setForeground(Color.BLACK);
        phoneField.setBackground(new Color(255, 240, 240));
        phoneField.setForeground(Color.BLACK);
        emailField.setBackground(new Color(255, 240, 240));
        emailField.setForeground(Color.BLACK);
        editButton.setBackground(new Color(255, 182, 193));
        editButton.setForeground(Color.BLACK);
        photoButton.setBackground(new Color(255, 182, 193));
        photoButton.setForeground(Color.BLACK);



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
            }
        });

        // 수정 버튼 이벤트 처리
        editButton.addActionListener(e -> editContact());

        setSize(300, 250);  // 다이얼로그 크기 확장 (사진 표시 추가)
        setLocationRelativeTo(parent);
    }

    // 기존 연락처 정보 불러오기
    private void loadContactInfo() {
        File file = new File("contacts.txt");

    }

    // 연락처 수정 및 파일에 저장
    private void editContact() {
        String newName = nameField.getText();
        String newPhone = phoneField.getText();
        String newEmail = emailField.getText();

        if (newName.isEmpty() || newPhone.isEmpty() || newEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이름, 전화번호, 이메일을 모두 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 수정된 사진 경로 저장
        if (photoPath != null && !photoPath.isEmpty()) {
            savePhotoToFileSystem(newName);  // 사진을 저장할 폴더에 저장
        }

        // 연락처 정보를 파일에서 수정
        File file = new File("contacts.txt");
        if (file.exists()) {
            try {
                // 모든 연락처를 읽어와서 수정
                List<String> contacts = new java.util.ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts[0].equalsIgnoreCase(oldName)) {
                            contacts.add(newName + "," + newPhone + "," + newEmail + "," + photoPath);  // 수정된 정보 추가
                        } else {
                            contacts.add(line);
                        }
                    }
                }

                // 수정된 연락처 목록을 파일에 다시 저장
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String contact : contacts) {
                        writer.write(contact);
                        writer.newLine();
                    }
                }

                JOptionPane.showMessageDialog(this, "연락처가 수정되었습니다.");
                updateContactList();
                setVisible(false);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "연락처 수정 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    // 수정된 사진을 파일 시스템에 저장
    private void savePhotoToFileSystem(String newName) {
        if (photoPath != null && !photoPath.isEmpty()) {
            File folder = new File("photos");
            if (!folder.exists()) {
                folder.mkdir();
            }
            String newPhotoPath = "photos/" + newName + "_photo.jpg";

            try {
                Path sourcePath = Paths.get(photoPath);
                Path targetPath = Paths.get(newPhotoPath);
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                photoPath = newPhotoPath;  // 사진 경로 업데이트
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "사진 저장 중 오류가 발생했습니다.");
                e.printStackTrace();
            }
        }
    }

    // JTextArea를 갱신하여 연락처 목록 업데이트
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
                    if (parts.length >= 3) {
                        String name = parts[0];
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
