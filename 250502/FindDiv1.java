public class FindDiv1 {
    public int solution(int n) {
        int answer = 1;

        while(true) {
            if(n % answer == 1) {   // 나머지가 1이면
                break;
            }
            else {  // 나머지가 1이 아니면
                answer++;
            }
        }

        return answer;
    }
}