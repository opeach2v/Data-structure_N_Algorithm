public class Collatz {
    public int solution(int num) {
        int count = 0;

        while(num > 1) {   // num이 1이 될 때까지 반복
            if(num % 2 == 0) {  // 짝수라면
                num /= 2;
            }
            else {  // 홀수라면
                num = num * 3 + 1;
            }
            count++;
        }

        if(num == 1) return count;
        else return -1;
    }

    public static void main(String[] args) {
        int n = 6;
        int res = 0;

        Collatz c = new Collatz();
        res = c.solution(n); 
    }
}