import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Top {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();  // 메인으로 씀
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            stack.push(sc.nextInt());
        }
        
        
        int low = stack.pop();  // 낮은 건물이라고 생각하고 ...
        for(int i = 0; i < count; i++) {
            if(stack.peek() >= low) list.add(stack.size()); // 해당 인덱스 넣어줘야 하니까
            else {
                low = stack.pop();
                i--;
            }
        }
        list.add(0);

        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i >= 0; i--) sb.append(list.get(i)).append(" ");

        System.out.println(sb.toString().trim());
    }
}