public class ExpressionNumber {
    public int solution(int n) {
        int answer = 1; // 자기 자신으로 표현하는 방법 미리 넣어놓기
        int sum = 0;
        int first = 1;

        if(n >= 0 && n <= 2) {  // 얘네는 1개씩 밖에 없음
            return 1;
        }
        else {
            while(first <= n / 2) {
                for(int i = first; i < n; i++) {
                    if(sum < n) {
                        sum += i;
                    }
                    else if(sum == n) { // 같아지면
                        answer++;
                        sum = 0;
                        first++;
                        break;
                    }
                    else {  // sum이 n보다 커지면
                        sum = 0;
                        first++;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        int res = 4;

        ExpressionNumber e = new ExpressionNumber();
        res = e.solution(n);
    }
}