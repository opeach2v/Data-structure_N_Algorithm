public class ShakeStr {
    public String solution(String str1, String str2) {
        String answer = "";

        String[] str1_s = str1.split("");
        String[] str2_s = str2.split("");

        for(int i = 0; i < str1_s.length; i++) {
            answer += str1_s[i] + str2_s[i];
        }

        return answer;
    }
}