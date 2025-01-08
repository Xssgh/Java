//2021863058 장현호
package defaultFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.text.BadLocationException;


public class defaultFrame extends JFrame {
    private JTextField tf;
    private JTextArea ta;
    private JTextArea detail;
    JPanel photozone = new JPanel();
    
    public defaultFrame() {

        setTitle("연락처 관리 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 192, 203));
        setLayout(new GridLayout(1, 3, 10, 10));

        // 버튼 3개 생성
        JButton button1 = new JButton("연락처 추가");
        JButton button2 = new JButton("연락처 삭제");
        JButton button3 = new JButton("연락처 수정");



        // 버튼 주변에 점선 없애기
        button1.setFocusPainted(false);
        button2.setFocusPainted(false);
        button3.setFocusPainted(false);

        button1.setPreferredSize(new Dimension(150, 150));
        button2.setPreferredSize(new Dimension(150, 150));
        button3.setPreferredSize(new Dimension(150, 150));

        // 버튼 색상 설정
        button1.setBackground(new Color(255, 182, 193));
        button1.setForeground(Color.BLACK);
        button2.setBackground(new Color(255, 182, 193));
        button2.setForeground(Color.BLACK);
        button3.setBackground(new Color(255, 182, 193));
        button3.setForeground(Color.BLACK);

        // 왼쪽 메뉴 버튼 생성
        JPanel leftMenu = new JPanel();
        leftMenu.setBackground(new Color(255, 230, 230));
        leftMenu.setLayout(new BoxLayout(leftMenu, BoxLayout.Y_AXIS));
        leftMenu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        leftMenu.add(button1);
        leftMenu.add(Box.createVerticalStrut(10));
        leftMenu.add(button2);
        leftMenu.add(Box.createVerticalStrut(10));
        leftMenu.add(button3);
        add(leftMenu);

        // 사진이 표시될 공간
        photozone.setLayout(new BoxLayout(photozone, BoxLayout.Y_AXIS));
        photozone.setBackground(new Color(255, 230, 230));
        photozone.setBorder(BorderFactory.createEmptyBorder(110, 60, 0, 0));
        add(photozone);

        // 오른쪽 검색 패널 만들기
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 230, 230));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // 검색 필드
        tf = new JTextField(10);
        ta = new JTextArea();
        ta.setEditable(false);
        ta.setPreferredSize(new Dimension(350, 420));

        detail = new JTextArea();
        detail.setEditable(false);
        detail.setPreferredSize(new Dimension(150, 420));

        //오른쪽 패널 색 변경
        tf.setBackground(new Color(255, 240, 240));
        tf.setForeground(Color.BLACK);
        ta.setBackground(new Color(255, 240, 240));
        ta.setForeground(Color.BLACK);
        detail.setBackground(new Color(255, 240, 240));
        detail.setForeground(Color.BLACK);

        rightPanel.add(new JLabel("검색하고 싶은 사람의 이름을 입력 후 Enter키를 누르세요"));
        rightPanel.add(tf);

        JScrollPane taScrollPane = new JScrollPane(ta);
        taScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로스크롤바 없애기
        rightPanel.add(taScrollPane);

        JScrollPane detailScrollPane = new JScrollPane(detail);
        rightPanel.add(detailScrollPane);
        detailScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); //세로 스크롤바 없애기
        detailScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // 이름으로 연락처 검색
        tf.addActionListener(e -> searchContact(tf.getText().trim(), photozone));

        // 연락처 추가 버튼 클릭시 이벤트
        button1.addActionListener(e -> {
            MyDialog dialog = new MyDialog(this, "연락처 추가", ta, photozone);
            dialog.setVisible(true);
        });

        // 연락처 삭제 버튼 클릭시 이벤트
        button2.addActionListener(e -> {
            DeleteDialog deleteDialog = new DeleteDialog(this, "연락처 삭제", ta);
            deleteDialog.setVisible(true);
        });

        // 연락처 수정 버튼 클릭 시
        button3.addActionListener(e -> {
            // 연락처 목록을 선택할 다이얼로그 열기
            ContactSelectionDialog selectionDialog = new ContactSelectionDialog(this, "연락처 수정", ta);
            selectionDialog.setVisible(true);
        });

        add(rightPanel);

        //연락처 목록을 클릭하면 상세정보에 출력
        ta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                // 클릭된 위치의 텍스트를 확인
                int offset = ta.viewToModel(evt.getPoint());
                try {
                    // 클릭된 위치의 줄 번호를 가져옴
                    int line = ta.getDocument().getDefaultRootElement().getElementIndex(offset);
                    String lineText = ta.getText(
                        ta.getDocument().getDefaultRootElement().getElement(line).getStartOffset(),
                        ta.getDocument().getDefaultRootElement().getElement(line).getEndOffset() - ta.getDocument().getDefaultRootElement().getElement(line).getStartOffset()
                    );

                    String selectedText = lineText.trim();

                    if (!selectedText.isEmpty()) {
                        // 해당 연락처의 세부 정보 가져오기
                        String contactInfo = FileChooserDialog.searchContact(selectedText);

                        if (contactInfo != null) {
                            detail.setText(contactInfo);
                        } else {
                            detail.setText("연락처를 찾을 수 없습니다.");
                        }

                        // selectedText (클릭한 이름)를 사용하여 사진 경로 생성
                        String photoPath = "photos/" + selectedText + "_photo.jpg";  // selectedText를 name으로 사용

                        if (photoPath != null && !photoPath.isEmpty()) {
                            File photoFile = new File(photoPath);
                            photozone.removeAll();  // 이전에 있는 사진 제거

                            if (photoFile.exists()) {
                                // 사진 로드 및 크기 조정
                                ImageIcon originalIcon = new ImageIcon(photoPath);
                                Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                                // JLabel에 사진 설정
                                JLabel photoLabel = new JLabel(resizedIcon);
                                photozone.add(photoLabel);
                            } else {
                                // 사진이 없을 경우 메시지 표시
                                JLabel noPhotoLabel = new JLabel("사진 없음");
                                noPhotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                photozone.add(noPhotoLabel);
                            }
                            photozone.revalidate();  // UI 갱신
                            photozone.repaint();
                        } else {
                            detail.setText("사진을 찾을 수 없습니다.");
                            photozone.removeAll();
                            JLabel noPhotoLabel = new JLabel("사진 없음");
                            noPhotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            photozone.add(noPhotoLabel);
                            photozone.revalidate();  // UI 갱신
                            photozone.repaint();
                        }
                    }
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });


        // 프로그램 실행 시 자동으로 연락처 목록을 불러오기
        loadContacts(); // 프로그램 실행 시 연락처 목록 불러오기

        setVisible(true);
        setSize(1000, 500);
    }

    // 이름으로 연락처 검색
    private void searchContact(String name, JPanel photozone) {
        String contactInfo = FileChooserDialog.searchContact(name);

        if (contactInfo != null) {
            detail.setText(contactInfo);
            // 사진 경로 설정
            String photoPath = "photos/" + name + "_photo.jpg"; //이름으로 찾을 수 있게
            File photoFile = new File(photoPath);
            photozone.removeAll();

            if (photoFile.exists()) {
                // 사진 로드 및 크기 조정
                ImageIcon originalIcon = new ImageIcon(photoPath);
                Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                JLabel photoLabel = new JLabel();
                photoLabel.setIcon(resizedIcon);

                // photozone에 사진 추가
                photozone.add(photoLabel);
            } else {
                // 사진이 없을 경우 메시지 출력
                JLabel noPhotoLabel = new JLabel("사진 없음");
                noPhotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                photozone.add(noPhotoLabel);
            }

            // photozone 갱신
            photozone.revalidate();
            photozone.repaint();
        } else {
            detail.setText("해당 이름의 연락처를 찾을 수 없습니다.");

            // photozone 초기화
            photozone.removeAll();
            JLabel noPhotoLabel = new JLabel("연락처를 찾을 수 없습니다.");
            noPhotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            photozone.add(noPhotoLabel);

            // photozone 갱신
            photozone.revalidate();
            photozone.repaint();
        }
    }
    // 연락처 목록을 자동으로 불러옴
    private void loadContacts() {
        File file = new File("contacts.txt");

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                ta.setText(""); // 기존 목록 초기화

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 1) {
                        String name = parts[0];
                        ta.append(name + "\n");  // 이름만 표시
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "연락처를 불러오는 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "연락처 파일이 존재하지 않습니다.", "파일 없음", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new defaultFrame();
    }
}
