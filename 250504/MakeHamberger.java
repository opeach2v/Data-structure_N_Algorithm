import java.util.ArrayList;

public class MakeHamberger {
    public int solution(int[] ingredient) {
        int answer = 0; // 햄버거 만든 횟수
        ArrayList<Integer> hambugi = new ArrayList<>();
        for(int i = 0; i < ingredient.length; i++) {    // 리스트에 넣기
            hambugi.add(ingredient[i]);
        }

        int ingredCount = ingredient.length;
        int firstIngred = 0;    // 첫 재료의 인덱스
        int count = 0;  // 햄버거 쌓을 때 총 4개 모이는지 (빵-야채-고기-빵)

        // 1은 빵, 2는 야채, 3은 고기
        // 예시는 2 1 1 2 3 1 2 3 1로 2개 만듦
        while(ingredCount > 0) {    // 재료가 다 없을 때까지
            for(int i = 0; i < hambugi.size(); i++) {
                if(count == 0) {    // 재료가 안 쌓여있으면
                    if(hambugi.get(i) == 1) {    // 재료가 빵이어야
                        count++;
                        firstIngred = i;
                    }
                }
                else {  // 이미 재료가 있으면
                    if(count == 1) {    // 재료가 1개 쌓여있으면 빵만 쌓임
                        if(hambugi.get(i) == 2) {    // 다음 재료가 야채여야만 카운트됨
                            count++;
                        }
                        else if(hambugi.get(i - 1) == hambugi.get(i)) {   // 그 전 거랑 같으면
                            firstIngred = i;
                        }
                        else {  // 야채가 아닐 시엔
                            count = 0;
                            firstIngred = 0;
                        }
                    }
                    else if(count == 2) {    // 재료가 2개 쌓여있으면 빵, 야채 쌓임
                        if(hambugi.get(i) == 3) {    // 다음 재료가 고기여야만 카운트됨
                            count++;
                        }
                        else {  // 고기가 아닐 시엔
                            count = 0;
                            firstIngred = 0;
                        }
                    }
                    else if(count == 3)  {  // 재료가 3개면 빵, 야채, 고기까지 쌓임
                        if(hambugi.get(i) == 1) {    // 다음 재료가 빵이여야만 카운트됨
                            count++;
                        }
                        else {  // 빵이 아닐 시엔
                            count = 0;
                            firstIngred = 0;
                        }
                    }
                }
                if(count == 4) {    // 다 쌓았으면
                    answer++;   // 햄버거 1개 만듦
                    int j = firstIngred;
                    while(count > 0) { // 재료 없애기
                        hambugi.remove(j);
                        ingredCount--;
                        count--;
                    }
                    i = -1;  // 다시 재료 처음부터
                }
                if(hambugi.size() < 4) {    // 햄버거 재료가 4개 이하면 끝
                    break;
                }
            }
            break;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] ingred = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int res = 0;

        MakeHamberger m = new MakeHamberger();
        res = m.solution(ingred);

        System.out.println(res);
    }
}