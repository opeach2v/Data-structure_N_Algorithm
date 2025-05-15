public class MatchTable {
    public int solution(int n, int a, int b) {
        int round = 1;  // 몇 라운드인지 저장

        if(a > b) { // a가 더 크면 바꿔주기
            int temp = a;
            a = b;
            b = temp;
        }

        if(a % 2 == 1 && a + 1 == b) return 1;  // a가 홀수면서 a + 1이 b면

        while(a + 1 != b || !(a % 2 == 1 && b % 2 == 0)) {
            if(a % 2 == 1) a++;
            if(b % 2 == 1) b++;
            a /= 2;
            b /= 2;
            round++;
        }

        return round;
    }

    public static void main(String[] args) {
        int N = 8;
        int A = 5;
        int B = 8;
        int res = 0;

        MatchTable m = new MatchTable();
        res = m.solution(N, A, B);

        System.out.println(res);
    }
}