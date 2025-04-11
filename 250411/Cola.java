public class Cola {
    public int[] solution(int n) {
        int[] cel = new int[n];
        int[] answer = new int[n];
        int i = 1;

        cel[0] = n;
        while (true) { 
            if(n % 2 == 0) {    // 짝수면
                n /= 2; // n을 2로 나누고
                cel[i] = n;
            }
            else {  // 홀수면
                n = 3 * n + 1;
                cel[i] = n;
            }

            if(n == 1) {
                break;
            }
            i++;
        }
        answer = new int[i + 1];
        for(int a = 0; a <= i; a++) {
            answer[a] = cel[a];
        }

        return answer;
    }
}