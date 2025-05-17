import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class TheHallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        Deque<Integer> qScore = new ArrayDeque<>(); // score의 값 넣기 (큐)
        for(int i = 0; i < score.length; i++) qScore.offer(score[i]);
        Deque<Integer> sScore = new ArrayDeque<Integer>();  // 명예의 전당 목록 (스택, 큐 공동 사용(되나?))

        int idx = 0;    // answer의 인덱스
        for(int i = 0; i < score.length; i++) {
            if(sScore.isEmpty()) {
                sScore.push(qScore.poll());
                answer[idx] = sScore.peekLast();
                idx++;
                continue;
            }
            if(sScore.size() > k) {
                if(sScore.peek() <= qScore.peek()) {
                    sScore.poll();
                    sScore.push(qScore.poll());
                }
                else qScore.poll();
            }
            else {
                if(sScore.peekLast() <= qScore.peek()){  // 넣을 원소가 원래 있던 원소보다 작으면 패스~
                    sScore.push(qScore.poll());   // 맨 처음 점수 부터 넣기
                }
                else qScore.poll(); // 그냥 빼내버리기만 ㄲ
            }

            if(sScore.size() == k)  {   // 목록이 k만큼 다 차면
                ArrayList<Integer> sort = new ArrayList<>();
                for(int j = 0; j < sScore.size(); j++) {    // 스택 값 넣고
                    sort.add(sScore.poll());
                    j--;
                }
                
                // 오름차순 정렬 후 스택으로 다시 넣기
                Collections.sort(sort);
                for(int j = sort.size() - 1; j >= 0; j--) {
                    sScore.push(sort.get(j));
                }
                
                answer[idx] = sScore.peek();    // 맨 앞 숫자 빼내기
                idx++;
                continue;
            }

            answer[idx] = sScore.peekLast();
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int[] res = {};

        TheHallOfFame t = new TheHallOfFame();
        res = t.solution(k, score);
    }
}