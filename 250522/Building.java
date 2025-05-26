import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        long answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        Deque<Integer> stack = new ArrayDeque<>();
        long count = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            count = stack.size();
            answer += count;
            stack.push(i);
        }
        System.out.println(answer);
    }
}