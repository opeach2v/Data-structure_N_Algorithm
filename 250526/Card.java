import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= num; i++) {
            queue.offer(i); // 일단 큐에 넣기
        }

        while(queue.size() > 1) {   // 큐 크기가 1이 될 때까지
            queue.poll();
            if(queue.size() == 1) {
                break;
            }
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());

        sc.close();
    }
}