public class Add {
    public int solution(int n) {
        int answer = 0;
        while(n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 930211;
        int re;

        Add a = new Add();
        re = a.solution(n);

        System.out.println(re);
    }
}

// 7시 14분 ~ 19분분