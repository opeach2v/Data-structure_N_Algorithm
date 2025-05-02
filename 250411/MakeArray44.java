import java.util.ArrayList;

public class MakeArray44 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(stk.isEmpty()) {  // 리스트가 비어있으면
                stk.add(arr[i]);
            }
            else if(stk.get(stk.size() - 1) < arr[i]) { // 앞 리스트보다 작으면
                stk.add(arr[i]);
            }
            else if(stk.get(stk.size() - 1) >= arr[i]) { // 앞 리스트 값이 더 크면 삭제
                stk.remove(stk.get(stk.size() - 1));
                i--;
            }
        }

        int[] result = new int[stk.size()];
        for(int a = 0; a < stk.size(); a++) {
            result[a] = stk.get(a);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        int[] result = {};

        MakeArray4 m = new MakeArray4();
        result = m.solution(arr);

        for (int i = 0; i < result.length; i++) {
            
            System.out.println(result);
        }
    }
}