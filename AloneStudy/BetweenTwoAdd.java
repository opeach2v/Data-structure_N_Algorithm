public class BetweenTwoAdd {
    public long solution(int a, int b) {
        long answer = 0;

        if(a > b) { // a가 더 큰 경우
            for(int i = b; i <= a; i++) {
                answer += i;
            }
        }
        else if(a == b) {
            answer = a;
        }
        else {  // b가 더 큰 경우
            for(int i = a; i <= b; i++) {
                answer += i;
            }
        }

        return answer;
    }
}

// 2분 41초