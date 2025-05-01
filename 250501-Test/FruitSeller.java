import java.util.ArrayList;

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        ArrayList<Integer> appleBox = new ArrayList<>();
        int zeroCount = 0;  // 0의 갯수. score 길이랑 같으면 반복문 빠져나옴

        // 점수가 가장 큰 것들 부터 상자에 넣기
        while (k > 0) { // 최저 점수가 0이 될 때까지
            for(int i = 0; i < score.length; i++) {
                if(score[i] != 0){
                    if(score[i] == k) { // 가장 높은 점수랑 만나면
                        appleBox.add(score[i]); // 상자에 넣고
                        score[i] = 0;   // 0으로 만들기
                    }
                }
                else {
                    zeroCount++;
                }
                if(appleBox.size() == m) {  // 상자가 다 찼으면
                    appleBox.removeAll(appleBox);
                    answer += (k * m);    // 최저 점수와 갯수 곱한 거 더하기
                }
            }

            // score을 다 돌았을 때
            if(zeroCount == score.length) break;    // 다 0이면 반복문 빠져나가기

            if(appleBox.size() < m) {   // 상자가 다 안 차면
                k--;
            }
            zeroCount = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};

        int res = 0;

        FruitSeller f = new FruitSeller();
        res = f.solution(k, m, score);

        System.out.println(res);
    }
}