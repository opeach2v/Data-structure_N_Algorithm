import java.util.ArrayDeque;
import java.util.Deque;

public class TheHallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        Deque<Integer> scoreQueue = new ArrayDeque<Integer>();
        int idx = 0;    // answer의 인덱스
        for(int i = 0; i < score.length; i++) {
            System.out.println(scoreQueue);
            if(i != 0 && score[i - 1] > score[i]) { // 다음 점수가 더 낮을 경우
                if(scoreQueue.peek() > score[i]) {  // 맨 앞 요소가 현재 score의 점수보다 크면 안 넣음
                    answer[idx] = scoreQueue.peek();
                    idx++;
                    continue;
                }
                int temp = scoreQueue.pop();   // 맨 뒤 삭제
                scoreQueue.push(score[i]);
                scoreQueue.push(temp);
                if(scoreQueue.size() > k) scoreQueue.poll();
                answer[idx] = scoreQueue.peek();
                idx++;
            }
            else {
                if(scoreQueue.size() < k) { // 스택의 내용물이 k보다 작으면
                    if(i != 0 && scoreQueue.getLast() > score[i]) {
                        scoreQueue.pop();   // 맨 뒤 삭제
                        scoreQueue.push(score[i]);
                    }
                    else {
                        scoreQueue.offer(score[i]);
                    }
                    answer[idx] = scoreQueue.peek();
                    idx++;
                }
                else {  // 큐가 k만큼 차잇으면 순차적으로 넣으면서 빼기
                    if(i != 0 && scoreQueue.getLast() > score[i]) {
                        scoreQueue.pop();   // 맨 뒤 삭제
                        scoreQueue.push(score[i]);
                        scoreQueue.poll();
                    }
                    else {
                        scoreQueue.offer(score[i]);
                        scoreQueue.poll();
                    }
                    answer[idx] = scoreQueue.peek(); // 넣을 때마다 맨 앞은 삭제하면서 저장
                    idx++;
                }
            }

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