import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackProgression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int topCount = sc.nextInt();   // 탑의 수

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < topCount; i++) {
            stack.push(sc.nextInt());
        }

        int num = 0;
        for(int i = 0; i < topCount; i++) {
            if(stack.size() == topCount) {
                num = stack.pop();
                continue;
            }

            if(num >= stack.peek()) {
                stack.pop();
                
            }

        }
    }
}