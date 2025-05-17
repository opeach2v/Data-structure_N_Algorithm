import java.util.ArrayDeque;
import java.util.Deque;

public class HateSameNum {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]); // 일단 넣기
                continue;
            }
            if(stack.peek() == arr[i])  {   // 들어있는 거랑 다음 배열 값이랑 같으면
                stack.pop();    // 원래 있던 거 빼내고
            }
            stack.push(arr[i]); // 다시 넣기(다른 거라면 그냥 그 위에 넣어지겠지)
        }

        int[] answer = new int[stack.size()];
        for(int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}