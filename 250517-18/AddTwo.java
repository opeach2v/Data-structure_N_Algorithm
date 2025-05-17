import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AddTwo {
    public int[] solution(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i; j < numbers.length; j++) {
                map.put(numbers[i] + numbers[j], 0);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int m : map.keySet()) list.get(m);
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }

    public static void main(String[] args) {
        int[] num = {2, 1, 3, 4, 1};
        int[] res = {};

        AddTwo a = new AddTwo();
        res = a.solution(num);
    }
}