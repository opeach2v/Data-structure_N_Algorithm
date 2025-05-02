public class ReverseNumArray {
    public long[] solution(long n) {
        long[] answer = new long[String.valueOf(n).length()];
        int i = 0;

        if(n >= 10) {
            while(n > 0) {
                answer[i] = n % 10;
                n /= 10;
                i++;
            }
        }
        else {
            answer[0] = n;
        }

        return answer;
    }

    public static void main(String[] args) {
        long n = 1000000000;
        long[] res = {};

        ReverseNumArray r = new ReverseNumArray();
        res = r.solution(n);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}