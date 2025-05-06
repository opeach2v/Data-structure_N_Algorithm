import java.util.ArrayList;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        ArrayList<String> map = new ArrayList<>(); // 한 줄 한 줄을 계산하며..

        for(int i = 0; i < arr1.length; i++) {
            int idx = 0;
            // 이진수 계산 후 map에 넣기
            while(arr1[i] > 0) {
                if(arr1[i] % 2 == 1) {
                    map.add("1");    // 벽
                }
                else {
                    map.add("0"); // 공백
                }
                arr1[i] /= 2;
                idx++;
            }
            if(map.size() < arr1.length) {  // 작으면
                int count = map.size();
                for(int c = count; c < arr1.length; c++) {
                    map.add("0");
                }
            }

            // 그 다음 arr2도 계산
            idx = 0;
            while(arr2[i] > 0) {
                // 벽만 채워준다
                if(arr2[i] % 2 == 1) {
                    if(map.get(idx).equals("0")) {  // 이미 0이 들어있으면
                        map.set(idx, "1");  // 1로 바꿈
                    }
                }
                arr2[i] /= 2;
                idx++;
            }

            // 그리고 i번째는 결과값에 #과 공백으로 뒤부터 넣어준다
            answer[i] = "";
            for(int j = map.size() - 1; j >= 0; j--) {
                if(map.get(j).equals("1")) {    // 1이면 벽이므로 # 넣기
                    answer[i] += "#";
                }
                else {
                    answer[i] += " ";   // 0이면 공백
                }
            }

            map.removeAll(map);
        }

        return answer;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {1, 10, 0, 2, 5};

        String[] res = {};

        SecretMap s = new SecretMap();
        res = s.solution(n, arr1, arr2);

    }
}