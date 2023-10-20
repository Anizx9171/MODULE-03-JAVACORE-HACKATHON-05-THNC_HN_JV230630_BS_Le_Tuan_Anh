package ra.run;

import config.Config;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Exam_Advance_2 {
    static Stack<String> stack = new Stack<>();
    public static void main(String[] args) {
        int choice;
        while (true){
            System.out.println("""
                    ****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************
                    1. Nhập câu
                    2. Đảo ngược câu
                    3. Thoát
                    """);
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice){
                case 1:
                    handleAdd();
                    break;
                case 2:
                    HandleReverse();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
    }

    private static void HandleReverse() {
        System.out.println("Câu đảo ngược là:");
        Collections.reverse(stack);
        StringBuilder str = new StringBuilder();
        for (String s:stack) {
                str.append(s).append(" ");
        }
        System.out.println(str.toString().trim());
    }

    private static void handleAdd() {
        stack.clear();
        System.out.println("Nhập câu");
        String s = Config.scanner().nextLine();
        stack.addAll(List.of(s.split(" ")));
    }
}
