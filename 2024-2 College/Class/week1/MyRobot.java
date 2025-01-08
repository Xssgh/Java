package apply;

import java.util.Arrays;
import java.util.Scanner;

class Robot {
    static int[] dx = {0, 1, 0, -1}; // x 방향 이동 (오른쪽, 아래, 왼쪽, 위)
    static int[] dy = {1, 0, -1, 0}; // y 방향 이동 (오른쪽, 아래, 왼쪽, 위)
    int x, y, direction;

    Robot() {
        x = 0;
        y = 0;
        direction = 0; // 초기 방향 (0 = 오른쪽)
    }

    void turnR() {
        direction = (direction + 1) % 4;
    }

    void turnL() {
        direction = (direction + 3) % 4;
    }

    void go() {
        x += dx[direction];
        y += dy[direction];
    }

    void back() {
        x -= dx[direction];
        y -= dy[direction];
    }
}

public class MyRobot { // 클래스 이름을 대문자로 시작
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        System.out.println(Arrays.toString(robottest(command)));
        scanner.close(); // 스캐너 닫기
    }

    public static int[] robottest(String command) {
        Robot myRobot = new Robot();
        
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'L') myRobot.turnL();
            else if (c == 'R') myRobot.turnR();
            else if (c == 'G') myRobot.go();
            else if (c == 'B') myRobot.back();
        }

        return new int[]{myRobot.x, myRobot.y}; // 최종 위치를 배열로 반환
    }
}
