public class Fibo {
    public int solution(int n) {
        int[] f = new int[2];
        int answer = 0;

        f[0] = 0;
        f[1] = 1;

        int count = 1;
        while(count < n) {
            answer = (f[0] % 1234567) + (f[1] % 1234567);
            f[0] = f[1];
            f[1] = answer;
            count++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        int res = 0;

        Fibo f = new Fibo();
        res = f.solution(n);

        System.out.println(res);
    }
}