import java.util.ArrayDeque;
import java.util.Deque;

public class CurrParenthesis {
    boolean solution(String s) {
        boolean answer = true;

        Deque<String> stack = new ArrayDeque<>();

        for(String p : s.split("")) {  // ss가 빌 때까지 반복
            if(stack.isEmpty()) {
                if(p.equals(")")) return false;
                stack.push(p);
                continue;
            }

            if(!stack.peek().equals(p)) {    // 둘이 다른 거면 ( 랑 ) 니까
                stack.pop();
            }
            else {
                stack.push(p);
            }
        }
        if(!stack.isEmpty()) return false;

        return answer;
    }

    public static void main(String[] args) {
        String s = "(())()";
        boolean res;

        CurrParenthesis c = new CurrParenthesis();
        res = c.solution(s);
    }
}