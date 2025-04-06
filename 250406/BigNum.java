public class BigNum {
    public String solution(String number, int k) {
        String answer = "";
        String max = "";
        String[] numS = number.split("");
        String[] maxStrings = new String[number.length() - k]; // 가장 큰 수들 골라서 저장 (전체 길이 중 k만큼 뺀 수만 존재해야 함.)
        
        // 가장 큰 수 찾기
        for(int i = 0; i < numS.length; i++) {
            if(Integer.parseInt(numS[i]) < Integer.parseInt(numS[i])) {
            }
        }

        maxStrings[0] = max;    // 가장 큰 숫자는 미리 넣어두고
        // 가장 큰 숫자를 기준으로 number의 길이에서 k만큼 뺀만큼의 큰 숫자 저장하기
        for(int i = 0; i < numS.length - k; i++) {

        }

        return answer;
    }
}