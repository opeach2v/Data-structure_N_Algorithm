import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(); // yes와 no 넣을 거
        while(true) { // .이 아닐 때 계속 반복
            String str = sc.nextLine();
            Deque<String> stack = new ArrayDeque<>();
            int check = 0;
            if(str.equals(".")) break;

            EXIT_for:
            for (String ss : str.split("")) {
                if (!(ss.charAt(0) >= 'a' && ss.charAt(0) <= 'z') && !(ss.charAt(0) <= 'A' && ss.charAt(0) >= 'Z')) {
                    if(stack.isEmpty()) {
                        if (ss.equals("(") || ss.equals("[") || ss.equals("{")) {
                            // 스택이 비어 있을 때 (, {, [ 이라면
                            stack.push(ss);
                        }
                        else if(ss.equals(")") || ss.equals("]") || ss.equals("}")) {
                            list.add("no");
                            check = 1;
                            break;  // 바로 중단
                        }
                        else {  // 이 외 . 같은 거
                            continue;
                        }
                    }
                    else {
                        switch (stack.peek()) {
                            case "(":
                                if(ss.equals(")")) stack.pop();
                                else if(ss.equals("(") || ss.equals("[") || ss.equals("{")) {
                                    stack.push(ss);
                                }
                                else if(ss.equals("]") || ss.equals("}")) {
                                    break EXIT_for;
                                }
                                break;
                            case "[":
                                if(ss.equals("]")) stack.pop();
                                else if(ss.equals("(") || ss.equals("[") || ss.equals("{")) {
                                    stack.push(ss);
                                }
                                else if(ss.equals(")") || ss.equals("}")) {
                                    break EXIT_for;
                                }
                                break;
                            case "{":
                                if(ss.equals("}")) stack.pop();
                                else if(ss.equals("(") || ss.equals("[") || ss.equals("{")) {
                                    stack.push(ss);
                                }
                                else if(ss.equals(")") || ss.equals("]")) {
                                    break EXIT_for;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

            if(check == 1) continue;
            if(stack.isEmpty()) list.add("yes");
            else list.add("no");
        }

        for(String s : list) System.out.println(s);
    }
}