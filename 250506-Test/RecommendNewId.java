import java.util.ArrayList;

public class RecommendNewId {
    public String solution(String new_id) {
        String answer = "";
        ArrayList<String> newId = new ArrayList<>();
        for(String s : new_id.split("")) {
            newId.add(s);
        }

        // 1단계) 모든 대문자를 소문자로 치환
        for(int i = 0; i < new_id.length(); i++) {
            char c = newId.get(i).charAt(0);
            if(c >= 'A' && c <= 'Z') {
                c += 32;    // 소문자로
                newId.remove(i);    // 지운 다음
                newId.add(i, String.valueOf(c));   // 바꿔넣어줌
            }
        }

        // 2단계) 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 삭제
        for(int i = 0; i < newId.size(); i++) {
            char c = newId.get(i).charAt(0);
            if(!(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9') && c != '-' && c != '_' && c != '.') {
                newId.remove(i);
                i--;
            }
        }

        // 3단계) 마침표가 2번 이상 나오면 하나를 제외한 모든 .을 삭제
        int count = 0;
        for(int i = 0; i < newId.size(); i++) {
            char c = newId.get(i).charAt(0);
            if(c == '.') {
                count++;
                if(count == 2) {    // count가 2가 되면 .이 연속됐다는 거라서
                    newId.remove(i);
                    count--;
                    i--;
                }
            }
            else {
                count = 0;  // 카운트 초기화
            }
        }

        // 4단계) 마침표가 처음이나 끝에 위치하면 삭제
        if(newId.size() != 0) {
            if(newId.get(0).charAt(0) == '.') newId.remove(0);
        }
        if(newId.size() != 0) {
            if(newId.get(newId.size() - 1).charAt(0) == '.') newId.remove(newId.size() - 1);
        }

        // 5단계) 빈 문자열이라면 newId에 "a" 대입
        if(newId.size() == 0) {
            newId.add("a");
        }

        // 6단계) 길이가 16자 이상이면 15자 이후론 삭제
        if(newId.size() > 15) {
            for(int i = 15; i < newId.size(); i++) {
                newId.remove(i);
                i--;
            }
            // 마지막 문장이 마침표라면 삭제
            if(newId.get(newId.size() - 1).charAt(0) == '.') newId.remove(newId.size() - 1);
        }

        // 7단계) 길이가 2자 이하라면 마지막 문자를 길이가 3이될 때까지 반복해서 붙임
        if(newId.size() <= 2) {
            String s = newId.get(newId.size() - 1);
            while(newId.size() < 3) {
                newId.add(s);
            }
        }

        // 문자열에 붙이기
        for(int i = 0; i < newId.size(); i++) {
            answer += newId.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String res = "";

        RecommendNewId r = new RecommendNewId();
        res = r.solution(new_id);
    }
}