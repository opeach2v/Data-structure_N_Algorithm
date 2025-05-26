import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class IronStick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String str = sc.next();
        Deque<String> stack = new ArrayDeque<>();
        String[] s = str.split("");

        for(int i = 0; i < s.length - 1; i++) {
            if(stack.isEmpty()) {
                if(s[i].equals("(")) {
                    stack.push(s[i]);  // 일단 넣기
                    if(s[i + 1].equals(")")) { // 바로 )가 나온다는 건 레이저라는 것
                        stack.pop();
                        i++;    // 그리고 한 칸 넘어가기
                    }
                }
            }
            else {
                if(s[i].equals("(") && s[i + 1].equals(")")) {  // 레이저라는 것
                    stack.push(s[i]);
                    i++;
                    stack.push(s[i]);
                    stack.pop();
                    stack.pop();
                    sum += stack.size();    // 레이저랑 만났을 땐 stack.size만큼 더해주면 됨
                }
                else {
                    if(stack.peek().equals("(")) {
                        if(s[i].equals(")")) {
                            stack.pop();
                            sum++;  // 레이저가 아닌 그냥 사라지는 건 1 증가
                        }
                        else stack.push(s[i]);   // ( 라면 스택에 넣기
                    } 
                }
            }
        }
        if(!stack.isEmpty()) sum++; // 마지막 하나 괄호 하나 남은 거라서 1 더해주기

        System.out.println(sum);

        sc.close();
    }
}