public class Ants {
    public int solution(int hp) {
        int answer = 0;

        while(hp > 0) {
            if(hp >= 5) {    // 장군 개미 데리고 감
                answer++;
                hp -= 5;
            }
            else if(hp < 5 && hp >= 3) {    // 병정 개미
                answer++;
                hp -= 3;
            }
            else {  // 일 개미
                answer++;
                hp -= 1;
            }
        }

        return answer;
    }
}