public class WithPw {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String[] skipS = skip.split("");

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for(int idx = 0; idx < index; idx++) {
                if(c == 'z') {  // z면
                    c = 'a';
                }
                else c++;    // 다음 알파벳

                for(int j = 0; j < skipS.length; j++) {
                    if(String.valueOf(c).equals(skipS[j])) {    // skip에 있는 거랑 같으면
                        if(c == 'z') {  // z면
                            c = 'a';
                            j = -1;
                        }
                        else {
                            c++;    // 다음 알파벳
                            j = -1;
                        }
                    }
                }
            }
            answer += String.valueOf(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "y";
        String skip = "baz";
        int index = 1;
        String res = "";

        WithPw wp = new WithPw();
        res = wp.solution(s, skip, index);
    }
}