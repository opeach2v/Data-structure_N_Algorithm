public class LeftRight {
    public int solution(int left, int right) {
        int answer = 0;
        int count = 2;  // 1과 해당 수를 미리 카운트

        if(left == 1 && right == 1) {   // 둘 다 1이면
            return -1;  // 1의 약수는 홀수라서 -1로
        }
        else if(left == 1) {    // left가 1로 시작하면
            answer = -1;    // 결과값을 미리 -1로 해주고
            left++; // 한 번 증가시켜주기
        }

        for(int i = left; i <= right; i++) {    // left 수부터 right 수까지
            for(int j = 2; j <= i / 2; j++) {    // 약수 카운트 하기
                if(i % j == 0) count++;
            }
            if(count % 2 == 0) {    // 약수의 개수가 짝수면
                answer += i;
            }
            else {
                answer -= i;
            }
            count = 2;
        }

        return answer;
    }
}