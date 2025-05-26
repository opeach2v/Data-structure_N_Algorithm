import java.util.HashMap;

public class KakaoMBTI {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] types = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> type = new HashMap<>();
        
        for(int i = 0 ; i < 8; i++) {
            type.put(types[i], 0);
        }

        for(int i = 0; i < survey.length; i++) {
            String[] sur = survey[i].split("");
            if(choices[i] >= 1 && choices[i] <= 3) {
                if(choices[i] == 1) type.put(sur[0], type.getOrDefault(sur[0], 0) + 3);
                else if(choices[i] == 2) type.put(sur[0], type.getOrDefault(sur[0], 0) + 2);
                else type.put(sur[0], type.getOrDefault(sur[0], 0) + 1);
            }
            else if(choices[i] >= 5 && choices[i] <= 7) {
                if(choices[i] == 5) type.put(sur[1], type.getOrDefault(sur[1], 0) + 1);
                else if(choices[i] == 6) type.put(sur[1], type.getOrDefault(sur[1], 0) + 2);
                else type.put(sur[1], type.getOrDefault(sur[1], 0) + 3);
            }
            else continue;
        }


        // R과 T
        if(type.get("R") >= type.get("T")) answer += "R";
        else answer += "T";
        
        // C와 F
        if(type.get("C") >= type.get("F")) answer += "C";
        else answer += "F";

        // J와 M
        if(type.get("J") >= type.get("M")) answer += "J";
        else answer += "M";

        // A와 N
        if(type.get("A") >= type.get("N")) answer += "A";
        else answer += "N";

        return answer;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String res = "";

        KakaoMBTI k = new KakaoMBTI();
        res = k.solution(survey, choices);
    }
}