import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseNum {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];

        Deque<String> stack = new ArrayDeque<>();

        for(String ss : s.split("")) {
            stack.push(ss);
        }

        for(int i = 0; i < s.length(); i++) {
            answer[i] = Integer.parseInt(stack.pop());
        }

        return answer;
    }
}