
public class Knight {
    public int solution(int number, int limit, int power) {
        int answer = 1; // 1번 기사 약수는 항상 1 / 2, 3번 기사는 항상 2
        
        if(number == 1) return 1;

        // 약수 구하기
        for(int i = 2; i <= number; i++) {
            int count = 2;
            int nums = i;
            if(i == 2 || i == 3) {
                answer += 2;
                continue;
            }
            if(number > 3) {
                for(int j = 2; j <= i / 2; j++) {
                    if(nums % j == 0) count++;
                    if(count > limit) {
                        count = power;
                        break;
                    }
                }
                answer += count;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int num = 5;
        int limit = 3;
        int power = 2;
        int res = 0;

        Knight k = new Knight();
        res = k.solution(num, limit, power);
    }
}