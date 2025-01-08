//2021863058 장현호
package defaultFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class ContactSelectionDialog extends JDialog {
    private JList<String> contactList;
    private DefaultListModel<String> listModel;
    private JButton selectButton;
    private JTextArea ta;

    public ContactSelectionDialog(JFrame parent, String title, JTextArea ta) {
        super(parent, title, true);
        this.ta = ta;

        setLayout(new BorderLayout());

        // 연락처 목록을 위한 모델과 리스트
        listModel = new DefaultListModel<>();
        contactList = new JList<>(listModel);
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        contactList.setBackground(new Color(255, 230, 230));

        // 연락처 목록을 파일에서 읽어와서 리스트에 추가
        loadContacts();

        // 스크롤 패널로 리스트 감싸기
        JScrollPane listScrollPane = new JScrollPane(contactList);
        add(listScrollPane, BorderLayout.CENTER);

        // 선택 버튼
        selectButton = new JButton("선택");
        selectButton.addActionListener(e -> selectContact());
        add(selectButton, BorderLayout.SOUTH);

        selectButton.setBackground(new Color(255, 182, 193));
        selectButton.setForeground(Color.BLACK);

        setSize(300, 400);
        setLocationRelativeTo(parent);
    }

    private void loadContacts() {
        File file = new File("contacts.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 1) {
                        listModel.addElement(parts[0]);  // 이름만 리스트에 추가
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "연락처를 불러오는 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void selectContact() {
        String selectedContact = contactList.getSelectedValue();
        if (selectedContact != null) {
            EditContactDialog editDialog = new EditContactDialog((JFrame) getParent(), "연락처 수정", ta, selectedContact);
            editDialog.setVisible(true);  // 다이얼로그 표시
            setVisible(false);  // 현재 다이얼로그 닫기
        } else {
            JOptionPane.showMessageDialog(this, "연락처를 선택해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
        }
    }
}
