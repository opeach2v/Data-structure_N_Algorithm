public class QRcode {
    public String solution(int q, int r, String code) {
        String answer = "";
        String[] codeS = code.split("");    // 각 인덱스를 q로 나눠주기 위한..

        for(int i = 0; i < codeS.length; i++) {
            if(i % q == r) {
                answer += codeS[i];
            }
        }

        return answer;
    }
}