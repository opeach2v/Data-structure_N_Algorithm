public class AddNumbers {
    public int solution(int n) {
        int answer = 0;

        if(n >= 10) {
            while(n > 0) {
                answer += n % 10;
                n /= 10;
            }
        }
        else {
            answer = n;
        }

        return answer;
    }
}