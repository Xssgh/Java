//2021863058 장현호
package defaultFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileChooserDialog {

    // 파일 열기 다이얼로그를 열고 선택된 파일을 반환 (사진 파일)
    public static String openPhotoFileChooser(JFrame parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("사진 파일 열기");
        // 이미지 파일 선택
        FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일", "jpg", "png", "gif");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();  // 선택한 파일의 경로 반환
        }

        return null;  // 파일을 선택하지 않으면 null 반환
    }

    // 파일에서 이름으로 연락처 검색
    public static String searchContact(String name) {
        File file = new File("contacts.txt");  // 고정된 "contacts.txt" 파일 사용

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[0].equalsIgnoreCase(name)) {
                        return "이름: " + parts[0] + "\n전화번호: " + parts[1] + "\n이메일: " + parts[2];
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "파일 읽기 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        return null;
    }

}
