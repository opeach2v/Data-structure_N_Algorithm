public class Americano {
    public int[] solution(int money) {
        int[] answer = {0, 0};

        answer[0] += money / 5500;
        money %= 5500;

        answer[1] = money;  // 남은 잔돈

        return answer;
    }

    public static void main(String[] args) {
        int money = 15000;
        int[] res = {};

        Americano a = new Americano();
        res = a.solution(money);
    }
}