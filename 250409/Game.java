public class Game {
    public int solution(int a, int b) {
        int answer = 0;

        if(a % 2 == 1 && b % 2 == 1) {
            answer = a * a + b * b;
        }
        else if(a % 2 == 1 || b % 2 == 1) {
            answer = 2 * (a + b);
        }
        else {
            answer = a - b;
            if(answer < 0) {
                answer = -answer;   // 음수면 - 붙여줘서 +로 만듦
            }
        }

        return answer;
    }
}