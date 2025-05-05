public class RepeatChange2 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;  // 반복한 횟수
        int zeroCount = 0;  // 제거할 0의 개수
        int sLen = 0;  // count만큼 제거한 수 업데이트
        int twos = 2;   // 여기서 2씩 곱하면서 계산할 것

        while(!s.equals("1")) {  // s가 1일 때까지
            sLen = s.length();  // zeroCount만큼 제거한 수 업데이트
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    zeroCount++;
                }
            }
            sLen -= zeroCount;  // 0 제거 후 길이
            answer[1] += zeroCount;

            s = Integer.toString(sLen, 2);

            count++;
            zeroCount = 0;
        }

        answer[0] = count;

        return answer;
    }

    public static void main(String[] args) {
        String s = "01110";
        int[] res = {};

        RepeatChange2 r = new RepeatChange2();
        res = r.solution(s);
    }
}