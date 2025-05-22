import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 명령의 수
        
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i <= num; i++) {  // 주어진 명령의 수만큼 돌면서
            String str = sc.nextLine();
            
            if(str.contains("push")) {  // push가 포함되어 있으면
                String[] s = str.split(" ");
                stack.push(Integer.valueOf(s[1])); // 해당 숫자 넣기
            }
            else if(str.equals("pop")) {
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            }
            else if(str.equals("size")) {
                System.out.println(stack.size());
            }
            else if(str.equals("empty")) {
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(str.equals("top")) {
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
        sc.close();
    }
}