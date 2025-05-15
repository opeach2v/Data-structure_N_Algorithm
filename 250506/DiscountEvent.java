public class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for(int i = 0; i < discount.length - 9; i++) {
            int j = 0;
            for(j = 0; j < want.length; j++) {
                int count = 0;
                for(int k = i; k < i + 10; k++) {
                    if(discount[k].equals(want[j])) count++;
                }
                if(count < number[j]) {
                    break;    // 10일 안에 사는 갯수가 적으면 그냥 빠져나가기
                }
            }
            if(j == want.length) answer++;
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