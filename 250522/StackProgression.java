import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class StackProgression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int topCount = sc.nextInt();    // 반복문 횟수
        ArrayList<String> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        int num = 1;    // 1부터 쌓기
        for (int i = 0; i < topCount; i++) {
            int input = sc.nextInt();

            // 필요한 만큼 push
            while (num <= input) {
                stack.push(num++);
                list.add("+");
            }

            // input이 stack의 top이어야 함
            if (!stack.isEmpty() && stack.peek() == input) {
                stack.pop();
                list.add("-");
            } else {
                System.out.println("NO");
                return;
            }
        }

        for(String s : list) System.out.println(s);
    }
}