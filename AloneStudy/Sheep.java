public class Sheep {
    public int solution(int n, int k) {
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            answer += 12000;
        }

        for(int i = 1; i <= k; i++) {
            answer += 2000;
        }

        if(n >= 10) {
            answer -= (n / 10) * 2000;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        int k = 3;

        int result = 0;
        Sheep s = new Sheep();
        result = s.solution(n, k);
    }
}