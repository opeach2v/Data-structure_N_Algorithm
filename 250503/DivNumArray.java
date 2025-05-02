import java.util.ArrayList;

public class DivNumArray {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> div = new ArrayList<>(); // 나누어 떨어지는 수 넣어놓기

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) { // 나누어 떨어지면
                div.add(arr[i]);
            }
        }

        
        if(div.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        answer = new int[div.size()];

        for(int i = 0; i < div.size(); i++) {
            answer[i] = div.get(i);
        }

        // 오름차순 정렬
        for(int i = 0; i < answer.length; i++) {
            for(int j = answer.length - 1; j > i; j--) {
                if(answer[j - 1] > answer[j]) {
                    int temp = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = temp;
                }
            }
        }

        return answer;
    }
}