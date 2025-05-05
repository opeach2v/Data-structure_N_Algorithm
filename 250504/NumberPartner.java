import java.util.Arrays;
import java.util.HashMap;

public class NumberPartner {
    public String solution(String X, String Y) {
        String answer = "";
        HashMap<Integer, Integer> x = new HashMap<>();
        String[] y = Y.split("");

        int count = 0;  // hashmap의 value값
        for(String s : X.split("")) {
            x.put(Integer.parseInt(s), x.getOrDefault(Integer.parseInt(s), 1) + 1);   // 중복 값 나올 시 value 증가
            count++;
        }

        for(String num : y) {
            if(x.containsKey(Integer.parseInt(num))) {  // 같은 숫자가 있으면
                answer += num;
                x.put(Integer.parseInt(num), x.getOrDefault(Integer.parseInt(num), 1) - 1);
                count = x.getOrDefault(Integer.parseInt(num), 1) - 1;
                if(count == 0) {
                    x.remove(Integer.parseInt(num));
                }
            }
        }
        if(answer.length() == 0) return "-1";
        if(answer.length() > 1) {   // 문자열 길이가 1보다 크면 정렬해야함
            count = 0;
            for(String str : answer.split("")) {
                if(str.charAt(0) == '0') {
                    count++;
                }
            }
            if(count == answer.length()) {  // 0개수가 answer 길이와 같다면
                return "0";
            }
            else {
                String[] str = answer.split("");
                Arrays.sort(str);   // 정렬 후
                answer = "";
                // 뒤에서부터 저장하며 내림차순 만듦
                for(int i = str.length - 1; i >= 0; i--) {
                    answer += str[i];
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";
        String res = "";

        NumberPartner n = new NumberPartner();
        res = n.solution(X, Y);

        System.out.println(res);
    }
}