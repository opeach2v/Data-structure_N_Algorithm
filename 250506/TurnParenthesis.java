import java.util.ArrayDeque;
import java.util.Deque;

public class TurnParenthesis {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split("");
        Deque<String> c = new ArrayDeque<>();    // s를 넣어놓은 것(큐)
        Deque<String> stack = new ArrayDeque<>();
        // 회전 시키면서 비교
        for(int i = 0; i < s.length(); i++) {
            for(int q = 0; q < s.length(); q++) c.offer(str[q]);   // 큐로 넣고 사용할 것(회전 시킬 때 사용함)
            if(i > 0) { // i가 0보다 크면 그만큼 옆으로 회전
                for(int t = 0; t < i; t++) c.offer(c.poll());
            }
            for(int j = 0; j < s.length(); j++) {
                if(stack.isEmpty()) {
                    stack.push(c.peek());
                    if(stack.peek().equals(")") || stack.peek().equals("]") || stack.peek().equals("}")) break;
                    c.poll();
                    continue;
                }

                switch (stack.peek()) {
                    case "(":
                        if(c.peek().equals(")")) {
                            stack.pop();
                            c.poll();
                        }
                        else if(c.peek().equals("(") || c.peek().equals("[") || c.peek().equals("{")) {
                            stack.push(c.poll());
                        }
                        break;
                    case "{":
                        if(c.peek().equals("}")) {
                            stack.pop();
                            c.poll();
                        }
                        else if(c.peek().equals("(") || c.peek().equals("[") || c.peek().equals("{")) {
                            stack.push(c.poll());
                        }
                        break;
                    case "[":
                        if(c.peek().equals("]")) {
                            stack.pop();
                            c.poll();
                        }
                        else if(c.peek().equals("(") || c.peek().equals("[") || c.peek().equals("{")) {
                            stack.push(c.poll());
                        }
                        break;
                    default:
                        break;
                }
            }
            if(stack.isEmpty()) answer++;   // stack이 비었다는 건 모두 짝이 맞는다는 뜻.
            stack.clear();
            c.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        // String s = "[(){{}}]";
        String s = "}]()[{";
        int res = 0;

        TurnParenthesis t = new TurnParenthesis();
        res = t.solution(s);

        System.out.println(res);
    }
}