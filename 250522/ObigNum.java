import java.util.*;

public class ObigNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            stack.push(sc.nextInt());
        }

        List<Integer> result = new ArrayList<>();
        int max = stack.pop();  // 첫 번째 비교 대상
        result.add(-1);
        int current = 0;
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (stack.size() >= 1 && stack.peek() < max) {
                if(stack.peek() < current) {    // 다음 값이랑 current값 중 current값이 더 크면 max 바꿔주기
                    result.add(current);
                    continue;
                }
                result.add(max);
            } else {
                result.add(-1);
                max = current;
            }
        }

        // 뒤집어서 출력
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (int num : result) sb.append(num).append(" ");
        System.out.println(sb.toString().trim());

        sc.close();
    }
}