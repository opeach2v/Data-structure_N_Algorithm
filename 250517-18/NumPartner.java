import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NumPartner {
    public String solution(String X, String Y) {
        String answer = "";

        HashMap<String, Integer> numX = new HashMap<>();
        HashMap<String, Integer> numY = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        for(String xs : X.split("")) {
            numX.put(xs, numX.getOrDefault(xs, 0) + 1);
        }
        for(String ys : Y.split("")) {
            numY.put(ys, numY.getOrDefault(ys, 0) + 1);
        }
        
        for(String s : numX.keySet()) {
            if(numY.containsKey(s)) {   // numY에도 존재하면
                if(numX.get(s) >= numY.get(s)) {    // 값이 Y보다 같거나 크면 
                    if(s.equals("0")) numX.put(s, 1);
                    else numX.put(s, numY.get(s));   // 작은 값으로 바꿔주기
                }
                for(int i = 0; i < numX.get(s); i++) {
                    list.add(Integer.parseInt(s));
                }
            }
        }
    
        if(list.isEmpty()) return "-1";   // 리스트가 비었다는 건 공통되는 수가 없다는 것
        
        Collections.sort(list);

        for(int i = list.size() - 1; i >= 0; i--) {
            answer += String.valueOf(list.get(i));
        }

        return answer;
    }
}