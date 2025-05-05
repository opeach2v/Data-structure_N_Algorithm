public class MakeJadenCase {
    public String solution(String s) {
        String answer = "";
        
        // 첫 문자가 소문자면
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            char c = s.charAt(0);
            c -= 32;
            answer += String.valueOf(c);    // 대문자로 넣어주기
        }
        else {
            answer += String.valueOf(s.charAt(0));
        }

        if(s.length() == 1) {   // 문자열 길이가 1이면
            return answer;  // 바로 리턴
        }
        else {
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) != ' ') {    // 공백이 아니면
                    if(s.charAt(i - 1) == ' ') {    // 그 전 인덱스가 공백이면서
                        char c = s.charAt(i);
                        if(c >= 'a' && c <= 'z') {  // 소문자면
                            c -= 32;
                            answer += String.valueOf(c);
                        }
                        else answer += String.valueOf(c);   // 대문자면 그냥 그대로 넣기
                    }
                    else {  // 그 전 인덱스가 공백이 아니면서
                        char c = s.charAt(i);
                        if(c >= 'A' && c <= 'Z') {  // 대문자면
                            c += 32;
                            answer += String.valueOf(c);
                        }
                        else {
                            answer += String.valueOf(c);    // 소문자면 그냥 그대로 넣기
                        }
                    }
                }
                else {  // 공백이면
                    answer += " ";  // 공백 추가
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        String res = "";

        MakeJadenCase m = new MakeJadenCase();
        res = m.solution(s);
    }
}