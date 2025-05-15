import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveS {
    public int solution(String s) {
        int answer = 0;

        Deque<String> stack = new ArrayDeque<>();   // 스택 사용
        for(int i = 0; i < s.length(); i++) {
            stack.push(String.valueOf(s.charAt(i)));
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "baab";
        int res = 0;

        RemoveS r = new RemoveS();
        res = r.solution(s);

        System.out.println(res);
    }
}