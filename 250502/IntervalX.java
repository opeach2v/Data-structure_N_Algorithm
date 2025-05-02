public class IntervalX {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        long interval = x;

        for(int i = 0; i < n; i++) {
            answer[i] = x;
            x += interval;
        }

        return answer;
    }
}