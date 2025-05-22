import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Top {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();  // 메인으로 씀
        Deque<Integer> res = new ArrayDeque<>();    // 결과 값 넣어주기

        for(int i = 0; i < count; i++) {
            stack.push(sc.nextInt());
        }

        // 반복문 개 많아서 메모리초과 떳네 ㅎ
        while(stack.size() > 1) {   // 맨 왼쪽 탑은 0이니까
            int cur = stack.pop();
            while(true) {
                if(stack.peek() > cur) {    // pop한 것보다 peekLast가 더 크면
                    res.push(stack.size());
                    if(!queue.isEmpty()) {
                        for(int k = 0; k < queue.size(); k++) {
                            stack.push(queue.poll());
                            k--;
                        }
                    }
                    break;
                }
                else {  // 같거나 작으면
                    queue.offer(stack.pop());   // 해당 값은 큐에 넣어놓고 계속 확인하기
                    if(stack.isEmpty()) {
                        // 더 큰 게 나올 수도 없고, 비교할 것도 없으니까
                        res.push(0);    // 0넣기
                        res.push(0);    // 마지막은 항상 0
                    }
                }
            }
        }

        for(int i = 0; i < count; i++) {
            System.out.println(res.pop());
        }
    }
}