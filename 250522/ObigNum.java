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

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (current < max) {
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
    }
}