public class TurnParenthesis {
    public int solution(String s) {
        int answer = 0;
        int currentCount = 0;   // 문자열 만큼 카운트해서 중간에 끊기면 틀린 거, 아니면 맞는 거

        if(s.length() % 2 == 1) return 0;   // 문자열 길이가 홀수면 괄호가 맞을 수가 x

        for(int i = 0; i < s.length() - 1; i++) {   // i만큼 왼쪽으로 회전 (0은 0번 회전 시킨다는 거)
            char[] cs = s.toCharArray();    // 문자로 나눠서 배열에 넣어줌
            if(cs[i] == '(') {
                for(int j = 1; j < s.length(); j++) {   // )가 아니면서 }, ]가 나오면
                    if(cs[j] == ')') {
                        currentCount++;
                        break;
                    }
                }
            }
            if(cs[i] == '{') {
                for(int j = 1; j < s.length(); j++) {   // )가 아니면서 }, ]가 나오면
                    if(cs[j] == '}') {
                        currentCount++;
                        break;
                    }
                }
            }
            if(cs[i] == '[') {
                for(int j = 1; j < s.length(); j++) {   // )가 아니면서 }, ]가 나오면
                    if(cs[j] == ']') {
                        currentCount++;
                        break;
                    }
                }
            }

            else {  // 첫 시작이 닫는 걸로 시작할 땐
                continue;
            }

            if(currentCount == s.length())  answer++;   // 맞는 갯수가 s 길이랑 같으면 올바른 괄호 문자열
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "[](){}";
    }
}

// 22분 진행중