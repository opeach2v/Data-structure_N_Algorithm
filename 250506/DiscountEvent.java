import java.util.ArrayList;
import java.util.HashMap;

public class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 할인 목록 hashMap에 넣기
        HashMap<String, Integer> fruit = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            fruit.put(want[i], number[i]);
        }

        // 본격적 계산
        for(int i = 0; i < discount.length; i++) {
            int count = 0; // 같은 과일이 갯수만큼 있는지
            if(fruit.containsKey(discount[i])) {    // 행사 목록에 사려는 과일이 잇으면
                count++;
                for(int j = i + 1; j < i + 10; j++) {   // 열흘 동안의 목록에 다 있는지 확인
                    if() {
                        count++;
                    }
                }
                if(count >= fruit.get(discount[i])) {   // count가 해당 과일의 개수보다 같거나 많으면
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int res = 0;

        DiscountEvent d = new DiscountEvent();
        res = d.solution(want, number, discount);
    }
}