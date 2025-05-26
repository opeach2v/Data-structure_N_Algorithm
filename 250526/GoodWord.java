import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class GoodWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int goodWord = 0;

        for(int i = 0; i < count; i++) {
            Deque<String> stack = new ArrayDeque<>();
            String str = sc.next();

            if(str.length() % 2 == 1) continue; // str의 길이가 홀수면 어차피 안 됨
            for(String s : str.split("")) {
                if(stack.isEmpty()) {
                    stack.push(s);
                    continue;
                }
                else {
                    if(stack.peek().equals(s)) {
                        stack.pop();
                    }
                    else stack.push(s);
                }
            }

            if(stack.isEmpty()) goodWord++;
        }

        System.out.println(goodWord);
    }
}