import java.util.ArrayDeque;
import java.util.Deque;

public class TurnParenthesis {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split("");
        Deque<String> c = new ArrayDeque<>();    // s를 넣어놓은 것(큐)
        for(int i = 0; i < s.length(); i++) {
            c.offer(str[i]);   // 큐로 넣고 사용할 것(회전 시킬 때 사용함)
        }

        Deque<String> stack = new ArrayDeque<>();
        // 회전 시키면서 비교
        for(int i = 0; i < c.size(); i++) {
            for(int j = 0; j < c.size(); j++) {
                if(stack.isEmpty()) {
                    stack.push(c.peek());
                    if(stack.peek().equals(")") || stack.peek().equals("]") || stack.peek().equals("]")) break;
                    c.offer(c.poll());
                    continue;
                }

                switch (stack.peek()) {
                    case "(":
                        if(c.peek().equals("(")) {
                            stack.pop();
                            c.offer(c.poll());
                        }
                        break;
                    case "{":
                        if(c.peek().equals("}")) {
                            stack.pop();
                            c.offer(c.poll());
                        }
                        break;
                    case "[":
                        if(c.peek().equals("]")) {
                            stack.pop();
                            c.offer(c.poll());
                        }
                        break;
                    default:
                        break;
                }
            }
            if(stack.isEmpty()) answer++;   // stack이 비었다는 건 모두 짝이 맞는다는 뜻.
            stack.clear();
            System.out.println(c);
            c.offer(c.poll());  // 한 번 뒤로 회전
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "[(){{}}]";
        int res = 0;

        TurnParenthesis t = new TurnParenthesis();
        res = t.solution(s);

        System.out.println(res);
    }
}

// 22분 진행중