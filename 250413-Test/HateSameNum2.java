import java.util.ArrayList;

public class HateSameNum2 {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(i, arr[i]);
        }

        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) == list.get(i + 1)) {
                list.remove(i);
                i--;
            }
            else {
                continue;
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}