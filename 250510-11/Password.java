public class Password {
    static String answer = "";
    static int i = 0;
    public String solution(String s, int n) {
        char c = s.charAt(i);
        if(c >= 'a' && c <= 'z') {  // 소문자면
            c += n;
            if(c > 'z') {   // c가 z이상이면
                c -= 26;    // 알파벳 갯수만큼 빼주기
            }
            answer += String.valueOf(c);  // 해당 인덱스 재배치
        }
        else if(c >= 'A' && c <= 'Z') {  // 대문자라면
            c += n;
            if(c > 'Z') {
                c -= 26;
            }
            answer += String.valueOf(c);
        }
        else answer += " ";
        i++;

        if(i == s.length()) {
            return answer;
        }

        return solution(s, n);
    }

    public static void main(String[] args) {
        String s = "AB";
        int n = 1;
        String res = "";

        Password p = new Password();
        res = p.solution(s, n);
        System.out.println(res);
    }
}