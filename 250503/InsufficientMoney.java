public class InsufficientMoney {
    public long solution(int price, int money, int count) {
        int p = price;  // price
        long total_price = 0;

        while(count > 0) {  // count가 0이 될 때까지
            total_price += price;
            price += p;
            count--;
        }
        if(money - total_price > 0) return 0; // 금액이 부족하지 않으면
        else return total_price - money;
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        long res = 0;

        InsufficientMoney i = new InsufficientMoney();
        res = i.solution(price, money, count);
    }
}