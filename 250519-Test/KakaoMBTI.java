import java.util.HashMap;

public class KakaoMBTI {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> type = new HashMap<>();
        for(String s : types) type.put(s, 0);   // 미리 0점으로 초기화

        for(int i = 0; i < survey.length; i++) {
            String[] two = survey[i].split("");
            if(choices[i] >= 1 && choices[i] <= 3) {
                switch (choices[i]) {
                    case 1:
                        type.put(two[0], type.get(two[0]) + 3);
                        break;
                    case 2:
                        type.put(two[0], type.get(two[0]) + 2);
                        break;
                    case 3:
                        type.put(two[0], type.get(two[0]) + 1);
                        break;
                }
            }
            else if(choices[i] >= 5 && choices[i] <= 7) {
                switch (choices[i]) {
                    case 5:
                        type.put(two[1], type.get(two[1]) + 1);
                        break;
                    case 6:
                        type.put(two[1], type.get(two[1]) + 2);
                        break;
                    case 7:
                        type.put(two[1], type.get(two[1]) + 3);
                        break;
                }
            }
        }

        if(type.get("R") >= type.get("T")) answer += "R";
        else answer += "T";

        if(type.get("C") >= type.get("F")) answer += "C";
        else answer += "F";

        if(type.get("J") >= type.get("M")) answer += "J";
        else answer += "M";

        if(type.get("A") >= type.get("N")) answer += "A";
        else answer += "N";

        return answer;
    }
}