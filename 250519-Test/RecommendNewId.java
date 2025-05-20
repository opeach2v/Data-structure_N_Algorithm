import java.util.ArrayList;

public class RecommendNewId {
    public String solution(String new_id) {
        String answer = "";

        ArrayList<String> newId = new ArrayList<>();
        for(String s : new_id.split("")) newId.add(s);

        // 1단계: 대문자를 모두 소문자로
        for(int i = 0; i < newId.size(); i++) {
            if(newId.get(i).charAt(0) >= 'A' && newId.get(i).charAt(0) <= 'Z') {
                char c = newId.get(i).charAt(0);
                c += 32;
                newId.set(i, String.valueOf(c));
            }
        }

        // 2단계: 소문자, 숫자, 밑줄(_), 마침표(.)를 제외하곤 모두 삭제
        for(int i = 0; i < newId.size(); i++) {
            char c = newId.get(i).charAt(0);
            if(!(c >= 'a' && c <= 'z') && c != '_' && c != '.' && c != '-' && !(c >= '0' && c <= '9')) {    // 가 아니면
                newId.remove(i);
                i--;
            }
        }

        // 3단계: 마침표가 2번 이상 연속되면 1개 빼고 다 삭제
        int check = 0;
        for(int i = 0; i < newId.size(); i++) {
            if(newId.get(i).charAt(0) == '.') {    // 다음도 0이면
                check++;
                if(check == 2) {
                    newId.remove(i);
                    i--;
                    check--;
                }
            }
            else {
                check = 0;
            }
        }

        // 4단계: 마침표가 처음이나 끝에 위치해있어도 삭제
        if(newId.get(0).equals(".")) {  // 처음이 .이라면
            newId.remove(0);
        }
        if(!newId.isEmpty()) {
            if(newId.get(newId.size() - 1).equals(".")) newId.remove(newId.size() - 1);
        }

        // 5단계: 빈 문자열이라면 "a"를 대입
        if(newId.isEmpty()) newId.add("a");

        // 6단계: 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자 삭제
        if(newId.size() >= 16) {
            for(int i = 15; i < newId.size(); i++) {
                newId.remove(i);
                i--;
            }
            if(newId.get(newId.size() - 1).equals(".")) newId.remove(newId.size() - 1);
        }

        // 7단계: 길이가 2자 이하면 마지막 문자를 길이가 3이 될 때까지 붙이기 
        if(newId.size() <= 2) {
            String s = newId.get(newId.size() - 1);
            while(newId.size() < 3) {
                newId.add(s);
            }
        }

        for(int i = 0; i < newId.size(); i++) {
            answer += newId.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String new_id = 	"...!@BaT#*..y.abcdefghijklm";
        String res = "";

        RecommendNewId r = new RecommendNewId();
        res = r.solution(new_id);
    }
}