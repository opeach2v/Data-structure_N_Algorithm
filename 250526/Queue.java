import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Queue {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();  // 개행 문자 제거용
        Deque<String> queue = new ArrayDeque<>();
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i = 0; i < count; i++) {
            String str = sc.nextLine();
            if(str.contains("push")) {
                String[] s = str.split(" ");
                queue.offer(s[1]);
                continue;
            }
            else if(str.equals("pop")) {
                if(queue.isEmpty()) bfw.write("-1");
                else bfw.write(queue.poll());
            }
            else if(str.equals("size")) {
                bfw.write(String.valueOf(queue.size()));
            }
            else if(str.equals("empty")) {
                if(queue.isEmpty()) bfw.write("1");
                else bfw.write("0");
            }
            else if(str.equals("front")) {
                if(queue.isEmpty()) bfw.write("-1");
                else bfw.write(queue.peek());
            }
            else if(str.equals("back")) {
                if(queue.isEmpty()) bfw.write("-1");
                else bfw.write(queue.peekLast());
            }
            bfw.newLine();
        }
        bfw.flush();

        sc.close();
    }
}