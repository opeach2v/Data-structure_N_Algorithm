public class Game369 {
    public int solution(int order) {
        int answer = 0;
        int len = String.valueOf(order).length();
        int i = 0;
        while(i < len) {
            if(order % 10 == 3 || order % 10 == 6 || order % 10 == 9) {    // 1의 자리가 3, 6, 9 중 하나면
                answer++;
                order /= 10;    // 1의 자리 떼버리기
                i++;
            }
            else {
                order /= 10;    // 안 더해주고 걍 바로 떼버리기
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int order = 29423;
        int result = 0;

        Game369 g = new Game369();
        result = g.solution(order);

        System.out.println(result);
    }
}
