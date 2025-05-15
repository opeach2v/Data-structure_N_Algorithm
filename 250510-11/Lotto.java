import java.util.HashMap;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];  // 최고 순위와 최저 순위 순으로 저장
        int lowCount = 0;
        int highCount = 0;

        HashMap<Integer, Integer> rank = new HashMap<>();   // 순위 넣어놓기
        int rankNum = 6;    // 6등부터
        for(int i = 0; i <= 6; i++) {
            rank.put(i, rankNum);
            if(i != 0) rankNum--;   // 0개, 1개는 똑같은 6등 
        }

        HashMap<Integer, Integer> winNum = new HashMap<>(); // 빨리 찾으려고 ㅎ
        for(int i = 0; i < win_nums.length; i++) winNum.put(win_nums[i], i);

        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] != 0) {   // 0이 아니면
                if(winNum.containsKey(lottos[i])) {
                    lowCount++;
                    highCount++;
                }
            }
            else highCount++;   // 0이면
        }

        answer[0] = rank.get(highCount);
        answer[1] = rank.get(lowCount);

        return answer;
    }
}