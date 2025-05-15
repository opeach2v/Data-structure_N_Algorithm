import java.util.ArrayDeque;
import java.util.Deque;

public class FoodFighter {
    public String solution(int[] food) {
        String answer = "";
        
        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();

        int foodNum = 0;
        for(int i = 1; i < food.length; i++) {
            if(food[i] % 2 == 1) {  // 음식의 양이 홀수면
                food[i]--;  // 음식 한 개 없애기
            }
            first.offer(food[i] / 2);   // 1번 선수는 큐에 넣기
            second.push(food[i] / 2);   // 2번 선수는 스택에 넣기
            foodNum++;   // 음식의 번호
        }

        for(int i = 1; i <= foodNum; i++) {
            int foodCount = first.poll();   // 각 음식의 번호의 음식의 개수
            if(foodCount == 0) continue; // 음식 개수가 0이면
            for(int j = 0; j < foodCount; j++) {
                answer += String.valueOf(i); // 맨 처음 사람 음식 넣기
            }
        }
        answer += "0";  // 물
        for(int i = foodNum; i > 0; i--) {
            int foodCount = second.pop();
            if(foodCount == 0) continue; // 음식 개수가 0이면
            for(int j = 0; j < foodCount; j++) {
                answer += String.valueOf(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] food = {1, 7, 1, 2};
        String res = "";

        FoodFighter f = new FoodFighter();
        res = f.solution(food);
    }
}