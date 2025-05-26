import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AddTwoNum {
    public int[] solution(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                map.put(numbers[i] + numbers[j], 0);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int m : map.keySet()) list.add(m);
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 1};
        int[] res = {};

        AddTwoNum a = new AddTwoNum();
        res = a.solution(nums);
    }
}