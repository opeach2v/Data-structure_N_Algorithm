import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Painting {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        ArrayList<Integer> sec = new ArrayList<>();
        for(int i = 0; i < section.length; i++) sec.add(section[i]);

        Deque<Integer> area = new ArrayDeque<>();   // 스택에 넣으면서 m만큼 칠해지는지 확인용
        int sum = 0;

        if(m == 1) return section.length;   // 롤러가 1이면 칠할 영역만큼
        else {
            int idx = 0;
            while(!sec.isEmpty()) { // 리스트가 빌 때까지
                area.push(sec.get(idx));    // 스택에 넣으면서
                sum += sec.get(idx);    // 더하고
                if(sum <= m) {
                    answer++;
                }
                sec.remove(idx);
            }
        }

        return answer;
    }
}