public class NoMoney {
    public long solution(int price, int money, int count) {
        long answer = 0;
        int price2 = price;

        for(int i = 0; i < count; i++) {
            answer += price;
            price += price2;
        }

        if(money >= answer) {
            return 0;
        }
        else {
            return answer - money;
        }
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        long res = 0;

        NoMoney n = new NoMoney();
        res = n.solution(price, money, count);
    }
}