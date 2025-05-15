import java.util.Arrays;
import java.util.HashMap;

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int idx = 0;

        Arrays.sort(score); // 오름차순으로 정리 후
        HashMap<Integer, Integer> s = new HashMap<>();  // 해시맵 만들기
        for(int i = 0; i < score.length; i++) {
            s.put(score[i], s.getOrDefault(score[i], 0) + 1);   // 중복되는 것 합치기
        }

        int[] num = new int[s.size()];
        for(int n : s.keySet()) {
            num[idx] = n;
            idx++;
        }
        idx--;

        int len = score.length;
        break2:
        while(len > 0) {
            for(int i = 0; i < m; i++) {
                if(len == 0) break break2;
                if(s.get(k) == 0) {  // 해당 점수가 0개면
                    s.remove(k); // 해당 키 삭제 후
                    idx--;
                    k = num[idx];
                }
                s.put(k, s.get(k) - 1);
                len--;
            }
            answer += (k * m);
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
    }
}