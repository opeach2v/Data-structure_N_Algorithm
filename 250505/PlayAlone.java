import java.util.ArrayList;
import java.util.Collections;

public class PlayAlone {
    public int solution(int[] cards) {
        int answer = 0;
        int count = -1;
        int i = 0;
        int noCount = 0;    // -1 갯수
        ArrayList<Integer> groupLen = new ArrayList<>();    // 몇 개의 상자가 속하는지

        while(true) {
            if(cards[i] == -1) {    // 이미 열었다는 의미
                if(count == -1) {
                    i++;    // 다음 상자를 찾기
                }
                else {  // count가 -1이 아니면
                    groupLen.add(count + 1);
                    i = 0;
                    count = -1;

                    // 다 -1인지 검사
                    for(int j = 0; j < cards.length; j++) {
                        if(cards[j] == -1) noCount++;
                        else {
                            noCount = 0;
                            break;
                        }
                    }
                    if(noCount == cards.length) break;
                }
            }
            else {
                count++;
                int idx = cards[i] - 1;
                cards[i] = -1;  // 열었다고 표시
                i = idx;
            }
        }

        // 2번째 시행까지의 상자의 수를 곱한 값 넣기
        if(groupLen.size() <= 1) {
            for(int g = 0; g < 2; g++) {
                groupLen.add(0);    // 0 넣어줌
            }
        }
        Collections.sort(groupLen); // 오름차순 정렬하고

        answer = groupLen.get(groupLen.size() - 1) * groupLen.get(groupLen.size() - 2);

        return answer;
    }

    public static void main(String[] args) {
        int[] cards = {2, 1, 4, 5, 3, 7, 8, 9, 6, 11, 12, 13, 14, 10};
        int res = 0;

        PlayAlone p = new PlayAlone();
        res = p.solution(cards);
    }
}