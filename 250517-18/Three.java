import java.util.ArrayDeque;
import java.util.Deque;

public class Three {
    public int solution(int n) {
        int answer = 0;
        Deque<String> stack = new ArrayDeque<>();
        int three = 1;

        while(n > 0) {
            if(n % 3 == 1) {
                stack.push("1");
            }
            else if (n % 3 == 2) {
                stack.push("2");
            }
            else {
                stack.push("0");
            }
            n /= 3;
        }

        for(int i = 0; i < stack.size(); i++) {
            answer += Integer.parseInt(stack.pop()) * three;
            three *= 3;
            i--;
        }

        return answer;
    }
}