import java.util.ArrayList;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        if(n == 1 && (arr1[0] == 1) || arr2[0] == 1) {
            answer[0] = "#";
            return answer;
        }

        int idx = 0;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            while(arr1[i] > 0) {
                if(arr1[i] % 2 == 0) {
                    list.add(" ");
                }
                else {
                    list.add("#");
                }
                arr1[i] /= 2;
            }
            if(list.size() < n) {
                int len = n - list.size();
                for(int k = 0; k < len; k++) {
                    list.add(" ");
                }
            }
            int l = 0;
            while(arr2[i] > 0) {
                if(list.get(l).equals(" ")) {
                    if(arr2[i] % 2 == 1) {
                        list.set(l, "#");
                    }
                }
                l++;
                arr2[i] /= 2;
            }
            answer[idx] = "";
            for(int j = n - 1; j >= 0; j--) {
                answer[idx] += list.get(j);
            }
            idx++;
            list.clear();
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] res = {};

        SecretMap s = new SecretMap();
        res = s.solution(n, arr1, arr2);
    }
}