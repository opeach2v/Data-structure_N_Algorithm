public class ShortageMoney {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long needMoney = 0;

        while(count > 0) {  // count가 0이 될 때까지
            needMoney += (long) (price * count);
            count--;
        }

        if(needMoney - money > 0) { // 돈이 부족하다는 것
            answer = (long) (needMoney - money);
        }
        else if(needMoney - money <= 0){   // 딱 맞거나 가진 돈이 더 많다
            answer = 0;
        }

        return answer;
    }
}

// 18분 24초