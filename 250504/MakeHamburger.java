import java.util.ArrayList;
import java.util.HashMap;

public class MakeHamburger {
    public int solution(int[] ingredient) {
        int answer = 0;
        int firstIngred = 0;   // 첫번째 재료 인덱스
        int count = 0;  // 재료가 얼마나 쌓였는지 보는 것(최대 4)
        HashMap<Integer, Integer> ingred = new HashMap<>(); // 재료 현황을 위한..
        ArrayList<Integer> ingredList = new ArrayList<>();

        for(int in : ingredient) {
            ingred.put(in, ingred.getOrDefault(in, 1) + 1); // 중복되면 value가 1씩 증가
            ingredList.add(in); // list에도 넣어줌
        }

        while(ingred.get(1) >= 2 || ingred.get(2) >= 1 || ingred.get(3) >= 1) {  // 재료가 있을 때까지 반복
            for(int i = 0; i < ingredList.size(); i++) {
                if(count == 0) {    // 재료가 안 쌓여있으면
                    if(ingredList.get(i) == 1) {    // 재료가 빵이어야
                        count++;
                        firstIngred = i;
                    }
                }
                else {  // 이미 재료가 있으면
                    if(count == 1) {    // 재료가 1개 쌓여있으면 빵만 있는 거
                        if(ingredList.get(i) == 2) {    // 다음 재료가 야채여야만 카운트됨
                            count++;
                        }
                        else if(ingredList.get(i) == 1) {   // 빵이면
                            firstIngred = i;
                        }
                        else {  // 야채가 아닐 시엔
                            count = 0;
                            firstIngred = 0;
                        }
                    }
                    else if(count == 2) {    // 재료가 2개 쌓여있으면 빵, 야채 쌓임
                        if(ingredList.get(i) == 3) {    // 다음 재료가 고기여야만 카운트됨
                            count++;
                        }
                        else {  // 고기가 아닐 시엔
                            count = 0;
                            firstIngred = 0;
                        }
                    }
                    else if(count == 3)  {  // 재료가 3개면 빵, 야채, 고기까지 쌓임
                        if(ingredList.get(i) == 1) {    // 다음 재료가 빵이여야만 카운트됨
                            count++;
                        }
                        else {  // 빵이 아닐 시엔
                            count = 0;
                            firstIngred = 0;
                            continue;
                        }
                    }
                }
                if(count == 4) {    // 다 쌓았으면
                    answer++;   // 햄버거 1개 만듦
                    int j = firstIngred;
                    while(count > 0) { // 재료 없애기
                        ingredList.remove(j);
                        count--;
                    }
                    i = -1;  // 다시 재료 처음부터
                    ingred.put(1, ingred.getOrDefault(1, 1) - 2);   // 빵 2개 삭제
                    ingred.put(2, ingred.getOrDefault(2, 1) - 1);   // 야채 1개 삭제
                    ingred.put(3, ingred.getOrDefault(3, 1) - 1);   // 고기 1개 삭제
                    if(ingred.get(1) < 2 || ingred.get(2) == 0 || ingred.get(3) == 0) { // 빵과 재료가 부족하면
                        return answer;
                    }
                }
                if(ingredList.size() < 4) {    // 햄버거 재료가 4개 이하면 끝
                    return answer;
                }
            }
            break;
        }

        return answer;
    }
}