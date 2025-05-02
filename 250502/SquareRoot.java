public class SquareRoot {
    public long solution(long n) {
        long answer = 0;
        for(long i = 0; i <= n; i++) {
            if((i * i) == n) {
                answer =  ((i + 1) * (i + 1));
                break;
            }
            else if((i * i) > n){    // 제곱근이 없다
                return (long) -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        long n = 121;
        long res = 0;

        SquareRoot s = new SquareRoot();
        res = s.solution(n);

        System.out.println(res);
    }
}