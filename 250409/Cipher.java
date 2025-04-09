public class Cipher {
    public String solution(String cipher, int code) {
        String answer = "";

        String[] ci = cipher.split("");

        int i = code;
        while(i <= ci.length) {
            answer += ci[i - 1];
            i += code;
        }

        return answer;
    }

    public static void main(String[] args) {
        String ciString = "dfjardstddetckdaccccdegk";
        int code = 4;
        String result = "";

        Cipher c = new Cipher();
        result = c.solution(ciString, code);

        System.out.println(result);
    }
}
