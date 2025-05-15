import java.util.ArrayList;
import java.util.HashMap;

public class SumCount {
    public int solution(int[] elements) {
        HashMap<Integer, Integer> sums = new HashMap<>();   // 각 수열들의 합(중복 없앰)
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < elements.length; i++) {
            list.add(elements[i]);   // 배열 그대로 차례대로 리스트에 넣기
        }

        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                int count = 0;  // 길이 count의 연속 부분 수열
                int sum = 0;
                while(count < i) {
                    sum += list.get(count);
                    count++;
                }
                sums.put(sum, 0);
                list.add(list.get(0));  // 앞에 숫자를 바로 뒤로 다시 넣기
                list.remove(0); // 그리고 맨 첫 숫자 삭제
            }
        }

        int answer = sums.size();

        return answer;
    }

    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        int res = 0;

        SumCount s = new SumCount();
        res = s.solution(elements);
    }
}