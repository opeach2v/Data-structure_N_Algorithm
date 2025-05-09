import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Mandarin {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int count = 0;  // k만큼 차는지 보려고
        ArrayList<Integer> tan = new ArrayList<>(); // 귤 순서
        ArrayList<Integer> tanCount = new ArrayList<>();    // 귤의 귤 갯수

        HashMap<Integer, Integer> tans = new HashMap<>();   // 정렬을 위한ㅎ(아마도 ㅠ)
        for(int i = 0; i < tangerine.length; i++) {    // 귤 번호가 작은 순 부터 일단 넣기
            tans.put(tangerine[i], tans.getOrDefault(tangerine[i], 0) + 1);
        }

        for(int i : tans.keySet()) {
            tan.add(i); // 이렇게 되면 귤이 1부터 10까지라면 1~10 순으로 저장이 됨
        }
        for(int i = 0; i < tans.size(); i++) {
            tanCount.add(tans.get(tan.get(i)));  // 귤 순서대로 해당 귤 갯수 넣기
        }

        if(k == tangerine.length) return 1; // 넣어야하는 수가 최대면 1밖에 없음
        else {
            Collections.sort(tanCount);

            for(int i = tanCount.size() - 1; i >= 0; i--) {
                if(tanCount.get(i) >= k) {
                    return 1;
                }
                else {
                    if(count < k) {
                        count += tanCount.get(i);
                        answer++;
                    }
                    
                    if(count >= k) return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] tangerine = {1, 1, 2, 2};
        int res = 0;

        Mandarin m = new Mandarin();
        res= m.solution(k, tangerine);
    }

    // 셸 정렬
    // for(int i = tanCount.size() / 2; i > 0; i /= 2) {
    //     for(int j = i; j < tanCount.size(); j++) {
    //         int z;
    //         int temp = tanCount.get(i);
    //         for(z = j - i; z >= 0 && tanCount.get(z) > temp; z -= i) {
    //             tanCount.set(z + i, tanCount.get(z));
    //         }
    //         tanCount.set(z + i, temp);
    //     }
    // }
}