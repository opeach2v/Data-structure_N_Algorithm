public class GetMiddleStr {
    public String solution(String s) {
        String answer = "";
        String[] sSplit = s.split("");

        if(sSplit.length % 2 == 0 ) {  // 문자열 길이가 짝수면
            answer += sSplit[sSplit.length / 2 - 1] + sSplit[sSplit.length / 2];
        }
        else {  // 홀수면
            answer += sSplit[sSplit.length / 2];
        }

        return answer;
    }
}