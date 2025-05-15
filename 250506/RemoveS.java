import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveS {
    public int solution(String s) {
        Deque<String> stack = new ArrayDeque<>();   // 스택 사용
        
        for(String ss : s.split("")) {
            if(stack.isEmpty()) {
                stack.push(ss);
                continue;
            }
            if(ss.equals(stack.peek())) stack.pop();
            else stack.push(ss);
        }
        if(stack.isEmpty()) return 1;   // 다 사라졌다는 거니까

        return 0;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        int res = 0;

        RemoveS r = new RemoveS();
        res = r.solution(s);

        System.out.println(res);
    }
}