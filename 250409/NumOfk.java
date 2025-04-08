public class NumOfk {
    public int solution(int i, int j, int k) {
        int answer = 0;
        int b = 0;

        for(int a = i; a <= j; a++) {
            if(a <= 9 && a >= 0) {
                if(a == k) {
                    answer++;
                    continue;
                }   
            }
            else {
                b = a;
                while(b > 0) {
                    if(b % 10 == k) {
                        answer++;
                        b /= 10;
                    }
                    else {
                        b /= 10;
                    }
                }
            }
        }

        return answer;
    }
}
