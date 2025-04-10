public class NumOfCurse {
    public int solution(int n) {
        int answer = 0;
        int a = 0;
        for(int i = 0; i < n; i++) {
            answer++;
            while(true) {
                a = answer;
                if(answer % 3 == 0) {
                    answer++;
                }
                if(answer % 10 == 3) {
                    answer++;
                }
                if(answer % 100 >= 30 && answer % 100 <= 39) {
                    answer++;
                }
                if(a == answer) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 40;
        int res = 0;

        NumOfCurse c = new NumOfCurse();
        res = c.solution(n);

        System.out.println(res);
    }
}