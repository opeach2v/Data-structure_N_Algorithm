public class Coke {
    // static int answer = 0;
    public int solution(int a, int b, int n, int answer) {
        if(n < a) {
            return answer;
        }
        else {
            answer += (n / a) * b;
            return solution(a, b, ((n / a) * b) + (n % a), answer);
        }
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int n = 10;
        int answer = 0;
        int res = 0;

        Coke c = new Coke();
        res = c.solution(a, b, n, answer);
    }
}