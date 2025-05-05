import java.util.HashMap;

public class NumberPartner {
    public String solution(String X, String Y) {
        String answer = "";

        HashMap<Integer, Integer> x = new HashMap<>();
        // HashMap<Integer, Integer> y = new HashMap<>();
        String[] y = Y.split("");

        int count = 0;  // hashmap의 value값
        for(String s : X.split("")) {
            x.put(Integer.parseInt(s), x.getOrDefault(Integer.parseInt(s), 1) + 1);   // 중복 값 나올 시 value 증가
            count++;
        }
        // count = 0;
        // for(String s : Y.split("")) {
        //     y.put(count, Integer.parseInt(s));
        //     count++;
        // }

        for(String num : y) {
            if(x.containsValue(Integer.parseInt(num))) {  // 같은 숫자가 있으면
                answer += num;
                x.put(Integer.parseInt(num), x.getOrDefault(Integer.parseInt(num), 1) - 1);
                count = x.getOrDefault(Integer.parseInt(num), 1) - 1;
                if(count == 0) {
                    x.remove(Integer.parseInt(num));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String X = "5525";
        String Y = "1255";
        String res = "";

        NumberPartner n = new NumberPartner();
        res = n.solution(X, Y);

        System.out.println(res);
    }
}