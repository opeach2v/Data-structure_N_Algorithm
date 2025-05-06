public class ExpressionNum {
    public int solution(int n) {
        int answer = 1; // 자기 자신 포함
        int first = 1;
        int sum = 0;    // 더해볼 거

        if(n >= 0 && n <= 2) {  // 얘네는 자기 자신 밖에 없음.
            return 1;
        }
        else {
            while(first <= n / 2) {
                for(int i = first; i <= n; i++) {
                    if(sum < n) {
                        sum += i;
                    }
                    else if(sum == n) {
                        answer++;
                        sum = 0;
                        break;
                    }
                    else {  // sum이 n보다 커지면
                        sum = 0;
                        break;
                    }
                }
                first++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int res = 0;

        ExpressionNum e = new ExpressionNum();
        res = e.solution(n);

        System.out.println(res);
    }
}