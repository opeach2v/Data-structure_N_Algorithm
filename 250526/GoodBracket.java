import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class GoodBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            Deque<String> stack = new ArrayDeque<>();
            String str = sc.next();

            if(str.length() % 2 == 1) {
                list.add("NO");
                continue;
            }
            else {
                for(String s : str.split("")) {
                    if(stack.isEmpty()) {
                        if(s.equals(")") || s.equals("}") || s.equals("]")) {
                            stack.push(s);   // 스택에 값이 남아있다는 걸 이용
                            break;
                        }
                        else {  // (, {, [ 일 때
                            stack.push(s);  // 일단 넣고
                        }
                    }
                    else {  // 스택이 차 잇을 때
                        if(stack.peek().equals("(")) {
                            if(s.equals("(") || s.equals("{") || s.equals("[")) stack.push(s);
                            else if(s.equals(")")) stack.pop();
                            else break;
                        }
                        else if(stack.peek().equals("{")) {
                            if(s.equals("(") || s.equals("{") || s.equals("[")) stack.push(s);
                            else if(s.equals("}")) stack.pop();
                            else break;
                        }
                        else if(stack.peek().equals("[")) {
                            if(s.equals("(") || s.equals("{") || s.equals("[")) stack.push(s);
                            else if(s.equals("]")) stack.pop();
                            else break;
                        }
                    }
                }
            }

            if(stack.isEmpty()) list.add("YES");
            else list.add("NO");
        }

        for(String s : list) System.out.println(s);
    }
}