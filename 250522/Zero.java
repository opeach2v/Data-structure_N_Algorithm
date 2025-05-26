import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Zero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int sum = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < count; i++) {
            int num = sc.nextInt();

            if(num == 0) {
                sum -= stack.pop();
            }
            else {
                sum += num;
                stack.push(num);
            }
        }

        System.out.println(sum);
        sc.close();
    }
}