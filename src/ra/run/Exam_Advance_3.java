package ra.run;

import config.Config;
import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam_Advance_3 {
    static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args) {
        int choice;
        System.out.println("""
                ****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************
                1. Nhập tên phụ huynh nộp hồ sơ
                2. Phụ huynh tiếp theo
                3. Thoát
                """);
        choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice){
            case 1:
                handleAdd();
                break;
            case 2:
                HandleNext();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Lựa chọn không hợp lệ");
                break;
        }
    }

    private static void HandleNext() {
        System.out.println(queue.poll());
    }

    private static void handleAdd() {
        System.out.println("Nhập tên phụ huynh");
        String s = Config.scanner().nextLine();
        queue.offer(s);
    }
}
