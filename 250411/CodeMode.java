public class CodeMode {
    public String solution(String code) {
        String answer = "";
        int mode = 0;   // 기본적으로 0
        String[] code_s = code.split("");

        for(int i = 0; i < code_s.length; i++) {
            if(code_s[i].equals("1")) { // code가 1이면 mode를 1로 바꿔야 함
                if(mode == 1) { // 모드가 이미 1이면
                    mode = 0;
                }
                else {
                    mode = 1;
                }
                continue;
            }
            if(mode == 0) {
                if(i % 2 == 0) {    // 모드가 0일 때, 짝수면 문자열에 더함
                    answer += code_s[i];
                }
            }
            else {  // 모드가 1일 때, 홀수면 문자열에 더함
                if(i % 2 == 1) {
                    answer += code_s[i];
                }
            }
        }
        return answer;
    }
}