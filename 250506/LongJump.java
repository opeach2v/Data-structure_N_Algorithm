// 일단 1시간 32분째... 

public class LongJump {
    public long solution(int n) {
        long answer = 1 % 1234567;    // 모두 1칸으로 뛸 경우 미리 추가
        int count2 = n / 2; // 2의 개수 저장(2가 가장 많을 때인 거) (마지막 자리수도 됨)

        while() {
            // 2가 1개일 때만 계산
            answer += (n - 1) % 1234567;

            // 2가 2이상일 때
            if(n % 2 == 1) {    // n이 홀수면
                answer += (count2 + 1) % 1234567;

            }
            else {  // 짝수면
                answer++;   // 모두 2일 때(count2만큼의 자리수 가짐)
                count2++;    // 다음 자리수(1이 2개씩 생기고 2가 1개 사라지는..)
                
                while(count2 < (n - 2)) {
                    
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        long res = 0;

        LongJump l = new LongJump();
        res = l.solution(n);

        System.out.println(res);
    }
}