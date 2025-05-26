import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ResultBracket {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] s = str.split("");
        Deque<String> stack = new ArrayDeque<>();   // 괄호 넣을 것
        Deque<Integer> sums = new ArrayDeque<>();    // 계산하기

        if(str.length() % 2 == 0) {
            for(int i = 0; i < s.length - 1; i++) {
                if(stack.isEmpty()) {
                    stack.push(s[i]);
                    if(s[i].equals("(") && s[i + 1].equals(")")) {
                        sum += 2;
                        stack.pop();
                        i++;
                    }
                    else if(s[i].equals("[") && s[i + 1].equals("]")) {
                        sum += 3;
                        stack.pop();
                        i++;
                    }
                    continue;
                }
                else {  // 비어있지 않았으면 곱하기 해줘야 함
                    if(stack.peek().equals("(")) {
                        if(s[i].equals(")")) {
                            sums.push(2);
                            stack.pop();
                        }
                        else {
                            if(s[i].equals("(")) {
                                stack.push(s[i]);
                            }
                            else if(s[i].equals("[")) {
                                stack.push(s[i]);
                            }
                            else {
                                break;
                            }
                        }
                    }
                    else {  // ] 라면
                        if(s[i].equals("]")) {
                            sums.push(3);
                            stack.pop();
                        }
                        else {
                            if(s[i].equals("(")) {
                                stack.push(s[i]);
                            }
                            else if(s[i].equals("[")) {
                                stack.push(s[i]);
                            }
                            else {
                                break;
                            }
                        }
                    }
                }
                for(int j = 0; j < sums.size(); j++) {
                    sum += sums.pop();
                    j--;
                }
            }
        }

        if(stack.isEmpty()) System.out.println(sum);
        else System.out.println(0);

        sc.close();
    }
}