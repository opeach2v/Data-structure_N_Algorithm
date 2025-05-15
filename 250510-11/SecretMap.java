import java.util.Deque;
import java.util.LinkedList;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        int idx = 0;    // answer의 인덱스 역할

        Deque<String> binary = new LinkedList<>(); // 2진수 저장하는 큐
        
        for(int i = 0; i < arr1.length; i++) {
            while(arr1[i] > 0 || arr2[i] > 0) { // 둘 다 0이 될 때까지
                String what = " ";   // arr1의 binary가 뭐인지 임시 저장(arr2의 binary랑 비교해야함)
                if(arr1[i] != 0) {
                    if(arr1[i] % 2 == 1) {  // 1로 끝나면
                        binary.push("#"); // 무조건 1 저장
                        arr1[i] /= 2;
                        arr2[i] /= 2;
                        continue;
                    }
                    else what = " ";   // 0으로 끝나면
                    arr1[i] /= 2;
                }
                if(arr2[i] != 0) {
                    if(arr2[i] % 2 == 1) {   // 만약 arr[i] 나머지는 0이었는데 arr2[i]는 1이면
                        what = "#";   // 1로 바꿔서 넣어줌
                    }
                    arr2[i] /= 2;
                }
                binary.push(what);
            }
            if(binary.size() < n) {  // 큐 사이즈가 부족하면
                int len = binary.size();
                for(int j = 0; j < n - len; j++) {    // 그만큼 0을 넣어줌
                    binary.push(" ");
                }
            }

            // answer에 바로 문자열로 넣어주기
            answer[idx] = "";
            int len = binary.size();
            for(int j = 0; j < len; j++) {
                answer[idx] += binary.pop();   // 차례대로 넣어주기
                System.out.println(binary);
            }
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {2, 2, 2, 2, 2};
        String[] res = {};

        SecretMap s = new SecretMap();
        res = s.solution(n, arr1, arr2);
    }
}