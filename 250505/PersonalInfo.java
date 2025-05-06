import java.util.ArrayList;
import java.util.Collections;

public class PersonalInfo {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayY = Integer.parseInt(today.substring(0, 4));
        int todayM = Integer.parseInt(today.substring(5, 7));
        int todayD = Integer.parseInt(today.substring(8, 10));
        ArrayList<Integer> number = new ArrayList<>();

        for(int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            for(int j = 0; j < terms.length; j++) {
                String[] term = terms[j].split(" ");
                if(info[1].equals(term[0])) {   // 맞는 약관을 발견하면
                    int mm = Integer.parseInt(info[0].substring(5, 7));   // 월만 추출
                    int dd = Integer.parseInt(info[0].substring(8, 10)) - 1;   // 일 추출
                    if(dd == 0) {
                        dd = 28;
                        mm--;
                    }
                    int yyyy = Integer.parseInt(info[0].substring(0, 4));   // 연 추출
                    mm += Integer.parseInt(term[1]);
                    if(mm > 12) {   // 월을 더 했을 때 12월이 넘으면
                        yyyy += mm / 12;   // 연 증가
                        mm %= 12;   // 12월을 빼고
                    }
                    if(mm == 0) {
                        mm = 12;
                        yyyy--;
                    }
                    if((yyyy < todayY) || (yyyy == todayY && mm < todayM) || (yyyy == todayY && mm == todayM && dd < todayD)) {
                        number.add(i + 1);
                    }
                    break;
                }
            }
        }

        int[] answer = new int[number.size()];
        Collections.sort(number);   // 정렬

        for(int i = 0; i < number.size(); i++) {
            answer[i] = number.get(i);
        } 

        return answer;
    }
    
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] res = {};

        PersonalInfo p = new PersonalInfo();
        res = p.solution(today, terms, privacies);
    }
}