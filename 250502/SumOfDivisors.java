public class SumOfDivisors {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {    // 약수
                answer += i;
            }
        }

        return answer;
    }
}